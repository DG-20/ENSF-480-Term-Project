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
    private Connection dbConnect;

    /**
     * 
     */
     final String DBURL = "":

    /**
     * 
     */
    final String USERNAME = "ORPMS";

    /**
     * 
     */
    final String PASSWORD = "ensf480";

    /**
     * @return
     */
    public void close();

    /**
     * @return
     */
    public void initializeConnection();

}