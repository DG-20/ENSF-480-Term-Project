/*
 * File Name: InteractionForm.java
 * Authors:
 *      Cheyenne Goh (UCID: 30040528)
 *      Divyansh Goyal (UCID: 30089488)
 *      Rui Guan(UCID: 30072848)
 *      Sajid Hafiz (UCID: 30061336)
 */
package ensf480group7.mavenproject1;

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
    protected Controller myLoginController;

    /**
     * 
     */
    protected Controller myRegistrationController;

    /**
     * 
     */
    protected Controller myPeriodFeesController;

    /**
     * 
     */
    protected Controller mySubscriptionController;

    /**
     * 
     */
    protected Controller myUpdateController;

    /**
     * 
     */
    protected Controller mySearchController;

    /**
     * 
     */
    //public void Attribute2;

    /**
     * 
     */
    protected ArrayList<Controller> myControllers;

}