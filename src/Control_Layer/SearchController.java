/*
 * File Name: SearchController.java
 * Authors:
 *      Cheyenne Goh (UCID: 30040528)
 *      Divyansh Goyal (UCID: 30089488)
 *      Rui Guan(UCID: 30072848)
 *      Sajid Hafiz (UCID: 30061336)
 */
package Control_Layer;

import Data_Source_Layer.*;
import Business_Layer.Property;
import java.util.*;

/**
 * Controller for browsing matching properties.
 * This class extends the Controller class.
 * Its purpose is to communicate between SearchForm and the Database.
 */
public class SearchController extends Controller {

    /*
     * Default constructor which adds a new object of type PropertyInventory into
     * myData.
     */
    public SearchController() {
        Database data = new PropertyInventory();
        myData.add(data);
    }

    /*
     * Calls the getMatching method in PropertyInventory and takes in arguments of
     * the search parameters.
     * This method returns an ArrayList of Property type which is the ArrayList
     * returned by getMatching.
     */
    public ArrayList<Property> forwardSearch(String type, int numBedrooms, int numBathrooms, boolean furnished,
            String quadrant) {
        Database d = myData.get(0);
        PropertyInventory property = (PropertyInventory) d;
        return property.getMatching(type, numBedrooms, numBathrooms, furnished, quadrant);
    }
}