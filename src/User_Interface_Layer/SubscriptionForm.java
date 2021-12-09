/*
 * File Name: SubscriptionForm.java
 * Authors:
 *      Cheyenne Goh (UCID: 30040528)
 *      Divyansh Goyal (UCID: 30089488)
 *      Rui Guan(UCID: 30072848)
 *      Sajid Hafiz (UCID: 30061336)
 */
package User_Interface_Layer;

import Control_Layer.SubscriptionController;
import Business_Layer.Subscription;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

/**
 * 
 */
public class SubscriptionForm extends InteractionForm {

    public SubscriptionForm(String email) {
        subscribedRequest = new Subscription();
        this.email = email;
    }

    private Subscription subscribedRequest;
    private SubscriptionController controller;
    private String email;

    public void enterSubCriteria() {
        // TODO implement here
    }

    public void displayMySubs() {
        ArrayList<Subscription> subs = controller.getSubs(email);

        JFrame a = new JFrame("Manage Subscriptions");
        a.setLocationRelativeTo(null);
        a.setSize(350, 350);
        a.setLayout(new FlowLayout());
        a.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        /* Header */
        JLabel header = new JLabel("Choose one of the following properties to update");
        JPanel row1 = new JPanel(new FlowLayout());
        row1.add(header);
        a.add(row1);

        JSeparator sep = new JSeparator();
        a.add(sep);

        String[] columnNames = {"Type",
                                "# of Bedrooms",
                                "# of Bathrooms",
                                "Furnished",
                                "Quadrant",};

        String data[][] = new String[subs.size()][5];
        for (int i = 0; i < subs.size(); i++) {
            data[i][0] = subs.get(i).getType();
            data[i][1] = String.valueOf(subs.get(i).getNumBedrooms());
            data[i][2] = String.valueOf(subs.get(i).getNumBathrooms());
            data[i][3] = String.valueOf(subs.get(i).getFurnished());
            data[i][4] = subs.get(i).getQuadrant();
        }

        JTable table = new JTable(data, columnNames);
        table.setEnabled(false);
        a.add(table);

        /* Back Button */
        JButton backButton = new JButton("<<");
        JPanel panelButton = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelButton.add(backButton);
        a.add(panelButton);

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

    private void selectUnsub(String type, int numBedrooms, int numBathrooms, boolean furnished, String quadrant) {
        // TODO implement here
    }
}