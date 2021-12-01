package Data_Source_Layer;

import Entity.Subscription;

import java.lang.reflect.Array;
import java.sql.*;
import java.util.*;

/**
 * 
 */
public class SubscriptionList implements Database {

    private Connection dbConnect;

    /**
     * Default constructor
     */
    public SubscriptionList() {
        initializeConnection();
    }

    /**
     * @param type 
     * @param numBedrooms 
     * @param numBathrooms 
     * @param furnished 
     * @param quadrant 
     * @param email 
     * Inserts a subscription into the database associated with a certain registered renter
     */
    public void insertSubscription(String type, int numBedrooms, int numBathrooms, boolean furnished, String quadrant, String email) {
        try{
            String query = "INSERT INTO subscription(RREmail, Quadrant, Furnished, numBathrooms, numBedrooms, Type) VALUES " +
                    "(?, ?, ?, ?, ?, ?)";
            String furn = "N";
            if (furnished) furn = "Y";
            PreparedStatement stmt = dbConnect.prepareStatement(query);
            stmt.setString(1, email);
            stmt.setString(2, quadrant);
            stmt.setString(3, furn);
            stmt.setInt(4, numBathrooms);
            stmt.setInt(5, numBedrooms);
            stmt.setString(6, type);
            int row = stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param type 
     * @param numBedrooms 
     * @param numBathrooms 
     * @param furnished 
     * @param quadrant 
     * @param email 
     * Deletes a certain subscription from the database associated with a certain registered renter and subscription details
     */
    public void deleteSubscription(String type, int numBedrooms, int numBathrooms, boolean furnished, String quadrant, String email) {
        try{
            String query = "DELETE FROM subscription WHERE RREmail = ? AND Quadrant = ? AND Furnished = ? AND numBathrooms = ? AND numBedrooms = ? AND Type = ?";
            String furn = "N";
            if (furnished) furn = "Y";
            PreparedStatement stmt = dbConnect.prepareStatement(query);
            stmt.setString(1, email);
            stmt.setString(2, quadrant);
            stmt.setString(3, furn);
            stmt.setInt(4, numBathrooms);
            stmt.setInt(5, numBedrooms);
            stmt.setString(6, type);
            int row = stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param email 
     * @return Returns the subscription details associated with a registered renter's email
     */
    public ArrayList<Subscription> retrieveSubscription(String email) {
        ArrayList<Subscription> mySubs = new ArrayList<>();
        try {
            String query = "SELECT *\n" +
                    "FROM Subscription\n" +
                    "WHERE Subscription.RREmail = " + email;
            Statement stmt = dbConnect.createStatement();
            ResultSet set = stmt.executeQuery(query);
            while (set.next()) {
                String quadrant = set.getString("Quadrant");
                String furnished = set.getString("Furnished");
                int numBathrooms = set.getInt("numBathrooms");
                int numBedrooms = set.getInt("numBedrooms");
                String type = set.getString("Type");
                Subscription s = new Subscription();
                mySubs.add(s);
            }
            stmt.close();
            set.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mySubs;
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
     * Attempts to intialize a connection to the database
     */
    public void initializeConnection() {
        try{
            this.dbConnect = DriverManager.getConnection(Database.DBURL, USERNAME, PASSWORD);

        } catch (SQLException e){
            e.printStackTrace();
        }
    }


}