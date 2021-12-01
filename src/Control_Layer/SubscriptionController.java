package Control_Layer;

import Data_Source_Layer.SubscriptionList;
import Entity.Subscription;

import java.util.*;

/**
 * 
 */
public class SubscriptionController extends Controller {

    /**
     * Default constructor
     */
    public SubscriptionController() {
    }

    /**
     * 
     */
    private SubscriptionList subList;

    /**
     * 
     */
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
        return null;
    }

    /**
     * @param email 
     * @return
     */
    public ArrayList<Subscription> getSubs(String email) {
        // TODO implement here
        return null;
    }

    public SubscriptionList getSubList() {
        return subList;
    }

    public void setSubList(SubscriptionList subList) {
        this.subList = subList;
    }

    public boolean isAddSub() {
        return addSub;
    }

    public void setAddSub(boolean addSub) {
        this.addSub = addSub;
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
    }

    /**
     * 
     */
    public void Operation1() {
        // TODO implement here
    }

    /**
     * @param addSub
     */
    public void SubscriptionController(boolean addSub) {
        // TODO implement here
    }

}