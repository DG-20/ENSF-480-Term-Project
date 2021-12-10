/*
 * File Name: Controller.java
 * Authors:
 *      Cheyenne Goh (UCID: 30040528)
 *      Divyansh Goyal (UCID: 30089488)
 *      Rui Guan(UCID: 30072848)
 *      Sajid Hafiz (UCID: 30061336)
 */
package Control_Layer;

import Data_Source_Layer.Database;

import java.util.*;

/**
 * This abstract Controller class serves as a container (almost like an
 * interface) for all Controller classes.
 * It contains an ArrayList of Database objects.
 */
public abstract class Controller {

    /*
     * Default constructor which initializes myData.
     */
    public Controller() {
        myData = new ArrayList<>();
    }

    protected ArrayList<Database> myData;
}