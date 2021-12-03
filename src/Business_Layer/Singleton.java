package Business_Layer;

import Entity.User;

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
        if (instance == NULL)
            instance = new Singleton();
        return instance;
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