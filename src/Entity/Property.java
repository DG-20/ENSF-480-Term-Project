package Entity;

import java.util.*;

/**
 * 
 */
public class Property {

    /**
     * Default constructor
     */
    public Property() {
    }

    /**
     * 
     */
    public void bool;

    /**
     * 
     */
    private int daysPaidRemaining;

    /**
     * 
     */
    private String status;

    public void getBool() {
        return bool;
    }

    public void setBool(void bool) {
        this.bool = bool;
    }

    public int getDaysPaidRemaining() {
        return daysPaidRemaining;
    }

    public Property(int daysPaidRemaining, String status, int numBedrooms, int numBathrooms, boolean furnished, String quadrant, int ID, String address, String email, int feeToPost) {
        this.daysPaidRemaining = daysPaidRemaining;
        this.status = status;
        this.numBedrooms = numBedrooms;
        this.numBathrooms = numBathrooms;
        this.furnished = furnished;
        this.quadrant = quadrant;
        this.ID = ID;
        this.address = address;
        this.email = email;
        this.feeToPost = feeToPost;
    }

    public void setDaysPaidRemaining(int daysPaidRemaining) {
        this.daysPaidRemaining = daysPaidRemaining;
    }

    public String getStatus() {
        return status;
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

    public int getFeeToPost() {
        return feeToPost;
    }

    public void setFeeToPost(int feeToPost) {
        this.feeToPost = feeToPost;
    }

    /**
     * 
     */
    private int numBedrooms;

    /**
     * 
     */
    private int numBathrooms;

    /**
     * 
     */
    private boolean furnished;

    /**
     * 
     */
    private String quadrant;

    /**
     * 
     */
    private int ID;

    /**
     * 
     */
    private String address;

    /**
     * 
     */
    private String email;

    /**
     * 
     */
    private int feeToPost;





    /**
     * @return
     */
    public void display() {
        // TODO implement here
        return null;
    }

    /**
     * 
     */
    public void Operation1() {
        // TODO implement here
    }

    /**
     * @param daysPaidRemaining 
     * @param status 
     * @param numBedrooms 
     * @param numBathrooms 
     * @param furnished 
     * @param quadrant 
     * @param ID 
     * @param address 
     * @param email
     */
    public void Property(int daysPaidRemaining, String status, int numBedrooms, int numBathrooms, bool furnished, String quadrant, int ID, String address, String email) {
        // TODO implement here
    }

    /**
     * @return
     */
    private void sendEmail() {
        // TODO implement here
        return null;
    }

}