/*
 * File Name: StartUp.java
 * Authors:
 *      Cheyenne Goh (UCID: 30040528)
 *      Divyansh Goyal (UCID: 30089488)
 *      Rui Guan (UCID: 30072848)
 *      Sajid Hafiz (UCID: 30061336)
 */

package User_Interface_Layer;

import javax.swing.*;
import java.awt.event.*;

public class StartUp {
    private String userType;
    private LoginForm login;
    // private InteractionForm homePage; // not used

    public boolean loginPage() { // boolean not used (can be void)
        login = new LoginForm(userType);
        login.startLogin();
        return true;
    }

    public void welcome() {
        JFrame frame = new JFrame("WELCOME SCREEN");
        frame.setSize(400, 320);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JButton registeredRenterButton = new javax.swing.JButton();
        JButton managerButton = new JButton();
        JButton noAccountButton = new JButton();
        JButton landlordButton = new JButton();
        JLabel chooseOneLabel = new JLabel();

        registeredRenterButton.setFont(new java.awt.Font("Times New Roman", 1, 14));
        registeredRenterButton.setText("Registered Renter");

        managerButton.setFont(new java.awt.Font("Times New Roman", 1, 14));
        managerButton.setText("Manager");

        noAccountButton.setFont(new java.awt.Font("Times New Roman", 1, 14));
        noAccountButton.setText("No Account");

        landlordButton.setFont(new java.awt.Font("Times New Roman", 1, 14));
        landlordButton.setText("LandLord");

        chooseOneLabel.setFont(new java.awt.Font("Times New Roman", 1, 14));
        chooseOneLabel.setText("Please Choose One:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(registeredRenterButton, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(noAccountButton, javax.swing.GroupLayout.DEFAULT_SIZE, 376,
                                                Short.MAX_VALUE)
                                        .addComponent(landlordButton, javax.swing.GroupLayout.DEFAULT_SIZE, 376,
                                                Short.MAX_VALUE)
                                        .addComponent(managerButton, javax.swing.GroupLayout.DEFAULT_SIZE, 376,
                                                Short.MAX_VALUE))
                                .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                                .addGap(135, 135, 135)
                                .addComponent(chooseOneLabel)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(chooseOneLabel)
                                .addGap(12, 12, 12)
                                .addComponent(managerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 58,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(landlordButton, javax.swing.GroupLayout.PREFERRED_SIZE, 58,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(registeredRenterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 58,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(noAccountButton, javax.swing.GroupLayout.PREFERRED_SIZE, 58,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        managerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                userType = "Manager";
                // frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                frame.setVisible(false);
                loginPage();
            }
        });

        registeredRenterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                userType = "RR";
                // frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                frame.setVisible(false);
                loginPage();
            }
        });

        noAccountButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                userType = "Unregistered Renter";
                // frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                frame.setVisible(false);
                GUIHomePage x = new GUIHomePage("");
                x.setDisplayStrategy(userType);
                x.performStrategy();
            }
        });

        landlordButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                userType = "Landlord";
                frame.setVisible(false);
                // frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                loginPage();
            }
        });

        frame.pack();
    }

    public static void main(String args[]) {
        StartUp startUp = new StartUp();
        startUp.welcome();
    }

    public StartUp() {
    }
}