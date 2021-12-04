package Control_Layer;

import Data_Source_Layer.PropertyInventory;
import Business_Layer.Property;

import java.util.*;

/**
 * 
 */
public class SearchController extends Controller {

    /**
     * Default constructor
     */
    public SearchController() {
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

    /**
     * @param type 
     * @param numBedrooms 
     * @param numBathrooms 
     * @param furnished 
     * @param quadrant 
     * @return
     */
    public ArrayList<Property> forwardSearch(String type, int numBedrooms, int numBathrooms, boolean furnished, String quadrant) {
        // TODO implement here
        return null;
    }

    /**
     * 
     */
    public void SearchController() {
        // TODO implement here
    }

}