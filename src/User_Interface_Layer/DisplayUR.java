/*
 * File Name: DisplayUR.java
 * Authors:
 *      Cheyenne Goh (UCID: 30040528)
 *      Divyansh Goyal (UCID: 30089488)
 *      Rui Guan(UCID: 30072848)
 *      Sajid Hafiz (UCID: 30061336)
 */
package User_Interface_Layer;

import User_Interface_Layer.InteractionForm;

import javax.swing.*;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
/**
 *
 * @author lareina.jo
 */
public class DisplayUR extends javax.swing.JFrame implements Strategy  {
    /**
     * Default constructor
     */
    public DisplayUR() {
        mySearchForm = new SearchForm();
    }

    private InteractionForm mySearchForm;


    /**
     * @param email 
     * Display the Landlord's Home Page
     */
    public void display(String email)  {
        JFrame f = this;
        f.setVisible(true);
        Color bgColor = new Color(225,225,225);
        f.getContentPane().setBackground(bgColor);
        f.setTitle("Unregistered Renter");
		f.setResizable(false); 		//user can't resize GUI on their own
		f.setSize(300,340);
		
        JButton Searching = new javax.swing.JButton();
        JButton Exit = new javax.swing.JButton();
        
        //Font font = new Font("Comic Sans MS", Font.PLAIN, 20);
        //Searching.setFont(font);
        //Exit.setFont(font);
        Searching.setText("Searching");
        Exit.setText("    Exit     ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
        		layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(90, 90, 90)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(Searching)
                        .addComponent(Exit))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addContainerGap(80, Short.MAX_VALUE))
        );
        
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(70, 70, 70)
                            .addComponent(Searching, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(30, 30, 30)
                            .addComponent(Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(106, Short.MAX_VALUE))
        );
        // </editor-fold>                       

        Searching.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		f.setVisible(false);
        		((SearchForm)mySearchForm).createSearchQuery();
        	}
    	});   
        
		
        /* Do a Logout */
        Exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StartUp.main(new String[]{""});

            }
        });

    }
    
}
