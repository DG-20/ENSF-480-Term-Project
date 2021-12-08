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

public class ChangePeriodFeesForm extends InteractionForm {
    public ChangePeriodFeesForm() {
        myController = new PeriodFeesController();
    }

    private Controller myController;
    JFrame frame; // The JFrame object.

    public Controller getMyController() {
        return myController;
    }

    public void setMyController(Controller myController) {
        this.myController = myController;
    }

    public void changePeriodFees() {
        frame = new JFrame();
        frame.setSize(450, 320);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JButton confirmButton = new JButton();
        JButton goBackButton = new JButton();
        JLabel enterInfoLabel = new JLabel();
        JLabel currentLabel = new JLabel();
        JLabel amountLabel = new JLabel();
        JLabel periodLabel = new JLabel();
        JTextField currentDisplay = new JTextField();
        JTextField amountInput = new JTextField(10);
        JTextField periodInput = new JTextField(10);

        int currentPaymentVal = ((PeriodFeesController) myController).sendPayment();
        int currentPeriodVal = ((PeriodFeesController) myController).sendPeriod();
        String currentDisplayField = "Amount: " + String.valueOf(currentPaymentVal) + "\nPeriod: "
                + String.valueOf(currentPeriodVal);

        enterInfoLabel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        enterInfoLabel.setText(
                "<html>Please enter in the following information:<br>(Leave unchanged element(s) blank)</html>");

        currentLabel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        currentLabel.setText("Current amount and period of fees:");

        currentDisplay.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        currentDisplay.setEditable(false);
        currentDisplay.setText(currentDisplayField);

        amountInput.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N

        periodInput.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N

        amountLabel.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        amountLabel.setText("Amount (int):");

        periodLabel.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        periodLabel.setText("Period (int):");

        confirmButton.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        confirmButton.setText("Confirm");

        goBackButton.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        goBackButton.setText("Go back");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(74, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(currentLabel)
                        .addGap(115, 115, 115))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(enterInfoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(85, 85, 85))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(currentDisplay, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(amountInput)
                                    .addComponent(amountLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(periodLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(periodInput))))
                        .addGap(67, 67, 67))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(goBackButton)
                            .addComponent(confirmButton))
                        .addGap(171, 171, 171))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(currentLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(currentDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(enterInfoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(amountLabel)
                    .addComponent(periodLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(amountInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(periodInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(confirmButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(goBackButton)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        frame.pack();

        /* Call ChangePeriodFees Form */
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newAmount = amountInput.getText();
                String newPeriod = periodInput.getText();

                int newAmountInt = 0;
                int newPeriodInt = 0;
                boolean zeroString = false;

                if (newAmount.strip().length() == 0) {
                    newAmountInt = -1;
                    zeroString = true;
                }

                if (newPeriod.strip().length() == 0) {
                    newPeriodInt = -1;
                    zeroString = true;
                }

                boolean error_present = false;

                if (zeroString == false) {
                    try {
                        newAmountInt = Integer.parseInt(newAmount);
                    } catch (NumberFormatException exc) {
                        error_present = true;
                    }
                    try {
                        newPeriodInt = Integer.parseInt(newPeriod);
                    } catch (NumberFormatException exc) {
                        error_present = true;
                    }

                    if (error_present == true) {
                        JOptionPane.showMessageDialog(frame, "Please enter integers only",
                                "INVALID INPUT", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }

                ((PeriodFeesController) myController).forwardPeriodFees(newAmountInt, newPeriodInt);
                JOptionPane.showMessageDialog(frame, "The period and fees have been updated.", "Success!", 1);
                frame.dispose();
                GUIHomePage x = new GUIHomePage(GUIHomePage.getEmail());
                x.performStrategy();
            }
        });

        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new GUIHomePage(GUIHomePage.getEmail()).performStrategy();
            }
        });
    }
}