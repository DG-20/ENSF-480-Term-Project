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

import javax.swing.*;

/*
 * A class concerned with searching for a property.
 */
public class SearchForm extends InteractionForm {
    /*
     * Default constructor.
     */
    public SearchForm() {
        myControllers.add(new SearchController());
    }

    /*
     * Create a new search
     */
    public void createSearchQuery() {

        // create a new frame
        JFrame f = new JFrame("Search Property Form");
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // setup the frame
        f.setSize(500, 300);
        f.setLocationRelativeTo(null);
        f.setLayout(new FlowLayout());
        JPanel rowEntry = new JPanel();
        rowEntry.setLayout(new GridLayout(0, 2));
        rowEntry.add(new JSeparator(SwingConstants.HORIZONTAL));
        rowEntry.add(new JSeparator(SwingConstants.HORIZONTAL));

        /* Header */
        JLabel labelTitle = new JLabel("Create a Search Query:  ");
        labelTitle.setHorizontalTextPosition(JLabel.CENTER);
        f.add(labelTitle);

        /* combo box of the house types */
        JLabel typeLabel = new JLabel("Type");
        String[] typeChoices = { "Apartment", "Detached", "Attached", "Townhouse", "Penthouse", "Dormitory" };
        JComboBox<String> typeT = new JComboBox<String>(typeChoices);
        rowEntry.add(typeLabel);
        rowEntry.add(typeT);

        /* combo box of the num of bathrooms & bedrooms */
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

        /* combo box of furnished or not */
        String[] furn = { "Y", "N" };
        JLabel furnishedLabel = new JLabel("Furnished");
        JComboBox furnishedT = new JComboBox(furn);
        rowEntry.add(furnishedLabel);
        rowEntry.add(furnishedT);

        /* combo box of the quadrants */
        String[] quadrants = { "NE", "NW", "SW", "SE" };
        JLabel quadrantLabel = new JLabel("Quadrants");
        rowEntry.add(quadrantLabel);
        JComboBox quadrantList = new JComboBox(quadrants);
        rowEntry.add(quadrantList);

        // add rowEntry into the frame
        f.add(rowEntry);

        /* Button of Submit */
        JButton submit = new JButton("SUBMIT");
        rowEntry.add(new JSeparator(SwingConstants.HORIZONTAL));
        rowEntry.add(new JSeparator(SwingConstants.HORIZONTAL));
        submit.setBackground(Color.GREEN);
        f.add(submit);

        f.setVisible(true);

        /* On SUBMIT button press */
        /*
         * Forward the search parameters to the controller and then call the
         * ViewPropertyForm display the matched properties
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
                if (selectedFurn.equals("Y"))
                    furn = true;

                ArrayList<Property> p = new ArrayList<>();
                p = ((SearchController) myControllers.get(0)).forwardSearch(selectedType, selectedBed,
                        selectedBath, furn, selectedQuad);
                f.dispose();
                new ViewPropertyForm(p);
            }
        });

        /* On Back Button press */
        /* Go back to user's home page */
        JButton backButton = new JButton("Go Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                pageBack.performStrategy();
            }
        });
        f.add(backButton);
    }
}
