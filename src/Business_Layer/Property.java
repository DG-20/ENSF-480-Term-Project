/*
 * File Name: Property.java
 * Authors:
 *      Cheyenne Goh (UCID: 30040528)
 *      Divyansh Goyal (UCID: 30089488)
 *      Rui Guan(UCID: 30072848)
 *      Sajid Hafiz (UCID: 30061336)
 */
package Business_Layer;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/*
 * Property is an entity class which contains the information of the property itself.
 */
public class Property {
    private String status;
    private int numBedrooms;
    private int numBathrooms;
    private String type;
    private boolean furnished;
    private String quadrant;
    private int ID;
    private String address;
    private String email;
    private String expDate;
    private String postedDate;

    /*
     * The Constrcutor of Property takes in all the values of the property and
     * initializes the member variables.
     */
    public Property(String status, int numBedrooms, int numBathrooms, boolean furnished, String quadrant, int ID,
            String address, String posted_date, String exp_date, String email_address, String type) {
        this.status = status;
        this.type = type;
        this.numBedrooms = numBedrooms;
        this.numBathrooms = numBathrooms;
        this.furnished = furnished;
        this.quadrant = quadrant;
        this.ID = ID;
        this.address = address;
        this.email = email_address;
        this.postedDate = posted_date.substring(0,10); // Trim off the hh:mm:ss. Format is now yyyy-MM-dd
        this.expDate = exp_date.substring(0,10); // Trim off the hh:mm:ss. Format is now yyyy-MM-dd
    }

    /*
     * Empty default constructor.
     */
    public Property() {
    }

    // Getters and Setters.
    public String getStatus() {
        return status;
    }

    public String getType() {
        return type;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public boolean isFurnished() {
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

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getExpDate() {
        return this.expDate;
    }

    public void setExpDate(String exp_date) {
        this.expDate = exp_date;
    }

    public String getPostedDate() {
        return this.postedDate;
    }

    public void setPostedDate(String posted_date) {
        this.postedDate = posted_date;
    }

    // Setter.
    public void setType(String type) {
        this.type = type;
    }
}