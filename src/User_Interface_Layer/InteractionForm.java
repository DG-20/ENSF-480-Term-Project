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
    }

    /**
     * 
     */
    private Controller myLoginController;

    /**
     * 
     */
    private Controller myRegistrationController;

    /**
     * 
     */
    private Controller myPeriodFeesController;

    /**
     * 
     */
    private Controller mySubscriptionController;

    /**
     * 
     */
    private Controller myUpdateController;

    /**
     * 
     */
    private Controller mySearchController;

    /**
     * 
     */
    //public void Attribute2;

    /**
     * 
     */
    private ArrayList<Controller> myControllers;

}