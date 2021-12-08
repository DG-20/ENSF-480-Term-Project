/*
 * File Name: DisplayLL.java
 * Authors:
 *      Cheyenne Goh (UCID: 30040528)
 *      Divyansh Goyal (UCID: 30089488)
 *      Rui Guan(UCID: 30072848)
 *      Sajid Hafiz (UCID: 30061336)
 */
package User_Interface_Layer;

import User_Interface_Layer.InteractionForm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

/**
 * 
 */
public class DisplayLL extends javax.swing.JFrame implements Strategy {

    /**
     * Default constructor
     */
    public DisplayLL() {
        myPropertyForm = new PropertyForm();
    }

    private InteractionForm myPropertyForm;

    public InteractionForm getMyPropertyForm() {
        return myPropertyForm;
    }

    public void setMyPropertyForm(InteractionForm myPropertyForm) {
        this.myPropertyForm = (PropertyForm) myPropertyForm;
    }

    /**
     * @param email
     *              Display the Landlord's Home Page
     */
    public void display(String email) {
        JFrame f = this;
        f.setVisible(true);
        JLabel jLabel1 = new javax.swing.JLabel();
        JButton updateListingB = new javax.swing.JButton();
        JButton registerPropertyB = new javax.swing.JButton();
        JButton logoutB = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Click one of the following options:");

        updateListingB.setText("Update a Listing");
        updateListingB.setActionCommand("Update a Listing");

        registerPropertyB.setText("Register a Property");
        logoutB.setBackground(new java.awt.Color(255, 0, 0));
        logoutB.setText("LOGOUT");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(140, 140, 140)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(registerPropertyB,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 215,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(updateListingB,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 215,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(21, 21, 21)
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98,
                                                        Short.MAX_VALUE)
                                                .addComponent(logoutB)))
                                .addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(logoutB))
                                .addGap(16, 16, 16)
                                .addComponent(updateListingB, javax.swing.GroupLayout.PREFERRED_SIZE, 104,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(registerPropertyB, javax.swing.GroupLayout.PREFERRED_SIZE, 108,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(23, Short.MAX_VALUE)));

        pack();

        /* Call Update Listing Form */
        updateListingB.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                ((PropertyForm) myPropertyForm).browseProperties();

            }
        });

        /* Call Register Form */
        registerPropertyB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                ((PropertyForm) myPropertyForm).startRegistration();

            }
        });

        /* Do a Logout */
        logoutB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                StartUp.main(new String[] { "" });

            }
        });

    }

}