/*
 * File Name: PropertyInventory.java
 * Authors:
 *      Cheyenne Goh (UCID: 30040528)
 *      Divyansh Goyal (UCID: 30089488)
 *      Rui Guan(UCID: 30072848)
 *      Sajid Hafiz (UCID: 30061336)
 */
package Data_Source_Layer;

import Business_Layer.Property;

import javax.swing.text.DateFormatter;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.sql.Date.*;
import java.util.Date;

/**
 * 
 */
public class PropertyInventory implements Database {

    private Connection dbConnect;
    private ArrayList<Property> mySearchedProperties;
    PaymentPeriodRecord myPaymentPeriodRecord;

    /**
     * Default constructor
     */
    public PropertyInventory() {
        myPaymentPeriodRecord = new PaymentPeriodRecord();
        initializeConnection();
        updateAllProperties();
    }

    /**
     * This updates all properties in the database to cancelled if the current date is greater or equal to the
     * expiration date and if it is not rented
     */
    private void updateAllProperties() {
        try{
            String query = "UPDATE property SET Status = 'Cancelled' WHERE SYSDATE() > ExpDate AND Status != 'Rented';";
            Statement stmt = dbConnect.createStatement();
            stmt.executeQuery(query);
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Getter, returns mySearchedProperties
     */
    public ArrayList<Property> getMySearchedProperties() {
        return mySearchedProperties;
    }

    /**
     *
     * @param mySearchedProperties
     * sets mySearchedProperties to parameter
     */
    public void setMySearchedProperties(ArrayList<Property> mySearchedProperties) {
        this.mySearchedProperties = mySearchedProperties;
    }




    /**
     * @param type 
     * @param numBedrooms 
     * @param numBathrooms 
     * @param furnished 
     * @param quadrant 
     * @return The matched properties that match the parameters and are active
     */
    public ArrayList<Property> getMatching(String type, int numBedrooms, int numBathrooms, boolean furnished, String quadrant) {
        char furn =  'N';
        ArrayList<Property> matchedProperties = new ArrayList<>();
        if (furnished)  {
            furn = 'Y';
        }
        try{
            String query = "SELECT * FROM property WHERE Quadrant = " + quadrant +" AND Furnished = " + furn + " AND numBathrooms =" + numBathrooms +
                    " AND numBedrooms = " + numBedrooms + " AND Type = " + type + " AND Status = 'Active'";
            Statement stmt = dbConnect.createStatement();
            ResultSet result = stmt.executeQuery(query);
            matchedProperties = convertToProperty(result);
           stmt.close();
           result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return matchedProperties;
    }

    /**
     * @param type 
     * @param numBedrooms 
     * @param numBathrooms 
     * @param furnished 
     * @param quadrant 
     * @param email 
     * @param ID
     * @param address 
     * Inserts a property into the database
     */
    public void registerProperty(String type, int numBedrooms, int numBathrooms, boolean furnished, String quadrant, String email, String address) {
        try {
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss");
            LocalDateTime localDate = LocalDateTime.now();
            String currentDate = dateFormat.format(localDate);

            LocalDateTime localExpdate = localDate.plusDays(myPaymentPeriodRecord.retrievePeriod());
            String expDate = dateFormat.format(localExpdate);

            String furn = "N";
            if (furnished) furn = "Y";
            String query = "INSERT INTO property (LandlordEmail, Status, Quadrant, Address, Furnished, numBathrooms, numBedrooms, Type, PostedDate, ExpDate) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = dbConnect.prepareStatement(query);
            stmt.setString(1, email);
            stmt.setString(2, "Active");
            stmt.setString(3, quadrant);
            stmt.setString(4, address);
            stmt.setString(5, furn);
            stmt.setInt(6, numBathrooms);
            stmt.setInt(7, numBedrooms);
            stmt.setString(8, type );
            stmt.setTimestamp(8, java.sql.Timestamp.valueOf(currentDate));
            stmt.setTimestamp(9, java.sql.Timestamp.valueOf(expDate));
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * @param email 
     * Returns a list of properties managed by a landlord
     */
    public ArrayList<Property> getMatching(String email) {
        ArrayList<Property> myProperties = new ArrayList<>();
       try {
           String query = "SELECT * FROM property where LandlordEmail = " + email;
           Statement stmt = dbConnect.createStatement();
           ResultSet set = stmt.executeQuery(query);
           myProperties = convertToProperty(set);
           stmt.close();
           set.close();
       } catch (SQLException e) {
           e.printStackTrace();
       }
        return myProperties;
    }

    /**
     *
     * @param email of a Registered Renter's
     * @return All active properties that match a registered renter's subscriptions given their email
     */
    public ArrayList<Property> getNotifications(String email) {
        ArrayList<Property> notifiedProperties = new ArrayList<>();
        try {
            String query = "SELECT * \n" +
                    "FROM\n" +
                    "(\n" +
                    "SELECT property.ID, property.LandlordEmail, property.Status, property.Quadrant, property.Address, property.Furnished, property.numBathrooms, property.numBedrooms, property.Type, property.PostedDate, property.ExpDate\n" +
                    "FROM\n" +
                    "(\n" +
                    "SELECT *\n" +
                    "FROM subscription\n" +
                    "WHERE RREmail = " + email +
                    ") AS T JOIN property using(Quadrant, Furnished, numBathrooms, numBedrooms)\n" +
                    "WHERE T.Quadrant = property.Quadrant AND T.Furnished = property.furnished AND T.numBathrooms = property.numBathrooms AND T.numBedrooms = property.numBedrooms\n" +
                    ") AS V WHERE V.Status = 'Active'";

            Statement stmt = dbConnect.createStatement();
            ResultSet set = stmt.executeQuery(query);
            notifiedProperties = convertToProperty(set);
            stmt.close();
            set.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return notifiedProperties;
    }

    /**
     * @param p 
     * Updates the property in the datbase associated with p's ID and p's new status
     */
    public void updateProperty(Property p) {
        String newStatus = p.getStatus();
        int ID = p.getID();
        try {
            String query = "UPDATE property SET STATUS = ? WHERE ID = ?";
            PreparedStatement stmt = dbConnect.prepareStatement(query);
            stmt.setString(1, newStatus);
            stmt.setInt(2, ID);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Return an array list of properties rented in the chosen period.
     */
    public ArrayList<Property> retrieveSummary() {
        ArrayList<Property> rented = new ArrayList<>();
        try{
            String query = "SELECT Name, ID AS House_ID, Address\n" +
                    "FROM property INNER JOIN user ON property.LandlordEmail = user.Email\n" +
                    "WHERE property.PostedDate >= DATE_SUB(SYSDATE(), INTERVAL " + myPaymentPeriodRecord.retrievePeriod() +
                    " DAY) AND Status = 'Rented';";
            Statement stmt = dbConnect.createStatement();
            ResultSet set = stmt.executeQuery(query);
           rented = convertToProperty(set);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rented;
    }

    /**
     * Attempts to Close the connection to the database
     */
    public void close() {
        try{
            dbConnect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Attempts to initialize the connection to the database
     */
    public void initializeConnection() {
            try{
                this.dbConnect = DriverManager.getConnection(Database.DBURL, USERNAME, PASSWORD);

            } catch (SQLException e){
                e.printStackTrace();
            }
    }

    /**
     * Retrievs the total number of listings within a period
     */
    public int getNumListingsPeriod(int period) {
        int count = -1;
        try {
            String query = "SELECT COUNT(*) AS Number_Of_Listings\n" +
                    "FROM property\n" +
                    "WHERE PostedDate >= DATE_SUB(SYSDATE(), INTERVAL " + period + " DAY)";
            Statement stmt = dbConnect.createStatement();
            ResultSet set = stmt.executeQuery(query);
            set.next();
            count = set.getInt(1);
            stmt.close();
            set.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    /**
     * Retrieves the total number of listings RENTED within a period
     */
    public int getNumRentedListingsPeriod(int period) {
        int count = -1;
        try {
            String query = "SELECT COUNT(*) AS Number_Of_Rented_Listings\n" +
                    "FROM property\n" +
                    "WHERE PostedDate >= DATE_SUB(SYSDATE(), INTERVAL " + period +" DAY) AND property.Status = 'Rented'";
            Statement stmt = dbConnect.createStatement();
            ResultSet set = stmt.executeQuery(query);
            set.next();
            count = set.getInt(1);
            stmt.close();
            set.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
    /**
     * Retrieves the total number of active listings within a period
     */
    public int getNumActiveListingsPeriod(int period) {
        int count = -1;
        try {
            String query = "SELECT COUNT(*) AS Number_Of_Rented_Listings\n" +
                    "FROM property\n" +
                    "WHERE PostedDate >= DATE_SUB(SYSDATE(), INTERVAL " + period +" DAY) AND property.Status = 'Active'";
            Statement stmt = dbConnect.createStatement();
            ResultSet set = stmt.executeQuery(query);
            set.next();
            count = set.getInt(1);
            stmt.close();
            set.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    /**
     * Retrieves the total number of active listings total
     */

    public int getNumActiveListings(int period) {
        int count = -1;
        try {
            String query = "SELECT COUNT(*) AS Number_Of_Rented_Listings\n" +
                    "FROM property\n" +
                    "WHERE property.Status = 'Active'";
            Statement stmt = dbConnect.createStatement();
            ResultSet set = stmt.executeQuery(query);
            set.next();
            count = set.getInt(1);
            stmt.close();
            set.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;

    }
    /**
     *
     * @param set
     * @return ArrayList<Property>
     *     This helper function takes in a ResultSet generated from an SQL query, parses it, calls the
     *     property constructor, and returns the list of properties.
     */
    private ArrayList<Property> convertToProperty(ResultSet set) {
        ArrayList<Property> result = new ArrayList<>();
       try {
           while (set.next()) {
               String type = set.getString("Type");
               int ID = set.getInt("ID");
               String quadrant = set.getString("Quadrant");
               String status = set.getString("Status");
               String address = set.getString("Address");
               int numBedrooms = set.getInt("numBedrooms");
               int numBathrooms = set.getInt("numBathrooms");
               String furnished = set.getString("Furnished");
               boolean furnished_bool = false;
               if (furnished.equals("true") == true)
                    furnished_bool =  true;
               DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss");
               Timestamp posted = set.getTimestamp("PostedDate");
               String postedDate = posted.toString();
               Timestamp exp = set.getTimestamp("ExpDate");
               String emailLl = set.getString("LandLordEmail");
               String expDate = posted.toString();
               Property p = new Property(status, numBedrooms, numBathrooms, furnished_bool, quadrant, ID, address, postedDate, expDate, emailLl, type);
               result.add(p);
           }
       } catch (SQLException e) {
           e.printStackTrace();
       }
        return result;
    }
}