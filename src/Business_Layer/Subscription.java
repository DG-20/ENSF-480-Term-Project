/*
 * File Name: Subscription.java
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

public class Subscription {
    private String type;
    private int numBedrooms;
    private int numBathrooms;
    private boolean furnished;
    private String quadrant;

    public Subscription(String type, int numBedrooms, int numBathrooms, boolean furnished, String quadrant) {
        this.type = type;
        this.numBedrooms = numBedrooms;
        this.numBathrooms = numBathrooms;
        this.furnished = furnished;
        this.quadrant = quadrant;
    }

    public Subscription() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public boolean getFurnished() {
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

    public void display() {
        JFrame subscriptionDetailsFrame = new JFrame("Subscription display");
        subscriptionDetailsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        subscriptionDetailsFrame.setSize(500, 500);
        Container subscriptionContainer = new Container();
        subscriptionContainer.setLayout(new GridBagLayout());
        JPanel subscriptionPanel = new JPanel();
        subscriptionPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        subscriptionPanel.setLayout(new BorderLayout());
        subscriptionPanel.add(subscriptionContainer);
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        String subscriptionInfoString = "<html><h2>Subscription Parameters</h2><br><p><b>Type of property: "
        + this.type
        + "<br>Number of bedrooms: "
        + String.valueOf(this.numBedrooms)
        + "<br>Number of bathrooms: "
        + String.valueOf(this.numBathrooms)
        + "<br>Furnished: "
        + (this.furnished == true? "Yes": "No")
        + "<br>City quadrant: "
        + this.quadrant
        + "</b></p></html>"; 
        System.out.println(subscriptionInfoString);
        JLabel subscriptionInfo = new JLabel(subscriptionInfoString);
        subscriptionInfo.setBorder(BorderFactory.createEmptyBorder(0, 5, 10, 0));
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        subscriptionContainer.add(subscriptionInfo, c);
        JButton okayButton = new JButton("Okay");
        okayButton.setFocusPainted(false);
        okayButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent end_event) {
                subscriptionDetailsFrame.dispose();
            }
        });
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));
        buttonPanel.add(Box.createHorizontalGlue());
        buttonPanel.add(okayButton);
        
        subscriptionDetailsFrame.getContentPane().add(subscriptionInfo, BorderLayout.CENTER);
        subscriptionDetailsFrame.getContentPane().add(buttonPanel, BorderLayout.PAGE_END);

        subscriptionDetailsFrame.pack();
        subscriptionDetailsFrame.setVisible(true);
        return;
    }
}