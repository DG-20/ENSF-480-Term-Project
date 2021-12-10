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

/*
 * A class concerned with adding and removing Registered Renter's subscriptions
 * and displaying them.
 */
public class SubscriptionForm extends InteractionForm {

    public SubscriptionForm(String email) {
        controller = new SubscriptionController(true);
        this.email = email;
    }

    private SubscriptionController controller;
    private String email;

    public void enterSubCriteria() {
        JFrame f = new JFrame("Enter Subscription Criteria");
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setSize(500, 300);
        f.setLayout(new FlowLayout());
        JPanel rowEntry = new JPanel();
        rowEntry.setLayout(new GridLayout(0, 2));
        rowEntry.add(new JSeparator(SwingConstants.HORIZONTAL));
        rowEntry.add(new JSeparator(SwingConstants.HORIZONTAL));

        /* Header */
        JLabel labelTitle = new JLabel("Criteria:  ");
        labelTitle.setHorizontalTextPosition(JLabel.CENTER);
        f.add(labelTitle);

        /* Type */
        JLabel typeLabel = new JLabel("Type");
        String[] typeChoices = { "Apartment", "Detached", "Attached", "Townhouse", "Penthouse", "Dormitory" };
        JComboBox<String> typeT = new JComboBox<String>(typeChoices);
        rowEntry.add(typeLabel);
        rowEntry.add(typeT);

        /* number of bathrooms & number of bedrooms */
        SpinnerModel numBathroomsVal = new SpinnerNumberModel(1, 0, 99, 1);
        SpinnerModel numBedroomsVal = new SpinnerNumberModel(1, 1, 99, 1);
        JSpinner numBathroomsT = new JSpinner(numBathroomsVal);
        JSpinner numBedroomsT = new JSpinner(numBedroomsVal);
        numBathroomsT.setEditor(new JSpinner.DefaultEditor(numBathroomsT));
        numBedroomsT.setEditor(new JSpinner.DefaultEditor(numBedroomsT));
        JLabel numBathroomsLabel = new JLabel("Number of bathrooms");
        rowEntry.add(numBathroomsLabel);
        rowEntry.add(numBathroomsT);
        JLabel numBedroomsLabel = new JLabel("Number of bedrooms");
        rowEntry.add(numBedroomsLabel);
        rowEntry.add(numBedroomsT);

        /* Furnished? */
        String[] furn = { "Y", "N" };
        JLabel furnishedLabel = new JLabel("Furnished");
        JComboBox<String> furnishedT = new JComboBox<String>(furn);
        rowEntry.add(furnishedLabel);
        rowEntry.add(furnishedT);

        String[] quadrants = { "NE", "NW", "SW", "SE" };
        JLabel quadrantLabel = new JLabel("Quadrants");
        rowEntry.add(quadrantLabel);
        JComboBox<String> quadrantList = new JComboBox<String>(quadrants);
        rowEntry.add(quadrantList);

        f.add(rowEntry);

        /* Submit */
        JButton submit = new JButton("SUBMIT");
        rowEntry.add(new JSeparator(SwingConstants.HORIZONTAL));
        rowEntry.add(new JSeparator(SwingConstants.HORIZONTAL));
        submit.setBackground(Color.GREEN);
        f.add(submit);

        f.setVisible(true);

        /* On SUBMIT button press */
        /*
         * REgister the subscription into the database by calling appropriate conrollers
         */
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedType = typeT.getSelectedItem().toString();
                int selectedBath = (Integer) numBathroomsT.getValue();
                int selectedBed = (Integer) numBedroomsT.getValue();
                String selectedFurn = furnishedT.getSelectedItem().toString();
                String selectedQuad = quadrantList.getSelectedItem().toString();
                boolean furn = false;
                if (selectedFurn.equals("Y")) {
                    furn = true;
                }
                controller.forwardSub(selectedType, selectedBed, selectedBath, furn, selectedQuad, email);
                f.dispose();
                displayMySubs();
            }
        });

        /* On Back button press */
        /* Redirect to and Call user's home page */
        JButton backButton = new JButton("Go Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                displayMySubs();
            }
        });
        f.add(backButton);
    }

    public void displayMySubs() {
        ArrayList<Subscription> subs = new ArrayList<Subscription>(controller.getSubs(email));

        JFrame a = new JFrame("Manage Subscriptions");
        a.setLocationRelativeTo(null);
        a.setSize(500, 530);
        a.setLayout(new FlowLayout());
        a.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        /* Header */
        JLabel header = new JLabel("Choose what kinds of properties to receive notifications for");
        JPanel row1 = new JPanel(new FlowLayout());
        row1.add(header);
        a.add(row1);

        JSeparator sep = new JSeparator();
        a.add(sep);

        String[] columnNames = { "Type",
                "# of Bedrooms",
                "# of Bathrooms",
                "Furnished",
                "Quadrant" };

        Object data[][] = new Object[subs.size()][5];
        for (int i = 0; i < subs.size(); i++) {
            data[i][0] = subs.get(i).getType();
            data[i][1] = Integer.valueOf(subs.get(i).getNumBedrooms());
            data[i][2] = Integer.valueOf(subs.get(i).getNumBathrooms());
            if (subs.get(i).getFurnished()) {
                data[i][3] = "Yes";
            } else {
                data[i][3] = "No";
            }
            data[i][4] = subs.get(i).getQuadrant();
        }

        JTable table = new JTable(data, columnNames);
        table.setDefaultEditor(Object.class, null);
        table.setRowSelectionAllowed(true);
        table.setColumnSelectionAllowed(false);

        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        a.add(scrollPane);

        /* Back Button */
        JButton backButton = new JButton("<<");

        /* Add Button */
        JButton addButton = new JButton("+");

        /* Delete Button */
        JButton deleteButton = new JButton("-");

        /* Button Panel */
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.add(backButton);
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        a.add(buttonPanel);

        // BACK BUTTON RESPONSE
        // Take user back to home page.
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                a.dispose();
                pageBack.performStrategy();
            }
        });

        // ADD BUTTON RESPONSE
        // Add new subscription
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enterSubCriteria();
                a.dispose();
            }
        });

        // DELETE BUTTON RESPONSE
        // Delete existing subscription
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i : table.getSelectedRows()) {
                    boolean furnished = false;
                    if (data[i][3].equals("Yes")) {
                        furnished = true;
                    }
                    selectUnsub((String) data[i][0], (int) data[i][1], (int) data[i][2], furnished,
                            (String) data[i][4]);
                }
                a.dispose();
                displayMySubs();
            }
        });
        a.setVisible(true);
    }

    /*
     * This private method simply takes in the subscription parameter and calls upon
     * fowardDeleteSub in the controller.
     */
    private void selectUnsub(String type, int numBedrooms, int numBathrooms, boolean furnished, String quadrant) {
        controller.forwardDeleteSub(type, numBedrooms, numBathrooms, furnished, quadrant, email);
    }
}