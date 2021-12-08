/*
 * File Name: RegistrationController.java
 * Authors:
 *      Cheyenne Goh (UCID: 30040528)
 *      Divyansh Goyal (UCID: 30089488)
 *      Rui Guan(UCID: 30072848)
 *      Sajid Hafiz (UCID: 30061336)
 */
package Control_Layer;

import Data_Source_Layer.*;

import java.util.*;

/**
 * 
 */
public class RegistrationController extends Controller {

    /**
     * Default constructor
     */
    public RegistrationController() {
        Database data = new PropertyInventory();
        myData.add(data);
    }



    /**
     * @param type 
     * @param numBedrooms 
     * @param numBathrooms 
     * @param furnished 
     * @param quadrant 
     * @param email
     * @param address 
     * @return
     */
    public void forwardProperty(String type, int numBedrooms, int numBathrooms, boolean furnished, String quadrant, String email, String address) {
        // TODO implement here
        Database d = myData.get(0);
        PropertyInventory property = (PropertyInventory)d;
        property.registerProperty(type, numBedrooms, numBathrooms, furnished, quadrant, email, address);
        return;
    }
}