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
 * 
 */
public abstract class Controller {

    /**
     * Default constructor
     */
    public Controller() {
    }

    /**
     * 
     */
    private ArrayList<Database> myData = new ArrayList<Database>(1);

     

    public ArrayList<Database> getDatabase(){
        return myData;
    }

    public void add(Database data){
        myData.add(data);
    }
}