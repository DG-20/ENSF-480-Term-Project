/*
 * File Name: Singleton.java
 * Authors:
 *      Cheyenne Goh (UCID: 30040528)
 *      Divyansh Goyal (UCID: 30089488)
 *      Rui Guan(UCID: 30072848)
 *      Sajid Hafiz (UCID: 30061336)
 */
package Business_Layer;

import java.util.*;

/*
 * Singleton class is a class of which only one instance can be made.
 * This class checks the registeredUsers member variable 
 * to determine the type of the email entered.
 */
public class Singleton {
    private static Singleton instance;
    private ArrayList<User> registeredUsers;

    // Getter and setter.
    public ArrayList<User> getRegisteredUsers() {
        return registeredUsers;
    }

    public void setRegisteredUsers(ArrayList<User> registeredUsers) {
        this.registeredUsers = registeredUsers;
    }

    /*
     * The major singleton method. If an instance already occurs, return that
     * instance.
     * If it doesn't, create a new instance and return that.
     */
    public static Singleton getInstance() {
        if (instance == null)
            instance = new Singleton();
        return instance;
    }

    /*
     * This method checks the email in question and
     * returns True if the email is associated with an existing Manager account,
     * otherwise returns false.
     */
    public boolean isManager(String email) {
        boolean result = false;
        for (User u : registeredUsers) {
            if (email.equals(u.getEmail()) && u.getType().equals("Manager")) {
                result = true;
            }
        }
        return result;
    }

    /*
     * This method checks the email in question and
     * returns True if the email is associated with an existing Registered Renter
     * account, otherwise returns false.
     */
    public boolean isRR(String email) {
        boolean result = false;
        for (User u : registeredUsers) {
            if (email.equals(u.getEmail()) && u.getType().equals("RR")) {
                result = true;
            }
        }
        return result;
    }

    /*
     * This method checks the email in question and
     * returns True if the email is associated with an existing LandLord account,
     * otherwise returns false.
     */
    public boolean isLL(String email) {
        boolean result = false;
        for (User u : registeredUsers) {
            if (email.equals(u.getEmail()) && u.getType().equals("Landlord")) {
                result = true;
            }
        }
        return result;
    }

    /**
     * Default private constructor which allocates space for registeredUsers.
     */
    private Singleton() {
        this.registeredUsers = new ArrayList<User>();
    }

    /*
     * This method adds a registered user to the registeredUsers arraylist.
     * It takes in a User u.
     */
    public void addUser(User u) {
        this.registeredUsers.add(u);
        return;
    }
}