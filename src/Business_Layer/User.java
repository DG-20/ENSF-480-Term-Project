/*
 * File Name: User.java
 * Authors:
 *      Cheyenne Goh (UCID: 30040528)
 *      Divyansh Goyal (UCID: 30089488)
 *      Rui Guan(UCID: 30072848)
 *      Sajid Hafiz (UCID: 30061336)
 */
package Business_Layer;

/*
 * The User class is a class which contains the email, 
 * password, user type, and name of the User.
 */
public class User {
    private String email;
    private String password;
    private String type;
    private String name;

    // Getters and Setters.
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*
     * Constructor for User which takes in the User's information and sets the
     * member variables accordingly.
     */
    public User(String email, String password, String type, String name) {
        this.email = email;
        this.password = password;
        this.type = type;
        this.name = name;
    }
}