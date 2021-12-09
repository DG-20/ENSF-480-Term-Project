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

/**
 * 
 */
public class SearchForm extends InteractionForm {

	/**
     * Default constructor
     */
    public SearchForm() {
        myControllers.add(new SearchController());
    }

    /**
     * 
     */
    private SearchController controller;

    /**
     * @return
     */
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
        
        String[] types = {"Apartment", "Attached House", "Detached House", "Townhouse"};
        JLabel typesLabel = new JLabel("House Types");
        rowEntry.add(typesLabel);
        JComboBox typesList = new JComboBox(types);
        rowEntry.add(typesList);
        
        /* number of bathrooms & number of bedrooms */
        String[] numChoices = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        JLabel numBathroomsLabel = new JLabel("Number of bathrooms");
        JComboBox numBathroomsT = new JComboBox(numChoices);
        rowEntry.add(numBathroomsLabel);
        rowEntry.add(numBathroomsT);
        JLabel numBedroomsLabel = new JLabel ("Number of bedrooms");
        JComboBox numBedroomsT = new JComboBox(numChoices);
        rowEntry.add(numBedroomsLabel);
        rowEntry.add(numBedroomsT);
        
        /* Furnished? */
        String[] furn = {"Y", "N"};
        JLabel furnishedLabel = new JLabel("Furnished");
        JComboBox furnishedT = new JComboBox(furn);
        rowEntry.add(furnishedLabel);
        rowEntry.add(furnishedT);
        
        String[] quadrants = {"NE", "NW", "SW", "SE"};
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
                if (selectedFurn.equals("Y"))  furn = true;
                
                ArrayList<Property> p = new ArrayList<>();
                p= ((SearchController) myControllers.get(0)).forwardSearch(selectedType, Integer.parseInt(selectedBed), 
                		Integer.parseInt(selectedBath), furn, selectedQuad);
                displayMatching(p);
            }
        });
        
        /* Back Button */
        JButton backButton = new JButton("<<");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                new DisplayUR().display(null);;
            }
        });
        f.add(backButton);
    }

    /**
     * @param matchedProperties
     * @return
     */
    private void displayMatching(ArrayList<Property> matchedProperties) {
        // TODO implement here
    	
    	for (Property selected : matchedProperties)
    	{
    		selected.display();
    	}
    	
        return;
    }

    /**
     * @return
     */
    public void sendEmailGUI() {
        // TODO implement here
        return;
    }

}