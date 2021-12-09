/*
 * File Name: UpdateController.java
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
 * 
 */
public class UpdateController extends Controller {

    /**
     * Default constructor
     */
    public UpdateController() {
        Database data = new PropertyInventory();
        myData.add(data);
    }

    /**
     * @param email
     * @return
     */
    public ArrayList<Property> forwardRequest(String email) {
        // TODO implement here
        Database d = myData.get(0);
        PropertyInventory property = (PropertyInventory) d;
        return property.getMatching(email);
    }

    /**
     * @param Property p
     * @return
     */
    public void forwardPropertyStatus(Property p) {
        // TODO implement here
        Database d = myData.get(0);
        PropertyInventory property = (PropertyInventory) d;
        property.updateProperty(p);
        return;
    }

}