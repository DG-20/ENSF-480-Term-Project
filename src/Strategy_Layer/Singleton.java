package Strategy_Layer;

import Entity.User;

import java.util.*;

/**
 * 
 */
public class Singleton {

    /**
     * Default constructor
     */
    public Singleton() {
    }

    /**
     * 
     */
    private Singleton instance;

    /**
     * 
     */
    private ArrayList<User> registeredUsers;


    public ArrayList<User> getRegisteredUsers() {
        return registeredUsers;
    }

    public void setRegisteredUsers(ArrayList<User> registeredUsers) {
        this.registeredUsers = registeredUsers;
    }

    /**
     * @return
     */
    public static Singleton getInstance() {
        // TODO implement here
        return null;
    }

    /**
     * 
     */
    private void Singleton() {
        // TODO implement here
    }

    /**
     * @param User u 
     * @return
     */
    public void addUser(User u) {
        // TODO implement here
        return null;
    }

}