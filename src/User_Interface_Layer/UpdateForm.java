
package User_Interface_Layer;

import Business_Layer.Property;
import Control_Layer.UpdateController;

import javax.swing.*;

/*
 * This class displays all properties in the case of a Manager, 
 * and certain properties in the case of a Landlord and 
 * allows the user to change the status of it. A strict limitation
 * that is followed here (as interpreted from the project description)
 * that no property can be updated from Cancelled to anything else.
 */
public class UpdateForm extends InteractionForm {

        // The JFrame object.
        javax.swing.JFrame f;
        // The Property object chosen to be updated.
        Property chosenProperty;

        // Constructor which takes in a Property object.
        // Calls upon changeStatus which displays the GUI page.
        public UpdateForm(Property p) {
                myControllers.add(new UpdateController());
                chosenProperty = p;
                changeStatus();
        }

        /**
         * A helper function. A view form that allows one to change the status of a
         * property.
         */
        private void changeStatus() {
                // Creating the JFrame and setting properties.
                f = new JFrame();
                f.setVisible(true);
                f.setLocationRelativeTo(null);

                // Creating all the elements which will be displayed on the JFrame.
                javax.swing.JLabel addressLabel;
                javax.swing.JButton backButton;
                javax.swing.JLabel currentStatusLabel;
                javax.swing.JLabel dateExpiredLabel;
                javax.swing.JLabel dateLastRentedLabel;
                javax.swing.JLabel datePostedLabel;
                javax.swing.JLabel furnishedLabel;
                javax.swing.JLabel header1;
                javax.swing.JLabel header2;
                javax.swing.JPanel jPanel1;
                javax.swing.JLabel numBathroomsLabel;
                javax.swing.JLabel numBedroomsLabel;
                javax.swing.JLabel propertyAddressLabel;
                javax.swing.JLabel propertyCurrentStatusLabel;
                javax.swing.JLabel propertyDateExpiredLabel;
                javax.swing.JLabel propertyDateLastRentedLabel;
                javax.swing.JLabel propertyDatePostedLabel;
                javax.swing.JLabel propertyFurnishedLabel;
                javax.swing.JLabel propertyNumBathroomsLabel;
                javax.swing.JLabel propertyNumBedroomsLabel;
                javax.swing.JLabel propertyQuadrantLabel;
                javax.swing.JLabel propertyTypeLabel;
                javax.swing.JLabel quadrantLabel;
                javax.swing.JComboBox<String> statusList;
                javax.swing.JLabel statusListLabel;
                javax.swing.JLabel typeLabel;
                javax.swing.JButton updateButton;

                header1 = new javax.swing.JLabel();
                header2 = new javax.swing.JLabel();
                jPanel1 = new javax.swing.JPanel();
                addressLabel = new javax.swing.JLabel();
                quadrantLabel = new javax.swing.JLabel();
                typeLabel = new javax.swing.JLabel();
                furnishedLabel = new javax.swing.JLabel();
                numBathroomsLabel = new javax.swing.JLabel();
                numBedroomsLabel = new javax.swing.JLabel();
                datePostedLabel = new javax.swing.JLabel();
                dateExpiredLabel = new javax.swing.JLabel();
                dateLastRentedLabel = new javax.swing.JLabel();
                currentStatusLabel = new javax.swing.JLabel();
                propertyAddressLabel = new javax.swing.JLabel();
                propertyQuadrantLabel = new javax.swing.JLabel();
                propertyTypeLabel = new javax.swing.JLabel();
                propertyFurnishedLabel = new javax.swing.JLabel();
                propertyNumBathroomsLabel = new javax.swing.JLabel();
                propertyNumBedroomsLabel = new javax.swing.JLabel();
                propertyDatePostedLabel = new javax.swing.JLabel();
                propertyDateExpiredLabel = new javax.swing.JLabel();
                propertyDateLastRentedLabel = new javax.swing.JLabel();
                propertyCurrentStatusLabel = new javax.swing.JLabel();
                backButton = new javax.swing.JButton();
                updateButton = new javax.swing.JButton();
                statusListLabel = new javax.swing.JLabel();
                statusList = new javax.swing.JComboBox<>();

                f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

                // Setting the text of the elements.
                f.setBackground(new java.awt.Color(255, 255, 255));

                header1.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
                header1.setText("Choose a new status to update to.");

                header2.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
                header2.setText("Detailed Property Information");

                jPanel1.setBackground(new java.awt.Color(255, 255, 255));
                jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
                jPanel1.setForeground(new java.awt.Color(255, 255, 255));

                addressLabel.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
                addressLabel.setText("Address:");

                quadrantLabel.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
                quadrantLabel.setText("Quadrant:");

                typeLabel.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
                typeLabel.setText("Type:");

                furnishedLabel.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
                furnishedLabel.setText("Furnished:");

                numBathroomsLabel.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
                numBathroomsLabel.setText("Number of bathrooms:");

                numBedroomsLabel.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
                numBedroomsLabel.setText("Number of Bedrooms:");

                datePostedLabel.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
                datePostedLabel.setText("Date Posted:");

                dateExpiredLabel.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
                dateExpiredLabel.setText("Date of Expiry:");

                dateLastRentedLabel.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
                dateLastRentedLabel.setText("Date Last Rented:");

                currentStatusLabel.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
                currentStatusLabel.setText("Current Status:");

                propertyAddressLabel.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
                propertyAddressLabel.setText("jLabel14");

                propertyQuadrantLabel.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
                propertyQuadrantLabel.setText("jLabel15");

                propertyTypeLabel.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
                propertyTypeLabel.setText("jLabel16");

                propertyFurnishedLabel.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
                propertyFurnishedLabel.setText("jLabel17");

                propertyNumBathroomsLabel.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
                propertyNumBathroomsLabel.setText("jLabel18");

                propertyNumBedroomsLabel.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
                propertyNumBedroomsLabel.setText("jLabel19");

                propertyDatePostedLabel.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
                propertyDatePostedLabel.setText("jLabel20");

                propertyDateExpiredLabel.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
                propertyDateExpiredLabel.setText("jLabel21");

                propertyDateLastRentedLabel.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
                propertyDateLastRentedLabel.setText("jLabel22");

                propertyCurrentStatusLabel.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
                propertyCurrentStatusLabel.setText("jLabel23");

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(dateExpiredLabel)
                                                                                .addComponent(currentStatusLabel)
                                                                                .addComponent(dateLastRentedLabel)
                                                                                .addComponent(datePostedLabel)
                                                                                .addComponent(numBedroomsLabel)
                                                                                .addComponent(numBathroomsLabel)
                                                                                .addComponent(furnishedLabel)
                                                                                .addComponent(typeLabel)
                                                                                .addComponent(quadrantLabel)
                                                                                .addComponent(addressLabel))
                                                                .addGap(112, 112, 112)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(propertyAddressLabel)
                                                                                .addComponent(propertyQuadrantLabel)
                                                                                .addComponent(propertyTypeLabel)
                                                                                .addComponent(propertyFurnishedLabel)
                                                                                .addComponent(propertyNumBathroomsLabel)
                                                                                .addComponent(propertyNumBedroomsLabel)
                                                                                .addComponent(propertyDatePostedLabel)
                                                                                .addComponent(propertyDateLastRentedLabel)
                                                                                .addComponent(propertyCurrentStatusLabel)
                                                                                .addComponent(propertyDateExpiredLabel))
                                                                .addContainerGap(138, Short.MAX_VALUE)));
                jPanel1Layout.setVerticalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addContainerGap(34, Short.MAX_VALUE)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(addressLabel)
                                                                                .addComponent(propertyAddressLabel))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(quadrantLabel)
                                                                                .addComponent(propertyQuadrantLabel))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(typeLabel)
                                                                                .addComponent(propertyTypeLabel))
                                                                .addGap(31, 31, 31)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(furnishedLabel)
                                                                                .addComponent(propertyFurnishedLabel))
                                                                .addGap(32, 32, 32)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(numBathroomsLabel)
                                                                                .addComponent(propertyNumBathroomsLabel))
                                                                .addGap(35, 35, 35)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(numBedroomsLabel)
                                                                                .addComponent(propertyNumBedroomsLabel))
                                                                .addGap(34, 34, 34)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(datePostedLabel)
                                                                                .addComponent(propertyDatePostedLabel))
                                                                .addGap(30, 30, 30)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(dateExpiredLabel)
                                                                                .addComponent(propertyDateExpiredLabel))
                                                                .addGap(39, 39, 39)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(dateLastRentedLabel)
                                                                                .addComponent(propertyDateLastRentedLabel))
                                                                .addGap(49, 49, 49)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(currentStatusLabel)
                                                                                .addComponent(propertyCurrentStatusLabel))
                                                                .addGap(46, 46, 46)));

                backButton.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
                backButton.setText("Go Back");

                updateButton.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
                updateButton.setForeground(new java.awt.Color(87, 242, 135));
                updateButton.setText("UPDATE");

                statusListLabel.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
                statusListLabel.setText("Choose a new status");

                statusList.setModel(new javax.swing.DefaultComboBoxModel<>(
                                new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

                statusList.setModel(new javax.swing.DefaultComboBoxModel<>(
                                new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

                statusList.setModel(new javax.swing.DefaultComboBoxModel<>(
                                new String[] { "Active", "Cancelled", "Rented", "Suspended" }));
                String furn = "Y";
                if (!chosenProperty.isFurnished())
                        furn = "N";
                propertyAddressLabel.setText(chosenProperty.getAddress());
                propertyQuadrantLabel.setText(chosenProperty.getQuadrant());
                propertyFurnishedLabel.setText(furn);
                propertyCurrentStatusLabel.setText(chosenProperty.getStatus());
                propertyNumBathroomsLabel.setText(String.valueOf(chosenProperty.getNumBathrooms()));
                propertyNumBedroomsLabel.setText(String.valueOf(chosenProperty.getNumBedrooms()));
                propertyDateExpiredLabel.setText(chosenProperty.getExpDate());
                propertyDatePostedLabel.setText(chosenProperty.getPostedDate());
                propertyTypeLabel.setText(chosenProperty.getType());
                String dateLastRented = chosenProperty.getRentedDate();
                if (dateLastRented.equals("yyyy-MM-dd")) {
                        dateLastRented = "Not rented yet.";
                }
                propertyDateLastRentedLabel.setText(dateLastRented);

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(f.getContentPane());
                f.getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addContainerGap()
                                                                                                .addGroup(layout.createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                                                .addComponent(statusList,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(statusListLabel)
                                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                                                .addComponent(backButton,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                96,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                .addGap(241, 241,
                                                                                                                                                241)
                                                                                                                                .addComponent(updateButton,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                96,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                                .addComponent(jPanel1,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addGap(113, 113, 113)
                                                                                                .addComponent(header2))
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addGap(113, 113, 113)
                                                                                                .addComponent(header1)))
                                                                .addContainerGap(23, Short.MAX_VALUE)));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addGap(7, 7, 7)
                                                                .addComponent(header1)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(header2)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jPanel1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(statusListLabel)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(statusList,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(31, 31, 31)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(backButton,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                47,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(updateButton,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                47,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));

                f.pack();

                updateButton.setForeground(new java.awt.Color(0, 255, 0));
                updateButton.setText("CONFIRM UPDATE");
                // If the update button is clicked, and the current status is not cancelled
                // update the property.
                updateButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                boolean success = true;
                                String newStatus = statusList.getSelectedItem().toString();
                                System.out.println("Current status is: " + chosenProperty.getStatus());
                                if (chosenProperty.getStatus().equals("Cancelled"))
                                        success = false;
                                if (!success) {
                                        JOptionPane.showMessageDialog(f,
                                                        "You cannot update a property that has been cancelled.",
                                                        "INVALID SELECTION", JOptionPane.ERROR_MESSAGE);
                                } else {

                                        /*
                                         * If you are trying to update a state from anything other than Active-->Rented,
                                         * prompt an error message.
                                         */
                                        if (!chosenProperty.getStatus().equals("Active")
                                                        && newStatus.equals("Rented")) {
                                                JOptionPane.showMessageDialog(f,
                                                                "You cannot update the property to rented unless it is active.",
                                                                "INVALID SELECTION", JOptionPane.ERROR_MESSAGE);
                                        } else {
                                                chosenProperty.setStatus(newStatus);
                                                /* Send the new property to the controller for it to be updated. */
                                                ((UpdateController) (myControllers.get(0)))
                                                                .forwardPropertyStatus(chosenProperty);
                                                JOptionPane.showMessageDialog(null,
                                                                "Your property has successfully been updated!",
                                                                "Update successful",
                                                                1);
                                                f.dispose();
                                                new GUIHomePage(GUIHomePage.getEmail()).performStrategy();
                                        }
                                }
                        }
                });

                backButton.setText("Go Back");
                // If the back button is clicked, take them to the property selection page.
                backButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                f.dispose();
                                new PropertyForm().browseProperties();

                        }
                });
        }

}
