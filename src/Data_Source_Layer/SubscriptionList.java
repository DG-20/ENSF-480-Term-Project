package Data_Source_Layer;

import Entity.Subscription;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.util.*;

/**
 * 
 */
public class SubscriptionList implements Database {

    /**
     * Default constructor
     */
    public SubscriptionList() {
    }

    /**
     * @param type 
     * @param numBedrooms 
     * @param numBathrooms 
     * @param furnished 
     * @param quadrant 
     * @param email 
     * @return
     */
    public void insertSubscription(String type, int numBedrooms, int numBathrooms, bool furnished, String quadrant, string email) {
        // TODO implement here
        return null;
    }

    /**
     * @param type 
     * @param numBedrooms 
     * @param numBathrooms 
     * @param furnished 
     * @param quadrant 
     * @param email 
     * @return
     */
    public void deleteSubscription(String type, int numBedrooms, int numBathrooms, bool furnished, String quadrant, String email) {
        // TODO implement here
        return null;
    }

    /**
     * @param email 
     * @return
     */
    public Set<Subscription> retrieveSubscription(String email) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public void close() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public void initializeConnection() {
        // TODO implement here
        return null;
    }

    /**
     * 
     */
    public void SubscriptionList() {
        // TODO implement here
    }

    /**
     * @return
     */
    public void close() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public void initializeConnection() {
        // TODO implement here
        return null;
    }

}