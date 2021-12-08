/*
 * File Name: PaymentPeriodRecord.java
 * Authors:
 *      Cheyenne Goh (UCID: 30040528)
 *      Divyansh Goyal (UCID: 30089488)
 *      Rui Guan(UCID: 30072848)
 *      Sajid Hafiz (UCID: 30061336)
 */
package Data_Source_Layer;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.*;

/**
 * 
 */
public class PaymentPeriodRecord implements Database {
    private Connection dbConnect;

    /**
     * Constructor, calls initializeConnection()
     */
    public PaymentPeriodRecord() {
        initializeConnection();
    }


    /**
     * @param fee 
     * @param period 
     * @return nothing
     * Updates the Database with a new fee or new period value where fee and period >=1.
     */
    public void updatePeriodPayment(int fee, int period) {
       try {
           if (fee >=1) {
               String query = "UPDATE fee SET Fee = " + fee;
               Statement stmt = dbConnect.createStatement();
               ResultSet result = stmt.executeQuery(query);
               stmt.close();
               result.close();
           }
       } catch (SQLException e) {
           e.printStackTrace();
       }
       try {
           if (period >=1) {
               String query = "UPDATE period SET Period = "+ period;
               Statement stmt = dbConnect.createStatement();
               ResultSet result = stmt.executeQuery(query);
               stmt.close();
               result.close();
           }
       } catch (SQLException e) {
           e.printStackTrace();
       }
    }

    /**
     * @return the current fee stored in the database
     */
    public int retrievePayment() {
        int fee = -1;
        try{
            String query = "select Fee from fee";
            Statement stmt = dbConnect.createStatement();
            ResultSet result = stmt.executeQuery(query);
            while (result.next()) {
                fee = result.getInt("Fee");
            }
            stmt.close();
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return fee;
    }

    /**
     *
     * @return The period stored in the database
     */
    public int retrievePeriod() {
        int period = -1;
        try{
            String query = "select Period from period";
            Statement stmt = dbConnect.createStatement();
            ResultSet result = stmt.executeQuery(query);
            while (result.next()) {
                period = result.getInt("Period");
            }
            stmt.close();
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return period;
    }


    /**
     * Attempts to establish a connection to the database using the DBURL, USERNAME, and PASSWORD
     */
    public void initializeConnection() {
        try{
            this.dbConnect = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);

        } catch (SQLException e){
            e.printStackTrace();
        }
        return;
    }

    /**
     * Closes connection to the database
     */
    public void close() {
        try{
            dbConnect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}