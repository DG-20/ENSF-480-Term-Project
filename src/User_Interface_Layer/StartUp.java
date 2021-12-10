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

/* 
 * StartUp is the creation class which contains the main method. This class 
 * contains an object of LoginFrom and a String which holds the type of user. It
 * presents the welcome page and calls upon the loginpage.
 */
public class StartUp {

        // Member attributes
        private String userType;
        private LoginForm login;

        /*
         * This function creates the LoginForm object and calls upon startLogin which
         * presents the login GUI and takes user input.
         * It takes in no parameters.
         * And returns void.
         */
        public boolean loginPage() {
                login = new LoginForm(userType);
                login.startLogin();
                return true;
        }

        /*
         * This function presents the welcome screen where the user chooses which
         * type of user they are, calls loginPage(), and for unregistered renters,
         * calls upon the appropriate function in the DisplayUR class.
         * It takes in no parameters.
         * And returns void.
         */
        public void welcome() {
                // Creating a new JFrame and setting its specs.
                JFrame frame = new JFrame("WELCOME SCREEN");
                frame.setSize(460, 530);
                frame.setVisible(true);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationRelativeTo(null);

                // Creating elements to be displayed on the frame.
                JPanel maxPanel = new JPanel();
                JPanel secondaryPanel = new JPanel();
                JPanel tertiaryPanel = new JPanel();
                JButton managerButton = new JButton();
                JButton landlordButton = new JButton();
                JButton rrButton = new JButton();
                JButton urButton = new JButton();
                JLabel titleLabel = new JLabel();
                JLabel taglineLabel = new JLabel();
                JLabel chooseLabel = new JLabel();
                JSeparator seperator = new JSeparator();

                // Setting the text and fonts of the elements.
                maxPanel.setBackground(new java.awt.Color(44, 47, 51));
                maxPanel.setBorder(new javax.swing.border.MatteBorder(null));

                secondaryPanel.setBackground(new java.awt.Color(44, 47, 51));

                tertiaryPanel.setBackground(new java.awt.Color(78, 93, 148));

                managerButton.setBackground(new java.awt.Color(220, 220, 220));
                managerButton.setFont(new java.awt.Font("Times New Roman", 1, 14));
                managerButton.setText("Manager");

                landlordButton.setBackground(new java.awt.Color(220, 220, 220));
                landlordButton.setFont(new java.awt.Font("Times New Roman", 1, 14));
                landlordButton.setText("LandLord");

                rrButton.setBackground(new java.awt.Color(220, 220, 220));
                rrButton.setFont(new java.awt.Font("Times New Roman", 1, 14));
                rrButton.setText("Registered Renter");

                urButton.setBackground(new java.awt.Color(220, 220, 220));
                urButton.setFont(new java.awt.Font("Times New Roman", 1, 14));
                urButton.setText("No Account");

                titleLabel.setFont(new java.awt.Font("Felix Titling", 1, 21));
                titleLabel.setForeground(new java.awt.Color(240, 240, 240));
                titleLabel.setText("Welcome to Rent'R'Us!");
                titleLabel.setPreferredSize(new java.awt.Dimension(113, 14));

                taglineLabel.setFont(new java.awt.Font("Roboto", 2, 14));
                taglineLabel.setForeground(new java.awt.Color(240, 240, 240));
                taglineLabel.setText("For all your renting needs!");

                chooseLabel.setFont(new java.awt.Font("Times New Roman", 1, 14));
                chooseLabel.setForeground(new java.awt.Color(240, 240, 240));
                chooseLabel.setText("Please choose what kind of user you are:");

                // Creating a new layout (horizontal and vertical) and placing the elements
                // accordingly to their respective positions.
                javax.swing.GroupLayout tertiaryPanelLayout = new javax.swing.GroupLayout(tertiaryPanel);
                tertiaryPanel.setLayout(tertiaryPanelLayout);
                tertiaryPanelLayout.setHorizontalGroup(
                                tertiaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(tertiaryPanelLayout.createSequentialGroup()
                                                                .addGroup(tertiaryPanelLayout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(tertiaryPanelLayout
                                                                                                .createSequentialGroup()
                                                                                                .addGroup(tertiaryPanelLayout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addGroup(tertiaryPanelLayout
                                                                                                                                .createSequentialGroup()
                                                                                                                                .addGap(12, 12, 12)
                                                                                                                                .addComponent(taglineLabel))
                                                                                                                .addGroup(tertiaryPanelLayout
                                                                                                                                .createSequentialGroup()
                                                                                                                                .addGap(73, 73, 73)
                                                                                                                                .addGroup(tertiaryPanelLayout
                                                                                                                                                .createParallelGroup(
                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                                .addComponent(landlordButton,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                147,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                                .addComponent(managerButton,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                147,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                                .addComponent(rrButton,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                147,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                                .addComponent(urButton,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                147,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                                                                .addGroup(tertiaryPanelLayout
                                                                                                                                .createSequentialGroup()
                                                                                                                                .addContainerGap()
                                                                                                                                .addComponent(titleLabel,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                284,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                tertiaryPanelLayout
                                                                                                                .createSequentialGroup()
                                                                                                                .addContainerGap()
                                                                                                                .addComponent(seperator)))
                                                                .addContainerGap())
                                                .addGroup(tertiaryPanelLayout.createSequentialGroup()
                                                                .addGap(26, 26, 26)
                                                                .addComponent(chooseLabel)
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));
                tertiaryPanelLayout.setVerticalGroup(
                                tertiaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(tertiaryPanelLayout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(titleLabel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                70,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(seperator,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                10,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(taglineLabel)
                                                                .addGap(20, 20, 20)
                                                                .addComponent(chooseLabel)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(managerButton,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                59,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(landlordButton,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                59,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(rrButton,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                59,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(urButton,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                59,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap(23, Short.MAX_VALUE)));

                javax.swing.GroupLayout secondaryPanelLayout = new javax.swing.GroupLayout(secondaryPanel);
                secondaryPanel.setLayout(secondaryPanelLayout);
                secondaryPanelLayout.setHorizontalGroup(
                                secondaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(secondaryPanelLayout.createSequentialGroup()
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(tertiaryPanel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                303,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)));
                secondaryPanelLayout.setVerticalGroup(
                                secondaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(tertiaryPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE));

                javax.swing.GroupLayout maxPanelLayout = new javax.swing.GroupLayout(maxPanel);
                maxPanel.setLayout(maxPanelLayout);
                maxPanelLayout.setHorizontalGroup(
                                maxPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, maxPanelLayout
                                                                .createSequentialGroup()
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(secondaryPanel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(489, 489, 489)));
                maxPanelLayout.setVerticalGroup(
                                maxPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(maxPanelLayout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(secondaryPanel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame.getContentPane());
                frame.getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(maxPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 357,
                                                                Short.MAX_VALUE));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(maxPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE));

                // Packs all elements according to their set sizes and locations.
                frame.pack();

                // If the manager button is clicked, calling upon loginpage() and hiding this
                // GUI.
                managerButton.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                                userType = "Manager";
                                // frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                                frame.setVisible(false);
                                loginPage();
                        }
                });

                // If the registered renter button is clicked, calling upon loginpage() and
                // hiding this GUI.
                rrButton.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                                userType = "RR";
                                // frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                                frame.setVisible(false);
                                loginPage();
                        }
                });

                // If no account is clicked, calling upon performStrategy after setting the
                // strategy according to the user type.
                urButton.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                                userType = "Unregistered Renter";
                                // frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                                frame.setVisible(false);
                                GUIHomePage x = new GUIHomePage("");
                                x.setDisplayStrategy(userType);
                                x.performStrategy();
                        }
                });

                // If the landlord button is clicked, calling upon loginpage() and hiding this
                // GUI.
                landlordButton.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                                userType = "Landlord";
                                frame.setVisible(false);
                                // frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                                loginPage();
                        }
                });
        }

        /*
         * This main function creates an object of type StartUp and calls upon the
         * welcome function.
         * It takes in an array of command line arguments of type String as
         * parameters.
         * And returns void.
         */
        public static void main(String args[]) {
                StartUp startUp = new StartUp();
                startUp.welcome();
        }

        // Empty default constructor
        public StartUp() {
        }
}