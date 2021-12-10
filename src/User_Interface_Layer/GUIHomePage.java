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
 * A class which implements the Strategy Design Pattern by using 
 * function setStrateug and performStrategy.
 * This class contains an object of the interface Strategy as a member variable, 
 * which is set differently, based on the user type.
 */
public class GUIHomePage {
    private static String email;
    private static Strategy displayStrategy;

    // Calls the display of the member variable displayStrategy.
    public void performStrategy() {
        displayStrategy.display(email);
    }

    /**
     * Takes in the user type as a String and accordingly sets a strategy depending on the usertype.
     * @param userType The type of the user {Landlord, Registered Renter, Unregistered Renter, Manager}
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

    // Getter.
    public static String getEmail() {
        return email;
    }

    // Default constructor.
    public GUIHomePage(String email) {
        this.email = email;
    }
}