/*
 * File Name: ChangePeriodFeesForm.java
 * Authors:
 *      Cheyenne Goh (UCID: 30040528)
 *      Divyansh Goyal (UCID: 30089488)
 *      Rui Guan(UCID: 30072848)
 *      Sajid Hafiz (UCID: 30061336)
 */
package User_Interface_Layer;

import Control_Layer.Controller;
import Control_Layer.PeriodFeesController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * A class which presents the GUI for the Manager when they would like to change
 * the period/amount of the fees.
 * This class communicates with the database using the PeriodFeesController to
 * get and set information provided by the manager.
 * This class extends InteractionForm as it is a form for the Manager.
 */
public class ChangePeriodFeesForm extends InteractionForm {
        // Default constructor which initializes myController.
        public ChangePeriodFeesForm() {
                myController = new PeriodFeesController();
        }

        private Controller myController;

        // Getter and Setter for myController.
        public Controller getMyController() {
                return myController;
        }

        public void setMyController(Controller myController) {
                this.myController = myController;
        }

        public void changePeriodFees() {
                // Creating a new JFrame and setting specs.
                JFrame frame = new JFrame();
                frame.setSize(450, 320);
                frame.setVisible(true);
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frame.setLocationRelativeTo(null);

                // Initializing the elements to be displayed on the JFrame.
                JButton confirmButton = new JButton();
                JButton goBackButton = new JButton();
                JLabel enterInfoLabel = new JLabel();
                JLabel currentLabel = new JLabel();
                JLabel amountLabel = new JLabel();
                JLabel periodLabel = new JLabel();
                JTextField currentDisplay = new JTextField();
                JTextField amountInput = new JTextField(10);
                JTextField periodInput = new JTextField(10);

                // Obtaining the current payment amount and period from the controller.
                // A type-case is required as the myController object is of type Controller
                // (container class).
                int currentPaymentVal = ((PeriodFeesController) myController).sendPayment();
                int currentPeriodVal = ((PeriodFeesController) myController).sendPeriod();

                // Setting the Strings of the elements that display values.
                String currentDisplayField = "Amount: " + String.valueOf(currentPaymentVal)
                                + "  Period: "
                                + String.valueOf(currentPeriodVal);

                enterInfoLabel.setFont(new java.awt.Font("Times New Roman", 1, 14));
                enterInfoLabel.setText(
                                "<html>Please enter in the following information:<br>(Leave unchanged element(s) blank)</html>");

                currentLabel.setFont(new java.awt.Font("Times New Roman", 1, 14));
                currentLabel.setText("Current amount and period of fees:");

                currentDisplay.setFont(new java.awt.Font("Times New Roman", 1, 12));
                currentDisplay.setEditable(false);
                currentDisplay.setText(currentDisplayField);

                amountInput.setFont(new java.awt.Font("Times New Roman", 0, 10));

                periodInput.setFont(new java.awt.Font("Times New Roman", 0, 10));

                amountLabel.setFont(new java.awt.Font("Times New Roman", 1, 12));
                amountLabel.setText("Amount (int):");

                periodLabel.setFont(new java.awt.Font("Times New Roman", 1, 12));
                periodLabel.setText("Period (int):");

                confirmButton.setFont(new java.awt.Font("Times New Roman", 1, 14));
                confirmButton.setText("Confirm");

                goBackButton.setFont(new java.awt.Font("Times New Roman", 1, 14));
                goBackButton.setText("Go back");

                // Creating a layout (both horizontal and vertical) to fixate all elements in
                // pre-defined areas and setting their sizes, as well as assigning gaps between
                // them.
                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame.getContentPane());
                frame.getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addContainerGap(74, Short.MAX_VALUE)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                layout.createSequentialGroup()
                                                                                                                .addComponent(currentLabel)
                                                                                                                .addGap(115, 115,
                                                                                                                                115))
                                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                layout
                                                                                                                .createSequentialGroup()
                                                                                                                .addComponent(enterInfoLabel,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addGap(85, 85, 85))
                                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                layout
                                                                                                                .createSequentialGroup()
                                                                                                                .addGroup(layout
                                                                                                                                .createParallelGroup(
                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                                false)
                                                                                                                                .addComponent(currentDisplay,
                                                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                312,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                                                                .addGroup(layout.createParallelGroup(
                                                                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                                                                                false)
                                                                                                                                                                .addComponent(amountInput)
                                                                                                                                                                .addComponent(amountLabel,
                                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                Short.MAX_VALUE))
                                                                                                                                                .addPreferredGap(
                                                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                Short.MAX_VALUE)
                                                                                                                                                .addGroup(layout.createParallelGroup(
                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                                                false)
                                                                                                                                                                .addComponent(periodLabel,
                                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                Short.MAX_VALUE)
                                                                                                                                                                .addComponent(periodInput))))
                                                                                                                .addGap(67, 67, 67))
                                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                layout
                                                                                                                .createSequentialGroup()
                                                                                                                .addGroup(layout
                                                                                                                                .createParallelGroup(
                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                .addComponent(goBackButton)
                                                                                                                                .addComponent(confirmButton))
                                                                                                                .addGap(171, 171,
                                                                                                                                171)))));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(currentLabel)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(currentDisplay,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                35,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(enterInfoLabel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(amountLabel)
                                                                                .addComponent(periodLabel))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(amountInput,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(periodInput,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(18, 18, 18)
                                                                .addComponent(confirmButton)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(goBackButton)
                                                                .addContainerGap(31, Short.MAX_VALUE)));

                // Packs all elements according to their set sizes and locations.
                frame.pack();

                // If the confirm button is clicked.
                confirmButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                // Obtaining the values the user entered as Strings.
                                String newAmount = amountInput.getText();
                                String newPeriod = periodInput.getText();

                                int newAmountInt = 0;
                                int newPeriodInt = 0;
                                boolean zeroStringAmount = false;
                                boolean zeroStringPeriod = false;

                                // If either field was left blank, this means they would like to use the current
                                // value.
                                if (newAmount.strip().length() == 0) {
                                        newAmountInt = -1;
                                        zeroStringAmount = true;
                                }

                                if (newPeriod.strip().length() == 0) {
                                        newPeriodInt = -1;
                                        zeroStringPeriod = true;
                                }

                                boolean error_present = false;

                                // If the user did not leave a field blank, trying to parse the String into an
                                // integer. Error checking if the user did not enter an int.
                                if (zeroStringAmount == false) {
                                        try {
                                                newAmountInt = Integer.parseInt(newAmount);
                                                if (newAmountInt < 0)
                                                        error_present = true;
                                        } catch (NumberFormatException exc) {
                                                error_present = true;
                                        }
                                }
                                if (zeroStringPeriod == false) {
                                        try {
                                                newPeriodInt = Integer.parseInt(newPeriod);
                                                if (newPeriodInt < 0)
                                                        error_present = true;
                                        } catch (NumberFormatException exc) {
                                                error_present = true;
                                        }
                                }

                                // If the input is invalid, displaying an error message and asking them to
                                // re-submit with proper values.
                                if (error_present == true) {
                                        JOptionPane.showMessageDialog(frame, "Please enter positive integers only",
                                                        "INVALID INPUT", JOptionPane.ERROR_MESSAGE);
                                        return;
                                }

                                // Calling forwardPeriodFees with the entered information to update the
                                // database. Then, showing the homepage for the Manager again.
                                ((PeriodFeesController) myController).forwardPeriodFees(newAmountInt, newPeriodInt);
                                JOptionPane.showMessageDialog(frame, "The period and fees have been updated.",
                                                "Success!", 1);
                                frame.dispose();
                                GUIHomePage x = new GUIHomePage(GUIHomePage.getEmail());
                                x.performStrategy();
                        }
                });

                // If the back button was clicked, go back to the homepage of the Manager.
                goBackButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                frame.dispose();
                                new GUIHomePage(GUIHomePage.getEmail()).performStrategy();
                        }
                });
        }
}