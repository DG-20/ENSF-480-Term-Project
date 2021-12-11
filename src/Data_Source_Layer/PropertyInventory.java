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
import Business_Layer.Singleton;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/*
A database interface class concerned with property management.
 */
public class PropertyInventory implements Database {

    private Connection dbConnect;

    /**
     * Default constructor which initializes the connection, and updates the
     * properties using the date.
     */
    public PropertyInventory() {
        initializeConnection();
        updateAllProperties();
    }

    /**
     * A helper function. This updates all properties in the database where the
     * current date > Expiry Date and
     * the status is not Rented to Cancelled.
     */
    private void updateAllProperties() {
        try {
            String query = "UPDATE property SET Status = 'Cancelled' WHERE SYSDATE() > ExpDate AND Status != 'Rented';";
            Statement stmt = dbConnect.createStatement();
            stmt.executeUpdate(query);
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Property> getAllProperties() {
        ArrayList<Property> allProperties = new ArrayList<>();
        try {
            String query = "SELECT * FROM PROPERTY";
            Statement stmt = dbConnect.createStatement();
            ResultSet set = stmt.executeQuery(query);
            allProperties = convertToProperty(set);
            stmt.close();
            set.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allProperties;
    }

    /**
     * Finds the matched properties that match the parameters and are also active.
     *
     * @param type
     * @param numBedrooms
     * @param numBathrooms
     * @param furnished
     * @param quadrant
     * @return ArrayList<Property> that matches the function parameters
     */
    public ArrayList<Property> getMatching(String type, int numBedrooms, int numBathrooms, boolean furnished,
            String quadrant) {
        char furn = 'N';
        ArrayList<Property> matchedProperties = new ArrayList<>();
        if (furnished) {
            furn = 'Y';
        }
        try {
            String query = "SELECT * FROM property WHERE Quadrant = '" + quadrant + "' AND Furnished = '" + furn
                    + "' AND numBathrooms =" + numBathrooms +
                    " AND numBedrooms = " + numBedrooms + " AND Type = '" + type + "' AND Status = 'Active'";
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
     * Inserts a property into the database
     *
     * @param type
     * @param numBedrooms
     * @param numBathrooms
     * @param furnished
     * @param quadrant
     * @param email
     * @param address
     */
    public void registerProperty(String type, int numBedrooms, int numBathrooms, boolean furnished, String quadrant,
            String email, String address) {
        try {

            Database myPaymentPeriodRecord = new PaymentPeriodRecord();

            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
            LocalDateTime localDate = LocalDateTime.now();
            String currentDate = dateFormat.format(localDate);

            LocalDateTime localExpdate = localDate
                    .plusDays(((PaymentPeriodRecord) myPaymentPeriodRecord).retrievePeriod());
            String expDate = dateFormat.format(localExpdate);

            String furn = "N";
            if (furnished)
                furn = "Y";
            String query = "INSERT INTO property (ID, LandlordEmail, Status, Quadrant, Address, Furnished, numBathrooms, numBedrooms, Type, PostedDate, ExpDate, RentedDate) VALUES (ID, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = dbConnect.prepareStatement(query);
            stmt.setString(1, email);
            stmt.setString(2, "Active");
            stmt.setString(3, quadrant);
            stmt.setString(4, address);
            stmt.setString(5, furn);
            stmt.setInt(6, numBathrooms);
            stmt.setInt(7, numBedrooms);
            stmt.setString(8, type);
            stmt.setTimestamp(9, java.sql.Timestamp.valueOf(currentDate));
            stmt.setTimestamp(10, java.sql.Timestamp.valueOf(expDate));
            stmt.setNull(11, Types.NULL);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Finds all properties associated with a user and their usertype and returns
     * those properties.
     *
     * @param email The email of a landlord/Manager
     * @return ArrayList<Property> that is managed by that user.
     */
    public ArrayList<Property> getMatching(String email) {

        ArrayList<Property> myProperties = new ArrayList<>();
        /*
         * First need to check if the email belongs to Landlord or Manager to decide
         * which properties to send.
         */
        boolean type = Singleton.getInstance().isManager(email);
        if (type) {
            // The user is a manager. Send all properties.
            try {
                String query = "SELECT * FROM property";
                Statement stmt = dbConnect.createStatement();
                ResultSet set = stmt.executeQuery(query);
                myProperties = convertToProperty(set);
                stmt.close();
                set.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            /* User is a Landlord. */
            try {
                String query = "SELECT * FROM property where LandlordEmail = '" + email + "'";
                Statement stmt = dbConnect.createStatement();
                ResultSet set = stmt.executeQuery(query);
                myProperties = convertToProperty(set);
                stmt.close();
                set.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return myProperties;
    }

    /**
     * Matches all properties that fit the registered renter's criteria and returns
     * them
     *
     * @param email The email of the registered Renter
     * @return An arraylist<Property> that matches the registered renter's
     *         subscriptions
     */
    public ArrayList<Property> getNotifications(String email) {
        ArrayList<Property> notifiedProperties = new ArrayList<>();
        try {
            String query = "SELECT * \n" +
                    "FROM\n" +
                    "(\n" +
                    "SELECT property.ID, property.LandlordEmail, property.Status, property.Quadrant, property.Address, property.Furnished, property.numBathrooms, property.numBedrooms, property.Type, property.PostedDate, property.ExpDate, property.RentedDate\n"
                    +
                    "FROM\n" +
                    "(\n" +
                    "SELECT *\n" +
                    "FROM subscription\n" +
                    "WHERE RREmail = '" + email +
                    "') AS T JOIN property using(Quadrant, Furnished, numBathrooms, numBedrooms)\n" +
                    "WHERE T.Quadrant = property.Quadrant AND T.Furnished = property.furnished AND T.numBathrooms = property.numBathrooms AND T.numBedrooms = property.numBedrooms\n"
                    +
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
     * Updates the property in the database to a new status.
     * If the property's new status is Rented, update the RentedDate as well.
     * 
     * @param p The property chosen to be updated.
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

            /* If the new status is rented, also update the RentedDate to today */
            if (newStatus.equals("Rented")) {
                updateRentedDate(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Update the property's Rented Date.
     * 
     * @param p The property chosen to be updated.
     */
    private void updateRentedDate(Property p) {
        int ID = p.getID();
        try {
            String query = "UPDATE property SET RentedDate = ? WHERE ID = ?";

            /* Get current date */
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
            LocalDateTime localDate = LocalDateTime.now();
            String currentDate = dateFormat.format(localDate);

            PreparedStatement stmt = dbConnect.prepareStatement(query);
            stmt.setString(1, currentDate);
            stmt.setInt(2, ID);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param period The period of the report where it checks the dates betweeen
     *               [currentDate-period, currentDate]
     * @return An arraylist of properties that were rented within the period.
     */
    public ArrayList<Property> retrieveSummary(int period) {
        ArrayList<Property> rented = new ArrayList<>();
        try {
            String query = "SELECT LandlordEmail, Name, ID AS House_ID, Address\n" +
                    "FROM property INNER JOIN user ON property.LandlordEmail = user.Email\n" +
                    "WHERE property.RentedDate >= DATE_SUB(SYSDATE(), " + " INTERVAL " + period +
                    " DAY);";
            Statement stmt = dbConnect.createStatement();
            ResultSet set = stmt.executeQuery(query);
            while (set.next()) {
                int houseID = set.getInt("House_ID");
                String address = set.getString("Address");
                String emailAddress = set.getString("LandlordEmail");
                Property p = new Property("Rented", -1, -1, false, "AA", houseID, address, "yyyy-MM-dd hh:mm:ss",
                        "yyyy-MM-dd hh:mm:ss", emailAddress, "", "yyyy-MM-dd hh:mm:ss");
                rented.add(p);
            }
            stmt.close();
            set.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rented;
    }

    // Attempts to Close the connection to the database.
    public void close() {
        try {
            dbConnect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Attempts to initialize the connection to the database.
    public void initializeConnection() {
        try {
            this.dbConnect = DriverManager.getConnection(Database.DBURL, USERNAME, PASSWORD);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param period The period of the report where it checks the dates betweeen
     *               [currentDate-period, currentDate]
     * @return the total number of listings within a period.
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
     *
     * @param period The period of the report where it checks the rentedDate
     *               betweeen [currentDate-period, currentDate]
     * @return Retrieves the total number of listings RENTED within a period.
     */
    public int getNumRentedListingsPeriod(int period) {
        int count = -1;
        try {
            String query = "SELECT COUNT(*) AS Number_Of_Rented_Listings\n" +
                    "FROM property\n" +
                    "WHERE RentedDate >= DATE_SUB(SYSDATE(), INTERVAL " + period
                    + " DAY)";
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

    // Retrieves the total number of active listings within a period.

    /**
     *
     * @param period The period of the report where it checks the dates betweeen
     *               [currentDate-period, currentDate]
     * @return the total number of active listings within a period.
     */
    public int getNumActiveListingsPeriod(int period) {
        int count = -1;
        try {
            String query = "SELECT COUNT(*) AS Number_Of_Active_Listings\n" +
                    "FROM property\n" +
                    "WHERE PostedDate >= DATE_SUB(SYSDATE(), INTERVAL " + period
                    + " DAY) AND property.Status = 'Active'";
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
     * @return the total number of active listings total.
     */
    public int getNumActiveListings() {
        int count = -1;
        try {
            String query = "SELECT COUNT(*) AS Number_Of_Active_Listings\n" +
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
     * This helper function takes in a ResultSet generated from an SQL query, parses
     * it, calls the property constructor, and returns the list of properties.
     * 
     * @param set - The set of all affected rows from the query
     * @return The converted array list of properties from the ResultSet
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
                if (furnished.equals("Y"))
                    furnished_bool = true;
                DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
                Timestamp posted = set.getTimestamp("PostedDate");
                String postedDate = posted.toString();
                Timestamp exp = set.getTimestamp("ExpDate");
                String emailLl = set.getString("LandLordEmail");
                String expDate = exp.toString();
                Timestamp rented = set.getTimestamp("RentedDate");
                String rentedDate = "yyyy-MM-dd hh:mm:ss";
                if (!set.wasNull()) {
                    rentedDate = rented.toString();
                }
                Property p = new Property(status, numBedrooms, numBathrooms, furnished_bool, quadrant, ID, address,
                        postedDate, expDate, emailLl, type, rentedDate);
                result.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}