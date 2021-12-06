/*
 * File Name: PropertyForm.java
 * Authors:
 *      Cheyenne Goh (UCID: 30040528)
 *      Divyansh Goyal (UCID: 30089488)
 *      Rui Guan(UCID: 30072848)
 *      Sajid Hafiz (UCID: 30061336)
 */
package User_Interface_Layer;

import Control_Layer.RegistrationController;
import Control_Layer.UpdateController;
import Control_Layer.PeriodFeesController;
import Business_Layer.Property;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

/**
 * 
 */
public class PropertyForm extends InteractionForm {

    /**
     * Default constructor
     */
    public PropertyForm() {
        myControllers.add( new PeriodFeesController());
        myControllers.add(new RegistrationController());
        myControllers.add(new UpdateController());
    }



    /**
     * @return
     */
    public void startRegistration() {
        JFrame f = new JFrame("Property Registration Form");
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setSize(500, 500);
        f.setLayout(new FlowLayout());
        JPanel rowEntry = new JPanel();
        rowEntry.setLayout(new GridLayout(0, 2));
        rowEntry.add(new JSeparator(SwingConstants.HORIZONTAL));
        rowEntry.add(new JSeparator(SwingConstants.HORIZONTAL));

        /* Header */
        JLabel labelTitle = new JLabel("Enter your property and payment details");
        labelTitle.setHorizontalTextPosition(JLabel.CENTER);
        f.add(labelTitle);


        /* Address */
        JLabel addressLabel = new JLabel("Address");
        JTextField addressFieldT = new JTextField(20);
        rowEntry.add(addressLabel);
        rowEntry.add(addressFieldT);

        /* Quadrant */
        String[] choices = {"NE", "NW", "SW", "SE"};
        JLabel quadrantLabel = new JLabel("Quadrant");
        rowEntry.add(quadrantLabel);
        JComboBox quadrantList = new JComboBox(choices);
        rowEntry.add(quadrantList);

        /* Type */
        JLabel typeLabel = new JLabel("Type");
        JTextField typeT = new JTextField(12);
        rowEntry.add(typeLabel);
        rowEntry.add(typeT);

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

        /* Credit Card Number */
        JLabel ccNumber = new JLabel("Card Number");
        JTextField ccNumberT = new JTextField(12);
        rowEntry.add(ccNumber);
        rowEntry.add(ccNumberT);

        /* Card Holder Name */
        JLabel cardHolderName = new JLabel("Cardholder Name");
        JTextField cardHolderNameT = new JTextField(12);
        rowEntry.add(cardHolderName);
        rowEntry.add(cardHolderNameT);

        /* Credit Card's CVV */
        JLabel cvv = new JLabel("CVV");
        JTextField cvvT = new JTextField(3);
        rowEntry.add(cvv);
        rowEntry.add(cvvT);


        /* Expiry Date */
        JPanel ccEntry = new JPanel();
        ccEntry.setLayout(new GridLayout(0, 2));
        JLabel expDate = new JLabel("Exp. Date (MM/YY)");
        String[] months = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
        String[] years = {"21", "22", "23", "24", "25"};
        JComboBox monthsT = new JComboBox(months);
        JComboBox yearsT = new JComboBox(years);
        ccEntry.add(monthsT);
        ccEntry.add(yearsT);
        rowEntry.add(expDate);
        rowEntry.add(ccEntry);

        f.add(rowEntry);

        /* Fee & Period declaration */
        //int fee = myController[0].sendPayment();
        //int period = myController[0].sendPeriod();
        int fee = 60;
        int period = 20;
        String s = "<html><it>Current fee is: $";
        s += fee;
        s += " and the current listing period is: ";
        s += period;
        s += " DAYS</html></it>";
        JLabel info = new JLabel(s);
        f.add(info);

        /* Submit */
        JButton b1 = new JButton("SUBMIT");
        rowEntry.add(new JSeparator(SwingConstants.HORIZONTAL));
        rowEntry.add(new JSeparator(SwingConstants.HORIZONTAL));
        b1.setBackground(Color.GREEN);
        f.add(b1);

        /* Submit Listener */
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String address = addressFieldT.getText();
                String type = typeT.getText();
                String cardNumber = ccNumber.getText();
                String cardHolderName = cardHolderNameT.getText();
                String furnished = furnishedT.getSelectedItem().toString();
                String quadrant = quadrantList.getSelectedItem().toString();
                boolean furn = false;
                if (furnished.equals("Y"))  furn = true;
                String CVV = cvvT.getText();
                String months = monthsT.getSelectedItem().toString();
                String year = yearsT.getSelectedItem().toString();
                String numBedrooms = numBedroomsT.getSelectedItem().toString();
                String numBathrooms = numBathroomsT.getSelectedItem().toString();


                if ( (address.length() == 0 || type.length() == 0 || cardNumber.length() == 0 || cardHolderName.length() == 0)
                        || (CVV.length() <=2 || CVV.length() >=5)
                        || (year.equals("21") && (months.equals("01") || months.equals("02") || months.equals("03") ||
                        months.equals("04") || months.equals("05") || months.equals("06") || months.equals("07")
                        || months.equals("08") || months.equals("09") || months.equals("10") || months.equals("11"))))
                {
                    JOptionPane.showMessageDialog(f, "One or more of your fields are invalid",
                            "INVALID INPUT", JOptionPane.ERROR_MESSAGE);
                    return;
                }


                /* Valid Details */
                JOptionPane.showMessageDialog(f, "Your property has been registered.", "Success!", 1 );
                /* Send the property details to Controller */
                ((RegistrationController)myControllers.get(1)).forwardProperty(type, Integer.parseInt(numBedrooms), Integer.parseInt(numBathrooms), furn, quadrant, GUIHomePage.getEmail(), address);
                f.setVisible(false);
                 GUIHomePage x = new GUIHomePage();
                 x.performStrategy();
            }

        });



        f.setVisible(true);

    }

    /**
     * @return
     */
    public void browseProperties() {
        // TODO implement here
        return;
    }

    /**
     * @param myProperties 
     * @return
     */
    private void displayMyProperties(ArrayList<Property> myProperties) {
        // TODO implement here
        return;
    }

    /**
     * @return
     */
    private Property selectProperty() {
        // TODO implement here
        return null;
    }


    /**
     * @param p 
     * @return
     */
    private String changeStatus(Property p) {
        // TODO implement here
        return "";
    }

    /**
     * @return
     */
    private void displayStatuses() {
        // TODO implement here
        return;
    }






}