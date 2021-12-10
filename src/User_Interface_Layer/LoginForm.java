/*
 * File Name: LoginForm.java
 * Authors:
 *      Cheyenne Goh (UCID: 30040528)
 *      Divyansh Goyal (UCID: 30089488)
 *      Rui Guan (UCID: 30072848)
 *      Sajid Hafiz (UCID: 30061336)
 */

package User_Interface_Layer;

import Control_Layer.*;

import javax.swing.*;
import java.awt.event.*;

/*
 * LoginForm presents the login page for managers, landlords, and registered 
 * renters. It displays the GUI and gets the user input. This class contains 
 * member variables which store the email, password, and the user type.
 */
public class LoginForm extends InteractionForm {

        // Member attributes
        private String inputEmail;
        private String inputPassword;
        private String userType;

        /*
         * This function performs the GUI operation to login
         * It takes in no parameters.
         * And returns void.
         */
        public void startLogin() {

                // Setting the JFrame properties.
                JFrame frame = new JFrame("LOGIN PAGE");
                frame.setLocationRelativeTo(null);
                frame.setSize(400, 230);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setVisible(true);

                // Creating and initializing the elements of the JFrame.
                JLabel loginLabel = new JLabel();
                JTextField emailTextField = new JTextField();
                JLabel emailLabel = new JLabel();
                JPasswordField passwordTextField = new JPasswordField();
                JLabel passwordLabel = new JLabel();
                JButton cancelButton = new JButton();
                JButton submitButton = new JButton();

                // Setting the font and text of the elements.
                loginLabel.setFont(new java.awt.Font("Times New Roman", 1, 14));
                loginLabel.setText("Please enter your login details:");

                emailTextField.setFont(new java.awt.Font("Times New Roman", 0, 12));

                emailLabel.setFont(new java.awt.Font("Times New Roman", 1, 12));
                emailLabel.setText("Email:");

                passwordTextField.setFont(new java.awt.Font("Times New Roman", 0, 12));

                passwordLabel.setFont(new java.awt.Font("Times New Roman", 1, 12));
                passwordLabel.setText("Password:");

                cancelButton.setBackground(new java.awt.Color(255, 0, 0));
                cancelButton.setFont(new java.awt.Font("Times New Roman", 1, 12));
                cancelButton.setText("Cancel");

                submitButton.setBackground(new java.awt.Color(50, 205, 50));
                submitButton.setFont(new java.awt.Font("Times New Roman", 1, 12));
                submitButton.setText("Submit");

                // Creating a new layout (both vertical and horizontal) and setting the
                // elements' sizes and positions.
                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame.getContentPane());
                frame.getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addContainerGap(33, Short.MAX_VALUE)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                layout.createSequentialGroup()
                                                                                                                .addComponent(loginLabel)
                                                                                                                .addGap(103, 103,
                                                                                                                                103))
                                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                layout
                                                                                                                .createSequentialGroup()
                                                                                                                .addGroup(layout
                                                                                                                                .createParallelGroup(
                                                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                                                                .addComponent(cancelButton,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                76,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                                .addGap(18, 18, 18)
                                                                                                                                                .addComponent(submitButton,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                76,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                                                                .addGroup(layout.createParallelGroup(
                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                                                .addComponent(emailLabel)
                                                                                                                                                                .addComponent(passwordLabel))
                                                                                                                                                .addGap(33, 33, 33)
                                                                                                                                                .addGroup(layout.createParallelGroup(
                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                                                false)
                                                                                                                                                                .addComponent(passwordTextField,
                                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                227,
                                                                                                                                                                                Short.MAX_VALUE)
                                                                                                                                                                .addComponent(emailTextField))))
                                                                                                                .addGap(53, 53, 53)))));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(loginLabel)
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(emailTextField,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                33,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(emailLabel))
                                                                .addGap(32, 32, 32)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(passwordLabel)
                                                                                .addComponent(passwordTextField,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                33,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                31,
                                                                                Short.MAX_VALUE)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(cancelButton,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                29,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(submitButton,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                29,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addContainerGap()));

                // If the user clicks upon the submit button, perform error checking and display
                // an error message if the input is not valid.
                // Calling upon forwardUser inside of controller to verify the email and
                // password entered.
                submitButton.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                                inputEmail = emailTextField.getText();
                                inputPassword = String.valueOf(passwordTextField.getPassword());
                                if (inputEmail.length() > 0 && inputPassword.length() > 0) {
                                        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                                        LoginController controller = (LoginController) myControllers.get(0);
                                        boolean valid = controller.forwardUser(inputEmail, inputPassword, userType);
                                        if (!valid) {
                                                JOptionPane.showMessageDialog(frame, "INVALID LOGIN! Try again.",
                                                                "INVALID LOGIN", JOptionPane.ERROR_MESSAGE);
                                                startLogin();
                                        } else {
                                                GUIHomePage guiHomePage = new GUIHomePage(inputEmail);
                                                guiHomePage.setDisplayStrategy(userType);
                                                guiHomePage.performStrategy();
                                        }
                                }
                        }
                });

                // If the user clicks on the cancel button, dispose of this frame and simply
                // call back the welcome function.
                cancelButton.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent equals) {
                                frame.dispose();
                                new StartUp().welcome();
                        }
                });

                // Packs all elements according to their set sizes and locations.
                frame.pack();
        }

        /*
         * This constructor sets the userType member variable, creates a
         * LoginController object and adds it to the myControllers ArrayList.
         * It takes in a user type of type String as a parameter.
         * And returns void.
         */
        public LoginForm(String userType) {
                this.userType = userType;
                Controller x = new LoginController();
                myControllers.add(x);
        }

        // Getter for inputEmail
        public String getInputEmail() {
                return inputEmail;
        }

        // Getter for inputPassword
        public String getInputPassword() {
                return inputPassword;
        }
}