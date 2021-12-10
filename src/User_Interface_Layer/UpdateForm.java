
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
         *  A helper function. A view form that allows one to change the status of a property.
         */
        private void changeStatus() {
                // Creating the JFrame and setting properties.
                f = new JFrame();
                f.setVisible(true);
                f.setLocationRelativeTo(null);

                // Creating all the elements which will be displayed on the JFrame.
                JLabel addressLabel;
                JButton backButton;
                JLabel dateExpiryLabel;
                JLabel datePostedLabel;
                JLabel furnishedLabel;
                JLabel header1;
                JLabel header2;
                JLabel header3;
                JSeparator jSeparator1;
                JLabel numBathroomsLabel;
                JLabel numBedroomsLabel;
                JLabel propertyAddressLabel;
                JLabel propertyDateExpiryLabel;
                JLabel propertyDatePostedLabel;
                JLabel propertyFurnishedLabel;
                JLabel propertyNumBathroomsLabel;
                JLabel propertyNumBedroomsLabel;
                JLabel propertyQuadrantLabel;
                JLabel propertyStatusLabel;
                JLabel propertyTypeLabel;
                JLabel quadrantLabel;
                JLabel statusLabel;
                JComboBox<String> statusList;
                JLabel typeLabel;
                JButton updateButton;

                header1 = new javax.swing.JLabel();
                header2 = new javax.swing.JLabel();
                jSeparator1 = new javax.swing.JSeparator();
                addressLabel = new javax.swing.JLabel();
                propertyAddressLabel = new javax.swing.JLabel();
                quadrantLabel = new javax.swing.JLabel();
                propertyQuadrantLabel = new javax.swing.JLabel();
                typeLabel = new javax.swing.JLabel();
                propertyTypeLabel = new javax.swing.JLabel();
                furnishedLabel = new javax.swing.JLabel();
                propertyFurnishedLabel = new javax.swing.JLabel();
                numBathroomsLabel = new javax.swing.JLabel();
                propertyNumBathroomsLabel = new javax.swing.JLabel();
                numBedroomsLabel = new javax.swing.JLabel();
                propertyNumBedroomsLabel = new javax.swing.JLabel();
                datePostedLabel = new javax.swing.JLabel();
                propertyDatePostedLabel = new javax.swing.JLabel();
                dateExpiryLabel = new javax.swing.JLabel();
                propertyDateExpiryLabel = new javax.swing.JLabel();
                statusLabel = new javax.swing.JLabel();
                propertyStatusLabel = new javax.swing.JLabel();
                updateButton = new javax.swing.JButton();
                backButton = new javax.swing.JButton();
                header3 = new javax.swing.JLabel();
                statusList = new javax.swing.JComboBox<>();

                f.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

                // Setting the text of the elements.
                header1.setText("Choose a new status to update to.");

                header2.setText("Detailed Property Information:");

                addressLabel.setText("Address: ");

                propertyAddressLabel.setText("jLabel4");

                quadrantLabel.setText("Quadrant:");

                propertyQuadrantLabel.setText("jLabel6");

                typeLabel.setText("Type:");

                propertyTypeLabel.setText("jLabel8");

                furnishedLabel.setText("Furnished:");

                propertyFurnishedLabel.setText("jLabel10");

                numBathroomsLabel.setText("Number of bathrooms:");

                propertyNumBathroomsLabel.setText("jLabel12");

                numBedroomsLabel.setText("Number of bedrooms:");

                propertyNumBedroomsLabel.setText("jLabel14");

                datePostedLabel.setText("Date Posted:");

                propertyDatePostedLabel.setText("jLabel16");

                dateExpiryLabel.setText("Date of Expiry:");

                propertyDateExpiryLabel.setText("jLabel18");

                statusLabel.setText("Current Status:");

                propertyStatusLabel.setText("jLabel20");

                updateButton.setForeground(new java.awt.Color(0, 255, 0));
                updateButton.setText("CONFIRM UPDATE");
                // If the update button is clicked, getting the selected item (new Status) and
                // calling updateButtonActionPerformed.
                updateButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                boolean success = true;
                                String newStatus = statusList.getSelectedItem().toString();
                                if (chosenProperty.getStatus().equals("Cancelled"))
                                        success = false;
                                updateButtonActionPerformed(evt, success, newStatus);
                        }
                });

                backButton.setText("Go Back");
                // If the back button is clicked, backButtonActionPerformed is called.
                backButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                backButtonActionPerformed(evt);
                        }
                });

                header3.setText("Choose a new status:");

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
                propertyStatusLabel.setText(chosenProperty.getStatus());
                propertyNumBathroomsLabel.setText(String.valueOf(chosenProperty.getNumBathrooms()));
                propertyNumBedroomsLabel.setText(String.valueOf(chosenProperty.getNumBedrooms()));
                propertyDateExpiryLabel.setText(chosenProperty.getExpDate());
                propertyDatePostedLabel.setText(chosenProperty.getPostedDate());
                propertyTypeLabel.setText(chosenProperty.getType());

                // Creating a new layout (both horizontal and vertical) to place all the
                // elements exactly and place the sizes accordingly.
                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(f.getContentPane());
                f.getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addGroup(layout.createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                                                .addGap(111, 111,
                                                                                                                                                111)
                                                                                                                                .addComponent(header1))
                                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                                                .addContainerGap()
                                                                                                                                .addComponent(header2))
                                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                                                .addContainerGap()
                                                                                                                                .addGroup(layout.createParallelGroup(
                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                                .addComponent(addressLabel)
                                                                                                                                                .addComponent(quadrantLabel)
                                                                                                                                                .addComponent(typeLabel)
                                                                                                                                                .addComponent(furnishedLabel)
                                                                                                                                                .addComponent(numBathroomsLabel)
                                                                                                                                                .addComponent(numBedroomsLabel)
                                                                                                                                                .addComponent(datePostedLabel)
                                                                                                                                                .addComponent(dateExpiryLabel)
                                                                                                                                                .addComponent(statusLabel))
                                                                                                                                .addGap(147, 147,
                                                                                                                                                147)
                                                                                                                                .addGroup(layout.createParallelGroup(
                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                                .addComponent(propertyStatusLabel)
                                                                                                                                                .addComponent(propertyDateExpiryLabel)
                                                                                                                                                .addComponent(propertyDatePostedLabel)
                                                                                                                                                .addComponent(propertyNumBedroomsLabel)
                                                                                                                                                .addComponent(propertyNumBathroomsLabel)
                                                                                                                                                .addComponent(propertyFurnishedLabel)
                                                                                                                                                .addComponent(propertyTypeLabel)
                                                                                                                                                .addComponent(propertyQuadrantLabel)
                                                                                                                                                .addComponent(propertyAddressLabel))))
                                                                                                .addGap(0, 85, Short.MAX_VALUE))
                                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                layout.createSequentialGroup()
                                                                                                                .addContainerGap()
                                                                                                                .addComponent(backButton)
                                                                                                                .addPreferredGap(
                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                Short.MAX_VALUE)
                                                                                                                .addGroup(layout.createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                .addComponent(header3)
                                                                                                                                .addComponent(updateButton)
                                                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                                                                .addGap(20, 20, 20)
                                                                                                                                                .addComponent(statusList,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                                                .addContainerGap()));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(header1)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jSeparator1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                11,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(header2)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(addressLabel)
                                                                                .addComponent(propertyAddressLabel))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(quadrantLabel)
                                                                                .addComponent(propertyQuadrantLabel))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(typeLabel)
                                                                                .addComponent(propertyTypeLabel))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(furnishedLabel)
                                                                                .addComponent(propertyFurnishedLabel))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(numBathroomsLabel)
                                                                                .addComponent(propertyNumBathroomsLabel))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(numBedroomsLabel)
                                                                                .addComponent(propertyNumBedroomsLabel))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(datePostedLabel)
                                                                                .addComponent(propertyDatePostedLabel))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(dateExpiryLabel)
                                                                                .addComponent(propertyDateExpiryLabel))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(statusLabel)
                                                                                .addComponent(propertyStatusLabel))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                24, Short.MAX_VALUE)
                                                                .addComponent(header3)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(statusList,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(45, 45, 45)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(updateButton)
                                                                                .addComponent(backButton))
                                                                .addContainerGap()));

                // Packs all elements according to their set sizes and locations.
                f.pack();
        }

        // If user clicks update, send the new updated property to controller and take
        // user back to the home page.
        private void updateButtonActionPerformed(java.awt.event.ActionEvent evt, boolean success, String newStatus) {
                if (!success) {
                        JOptionPane.showMessageDialog(f, "You cannot update a property that has been cancelled.",
                                        "INVALID SELECTION", JOptionPane.ERROR_MESSAGE);
                } else {
                        chosenProperty.setStatus(newStatus);
                        /* Send the new property to the controller for it to be updated. */
                        ((UpdateController) (myControllers.get(0))).forwardPropertyStatus(chosenProperty);
                        JOptionPane.showMessageDialog(null, "Your property has successfully been updated!",
                                        "Update successful",
                                        1);
                        f.dispose();
                        new GUIHomePage(GUIHomePage.getEmail()).performStrategy();
                }
        }

        // If the user presses back button, take them to the property selection page.
        private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {
                f.dispose();
                new PropertyForm().browseProperties();
        }
}
