/*
 * File Name: Property.java
 * Authors:
 *      Cheyenne Goh (UCID: 30040528)
 *      Divyansh Goyal (UCID: 30089488)
 *      Rui Guan(UCID: 30072848)
 *      Sajid Hafiz (UCID: 30061336)
 */
package Business_Layer;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/*
 * Property is an entity class which contains the information of the property itself.
 */
public class Property {
    private String status;
    private int numBedrooms;
    private int numBathrooms;
    private String type;
    private boolean furnished;
    private String quadrant;
    private int ID;
    private String address;
    private String email;
    private String expDate;
    private String postedDate;

    /*
     * The Constrcutor of Property takes in all the values of the property and
     * initializes the member variables.
     */
    public Property(String status, int numBedrooms, int numBathrooms, boolean furnished, String quadrant, int ID,
            String address, String posted_date, String exp_date, String email_address, String type) {
        this.status = status;
        this.type = type;
        this.numBedrooms = numBedrooms;
        this.numBathrooms = numBathrooms;
        this.furnished = furnished;
        this.quadrant = quadrant;
        this.ID = ID;
        this.address = address;
        this.email = email_address;
        this.postedDate = posted_date;
        this.expDate = exp_date;
    }

    /*
     * Empty default constructor.
     */
    public Property() {
    }

    // Getters and Setters.
    public String getStatus() {
        return status;
    }

    public String getType() {
        return type;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getNumBedrooms() {
        return numBedrooms;
    }

    public void setNumBedrooms(int numBedrooms) {
        this.numBedrooms = numBedrooms;
    }

    public int getNumBathrooms() {
        return numBathrooms;
    }

    public void setNumBathrooms(int numBathrooms) {
        this.numBathrooms = numBathrooms;
    }

    public boolean isFurnished() {
        return furnished;
    }

    public void setFurnished(boolean furnished) {
        this.furnished = furnished;
    }

    public String getQuadrant() {
        return quadrant;
    }

    public void setQuadrant(String quadrant) {
        this.quadrant = quadrant;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getExpDate() {
        return this.expDate;
    }

    public void setExpDate(String exp_date) {
        this.expDate = exp_date;
    }

    public String getPostedDate() {
        return this.postedDate;
    }

    public void setPostedDate(String posted_date) {
        this.postedDate = posted_date;
    }

    /*
     * The display function creates a new GUI to display properties of display.
     * This function doesn't take in any arguments.
     * This function doesn't return anything.
     */
    public void display() {
        // Creating the JFrame and setting its properties.
        JFrame propertyDetailsFrame = new JFrame("PROPERTY DISPLAY");
        propertyDetailsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        propertyDetailsFrame.setSize(400, 360);
        propertyDetailsFrame.setLocationRelativeTo(null);
        propertyDetailsFrame.setVisible(true);

        // Creating the elements which will be displayed on the JFrame.
        JLabel titleLabel = new JLabel();
        JLabel addressLabel = new JLabel();
        JLabel typeLabel = new JLabel();
        JLabel numBedroomsLabel = new JLabel();
        JLabel numBathroomsLabel = new JLabel();
        JLabel furnishedLabel = new JLabel();
        JLabel quadrantLabel = new JLabel();
        JLabel dateLabel = new JLabel();
        JTextField addressDisplay = new JTextField();
        JTextField numBathroomsDisplay = new JTextField();
        JTextField typeDisplay = new JTextField();
        JTextField quadrantDisplay = new JTextField();
        JTextField numBedroomsDisplay = new JTextField();
        JTextField dateDisplay = new JTextField();
        JTextField furnishedDisplay = new JTextField();
        JButton doneButton = new JButton();
        JButton sendEmailButton = new JButton();

        // Setting the font and text of the elements.
        titleLabel.setFont(new java.awt.Font("Times New Roman", 1, 14));
        titleLabel.setText("Property Information");

        addressLabel.setFont(new java.awt.Font("Times New Roman", 1, 12));
        addressLabel.setText("Address:");

        typeLabel.setFont(new java.awt.Font("Times New Roman", 1, 12));
        typeLabel.setText("Type of Property:");

        numBedroomsLabel.setFont(new java.awt.Font("Times New Roman", 1, 12));
        numBedroomsLabel.setText("Number of Bedrooms:");

        numBathroomsLabel.setFont(new java.awt.Font("Times New Roman", 1, 12));
        numBathroomsLabel.setText("Number of Bathrooms:");

        furnishedLabel.setFont(new java.awt.Font("Times New Roman", 1, 12));
        furnishedLabel.setText("Furnished:");

        quadrantLabel.setFont(new java.awt.Font("Times New Roman", 1, 12));
        quadrantLabel.setText("City Quadrant:");

        dateLabel.setFont(new java.awt.Font("Times New Roman", 1, 12));
        dateLabel.setText("Posted Date:");

        addressDisplay.setFont(new java.awt.Font("Times New Roman", 0, 12));
        addressDisplay.setEditable(false);
        addressDisplay.setText(this.address);

        numBathroomsDisplay.setFont(new java.awt.Font("Times New Roman", 0, 12));
        numBathroomsDisplay.setEditable(false);
        numBathroomsDisplay.setText(String.valueOf(this.numBathrooms));

        typeDisplay.setFont(new java.awt.Font("Times New Roman", 0, 12));
        typeDisplay.setEditable(false);
        typeDisplay.setText(this.type);

        quadrantDisplay.setFont(new java.awt.Font("Times New Roman", 0, 12));
        quadrantDisplay.setEditable(false);
        quadrantDisplay.setText(this.quadrant);

        numBedroomsDisplay.setFont(new java.awt.Font("Times New Roman", 0, 12));
        numBedroomsDisplay.setEditable(false);
        numBedroomsDisplay.setText(String.valueOf(this.numBedrooms));

        dateDisplay.setFont(new java.awt.Font("Times New Roman", 0, 12));
        dateDisplay.setEditable(false);
        dateDisplay.setText(this.postedDate);

        furnishedDisplay.setFont(new java.awt.Font("Times New Roman", 0, 12));
        furnishedDisplay.setEditable(false);
        String furnishedString;
        if (this.furnished == true)
            furnishedString = "Yes";
        else
            furnishedString = "No";
        furnishedDisplay.setText(furnishedString);

        doneButton.setBackground(new java.awt.Color(0, 204, 0));
        doneButton.setFont(new java.awt.Font("Times New Roman", 1, 12));
        doneButton.setText("Done");

        sendEmailButton.setFont(new java.awt.Font("Times New Roman", 1, 12));
        sendEmailButton.setText("Send Email");

        // Creating a new layout (horizontal and vertical both) to fixate the elements
        // and their sizes.
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(propertyDetailsFrame.getContentPane());
        propertyDetailsFrame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(addressLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(addressDisplay, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(typeLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(typeDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 174,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(numBathroomsLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33,
                                                        Short.MAX_VALUE)
                                                .addComponent(numBathroomsDisplay,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 174,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(numBedroomsLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(numBedroomsDisplay,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 174,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(furnishedLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(furnishedDisplay, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(quadrantLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(quadrantDisplay, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                .createSequentialGroup()
                                                .addComponent(dateLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                false)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(doneButton)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        Short.MAX_VALUE)
                                                                .addComponent(sendEmailButton))
                                                        .addComponent(dateDisplay,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 174,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(23, 23, 23))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(titleLabel)
                                .addGap(126, 126, 126)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(titleLabel)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(addressLabel)
                                        .addComponent(addressDisplay, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(typeLabel)
                                        .addComponent(typeDisplay, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(numBedroomsLabel)
                                        .addComponent(numBedroomsDisplay, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(numBathroomsLabel)
                                        .addComponent(numBathroomsDisplay, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(furnishedLabel)
                                        .addComponent(furnishedDisplay, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(quadrantLabel)
                                        .addComponent(quadrantDisplay, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(dateLabel)
                                        .addComponent(dateDisplay, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(doneButton)
                                        .addComponent(sendEmailButton))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        // Packs all elements according to their set sizes and locations.
        propertyDetailsFrame.pack();

        // If the done button is clicked, dispose of this frame.
        doneButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent end_event) {
                propertyDetailsFrame.dispose();
            }
        });

        // If the send email button is clicked, call sendEmail();
        sendEmailButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent end_event) {
                propertyDetailsFrame.dispose();
                sendEmail();
            }
        });
    }

    public void display(Object e) {
        // Creating the JFrame and setting its properties.
        JFrame propertyDetailsFrame = new JFrame("PROPERTY DISPLAY");
        propertyDetailsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        propertyDetailsFrame.setSize(400, 360);
        propertyDetailsFrame.setLocationRelativeTo(null);
        propertyDetailsFrame.setVisible(true);

        // Creating the elements which will be displayed on the JFrame.
        JLabel titleLabel = new JLabel();
        JLabel addressLabel = new JLabel();
        JLabel typeLabel = new JLabel();
        JLabel numBedroomsLabel = new JLabel();
        JLabel numBathroomsLabel = new JLabel();
        JLabel furnishedLabel = new JLabel();
        JLabel quadrantLabel = new JLabel();
        JLabel dateLabel = new JLabel();
        JTextField addressDisplay = new JTextField();
        JTextField numBathroomsDisplay = new JTextField();
        JTextField typeDisplay = new JTextField();
        JTextField quadrantDisplay = new JTextField();
        JTextField numBedroomsDisplay = new JTextField();
        JTextField dateDisplay = new JTextField();
        JTextField furnishedDisplay = new JTextField();
        JButton doneButton = new JButton();
        JButton sendEmailButton = new JButton();

        // Setting the font and text of the elements.
        titleLabel.setFont(new java.awt.Font("Times New Roman", 1, 14));
        titleLabel.setText("Property Information");

        addressLabel.setFont(new java.awt.Font("Times New Roman", 1, 12));
        addressLabel.setText("Address:");

        typeLabel.setFont(new java.awt.Font("Times New Roman", 1, 12));
        typeLabel.setText("Type of Property:");

        numBedroomsLabel.setFont(new java.awt.Font("Times New Roman", 1, 12));
        numBedroomsLabel.setText("Number of Bedrooms:");

        numBathroomsLabel.setFont(new java.awt.Font("Times New Roman", 1, 12));
        numBathroomsLabel.setText("Number of Bathrooms:");

        furnishedLabel.setFont(new java.awt.Font("Times New Roman", 1, 12));
        furnishedLabel.setText("Furnished:");

        quadrantLabel.setFont(new java.awt.Font("Times New Roman", 1, 12));
        quadrantLabel.setText("City Quadrant:");

        dateLabel.setFont(new java.awt.Font("Times New Roman", 1, 12));
        dateLabel.setText("Posted Date:");

        addressDisplay.setFont(new java.awt.Font("Times New Roman", 0, 12));
        addressDisplay.setEditable(false);
        addressDisplay.setText(this.address);

        numBathroomsDisplay.setFont(new java.awt.Font("Times New Roman", 0, 12));
        numBathroomsDisplay.setEditable(false);
        numBathroomsDisplay.setText(String.valueOf(this.numBathrooms));

        typeDisplay.setFont(new java.awt.Font("Times New Roman", 0, 12));
        typeDisplay.setEditable(false);
        typeDisplay.setText(this.type);

        quadrantDisplay.setFont(new java.awt.Font("Times New Roman", 0, 12));
        quadrantDisplay.setEditable(false);
        quadrantDisplay.setText(this.quadrant);

        numBedroomsDisplay.setFont(new java.awt.Font("Times New Roman", 0, 12));
        numBedroomsDisplay.setEditable(false);
        numBedroomsDisplay.setText(String.valueOf(this.numBedrooms));

        dateDisplay.setFont(new java.awt.Font("Times New Roman", 0, 12));
        dateDisplay.setEditable(false);
        dateDisplay.setText(this.postedDate);

        furnishedDisplay.setFont(new java.awt.Font("Times New Roman", 0, 12));
        furnishedDisplay.setEditable(false);
        String furnishedString;
        if (this.furnished == true)
            furnishedString = "Yes";
        else
            furnishedString = "No";
        furnishedDisplay.setText(furnishedString);

        doneButton.setBackground(new java.awt.Color(0, 204, 0));
        doneButton.setFont(new java.awt.Font("Times New Roman", 1, 12));
        doneButton.setText("Done");

        sendEmailButton.setFont(new java.awt.Font("Times New Roman", 1, 12));
        sendEmailButton.setText("Send Email");

        // Creating a new layout (horizontal and vertical both) to fixate the elements
        // and their sizes.
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(propertyDetailsFrame.getContentPane());
        propertyDetailsFrame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(addressLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(addressDisplay, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(typeLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(typeDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 174,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(numBathroomsLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33,
                                                        Short.MAX_VALUE)
                                                .addComponent(numBathroomsDisplay,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 174,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(numBedroomsLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(numBedroomsDisplay,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 174,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(furnishedLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(furnishedDisplay, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(quadrantLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(quadrantDisplay, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                .createSequentialGroup()
                                                .addComponent(dateLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                false)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(doneButton)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        Short.MAX_VALUE)
                                                                .addComponent(sendEmailButton))
                                                        .addComponent(dateDisplay,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 174,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(23, 23, 23))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(titleLabel)
                                .addGap(126, 126, 126)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(titleLabel)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(addressLabel)
                                        .addComponent(addressDisplay, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(typeLabel)
                                        .addComponent(typeDisplay, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(numBedroomsLabel)
                                        .addComponent(numBedroomsDisplay, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(numBathroomsLabel)
                                        .addComponent(numBathroomsDisplay, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(furnishedLabel)
                                        .addComponent(furnishedDisplay, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(quadrantLabel)
                                        .addComponent(quadrantDisplay, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(dateLabel)
                                        .addComponent(dateDisplay, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(doneButton)
                                        .addComponent(sendEmailButton))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        // Packs all elements according to their set sizes and locations.
        propertyDetailsFrame.pack();

        // If the done button is clicked, dispose of this frame.
        doneButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent end_event) {
                propertyDetailsFrame.dispose();
                e.callback();
            }
        });

        // If the send email button is clicked, call sendEmail();
        sendEmailButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent end_event) {
                propertyDetailsFrame.dispose();
                sendEmail();
            }
        });
    }

    /*
     * Function to simulate an email sending GUI page.
     * Takes in no arguments and returns nothing.
     */
    private void sendEmail() {
        // Creating a new JFrame and setting its properties.
        JFrame sendEmailFrame = new JFrame("SEND EMAIL");
        sendEmailFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        sendEmailFrame.setSize(400, 270);
        sendEmailFrame.setLocationRelativeTo(null);
        sendEmailFrame.setVisible(true);

        // Creating elements to go on the JFrame.
        JScrollPane emailPane = new JScrollPane();
        JTextArea emailInput = new JTextArea();
        JLabel titleLabel = new JLabel();
        JButton sendButton = new JButton();

        // Setting properties and text and font of elements.
        emailInput.setColumns(20);
        emailInput.setRows(5);
        emailInput.setWrapStyleWord(true);
        emailPane.setViewportView(emailInput);

        titleLabel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        titleLabel.setText("Please enter your email:");

        sendButton.setBackground(new java.awt.Color(0, 204, 0));
        sendButton.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        sendButton.setText("Send");

        // Creating a new layout (both horizontal and vertical) to fixate the elements
        // position and sizes.
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(sendEmailFrame.getContentPane());
        sendEmailFrame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(emailPane))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(120, 120, 120)
                                                .addComponent(titleLabel)
                                                .addGap(0, 120, Short.MAX_VALUE)))
                                .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                                .addGap(165, 165, 165)
                                .addComponent(sendButton)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(titleLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(emailPane, javax.swing.GroupLayout.PREFERRED_SIZE, 153,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(sendButton)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        // Packs all elements according to their set sizes and locations.
        sendEmailFrame.pack();

        // If the send button is clicked, display a message box saying email sent and
        // dispose this frame.
        sendButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent end_event) {
                String[] option = { "Great!" };
                JOptionPane.showOptionDialog(null, "Email has been sent to landlord", "Confirmation page",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, option, option[0]);
                sendEmailFrame.dispose();
                display();
            }
        });
    }

    // Setter.
    public void setType(String type) {
        this.type = type;
    }
}