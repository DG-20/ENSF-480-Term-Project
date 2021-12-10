package User_Interface_Layer;

import Business_Layer.Property;
import Data_Source_Layer.Database;
import Data_Source_Layer.PropertyInventory;

import javax.xml.crypto.Data;
import java.util.ArrayList;

/**
 * This class is a detaild view of all properties.
 */
public class DetailedViewProperty extends InteractionForm {
    ArrayList<Property> allProperties;
    Database myData;

    /**
     * Constructor, initializes allProperties and calls display.
     */
    public DetailedViewProperty() {
        myData = new PropertyInventory();
        allProperties = ((PropertyInventory)myData).getAllProperties();
    }

    public void display() {
        
    }


}
