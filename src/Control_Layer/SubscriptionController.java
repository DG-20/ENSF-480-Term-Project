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

/**
 * 
 */
public class SubscriptionController extends Controller {

    /**
     * Default constructor
     */
    public SubscriptionController(boolean addSub) {
        this.addSub=addSub;
        Database data = new SubscriptionList();
        myData.add(data);
    }

    private boolean addSub;





    /**
     * @param type 
     * @param numBedrooms 
     * @param numBathrooms 
     * @param furnished 
     * @param quadrant 
     * @param email 
     * @return
     */
    public void forwardSub(String type, int numBedrooms, int numBathrooms, boolean furnished, String quadrant, String email) {
        // TODO implement here
        Database d = myData.get(0);
        SubscriptionList list = (SubscriptionList)d;
        list.insertSubscription(type, numBedrooms, numBathrooms, furnished, quadrant, email);
        return; 
    }

    /**
     * @param email 
     * @return
     */
    public ArrayList<Subscription> getSubs(String email) {
        // TODO implement here
        Database d = myData.get(0);
        SubscriptionList list = (SubscriptionList)d;
        return list.retrieveSubscription(email);
    }


    /**
     * @param type 
     * @param numBedrooms 
     * @param numBathrooms 
     * @param furnished 
     * @param quadrant 
     * @param email
     */
    public void forwardDeleteSub(String type, int numBedrooms, int numBathrooms, boolean furnished, String quadrant, String email) {
        // TODO implement here
        Database d = myData.get(0);
        SubscriptionList list = (SubscriptionList)d;
        list.deleteSubscription(type, numBedrooms, numBathrooms, furnished, quadrant, email);
        return;
    }


    public ArrayList<Property> getSubbedProperties(String email){
        Database d = myData.get(0);
        PropertyInventory property = (PropertyInventory)d;
        return property.getNotifications(email);
    }
}