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
import javax.xml.crypto.Data;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * SummaryForm displays the summary for a specified time period to a Manager.
 * This class extends InteractionForm interface.
 * It contains three Database objects, since it requires information from all three.
 */
public class SummaryForm extends InteractionForm {
        // The default constructor initializes the three Database member objects.
        public SummaryForm() {
                myData = new ArrayList<>();
                Database myInventory = new PropertyInventory();
                Database myPaymentPeriod = new PaymentPeriodRecord();
                Database myUserInfo = new UserInfo();
                myData.add(myInventory);
                myData.add(myPaymentPeriod);
                myData.add(myUserInfo);
        }

        private ArrayList<Database> myData;

        // Getter for the period, calls upon retrievePeriod from myPaymentPeriod.
        public int getPeriod() {
                return ((PaymentPeriodRecord) myData.get(1)).retrievePeriod();
        }

        // Displays the Summary in a clean GUI page.
        public void showSummary(int periodChosen) {
                // Creating a new JFrame and setting its properties.
                JFrame frame = new JFrame();
                frame.setSize(563, 500);
                frame.setVisible(true);
                frame.setLocationRelativeTo(null);
                frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

                // Creating elements to be displayed on the JFrame.
                JButton doneButton = new JButton();
                JLabel listLabel = new JLabel();
                JScrollPane listPane = new JScrollPane();
                JTable listTable = new JTable();
                JLabel summaryTitleLabel = new JLabel();
                JTextArea totalActiveListingsDisplay = new JTextArea();
                JLabel totalActiveListingsLabel = new JLabel();
                JScrollPane totalActiveListingsPane = new JScrollPane(totalActiveListingsDisplay,
                                JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                JTextArea totalPeriodListingsDisplay = new JTextArea();
                JLabel totalPeriodListingsLabel = new JLabel();
                JScrollPane totalPeriodListingsPane = new JScrollPane(totalPeriodListingsDisplay,
                                JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                JTextArea totalRentedListingsDisplay = new JTextArea();
                JLabel totalRentedListingsLabel = new JLabel();
                JScrollPane totalRentedListingsPane = new JScrollPane(totalRentedListingsDisplay,
                                JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

                // Retrieving the total statistics from myInventory using various functions.
                int totalRentedListings = ((PropertyInventory) myData.get(0)).getNumRentedListingsPeriod(periodChosen);
                int totalPeriodListings = ((PropertyInventory) myData.get(0)).getNumListingsPeriod(periodChosen);
                int totalActiveListings = ((PropertyInventory) myData.get(0)).getNumActiveListings();
                // Getting an ArrayList of Properties using retrieveSummary.
                ArrayList<Property> rentedProperties = ((PropertyInventory) myData.get(0))
                                .retrieveSummary(periodChosen);
                int numPropertiesRented = rentedProperties.size();

                // Setting the characteristics of the elements.
                totalRentedListingsDisplay.setColumns(20);
                totalRentedListingsDisplay.setRows(5);
                totalRentedListingsDisplay.setEditable(false);
                totalRentedListingsDisplay.setText(String.valueOf(totalRentedListings));

                totalPeriodListingsDisplay.setColumns(20);
                totalPeriodListingsDisplay.setRows(5);
                totalPeriodListingsDisplay.setEditable(false);
                totalPeriodListingsDisplay.setText(String.valueOf(totalPeriodListings));

                doneButton.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
                doneButton.setText("Done");
                doneButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

                summaryTitleLabel.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
                summaryTitleLabel.setText("Summary:");

                totalPeriodListingsLabel.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
                totalPeriodListingsLabel
                                .setText("Total number of listings in the last " + String.valueOf(periodChosen)
                                                + " days:");

                totalRentedListingsLabel.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
                totalRentedListingsLabel
                                .setText("Total number of rented properties in the last " + String.valueOf(periodChosen)
                                                + " days:");

                totalActiveListingsDisplay.setColumns(20);
                totalActiveListingsDisplay.setRows(5);
                totalActiveListingsDisplay.setEditable(false);
                totalActiveListingsDisplay.setText(String.valueOf(totalActiveListings));

                totalActiveListingsLabel.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
                totalActiveListingsLabel.setText("Total number of \"active\" listings:");

                listLabel.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
                listLabel.setText(
                                "List of properties \"rented\" in the last " + String.valueOf(periodChosen) + " days:");

                // Creating and populating an Object 2D array for the table using the obtained
                // ArrayList of Properties from the database.
                Object[][] vals;
                vals = new Object[numPropertiesRented][3];

                for (int i = 0; i < numPropertiesRented; i++) {
                        Property propertyGet = rentedProperties.get(i);
                        vals[i][0] = ((UserInfo) myData.get(2)).retrieveLandlordsName(propertyGet.getEmail());
                        vals[i][1] = propertyGet.getID();
                        vals[i][2] = propertyGet.getAddress();
                }

                listTable.setModel(new javax.swing.table.DefaultTableModel(
                                vals,
                                new String[] {
                                                "LandLord Name", "Property ID", "Address"
                                }) {
                        Class[] types = new Class[] {
                                        java.lang.String.class, java.lang.String.class, java.lang.String.class
                        };
                        boolean[] canEdit = new boolean[] {
                                        false, false, false
                        };

                        public Class getColumnClass(int columnIndex) {
                                return types[columnIndex];
                        }

                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                                return canEdit[columnIndex];
                        }
                });
                listPane.setViewportView(listTable);

                // Creating a new Layout (both horizontal and vertical) to specify positioning
                // of the elements along with sizes.
                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame.getContentPane());
                frame.getContentPane().setLayout(layout);
                frame.setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                                .createSequentialGroup()
                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                layout.createSequentialGroup()
                                                                                                                .addComponent(summaryTitleLabel)
                                                                                                                .addGap(246, 246,
                                                                                                                                246))
                                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                layout.createSequentialGroup()
                                                                                                                .addComponent(doneButton)
                                                                                                                .addGap(233, 233,
                                                                                                                                233))))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                                .createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(listPane,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                537,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(totalRentedListingsPane,
                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(totalPeriodListingsPane)
                                                                                .addComponent(totalActiveListingsPane,
                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                layout
                                                                                                                .createSequentialGroup()
                                                                                                                .addGroup(layout
                                                                                                                                .createParallelGroup(
                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                .addComponent(totalPeriodListingsLabel)
                                                                                                                                .addComponent(totalRentedListingsLabel)
                                                                                                                                .addComponent(totalActiveListingsLabel)
                                                                                                                                .addComponent(listLabel))
                                                                                                                .addGap(0, 0, Short.MAX_VALUE)))
                                                                .addContainerGap()));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(summaryTitleLabel)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(totalPeriodListingsLabel)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(totalPeriodListingsPane,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                50,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(totalRentedListingsLabel)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(totalRentedListingsPane,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                50,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(totalActiveListingsLabel)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(totalActiveListingsPane,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                49,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(listLabel)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(listPane,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                87,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(doneButton)
                                                                .addContainerGap(16, Short.MAX_VALUE)));

                // If the user clicks the done button, dispose of this frame, and display the
                // Manager's Homepage again using performStrategy.
                doneButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                frame.dispose();
                                new GUIHomePage(GUIHomePage.getEmail()).performStrategy();
                        }
                });
        }
}