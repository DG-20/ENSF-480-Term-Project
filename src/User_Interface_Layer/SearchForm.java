/*
 * File Name: SearchForm.java
 * Authors:
 *      Cheyenne Goh (UCID: 30040528)
 *      Divyansh Goyal (UCID: 30089488)
 *      Rui Guan(UCID: 30072848)
 *      Sajid Hafiz (UCID: 30061336)
 */
package User_Interface_Layer;

import Control_Layer.*;
import Business_Layer.Property;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

/*
 * 
 */
public class SearchForm extends InteractionForm {
    /*
     * Default constructor.
     */
    public SearchForm() {
        myControllers.add(new SearchController());
    }

    private SearchController controller;

    public void createSearchQuery() {
        // TODO implement here
        JFrame f = new JFrame("Search Property Form");
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setSize(500, 300);
        f.setLayout(new FlowLayout());
        JPanel rowEntry = new JPanel();
        rowEntry.setLayout(new GridLayout(0, 2));
        rowEntry.add(new JSeparator(SwingConstants.HORIZONTAL));
        rowEntry.add(new JSeparator(SwingConstants.HORIZONTAL));

        /* Header */
        JLabel labelTitle = new JLabel("Create a Search Query:  ");
        labelTitle.setHorizontalTextPosition(JLabel.CENTER);
        f.add(labelTitle);

        String[] types = { "Apartment", "Attached House", "Detached House", "Townhouse" };
        JLabel typesLabel = new JLabel("House Types");
        rowEntry.add(typesLabel);
        JComboBox typesList = new JComboBox(types);
        rowEntry.add(typesList);

        /* number of bathrooms & number of bedrooms */
        String[] numChoices = { "1", "2", "3", "4", "5", "6", "7", "8", "9" };
        JLabel numBathroomsLabel = new JLabel("Number of bathrooms");
        JComboBox numBathroomsT = new JComboBox(numChoices);
        rowEntry.add(numBathroomsLabel);
        rowEntry.add(numBathroomsT);
        JLabel numBedroomsLabel = new JLabel("Number of bedrooms");
        JComboBox numBedroomsT = new JComboBox(numChoices);
        rowEntry.add(numBedroomsLabel);
        rowEntry.add(numBedroomsT);

        /* Furnished? */
        String[] furn = { "Y", "N" };
        JLabel furnishedLabel = new JLabel("Furnished");
        JComboBox furnishedT = new JComboBox(furn);
        rowEntry.add(furnishedLabel);
        rowEntry.add(furnishedT);

        String[] quadrants = { "NE", "NW", "SW", "SE" };
        JLabel quadrantLabel = new JLabel("Quadrants");
        rowEntry.add(quadrantLabel);
        JComboBox quadrantList = new JComboBox(quadrants);
        rowEntry.add(quadrantList);

        f.add(rowEntry);

        /* Submit */
        JButton submit = new JButton("SUBMIT");
        rowEntry.add(new JSeparator(SwingConstants.HORIZONTAL));
        rowEntry.add(new JSeparator(SwingConstants.HORIZONTAL));
        submit.setBackground(Color.GREEN);
        f.add(submit);

        f.setVisible(true);

        /* Submit Listener */
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedType = typesList.getSelectedItem().toString();
                String selectedBath = numBathroomsT.getSelectedItem().toString();
                String selectedBed = numBedroomsT.getSelectedItem().toString();
                String selectedFurn = furnishedT.getSelectedItem().toString();
                String selectedQuad = quadrantList.getSelectedItem().toString();
                boolean furn = false;
                if (selectedFurn.equals("Y"))
                    furn = true;

                ArrayList<Property> p = new ArrayList<>();
                p = ((SearchController) myControllers.get(0)).forwardSearch(selectedType, Integer.parseInt(selectedBed),
                        Integer.parseInt(selectedBath), furn, selectedQuad);
                f.dispose();

                matchedProperties = p;
                displayMatching();
            }
        });

        /* Back Button */
        JButton backButton = new JButton("Go Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                // new DisplayUR().display(null);
                new GUIHomePage(GUIHomePage.getEmail()).performStrategy();
            }
        });
        f.add(backButton);
    }

    private ArrayList<Property> matchedProperties;

    private void displayMatching() {
        if (matchedProperties.size() == 0) {
            JOptionPane.showMessageDialog(null, "No properties matching your search!");
            createSearchQuery();
            return;
        }

        JFrame frame = new JFrame("SEARCH RESULTS");
        frame.setSize(400, 280);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);

        JLabel titleLabel = new JLabel();
        JComboBox<String> addressComboBox = new JComboBox<String>();
        JButton detailsButton = new JButton();
        JButton goBackButton = new JButton();

        titleLabel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        titleLabel.setText("Search Results");

        addressComboBox.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        addressComboBox.setMaximumRowCount(100);

        int numSize = matchedProperties.size();

        String[] addresses = new String[numSize];
        for (int i = 0; i < matchedProperties.size(); i++) {
            addresses[i] = matchedProperties.get(i).getAddress();
        }

        addressComboBox.setModel(
                new javax.swing.DefaultComboBoxModel<>(addresses));
        addressComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            }
        });

        detailsButton.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        detailsButton.setText("View Details");

        goBackButton.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        goBackButton.setText("Go Back");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(titleLabel)
                                .addGap(151, 151, 151))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(goBackButton))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(37, 37, 37)
                                                .addComponent(addressComboBox, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73,
                                                        Short.MAX_VALUE)
                                                .addComponent(detailsButton)))
                                .addGap(35, 35, 35)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(titleLabel)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(detailsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(addressComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 31,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 153,
                                        Short.MAX_VALUE)
                                .addComponent(goBackButton)
                                .addContainerGap()));

        frame.pack();

        detailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                String addressChosen = addressComboBox.getSelectedItem().toString();
                for (int i = 0; i < numSize; i++) {
                    if (addressChosen.equals(matchedProperties.get(i).getAddress())) {
                        matchedProperties.get(i).display(this);
                        break;
                    }
                }
            }
        });
        // createSearchQuery();

        // for (Property selected : matchedProperties) {
        // selected.display();
        // }
        // createSearchQuery();
    }

    public void callback() {
        displayMatching();
    }
}