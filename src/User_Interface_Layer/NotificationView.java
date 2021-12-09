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
import Control_Layer.SubscriptionController;
import Business_Layer.Property;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class NotificationView extends InteractionForm {

    public NotificationView(String email) {
        // controller = new SearchController();
        this.email = email;
        subController = new SubscriptionController(true);
    }

    // private SearchController controller;
    private String email;
    private SubscriptionController subController;

    public void showSubbed() {

        ArrayList<Property> p = new ArrayList<>(subController.getSubbedProperties(email));
        JFrame a = new JFrame("Notifications");
        a.setLocationRelativeTo(null);
        a.setSize(350, 350);
        a.setLayout(new FlowLayout());
        a.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        /* Header */
        JLabel header = new JLabel("Choose a notification to view");
        JPanel row1 = new JPanel(new FlowLayout());
        row1.add(header);
        a.add(row1);

        JSeparator sep = new JSeparator();
        a.add(sep);

        /* Initializing the combo box with Subscriptions' Address' */
        String[] address = new String[p.size()];
        for (int i = 0; i < p.size(); i++) {
            address[i] = p.get(i).getAddress();
        }
        JComboBox addressList = new JComboBox(address);
        a.add(addressList);

        /* View Property Button */
        JButton viewPropertyButton = new JButton("VIEW PROPERTY");
        a.add(viewPropertyButton);

        /* Back Button */
        JButton backButton = new JButton("<<");
        JPanel panelButton = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelButton.add(backButton);
        a.add(panelButton);

        // VIEW PROPERTY BUTTON RESPONSE
        // Calls on the selected property.
        viewPropertyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String address_selected = addressList.getSelectedItem().toString();
                boolean found = false;
                Property choice = null;
                for (Property selected : p) {
                    if (selected.getAddress().equals(address_selected)) {
                        found = true;
                        choice = selected;
                        break;
                    }
                }
                if (found) {
                    a.dispose();
                    choice.display();
                }
            }
        });
        // BACK BUTTON RESPONSE
        // Take user back to home page.
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                a.dispose();
                new GUIHomePage(GUIHomePage.getEmail()).performStrategy();
            }
        });

        a.setVisible(true);

    }

}