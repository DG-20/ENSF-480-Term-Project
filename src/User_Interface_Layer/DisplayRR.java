package User_Interface_Layer;

import User_Interface_Layer.InteractionForm;

import java.util.*;

/**
 * 
 */
public class DisplayRR implements Strategy {

    public InteractionForm getMySearchForm() {
        return mySearchForm;
    }

    public void setMySearchForm(InteractionForm mySearchForm) {
        this.mySearchForm = mySearchForm;
    }

    public InteractionForm getMySubForm() {
        return mySubForm;
    }

    public void setMySubForm(InteractionForm mySubForm) {
        this.mySubForm = mySubForm;
    }

    public InteractionForm getMyNotifView() {
        return myNotifView;
    }

    public void setMyNotifView(InteractionForm myNotifView) {
        this.myNotifView = myNotifView;
    }

    /**
     * Default constructor
     */
    public DisplayRR() {
    }

    /**
     * 
     */
    private InteractionForm mySearchForm;

    /**
     * 
     */
    private InteractionForm mySubForm;

    /**
     * 
     */
    private InteractionForm myNotifView;










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
    public void DisplayRR() {
        // TODO implement here
    }
}