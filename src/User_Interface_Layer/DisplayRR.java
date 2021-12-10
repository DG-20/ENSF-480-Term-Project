/*
 * File Name: DisplayRR.java
 * Authors:
 *      Cheyenne Goh (UCID: 30040528)
 *      Divyansh Goyal (UCID: 30089488)
 *      Rui Guan(UCID: 30072848)
 *      Sajid Hafiz (UCID: 30061336)
 */
package User_Interface_Layer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * A class concerned with displaying all relevant Registered Renter use cases 
 * which include: browsing a property, adding a subscription, removing a 
 * subscription, and notifications.
 */
public class DisplayRR extends javax.swing.JFrame implements Strategy {

    // Member attributes
    private InteractionForm mySearchForm;
    private InteractionForm mySubForm;
    private InteractionForm myNotifView;

    /*
     * This constructor initializes the mySearchForm member object
     * It takes in no parameters.
     */
    public DisplayRR() {
        mySearchForm = new SearchForm();
    }

    // Getter for mySearchForm
    public InteractionForm getMySearchForm() {
        return mySearchForm;
    }

    // Setter for mySearchForm
    public void setMySearchForm(InteractionForm mySearchForm) {
        this.mySearchForm = mySearchForm;
    }

    // Getter for mySubForm
    public InteractionForm getMySubForm() {
        return mySubForm;
    }

    // Setter for mySubForm
    public void setMySubForm(InteractionForm mySubForm) {
        this.mySubForm = mySubForm;
    }

    // Getter for myNotifView
    public InteractionForm getMyNotifView() {
        return myNotifView;
    }

    // Setter for myNotifView
    public void setMyNotifView(InteractionForm myNotifView) {
        this.myNotifView = myNotifView;
    }

    /*
     * This function displays the Registered Renter Homepage.
     * It takes in a user's email address of type String as a parameter.
     * And returns void.
     */
    public void display(String email) {
        // Frame
        JFrame frame = this;
        frame.setVisible(true);
        frame.setTitle("REGISTERED RENTER HOMEPAGE");
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // Button and Label objects
        JButton manageSubscriptionsButton = new JButton();
        JButton notificationsButton = new JButton();
        JButton browseButton = new JButton();
        JButton logoutButton = new JButton();
        JLabel titleText = new JLabel();

        manageSubscriptionsButton.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        manageSubscriptionsButton.setText("Manage Subsciptions");

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
                                                        .addComponent(manageSubscriptionsButton,
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
                                .addComponent(manageSubscriptionsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 64,
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

        /*
         * On manageSubscriptions button press, calls displayMySubs in SubscriptionForm.
         */
        manageSubscriptionsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                mySubForm = new SubscriptionForm(email);
                ((SubscriptionForm) mySubForm).displayMySubs();
            }
        });

        /* On notificationsButton press call Notification View's method showSubbed. */
        notificationsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                myNotifView = new NotificationView(email);
                ((NotificationView) myNotifView).showSubbed();
            }
        });

        /* On browseButton press, call SearchForm's method, createSearchQuery. */
        browseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                ((SearchForm) mySearchForm).createSearchQuery();
            }
        });

        /* On logoutButton press, perform a Logout. */
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