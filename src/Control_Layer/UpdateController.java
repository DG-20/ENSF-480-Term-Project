package Control_Layer;

import Data_Source_Layer.PropertyInventory;
import Entity.Property;

import java.util.*;

/**
 * 
 */
public class UpdateController extends Controller {

    /**
     * Default constructor
     */
    public UpdateController() {
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

    public void getAttribute1() {
        return Attribute1;
    }

    public void setAttribute1(void attribute1) {
        Attribute1 = attribute1;
    }

    /**
     * 
     */
    public void Attribute1;





    /**
     * @param email 
     * @return
     */
    public ArrayList<Property> forwardRequest(String email) {
        // TODO implement here
        return null;
    }

    /**
     * @param Property p 
     * @return
     */
    public void forwardPropertyStatus(Property p) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public Set<Property> forwardRequest() {
        // TODO implement here
        return null;
    }

    /**
     * 
     */
    public void UpdateController() {
        // TODO implement here
    }

}