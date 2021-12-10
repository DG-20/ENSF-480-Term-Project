package User_Interface_Layer;

import Business_Layer.Property;
import Data_Source_Layer.Database;
import Data_Source_Layer.PropertyInventory;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * This class is a detailed view of all properties.
 */
public class DetailedViewProperty extends InteractionForm {
    ArrayList<Property> allProperties;
    Database myData;

    /**
     * Constructor, initializes allProperties and calls display.
     */
    public DetailedViewProperty() {
        myData = new PropertyInventory();
        allProperties = ((PropertyInventory) myData).getAllProperties();
    }

    public void display() {
         javax.swing.JFrame f = new javax.swing.JFrame();
         f.setVisible(true);
         javax.swing.JLabel header;
         javax.swing.JScrollPane jScrollPane1;
         javax.swing.JTable propertyTable;
         javax.swing.JButton backButton;

        header = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        propertyTable = new javax.swing.JTable();
        backButton = new javax.swing.JButton();

        f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        header.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        header.setText("Detailed Property Information Viewer");

        propertyTable.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        jScrollPane1.setViewportView(propertyTable);
        if (propertyTable.getColumnModel().getColumnCount() > 0) {
            propertyTable.getColumnModel().getColumn(0).setResizable(false);
            propertyTable.getColumnModel().getColumn(1).setResizable(false);
            propertyTable.getColumnModel().getColumn(2).setResizable(false);
            propertyTable.getColumnModel().getColumn(3).setResizable(false);
            propertyTable.getColumnModel().getColumn(5).setResizable(false);
            propertyTable.getColumnModel().getColumn(6).setResizable(false);
            propertyTable.getColumnModel().getColumn(7).setResizable(false);
            propertyTable.getColumnModel().getColumn(8).setResizable(false);
            propertyTable.getColumnModel().getColumn(9).setResizable(false);
            propertyTable.getColumnModel().getColumn(10).setResizable(false);
            propertyTable.getColumnModel().getColumn(11).setResizable(false);
        }

        // Populating the JTable data with property details
        String[][] propertyTableStrings = new String[allProperties.size()][12];
        int idx = 0;
        for (int i = 0; i < allProperties.size(); i++) {
            propertyTableStrings[idx][0] = String.valueOf(allProperties.get(i).getID());
            propertyTableStrings[idx][1] = allProperties.get(i).getEmail();
            propertyTableStrings[idx][2] = allProperties.get(i).getStatus();
            propertyTableStrings[idx][3] = allProperties.get(i).getQuadrant();
            propertyTableStrings[idx][4] = allProperties.get(i).getAddress();
            String furn = "N";
            if (allProperties.get(i).isFurnished()) furn = "Y";
            propertyTableStrings[idx][5] = furn;
            propertyTableStrings[idx][6] = String.valueOf(allProperties.get(i).getNumBathrooms());
            propertyTableStrings[idx][7] = String.valueOf(allProperties.get(i).getNumBedrooms());
            propertyTableStrings[idx][8] = allProperties.get(i).getType();
            propertyTableStrings[idx][9] = allProperties.get(i).getPostedDate();
            propertyTableStrings[idx][10] = allProperties.get(i).getExpDate();
            String dateRented = allProperties.get(i).getRentedDate();
            if (dateRented.equals("yyyy-MM-dd")) dateRented = "Never Rented";
            propertyTableStrings[idx][11] = dateRented;
            idx++;
        }

        propertyTable.setModel(new javax.swing.table.DefaultTableModel(
                propertyTableStrings,
                new String [] {
                        "House ID", "Email", "Status", "Quadrant", "Address", "Furnished", "numBathrooms", "numBedrooms", "Type", "Posted Date", "Expiry Date", "Last Rented Date"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false, false, false, false, false, true, false, false, false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });

        final TableColumnModel columnModel = propertyTable.getColumnModel();
        for (int column = 0; column < propertyTable.getColumnCount(); column++) {
            int width = 10; // Min width
            for (int row = 0; row < propertyTable.getRowCount(); row++) {
                TableCellRenderer renderer = propertyTable.getCellRenderer(row, column);
                Component comp = propertyTable.prepareRenderer(renderer, row, column);
                width = Math.max(comp.getPreferredSize().width +1 , width);
            }
            if(width > 300)
                width=300;
            columnModel.getColumn(column).setPreferredWidth(width);
        }

        backButton.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        backButton.setText("Go Back");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(f.getContentPane());
        f.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1)
                                .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                                .addGap(778, 778, 778)
                                .addComponent(header)
                                .addGap(0, 797, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(backButton)
                                .addGap(847, 847, 847))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(header)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 662, Short.MAX_VALUE)
                                .addGap(21, 21, 21)
                                .addComponent(backButton)
                                .addContainerGap())
        );

        f.pack();

        /* On Back button Press, call the Home page */
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                pageBack.performStrategy();
            }
        });
    }

    }


