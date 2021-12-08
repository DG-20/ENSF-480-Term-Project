/*
 * File Name: Database.java
 * Authors:
 *      Cheyenne Goh (UCID: 30040528)
 *      Divyansh Goyal (UCID: 30089488)
 *      Rui Guan(UCID: 30072848)
 *      Sajid Hafiz (UCID: 30061336)
 */
package Data_Source_Layer;

import java.sql.Connection;
import java.util.*;

/**
 * 
 */
public interface Database {

    /**
     *
     */

    /**
     * The JDBC URL to the Database
     */
    final String DBURL = "jdbc:mysql://127.0.0.1:3306/orpms";

    /**
     * The username for the Database
     */
    final String USERNAME = "ORPMS";

    /**
     * The password for the Database
     */
    final String PASSWORD = "ensf480";

    /**
     * Closes connection to the database
     *
     */
    public void close();

    /**
     * Opens a connection to the daatabase
     */
    public void initializeConnection();

}