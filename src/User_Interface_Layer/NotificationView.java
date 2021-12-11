/*
 * File Name: NotificationView.java
 * Authors:
 *      Cheyenne Goh (UCID: 30040528)
 *      Divyansh Goyal (UCID: 30089488)
 *      Rui Guan(UCID: 30072848)
 *      Sajid Hafiz (UCID: 30061336)
 */
package User_Interface_Layer;

// import Control_Layer.SearchController;
import Control_Layer.Controller;
import Control_Layer.SubscriptionController;
import Business_Layer.Property;

import javax.swing.*;
import java.util.*;

/**
 * A class concerned with the Notifications of a Registered Renter.
 */
public class NotificationView extends InteractionForm {

    public NotificationView(String email) {
        // controller = new SearchController();
        this.email = email;
        Controller c = new SubscriptionController();
        myControllers.add(c);
    }

    // private SearchController controller;
    private String email;

    public void showSubbed() {

        ArrayList<Property> p = ((SubscriptionController)(myControllers.get(0))).getSubbedProperties(email);
        if (p.isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "No Matches Found!",
                    "Sorry...",
                    JOptionPane.INFORMATION_MESSAGE);
            pageBack.performStrategy();
            return;
        }
        new ViewPropertyForm(p);
    }
}