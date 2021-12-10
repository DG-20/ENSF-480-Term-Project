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

/**
 * The controller for the property registration.
 * This class communicates with the Database and the RegistrationForm.
 * This class extends Controller.
 */
public class RegistrationController extends Controller {

    /**
     * Default constructor.
     * This constructor creates a new object data to be a new PropertyInventory
     * object.
     * Also, this adds this data object to the myData ArrayList in Controller.
     */
    public RegistrationController() {
        Database data = new PropertyInventory();
        myData.add(data);
    }

    /**
     * Call the registerProperty function of the PropertyInventory class.
     * This method takes in the property's values as arguments and then passes it to
     * registerProperty.
     * The return type of forwardProperty is void.
     */
    public void forwardProperty(String type, int numBedrooms, int numBathrooms, boolean furnished, String quadrant,
            String email, String address) {
        Database d = myData.get(0);
        PropertyInventory property = (PropertyInventory) d;
        property.registerProperty(type, numBedrooms, numBathrooms, furnished, quadrant, email, address);
        return;
    }
}