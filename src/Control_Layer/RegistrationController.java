package Control_Layer;

import Data_Source_Layer.PropertyInventory;

import java.util.*;

/**
 * 
 */
public class RegistrationController extends Controller {

    /**
     * Default constructor
     */
    public RegistrationController() {
    }

    /**
     * 
     */
    private PropertyInventory myInventory;

    public PropertyInventory getMyInventory() {
        return myInventory;
    }

    public void setMyInventory(PropertyInventory myInventory) {
        this.myInventory = myInventory;
    }

    public PeriodFeesController getMyPeriodFees() {
        return myPeriodFees;
    }

    public void setMyPeriodFees(PeriodFeesController myPeriodFees) {
        this.myPeriodFees = myPeriodFees;
    }

    /**
     * 
     */
    private PeriodFeesController myPeriodFees;



    /**
     * @param type 
     * @param numBedrooms 
     * @param numBathrooms 
     * @param furnished 
     * @param quadrant 
     * @param email 
     * @param int 
     * @param address 
     * @return
     */
    public void forwardProperty(String type, int numBedrooms, int numBathrooms, boolean furnished, String quadrant, String email, int ID, String address) {
        // TODO implement here
        return;
    }

    /**
     * 
     */
    public void RegistrationController() {
        // TODO implement here
    }

}