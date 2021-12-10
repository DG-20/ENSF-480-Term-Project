/*
 * File Name: SubscriptionController.java
 * Authors:
 *      Cheyenne Goh (UCID: 30040528)
 *      Divyansh Goyal (UCID: 30089488)
 *      Rui Guan(UCID: 30072848)
 *      Sajid Hafiz (UCID: 30061336)
 */
package Control_Layer;

import Data_Source_Layer.*;
import Business_Layer.*;
import java.util.*;

/*
 * Controller for managing subscription. This class extends the Controller class.
 * This class communicates with SubscriptionForm and the Database.
 */
public class SubscriptionController extends Controller {
    /*
     * Default constructor which takes in a boolean.
     * This constructor adds objects of SubscriptionList and PropertyInventory into
     * myData.
     */
    public SubscriptionController(boolean addSub) {
        Database data = new SubscriptionList();
        myData.add(data);
        Database data2 = new PropertyInventory();
        myData.add(data2);
    }

    /*
     * Calls insertSubscription function in SubscriptionList.
     * This method takes in the subscription parameters and passes them into
     * insertSubscription. This method returns void.
     */
    public void forwardSub(String type, int numBedrooms, int numBathrooms, boolean furnished, String quadrant,
            String email) {
        Database d = myData.get(0);
        SubscriptionList list = (SubscriptionList) d;
        list.insertSubscription(type, numBedrooms, numBathrooms, furnished, quadrant, email);
        return;
    }

    /*
     * Calls retrieveSubscription function in SubscriptionList.
     * This function takes in the email of the user.
     * It returns an ArrayList of Subscriptions which was retrieved from
     * retrieveSubscription.
     */
    public ArrayList<Subscription> getSubs(String email) {
        Database d = myData.get(0);
        SubscriptionList list = (SubscriptionList) d;
        return list.retrieveSubscription(email);
    }

    /*
     * Calls deleteSubscription function of SubscriptionList.
     * This method takes in arguments of the subscription paramters and passes them
     * into deleteSubscription.
     * This method does not return anything.
     */
    public void forwardDeleteSub(String type, int numBedrooms, int numBathrooms, boolean furnished, String quadrant,
            String email) {
        Database d = myData.get(0);
        SubscriptionList list = (SubscriptionList) d;
        list.deleteSubscription(type, numBedrooms, numBathrooms, furnished, quadrant, email);
        return;
    }

    /*
     * Asks the database for all properties matching subscriptions associated with a
     * registered renter's email and returns all those properties in an ArrayList.
     */
    public ArrayList<Property> getSubbedProperties(String email) {
        Database d = myData.get(1);
        PropertyInventory property = (PropertyInventory) d;
        return property.getNotifications(email);
    }
}
