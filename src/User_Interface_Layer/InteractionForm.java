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

/**
 * 
 */
public abstract class InteractionForm {

    /**
     * Default constructor
     */
    public InteractionForm() {
        myControllers = new ArrayList<>();
    }


    protected ArrayList<Controller> myControllers;

}