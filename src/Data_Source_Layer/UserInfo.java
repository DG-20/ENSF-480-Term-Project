/*
 * File Name: UserInfo.java
 * Authors:
 *      Cheyenne Goh (UCID: 30040528)
 *      Divyansh Goyal (UCID: 30089488)
 *      Rui Guan(UCID: 30072848)
 *      Sajid Hafiz (UCID: 30061336)
 */
package Data_Source_Layer;

import Business_Layer.User;
import Business_Layer.Singleton;

import java.sql.*;
import java.util.*;

/**
 * A database interface class concerned only with user information including
 * name, login, password.
 */
public class UserInfo implements Database {

    private Connection dbConnect;

    /**
     * Default constructor
     * Initializes a connection and initializes the list of logins,names, and
     * passwords stored in the Singleton users
     */
    public UserInfo() {
        initializeConnection();
        users = Singleton.getInstance();
        /* We've already added the users, return out */
        if (users.isAdded())
            return;
        ArrayList<User> registeredUsers = getAllUsers();
        for (User u : registeredUsers) {
            this.users.addUser(u);
        }
        users.setAdded(true);
    }

    /**
     * Singleton design pattern. Holds the list of all users in the database
     */
    private Singleton users;

    /**
     * @param email
     * @param password
     * @param userType
     * @return Return true if the user has valid login credentials, otherwise return
     *         false.
     *         Checks and validates a user's login details of a certain user type.
     */
    public boolean validation(String email, String password, String userType) {
        ArrayList<User> myUsers = users.getRegisteredUsers();
        for (int i = 0; i < myUsers.size(); i++) {
            String userEmail = myUsers.get(i).getEmail();
            String userPassword = myUsers.get(i).getPassword();
            String usersType = myUsers.get(i).getType();
            if (email.equals(userEmail) && userPassword.equals(password) && userType.equals(usersType)) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param email The email of the Landlord.
     * @return String The name of the landlord associated with their login email.
     *         Finds the Landlord's name from their email.
     */
    public String retrieveLandlordsName(String email) {
        String name = "";
        ArrayList<User> myUsers = users.getRegisteredUsers();
        for (User u : myUsers) {
            if (u.getType().equals("Landlord") && u.getEmail().equals(email)) {
                name = u.getName();
            }
        }
        return name;
    }

    /**
     * Queries the database to collect all user info.
     * 
     * @return ArrayList<User>
     */
    public ArrayList<User> getAllUsers() {
        ArrayList<User> u = new ArrayList<>();
        try {
            String query = "SELECT * FROM user";
            Statement stmt = dbConnect.createStatement();
            ResultSet set = stmt.executeQuery(query);
            while (set.next()) {
                String email = set.getString("Email");
                String pswd = set.getString("Password");
                String name = set.getString("Name");
                String type = set.getString("Type");
                User user = new User(email, pswd, type, name);
                u.add(user);
            }
            stmt.close();
            set.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }

    /**
     * Attempts to Close the connection to the database
     */
    public void close() {
        try {
            dbConnect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Attempts to intialize a connection to the database
     */
    public void initializeConnection() {
        try {
            this.dbConnect = DriverManager.getConnection(Database.DBURL, USERNAME, PASSWORD);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}