package User_Interface_Layer;

import User_Interface_Layer.InteractionForm;

import java.util.*;

/**
 * 
 */
public class DisplayManager implements Strategy {

    /**
     * Default constructor
     */
    public DisplayManager() {
    }

    /**
     * 
     */
    private InteractionForm mySummaryForm;

    /**
     * 
     */
    private InteractionForm myChangePF;

    /**
     * 
     */
    private InteractionForm myPropertyForm;


    public InteractionForm getMySummaryForm() {
        return mySummaryForm;
    }

    public void setMySummaryForm(InteractionForm mySummaryForm) {
        this.mySummaryForm = mySummaryForm;
    }

    public InteractionForm getMyChangePF() {
        return myChangePF;
    }

    public void setMyChangePF(InteractionForm myChangePF) {
        this.myChangePF = myChangePF;
    }

    public InteractionForm getMyPropertyForm() {
        return myPropertyForm;
    }

    public void setMyPropertyForm(InteractionForm myPropertyForm) {
        this.myPropertyForm = myPropertyForm;
    }

    /**
     * @param email 
     * @return
     */
    public void display(String email) {
        // TODO implement here
        return;
    }

    /**
     * 
     */
    public void DisplayManager() {
        // TODO implement here
    }
}