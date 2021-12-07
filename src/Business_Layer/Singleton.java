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

public class Singleton {
    private static Singleton instance;
    private ArrayList<User> registeredUsers;


    public ArrayList<User> getRegisteredUsers() {
        return registeredUsers;
    }

    public void setRegisteredUsers(ArrayList<User> registeredUsers) {
        this.registeredUsers = registeredUsers;
    }

    public static Singleton getInstance() {
        if (instance == null)
            instance = new Singleton();
        return instance;
    }

    /**
     *
     * @param email - The email in question
     * @return True if the email is associated with an existing Manager account, otherwise return false
     */
    public boolean isManager(String email)
    {
        boolean result = false;
        for(User u: registeredUsers)
        {
            if (email.equals(u.getEmail()) && u.getType().equals("Manager"))
            {
                result = true;
            }
        }
        return result;
    }

    /**
     *
     * @param email - The email in question
     * @return True if the email is associated with an existing Registered Renter account, otherwise return false
     */
    public boolean isRR(String email)
    {
        boolean result = false;
        for(User u: registeredUsers)
        {
            if (email.equals(u.getEmail()) && u.getType().equals("RR"))
            {
                result = true;
            }
        }
        return result;
    }

    /**
     *
     * @param email - The email in question
     * @return True if the email is associated with an existing Landlord account, otherwise return false
     */
    public boolean isLL(String email)
    {
        boolean result = false;
        for(User u: registeredUsers)
        {
            if (email.equals(u.getEmail()) && u.getType().equals("Landlord"))
            {
                result = true;
            }
        }
        return result;
    }

    private Singleton() 
    {
        this.registeredUsers = new ArrayList<User>();
    }

    public void addUser(User u) {
        this.registeredUsers.add(u);
        return;
    }
}