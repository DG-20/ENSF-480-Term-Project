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

/*
 * Class for updating the PropertyInventory database.
 * This class extends Controller.
 */
public class UpdateController extends Controller {
    /*
     * Default constructor creates a new object of type PropertyInventory and adds
     * it to myData.
     */
    public UpdateController() {
        Database data = new PropertyInventory();
        myData.add(data);
    }

    /*
     * Calls getMatching function in PropertyInventory and takes in the User's
     * email.
     * It returns the properties associated with the landlord's email in an
     * ArrayList.
     */
    public ArrayList<Property> forwardRequest(String email) {
        Database d = myData.get(0);
        PropertyInventory property = (PropertyInventory) d;
        return property.getMatching(email);
    }

    /*
     * Calls updateProperty function in PropertyInventory.
     * This takes in a Property as the argument and passes that property into the
     * updateProperty function to update the database.
     * The return type of this method is void.
     */
    public void forwardPropertyStatus(Property p) {
        Database d = myData.get(0);
        PropertyInventory property = (PropertyInventory) d;
        property.updateProperty(p);
        return;
    }
}
