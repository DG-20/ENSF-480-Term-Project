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

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DisplayRR implements Strategy {
    public DisplayRR() {
        mySearchForm = new SearchForm();
        mySubForm = new SubscriptionForm();
        myNotifView = new NotificationView();
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
        
        EventQueue.invokeLater(() -> {
            JFrame frame = new JFrame("Registered Renter Homepage");
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

            JButton okButton = new JButton("OK");
            okButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    
                }
            });



            /* ON OK BUTTON PRESS */
            /* Check if user has valid login credentials */
            /* If true, redirect them to their correct homepage, otherwise show an error message */
            JButton okButton = new JButton("OK");
            okButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    
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
}