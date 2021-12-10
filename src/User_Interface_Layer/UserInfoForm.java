/*
 * File Name: UserInfoForm.java
 * Authors:
 *      Cheyenne Goh (UCID: 30040528)
 *      Divyansh Goyal (UCID: 30089488)
 *      Rui Guan(UCID: 30072848)
 *      Sajid Hafiz (UCID: 30061336)
 */
package User_Interface_Layer;

import Business_Layer.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

/*
 * This class display all user information to the Manager.
 * It extends InteractionForm.
 */
public class UserInfoForm extends InteractionForm {
        /*
         * The public default constructor.
         */
        public UserInfoForm() {
        }

        /*
         * This display function returns nothing and takes in no arguments. Its purpose
         * is to display all users' (except managers') email, password, name, and type
         * in a JTable.
         */
        public void display() {
                // Getting all Registered Users using the Singleton.
                ArrayList<User> allUsers = Singleton.getInstance().getRegisteredUsers();
                // Creating a new frame and setting its properties.
                JFrame frame = new JFrame("USERS INFORMATION");
                frame.setSize(550, 330);
                frame.setVisible(true);
                frame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
                frame.setLocationRelativeTo(null);

                // Creating new elements to be displays on the JFrame.
                JLabel titleLabel = new javax.swing.JLabel();
                JScrollPane tablePane = new javax.swing.JScrollPane();
                JTable userTable = new javax.swing.JTable();
                JButton doneButton = new javax.swing.JButton();

                // Setting the element properties and values.
                titleLabel.setFont(new java.awt.Font("Times New Roman", 1, 14));
                titleLabel.setText("All Registered User Information:");

                int numManagers = 0;

                for (int i = 0; i < allUsers.size(); i++) {
                        if (allUsers.get(i).getType().equals("Manager"))
                                numManagers++;
                }

                // Populating the JTable data with names, types, emails, and passwords of all
                // users excluding Managers.
                String[][] userTableStrings = new String[allUsers.size() - numManagers][4];
                int idx = 0;
                for (int i = 0; i < allUsers.size(); i++) {
                        if (allUsers.get(i).getType().equals("Manager"))
                                continue;
                        userTableStrings[idx][0] = allUsers.get(i).getName();
                        userTableStrings[idx][1] = allUsers.get(i).getType();
                        userTableStrings[idx][2] = allUsers.get(i).getEmail();
                        userTableStrings[idx][3] = allUsers.get(i).getPassword();
                        idx++;
                }

                // Setting properties of the JTable.
                userTable.setFont(new java.awt.Font("Times New Roman", 0, 12));
                userTable.setModel(new javax.swing.table.DefaultTableModel(
                                userTableStrings,
                                new String[] {
                                                "Name", "Type", "Email", "Password"
                                }) {
                        Class[] types = new Class[] {
                                        java.lang.String.class, java.lang.String.class, java.lang.String.class,
                                        java.lang.String.class
                        };
                        boolean[] canEdit = new boolean[] {
                                        false, false, false, false
                        };

                        public Class getColumnClass(int columnIndex) {
                                return types[columnIndex];
                        }

                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                                return canEdit[columnIndex];
                        }
                });
                tablePane.setViewportView(userTable);

                doneButton.setFont(new java.awt.Font("Times New Roman", 1, 12));
                doneButton.setText("Done");

                // Creating a new layout (both horizontal and vertical) and fixating the
                // position and sizes along with gaps between elements.
                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame.getContentPane());
                frame.getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(tablePane,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                520, Short.MAX_VALUE)
                                                                .addContainerGap())
                                                .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addGap(162, 162, 162)
                                                                                                .addComponent(titleLabel))
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addGap(225, 225, 225)
                                                                                                .addComponent(doneButton)))
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(titleLabel)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(tablePane,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                210,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                29,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(doneButton)
                                                                .addContainerGap()));

                // Packs all elements according to their set sizes and locations.
                frame.pack();

                // If the done button was clicked, dispose of this frame and call upon the
                // Homepage of the Manager again.
                doneButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                frame.dispose();
                                GUIHomePage x = new GUIHomePage(GUIHomePage.getEmail());
                                x.performStrategy();
                        }
                });
        }
};