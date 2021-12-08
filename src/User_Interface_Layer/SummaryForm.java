/*
 * File Name: SummaryForm.java
 * Authors:
 *      Cheyenne Goh (UCID: 30040528)
 *      Divyansh Goyal (UCID: 30089488)
 *      Rui Guan(UCID: 30072848)
 *      Sajid Hafiz (UCID: 30061336)
 */
package User_Interface_Layer;

import Data_Source_Layer.*;
import Business_Layer.Property;

import java.util.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SummaryForm extends InteractionForm {
    public SummaryForm() {
        myInventory = new PropertyInventory();
        myPaymentPeriod = new PaymentPeriodRecord();
    }

    private Database myInventory;
    private Database myPaymentPeriod;

    public int getPeriod()
    {
        return ((PaymentPeriodRecord)myPaymentPeriod).retrievePeriod();
    }

    public void showSummary(int periodChosen) {
        JFrame frame = new JFrame();
        frame.setSize(563, 500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        JButton doneButton = new JButton();
        JLabel listLabel = new JLabel();
        JScrollPane listPane = new JScrollPane();
        JTable listTable = new JTable();
        JLabel summaryTitleLabel = new JLabel();
        JTextArea totalActiveListingsDisplay = new JTextArea();
        JLabel totalActiveListingsLabel = new JLabel();
        JScrollPane totalActiveListingsPane = new JScrollPane();
        JTextArea totalPeriodListingsDisplay = new JTextArea();
        JLabel totalPeriodListingsLabel = new JLabel();
        JScrollPane totalPeriodListingsPane = new JScrollPane();
        JTextArea totalRentedListingsDisplay = new JTextArea();
        JLabel totalRentedListingsLabel = new JLabel();
        JScrollPane totalRentedListingsPane = new JScrollPane();

        int totalRentedListings = ((PropertyInventory)myInventory).getNumRentedListingsPeriod(periodChosen);
        int totalPeriodListings = ((PropertyInventory)myInventory).getNumListingsPeriod(periodChosen);
        int totalActiveListings = ((PropertyInventory)myInventory).getNumActiveListingsPeriod(periodChosen);
        ArrayList<Property> rentedProperties = ((PropertyInventory)myInventory).retrieveSummary(periodChosen);
        int numPropertiesRented = rentedProperties.size();

        totalRentedListingsDisplay.setColumns(20);
        totalRentedListingsDisplay.setRows(5);
        totalRentedListingsDisplay.setEditable(false);
        totalRentedListingsDisplay.setText(String.valueOf(totalRentedListings));

        totalRentedListingsPane.setViewportView(totalRentedListingsDisplay);

        totalPeriodListingsDisplay.setColumns(20);
        totalPeriodListingsDisplay.setRows(5);
        totalPeriodListingsDisplay.setEditable(false);
        totalPeriodListingsDisplay.setText(String.valueOf(totalPeriodListings));
        totalPeriodListingsPane.setViewportView(totalPeriodListingsDisplay);

        doneButton.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        doneButton.setText("Done");
        doneButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        summaryTitleLabel.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        summaryTitleLabel.setText("Summary:");

        totalPeriodListingsLabel.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        totalPeriodListingsLabel.setText("Total number of listings in " + String.valueOf(periodChosen) + " days:" );

        totalRentedListingsLabel.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        totalRentedListingsLabel.setText("Total number of rented properties in " + String.valueOf(periodChosen) + " days:");

        totalActiveListingsDisplay.setColumns(20);
        totalActiveListingsDisplay.setRows(5);
        totalActiveListingsDisplay.setEditable(false);
        totalActiveListingsDisplay.setText(String.valueOf(totalActiveListings));
        totalActiveListingsPane.setViewportView(totalActiveListingsDisplay);

        totalActiveListingsLabel.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        totalActiveListingsLabel.setText("Total number of \"active\" listings:");

        listLabel.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        listLabel.setText("List of properties \"rented\" in " + String.valueOf(periodChosen) + " days:");

        Object [][] vals;
        vals = new Object[numPropertiesRented][3];

        for (int i = 0; i < numPropertiesRented; i++)
        {
            Property propertyGet = rentedProperties.get(i);
            vals[]
        }

        listTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "LandLord Name", "Property ID", "Address"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        listPane.setViewportView(listTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(layout);
        frame.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(summaryTitleLabel)
                        .addGap(246, 246, 246))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(doneButton)
                        .addGap(233, 233, 233))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(listPane, javax.swing.GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE)
                    .addComponent(totalRentedListingsPane, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(totalPeriodListingsPane)
                    .addComponent(totalActiveListingsPane, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(totalPeriodListingsLabel)
                            .addComponent(totalRentedListingsLabel)
                            .addComponent(totalActiveListingsLabel)
                            .addComponent(listLabel))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(summaryTitleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalPeriodListingsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalPeriodListingsPane, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(totalRentedListingsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalRentedListingsPane, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(totalActiveListingsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalActiveListingsPane, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(listLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(listPane, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(doneButton)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        
    }
}