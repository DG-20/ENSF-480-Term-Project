package Business_Layer;

import java.util.*;

public class Subscription {
    private String type;
    private int numBedrooms;
    private int numBathrooms;
    private boolean furnished;
    private String quadrant;

    public Subscription(String type, int numBedrooms, int numBathrooms, boolean furnished, String quadrant) {
        this.type = type;
        this.numBedrooms = numBedrooms;
        this.numBathrooms = numBathrooms;
        this.furnished = furnished;
        this.quadrant = quadrant;
    }

    public Subscription() {
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

    public boolean getFurnished() {
        return furnished;
    }

    public void setFurnished(boolean furnished) {
        this.furnished = furnished;
    }

    public String getQuadrant() {
        return quadrant;
    }

    public void setQuadrant(String quadrant) {
        this.quadrant = quadrant;
    }

    public void display() {
        // TODO implement here
        return;
    }
}