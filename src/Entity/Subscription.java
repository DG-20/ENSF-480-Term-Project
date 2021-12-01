package Entity;

import java.util.*;

/**
 * 
 */
public class Subscription {

    /**
     * Default constructor
     */
    public Subscription() {
    }

    /**
     * 
     */
    private String type;

    /**
     * 
     */
    private int numBedrooms;

    public Subscription(String type, int numBedrooms, int numBathrooms, bool furnished, String quadrant) {
        this.type = type;
        this.numBedrooms = numBedrooms;
        this.numBathrooms = numBathrooms;
        this.furnished = furnished;
        this.quadrant = quadrant;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNumBedrooms() {
        return numBedrooms;
    }

    public void setNumBedrooms(int numBedrooms) {
        this.numBedrooms = numBedrooms;
    }

    public int getNumBathrooms() {
        return numBathrooms;
    }

    public void setNumBathrooms(int numBathrooms) {
        this.numBathrooms = numBathrooms;
    }

    public bool getFurnished() {
        return furnished;
    }

    public void setFurnished(bool furnished) {
        this.furnished = furnished;
    }

    public String getQuadrant() {
        return quadrant;
    }

    public void setQuadrant(String quadrant) {
        this.quadrant = quadrant;
    }

    /**
     * 
     */
    private int numBathrooms;

    /**
     * 
     */
    private bool furnished;

    /**
     * 
     */
    private String quadrant;







    /**
     * @return
     */
    public void display() {
        // TODO implement here
        return null;
    }

    /**
     * @param type 
     * @param numBedrooms 
     * @param numBathrooms 
     * @param furnished 
     * @param quadrant
     */
    public void Subscription(String type, int numBedrooms, int numBathrooms, bool furnished, String quadrant) {
        // TODO implement here
    }

    /**
     * 
     */
    public void Operation2() {
        // TODO implement here
    }

}