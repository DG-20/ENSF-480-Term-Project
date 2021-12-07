/*
 * File Name: DisplayManager.java
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

public class DisplayManager extends javax.swing.JFrame implements Strategy {
    public DisplayManager() {
        mySummaryForm = new SummaryForm();
        myChangePF = new ChangePeriodFeesForm();
        myPropertyForm = new PropertyForm();
    }

    private InteractionForm mySummaryForm;
    private InteractionForm myChangePF;
    private InteractionForm myPropertyForm;

    public InteractionForm getMySummaryForm() {
        return mySummaryForm;
    }

    public void setMySummaryForm(InteractionForm mySummaryForm) {
        this.mySummaryForm = mySummaryForm;
    }

    public InteractionForm getMyChangePF() {
        return myChangePF;
    }

    public void setMyChangePF(InteractionForm myChangePF) {
        this.myChangePF = myChangePF;
    }

    public InteractionForm getMyPropertyForm() {
        return myPropertyForm;
    }

    public void setMyPropertyForm(InteractionForm myPropertyForm) {
        this.myPropertyForm = myPropertyForm;
    }

    public void display(String email) {
        JFrame frame = this;
        frame.setVisible(true);
        JButton updateListingButton = new JButton();
        JButton changePFButton = new JButton();
        JButton summaryButton = new JButton();
        JButton logoutButton = new javax.swing.JButton();
        JLabel titleText = new JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        updateListingButton.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        updateListingButton.setText("Update Listing");

        changePFButton.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        changePFButton.setText("Change Amount and Period of Fees");

        summaryButton.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        summaryButton.setText("Show Summary");

        logoutButton.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        logoutButton.setText("Logout");
        logoutButton.setActionCommand("Logout");

        titleText.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        titleText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleText.setText("Please make a selection:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(updateListingButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(changePFButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                            .addComponent(summaryButton, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addComponent(titleText)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(titleText)
                .addGap(18, 18, 18)
                .addComponent(summaryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(updateListingButton, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(changePFButton, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();

        /* Call Update Listing Form */
        updateListingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                ((PropertyForm)myPropertyForm).browseProperties();
            }
        });

        /* Call ChangePeriodFees Form */
        changePFButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                ((ChangePeriodFeesForm)myChangePF).changePeriodFees();
            }
        });

        /* Call Summary Form */
        summaryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                ((SummaryForm)mySummaryForm).showSummary();
            }
        });

        /* Do a Logout */
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StartUp.main(new String[]{""});
            }
        });
    }
}