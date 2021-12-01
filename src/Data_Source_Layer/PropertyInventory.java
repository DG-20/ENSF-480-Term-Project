package Data_Source_Layer;

import Entity.Property;

import java.sql.Connection;
import java.util.*;

/**
 * 
 */
public class PropertyInventory implements Database {

    /**
     * Default constructor
     */
    public PropertyInventory() {
    }

    /**
     * 
     */
    private Connection dbConnect;

    public ArrayList<Property> getMySearchedProperties() {
        return mySearchedProperties;
    }

    public void setMySearchedProperties(ArrayList<Property> mySearchedProperties) {
        this.mySearchedProperties = mySearchedProperties;
    }

    /**
     * 
     */
    private void DBURL;

    /**
     * 
     */
    public void user;

    /**
     * 
     */
    public void pass;

    /**
     * 
     */
    private ArrayList<Property> mySearchedProperties;











    /**
     * @param type 
     * @param numBedrooms 
     * @param numBathrooms 
     * @param furnished 
     * @param quadrant 
     * @return
     */
    public Set<Property> getMatching(String type, int numBedrooms, int numBathrooms, bool furnished, String quadrant) {
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
     * @param int 
     * @param address 
     * @return
     */
    public void registerProperty(String type, int numBedrooms, int numBathrooms, bool furnished, String quadrant, String email, ID int, string address) {
        // TODO implement here
        return null;
    }

    /**
     * @param email 
     * @return
     */
    public Set<Property> getMatching(string email) {
        // TODO implement here
        return null;
    }

    /**
     * @param p 
     * @return
     */
    public void updateProperty(Property p) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public Set<Property> retrieveSummary() {
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
    public void PropertyInventory() {
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