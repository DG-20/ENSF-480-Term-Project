/*
 * File Name: LoginForm.java
 * Authors:
 *      Cheyenne Goh (UCID: 30040528)
 *      Divyansh Goyal (UCID: 30089488)
 *      Rui Guan (UCID: 30072848)
 *      Sajid Hafiz (UCID: 30061336)
 */

package User_Interface_Layer;

// import LoginController.*;
import Control_Layer.Controller;
import Control_Layer.LoginController;
import Control_Layer.PeriodFeesController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginForm extends InteractionForm {
    private String inputEmail;
    private String inputPassword;
    private String userType; // not relevant

    /* Start the Login Process View */
    public void startLogin() {
        EventQueue.invokeLater(() -> {
            JFrame frame = new JFrame("Start Login");
            frame.setLocationRelativeTo(null);
            frame.setSize(500, 500);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            Container container = new Container();
            container.setLayout(new GridBagLayout());

            JPanel panel = new JPanel();
            panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            panel.setLayout(new BorderLayout());
            panel.add(container);

            GridBagConstraints c = new GridBagConstraints();
            c.fill = GridBagConstraints.HORIZONTAL;

            JLabel loginLabel = new JLabel("Login");
            loginLabel.setBorder(BorderFactory.createEmptyBorder(0, 5, 10, 0));
            c.gridx = 0;
            c.gridy = 0;
            c.gridwidth = 2;
            container.add(loginLabel, c);

            JLabel emailLabel = new JLabel("Email:", JLabel.TRAILING);
            c.gridwidth = 1;
            c.gridy = 1;
            container.add(emailLabel, c);
            JTextField emailTextField = new JTextField(10);
            c.gridx = 1;
            emailLabel.setLabelFor(emailTextField);
            container.add(emailTextField, c);

            JLabel passwordLabel = new JLabel("Password:", JLabel.TRAILING);
            c.gridx = 0;
            c.gridy = 2;
            container.add(passwordLabel, c);
            JPasswordField passwordField = new JPasswordField(10);
            c.gridx = 1;
            passwordLabel.setLabelFor(passwordField);
            container.add(passwordField, c);

            /* ON OK BUTTON PRESS */
            /* Check if user has valid login credentials */
            /*
             * If true, redirect them to their correct homepage, otherwise show an error
             * message
             */
            JButton okButton = new JButton("OK");
            okButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    inputEmail = emailTextField.getText();
                    inputPassword = String.valueOf(passwordField.getPassword());
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

            JPanel buttonPanel = new JPanel();
            buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
            buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));
            buttonPanel.add(Box.createHorizontalGlue());
            buttonPanel.add(okButton);

            frame.getContentPane().add(panel, BorderLayout.CENTER);
            frame.getContentPane().add(buttonPanel, BorderLayout.PAGE_END);

            frame.pack();
            frame.setVisible(true);
        });
    }

    public LoginForm(String userType) {
        this.userType = userType;
        Controller x = new LoginController();
        myControllers.add(x);
    }

    public String getInputEmail() {
        return inputEmail;
    }

    public String getInputPassword() {
        return inputPassword;
    }

}