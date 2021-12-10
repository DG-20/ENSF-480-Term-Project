/*
 * File Name: GUIHomePage.java
 * Authors:
 *      Cheyenne Goh (UCID: 30040528)
 *      Divyansh Goyal (UCID: 30089488)
 *      Rui Guan (UCID: 30072848)
 *      Sajid Hafiz (UCID: 30061336)
 */

package User_Interface_Layer;

/*
 * A class which implements the Strategy Design Pattern by using function 
 * setStrategy and performStrategy. This class contains an object of the 
 * interface Strategy as a member variable, which is set differently, based on 
 * the user type.
 */
public class GUIHomePage {
    
    // Member attributes
    private static String email;
    private static Strategy displayStrategy;

    /*
    * This constructor assigns the email member variable
    * It takes in an email address of type String as a parameter.
    */
    public GUIHomePage(String email) {
        GUIHomePage.email = email;
    }

    // Getter for email
    public static String getEmail() {
        return email;
    }

    /*
    * This function calls the display of the member variable displayStrategy
    * It takes in no parameters.
    */
    public void performStrategy() {
        displayStrategy.display(email);
    }

    /*
    * This function takes in the user type as a String and accordingly sets a 
    * strategy depending on the usertype.
    * It takes in the type of user {Landlord, RR, Unregistered Renter, Manager}
    * of type String as a parameter.
    * And returns void.
    */
    public void setDisplayStrategy(String userType) {
        if (userType.equals("Landlord")) {
            displayStrategy = new DisplayLL();
        } else if (userType.equals("Manager")) {
            displayStrategy = new DisplayManager();
        } else if (userType.equals("RR")) {
            displayStrategy = new DisplayRR();
        } else {
            displayStrategy = new DisplayUR();
        }
    }
}