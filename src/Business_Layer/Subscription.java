/*
 * File Name: Subscription.java
 * Authors:
 *      Cheyenne Goh (UCID: 30040528)
 *      Divyansh Goyal (UCID: 30089488)
 *      Rui Guan(UCID: 30072848)
 *      Sajid Hafiz (UCID: 30061336)
 */
package Business_Layer;

/*
 * Subscription is an entity class which holds the parameters
 * used for criteria subscription by a Registered Renter.
 */
public class Subscription {
    private String type;
    private int numBedrooms;
    private int numBathrooms;
    private boolean furnished;
    private String quadrant;

    /*
     * Constructor of Subscription, takes in all the parameters in a subscription
     * and sets the local member variables accordingly.
     */
    public Subscription(String type, int numBedrooms, int numBathrooms, boolean furnished, String quadrant) {
        this.type = type;
        this.numBedrooms = numBedrooms;
        this.numBathrooms = numBathrooms;
        this.furnished = furnished;
        this.quadrant = quadrant;
    }

    // Getters and Setters.
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
}