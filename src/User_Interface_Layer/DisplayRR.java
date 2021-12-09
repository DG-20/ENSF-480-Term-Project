/*
 * File Name: DisplayRR.java
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

public class DisplayRR extends javax.swing.JFrame implements Strategy {

    public DisplayRR() {
        mySearchForm = new SearchForm();
        mySubForm = new SubscriptionForm();
    }

    private InteractionForm mySearchForm;
    private InteractionForm mySubForm;
    private InteractionForm myNotifView;

    public InteractionForm getMySearchForm() {
        return mySearchForm;
    }

    public void setMySearchForm(InteractionForm mySearchForm) {
        this.mySearchForm = mySearchForm;
    }

    public InteractionForm getMySubForm() {
        return mySubForm;
    }

    public void setMySubForm(InteractionForm mySubForm) {
        this.mySubForm = mySubForm;
    }

    public InteractionForm getMyNotifView() {
        return myNotifView;
    }

    public void setMyNotifView(InteractionForm myNotifView) {
        this.myNotifView = myNotifView;
    }

    public void display(String email) {
        JFrame frame = this;
        frame.setVisible(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JButton manageSubsButton = new JButton();
        JButton notificationsButton = new JButton();
        JButton browseButton = new JButton();
        JButton logoutButton = new JButton();
        JLabel titleText = new JLabel();

        manageSubsButton.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        manageSubsButton.setText("Manage Subs");

        notificationsButton.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        notificationsButton.setText("Notifications");

        browseButton.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        browseButton.setText("Browse");

        logoutButton.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        logoutButton.setText("Logout");
        logoutButton.setActionCommand("Logout");

        titleText.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        titleText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleText.setText("Please make a selection:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(manageSubsButton,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(notificationsButton,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(browseButton,
                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, 376,
                                                                Short.MAX_VALUE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(113, 113, 113)
                                                .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 172,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                                .addGap(125, 125, 125)
                                .addComponent(titleText)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(titleText)
                                .addGap(18, 18, 18)
                                .addComponent(manageSubsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 64,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(notificationsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 64,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(browseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 64,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 28,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap()));

        pack();

        /* Call Manage Subs */
        manageSubsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                ((SubscriptionForm)mySubForm).displayMySubs();
            }
        });

        /* Call Notification View */
        notificationsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                myNotifView = new NotificationView(email);
                ((NotificationView)myNotifView).showSubbed();
            }
        });

        /* Call Search Form */
        browseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                ((SearchForm)mySearchForm).createSearchQuery(); // Rui's implementation
            }
        });

        /* Do a Logout */
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                ;
                StartUp.main(new String[] { "" });
            }
        });
        return;
    }
}