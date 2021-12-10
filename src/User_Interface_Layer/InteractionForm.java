/*
 * File Name: InteractionForm.java
 * Authors:
 *      Cheyenne Goh (UCID: 30040528)
 *      Divyansh Goyal (UCID: 30089488)
 *      Rui Guan(UCID: 30072848)
 *      Sajid Hafiz (UCID: 30061336)
 */
package User_Interface_Layer;

import Control_Layer.Controller;

import java.util.*;

/*
 * This class is abstract and is a container class for all Form classes in this
 * package. It contains an ArrayList of Controllers for easier usage by all
 * classes that inherit this abstract class.
 */
public abstract class InteractionForm {

    // Member attribute
    protected ArrayList<Controller> myControllers;

    /*
     * This constructor allocates space for the myControllers member.
     * It takes no parameters.
     * And returns void.
     */
    public InteractionForm() {
        myControllers = new ArrayList<>();
    }
}