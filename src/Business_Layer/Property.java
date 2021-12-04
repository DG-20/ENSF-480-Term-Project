package Business_Layer;

import java.util.*;

public class Property {
    private String status;
    private int numBedrooms;
    private int numBathrooms;
    private boolean furnished;
    private String quadrant;
    private int ID;
    private String address;
    private String email;
    private int feeToPost;
    private String expDate;
    private String postedDate;

    public Property(String status, int numBedrooms, int numBathrooms, boolean furnished, String quadrant, int ID, String address, String posted_date, String exp_date, String email_address) {
        this.status = status;
        this.numBedrooms = numBedrooms;
        this.numBathrooms = numBathrooms;
        this.furnished = furnished;
        this.quadrant = quadrant;
        this.ID = ID;
        this.address = address;
        this.email = email_address;
        this.postedDate = posted_date;
        this.expDate = exp_date;
    }

    public Property() {
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

    public String getExpDate()
    {
        return this.expDate;
    }

    public void setExpDate(String exp_date)
    {
        this.expDate = exp_date;
    }

    public String getPostedDate()
    {
        return this.postedDate;
    }

    public void setPostedDate(String posted_date)
    {
        this.postedDate = posted_date;
    }

    public void display() {
        // TODO implement here
        return;
    }

    private void sendEmail() {
        // TODO implement here
        return;
    }
}