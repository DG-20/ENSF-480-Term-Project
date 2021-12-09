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

    public Property() {
    }

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

    public void display() {
        JFrame propertyDetailsFrame = new JFrame("Property display");
        propertyDetailsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        propertyDetailsFrame.setSize(500, 500);
        Container propertyHomeContainer = new Container();
        propertyHomeContainer.setLayout(new GridBagLayout());
        JPanel propertyPanel = new JPanel();
        propertyPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        propertyPanel.setLayout(new BorderLayout());
        propertyPanel.add(propertyHomeContainer);
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        String propertyInfoString = "<html><p><b>Address: "
                + this.address
                + "<br>Type of property: "
                + this.type
                + "<br>Number of bedrooms: "
                + String.valueOf(this.numBedrooms)
                + "<br>Number of bathrooms: "
                + String.valueOf(this.numBathrooms)
                + "<br>Furnished: "
                + (this.furnished == true ? "Yes" : "No")
                + "<br>City quadrant: "
                + this.quadrant
                + "<br>Date posted: "
                + this.postedDate
                + "</b></p></html>";
        JLabel propertyInfo = new JLabel(propertyInfoString);
        propertyInfo.setBorder(BorderFactory.createEmptyBorder(0, 5, 10, 0));
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        propertyHomeContainer.add(propertyInfo, c);
        JButton okayButton = new JButton("Okay");
        okayButton.setFocusPainted(false);
        okayButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent end_event) {
                propertyDetailsFrame.dispose();
            }
        });
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));
        buttonPanel.add(Box.createHorizontalGlue());
        buttonPanel.add(okayButton);
        JButton sendEmailButton = new JButton("Email landlord");
        sendEmailButton.setFocusPainted(false);
        sendEmailButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent end_event) {
                sendEmail();
            }
        });
        buttonPanel.add(sendEmailButton);
        propertyDetailsFrame.getContentPane().add(propertyInfo, BorderLayout.CENTER);
        propertyDetailsFrame.getContentPane().add(buttonPanel, BorderLayout.PAGE_END);

        propertyDetailsFrame.pack();
        propertyDetailsFrame.setVisible(true);
        return;
    }

    private void sendEmail() {
        JFrame sendEmailFrame = new JFrame("Property display");
        sendEmailFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        sendEmailFrame.setSize(500, 500);
        Container emailContainer = new Container();
        emailContainer.setLayout(new GridBagLayout());
        JPanel emailPanel = new JPanel();
        emailPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        emailPanel.setLayout(new BorderLayout());
        emailPanel.add(emailContainer);
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        JTextField emailBody = new JTextField(20);
        emailBody.setBorder(BorderFactory.createEmptyBorder(0, 5, 10, 0));
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        emailContainer.add(emailBody, c);
        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent end_event) {
                String[] option = { "Great!" };
                JOptionPane.showOptionDialog(null, "Email has been sent to landlord", "Confirmation page",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, option, option[0]);
                sendEmailFrame.dispose();
            }
        });
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));
        buttonPanel.add(Box.createHorizontalGlue());
        buttonPanel.add(sendButton);
        sendEmailFrame.getContentPane().add(emailPanel, BorderLayout.CENTER);
        sendEmailFrame.getContentPane().add(buttonPanel, BorderLayout.PAGE_END);
        sendEmailFrame.pack();
        sendEmailFrame.setVisible(true);
        return;
    }

    public void setType(String type) {
        this.type = type;
    }
}