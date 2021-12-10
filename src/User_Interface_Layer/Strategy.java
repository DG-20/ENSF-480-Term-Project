/*
 * File Name: Strategy.java
 * Authors:
 *      Cheyenne Goh (UCID: 30040528)
 *      Divyansh Goyal (UCID: 30089488)
 *      Rui Guan(UCID: 30072848)
 *      Sajid Hafiz (UCID: 30061336)
 */
package User_Interface_Layer;

/*
 * Strategy is the interface which contains the contractual method display. 
 * This interface provides flexibility for future improvements upon types 
 * of users and what they can do.
 */
public interface Strategy {
    // The contractual display method.
    public void display(String email);
}