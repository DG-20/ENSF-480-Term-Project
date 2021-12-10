/*
 * File Name: DisplayManager.java
 * Authors:
 *      Cheyenne Goh (UCID: 30040528)
 *      Divyansh Goyal (UCID: 30089488)
 *      Rui Guan(UCID: 30072848)
 *      Sajid Hafiz (UCID: 30061336)
 */
package User_Interface_Layer;

import Business_Layer.Property;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * A class which displays the homepage of the Manager.
 * Calls upon other InteractionForms depending on which button is clicked on.
 * This class extends the JFrame class and implements the Strategy interface.
 */
public class DisplayManager extends javax.swing.JFrame implements Strategy {
    /*
     * Public Constructor for DisplayManager.
     * It initializes all three InteractionForm member variables.
     * This does not take in any values as parameters.
     */
    public DisplayManager() {
        mySummaryForm = new SummaryForm();
        myChangePF = new ChangePeriodFeesForm();
        myPropertyForm = new PropertyForm();
    }

    private InteractionForm mySummaryForm;
    private InteractionForm myChangePF;
    private InteractionForm myPropertyForm;
    private InteractionForm myUserInfoForm;
    private InteractionForm myDetailedViewProperty;

    // Getters and Setters.
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

    // A function which displays the homepage of the Manager.
    public void display(String email) {
        // Setting properties of the JFrame.
        JFrame frame = this;
        frame.setTitle("MANAGER HOMEPAGE");
        frame.setVisible(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // Creating elements to be displayed on the JFrame.
        JButton updateListingButton = new JButton();
        JButton changePFButton = new JButton();
        JButton summaryButton = new JButton();
        JButton logoutButton = new JButton();
        JButton userInfoButton = new JButton();
        JLabel titleText = new JLabel();
        JButton propertyInfoButton = new JButton();

        // Setting the fonts and texts of the created elements.
        updateListingButton.setFont(new java.awt.Font("Times New Roman", 1, 14));
        updateListingButton.setText("Update Listing");

        changePFButton.setFont(new java.awt.Font("Times New Roman", 1, 14));
        changePFButton.setText("Change Amount and Period of Fees");

        summaryButton.setFont(new java.awt.Font("Times New Roman", 1, 14));
        summaryButton.setText("Show Summary");

        logoutButton.setFont(new java.awt.Font("Times New Roman", 1, 12));
        logoutButton.setText("Logout");
        logoutButton.setActionCommand("Logout");

        titleText.setFont(new java.awt.Font("Times New Roman", 1, 14));
        titleText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleText.setText("Please make a selection:");

        userInfoButton.setFont(new java.awt.Font("Times New Roman", 1, 14));
        userInfoButton.setText("Show All User Information");

        propertyInfoButton.setFont(new java.awt.Font("Times New Roman", 1, 14));
        propertyInfoButton.setText("View Properties");

        // Creating a new layout (both horizontal and vertical) to position all elements
        // and size them as we intend.
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(125, 125, 125)
                                                .addComponent(titleText)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(updateListingButton,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(changePFButton,
                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, 376,
                                                                Short.MAX_VALUE)
                                                        .addComponent(summaryButton,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                376, Short.MAX_VALUE)
                                                        .addComponent(userInfoButton,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, 376,
                                                                Short.MAX_VALUE)
                                                        .addComponent(propertyInfoButton,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, 376,
                                                                Short.MAX_VALUE))))
                                .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 172,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(titleText)
                                .addGap(18, 18, 18)
                                .addComponent(summaryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 64,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(updateListingButton, javax.swing.GroupLayout.PREFERRED_SIZE, 64,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(changePFButton, javax.swing.GroupLayout.PREFERRED_SIZE, 64,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(userInfoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 64,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(propertyInfoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 64,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 28,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        // Packs all elements according to their set sizes and locations.
        pack();

        // If the update listing button is clicked, hides this GUI page and calls upon
        // myPropertyForm's function browseProperties.
        updateListingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                ((PropertyForm) myPropertyForm).browseProperties();
            }
        });

        propertyInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new DetailedViewProperty();
            }
        });

        // If the change period and fees button is clicked, hide this GUI page, and call
        // upon the changePeriodFees function in myChangePF.
        changePFButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                ((ChangePeriodFeesForm) myChangePF).changePeriodFees();
            }
        });

        // If the summary button is clicked, asking the user what time period they would
        // like to view back up to. Showing the current period value in the inputDialog
        // box.
        summaryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int defaultPeriod = ((SummaryForm) mySummaryForm).getPeriod();
                String input = JOptionPane.showInputDialog(
                        "Please choose the period (number of days) of the summary you would like to view:",
                        defaultPeriod);
                if (input == null)
                    return;
                int periodChosen = defaultPeriod;
                // Error checking to only take in a positive integer value, and re-prompting the
                // user until a valid input is entered.
                try {
                    periodChosen = Integer.parseInt(input);
                } catch (Exception ee) {
                    boolean valid = false;
                    while (valid == false) {
                        input = JOptionPane
                                .showInputDialog("Please choose the period of the summary you would like to view:", 60);
                        try {
                            periodChosen = Integer.parseInt(input);
                            valid = true;
                        } catch (Exception eee) {
                            valid = false;
                        }
                    }
                }
                boolean valid = true;
                while (periodChosen <= 0 || valid == false) {
                    input = JOptionPane
                            .showInputDialog("Please choose the period of the summary you would like to view:", 60);
                    try {
                        periodChosen = Integer.parseInt(input);
                        valid = true;
                    } catch (Exception eee) {
                        valid = false;
                    }
                }
                // Hiding this GUI page and calling upon showSummary in mySummaryForm.
                frame.dispose();
                ((SummaryForm) mySummaryForm).showSummary(periodChosen);
            }
        });

        // If the user info button was clicked, dispose of this frame and call upon the
        // UserInfoForm constructor which displays all the users' information.
        userInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new UserInfoForm();
            }
        });

        // If the logout button was clicked, dispose of this frame and call upon the
        // main function again.
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                StartUp.main(new String[] { "" });
            }
        });
    }
}