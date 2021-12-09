package User_Interface_Layer;

import Business_Layer.Property;

import java.util.*;
import javax.swing.*;
import java.awt.event.*;

public class ViewPropertyForm {
    public ViewPropertyForm(ArrayList<Property> myProperties) {
        matchedProperties = myProperties;
        displayProperties();
    }

    ArrayList<Property> matchedProperties;

    private void displayProperties() {
        if (matchedProperties.size() == 0) {
            JOptionPane.showMessageDialog(null, "No properties matching your search!");
            GUIHomePage x = new GUIHomePage(GUIHomePage.getEmail());
            x.performStrategy();
            return;
        }

        JFrame frame = new JFrame("SEARCH RESULTS");
        frame.setSize(400, 280);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);

        JLabel titleLabel = new JLabel();
        JComboBox<String> addressComboBox = new JComboBox<String>();
        JButton detailsButton = new JButton();
        JButton goBackButton = new JButton();

        titleLabel.setFont(new java.awt.Font("Times New Roman", 1, 14));
        titleLabel.setText("Search Results");

        addressComboBox.setFont(new java.awt.Font("Times New Roman", 0, 12));
        addressComboBox.setMaximumRowCount(100);

        int numSize = matchedProperties.size();

        String[] addresses = new String[numSize];
        for (int i = 0; i < matchedProperties.size(); i++) {
            addresses[i] = matchedProperties.get(i).getAddress();
        }

        addressComboBox.setModel(
                new javax.swing.DefaultComboBoxModel<>(addresses));
        addressComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            }
        });

        detailsButton.setFont(new java.awt.Font("Times New Roman", 1, 12));
        detailsButton.setText("View Details");

        goBackButton.setFont(new java.awt.Font("Times New Roman", 1, 12));
        goBackButton.setText("Go Back");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(titleLabel)
                                .addGap(151, 151, 151))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(goBackButton))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(37, 37, 37)
                                                .addComponent(addressComboBox, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73,
                                                        Short.MAX_VALUE)
                                                .addComponent(detailsButton)))
                                .addGap(35, 35, 35)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(titleLabel)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(detailsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(addressComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 31,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 153,
                                        Short.MAX_VALUE)
                                .addComponent(goBackButton)
                                .addContainerGap()));

        frame.pack();

        detailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                String addressChosen = addressComboBox.getSelectedItem().toString();
                for (int i = 0; i < numSize; i++) {
                    if (addressChosen.equals(matchedProperties.get(i).getAddress())) {
                        displayProperty(matchedProperties.get(i));
                        break;
                    }
                }
            }
        });

        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                GUIHomePage x = new GUIHomePage(GUIHomePage.getEmail());
                x.performStrategy();
            }
        });
    }

    public void displayProperty(Property chosenProperty) {
        JFrame frame = new JFrame("PROPERTY DISPLAY");
        frame.setSize(400, 580);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);

        JLabel titleLabel = new javax.swing.JLabel();
        JLabel addressLabel = new javax.swing.JLabel();
        JLabel typeLabel = new javax.swing.JLabel();
        JLabel numBedroomsLabel = new javax.swing.JLabel();
        JLabel numBathroomsLabel = new javax.swing.JLabel();
        JLabel furnishedLabel = new javax.swing.JLabel();
        JLabel quadrantLabel = new javax.swing.JLabel();
        JLabel dateLabel = new javax.swing.JLabel();
        JTextField addressDisplay = new javax.swing.JTextField();
        JTextField numBathroomsDisplay = new javax.swing.JTextField();
        JTextField typeDisplay = new javax.swing.JTextField();
        JTextField quadrantDisplay = new javax.swing.JTextField();
        JTextField numBedroomsDisplay = new javax.swing.JTextField();
        JTextField dateDisplay = new javax.swing.JTextField();
        JTextField furnishedDisplay = new javax.swing.JTextField();
        JButton doneButton = new javax.swing.JButton();
        JButton sendEmailButton = new javax.swing.JButton();
        JTextField emailInput = new javax.swing.JTextField();
        JLabel emailLabel = new javax.swing.JLabel();
        JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        JTextArea messageInput = new javax.swing.JTextArea();
        JLabel messageLabel = new javax.swing.JLabel();
        JSeparator seperator = new javax.swing.JSeparator();

        titleLabel.setFont(new java.awt.Font("Times New Roman", 1, 14));
        titleLabel.setText("Property Information");

        addressLabel.setFont(new java.awt.Font("Times New Roman", 1, 12));
        addressLabel.setText("Address:");

        typeLabel.setFont(new java.awt.Font("Times New Roman", 1, 12));
        typeLabel.setText("Type of Property:");

        numBedroomsLabel.setFont(new java.awt.Font("Times New Roman", 1, 12));
        numBedroomsLabel.setText("Number of Bedrooms:");

        numBathroomsLabel.setFont(new java.awt.Font("Times New Roman", 1, 12));
        numBathroomsLabel.setText("Number of Bathrooms:");

        furnishedLabel.setFont(new java.awt.Font("Times New Roman", 1, 12));
        furnishedLabel.setText("Furnished:");

        quadrantLabel.setFont(new java.awt.Font("Times New Roman", 1, 12));
        quadrantLabel.setText("City Quadrant:");

        dateLabel.setFont(new java.awt.Font("Times New Roman", 1, 12));
        dateLabel.setText("Posted Date:");

        addressDisplay.setFont(new java.awt.Font("Times New Roman", 0, 12));
        addressDisplay.setEditable(false);
        addressDisplay.setText(chosenProperty.getAddress());

        numBathroomsDisplay.setFont(new java.awt.Font("Times New Roman", 0, 12));
        numBathroomsDisplay.setEditable(false);
        numBathroomsDisplay.setText(String.valueOf(chosenProperty.getNumBathrooms()));

        typeDisplay.setFont(new java.awt.Font("Times New Roman", 0, 12));
        typeDisplay.setEditable(false);
        typeDisplay.setText(chosenProperty.getType());

        quadrantDisplay.setFont(new java.awt.Font("Times New Roman", 0, 12));
        quadrantDisplay.setEditable(false);
        quadrantDisplay.setText(chosenProperty.getQuadrant());

        numBedroomsDisplay.setFont(new java.awt.Font("Times New Roman", 0, 12));
        numBedroomsDisplay.setEditable(false);
        numBedroomsDisplay.setText(String.valueOf(chosenProperty.getNumBedrooms()));

        dateDisplay.setFont(new java.awt.Font("Times New Roman", 0, 12));
        dateDisplay.setEditable(false);
        dateDisplay.setText(chosenProperty.getPostedDate());

        furnishedDisplay.setFont(new java.awt.Font("Times New Roman", 0, 12));
        furnishedDisplay.setEditable(false);
        String furnishedString;
        if (chosenProperty.isFurnished() == true)
            furnishedString = "Yes";
        else
            furnishedString = "No";
        furnishedDisplay.setText(furnishedString);

        doneButton.setBackground(new java.awt.Color(0, 204, 0));
        doneButton.setFont(new java.awt.Font("Times New Roman", 1, 12));
        doneButton.setText("Done");

        sendEmailButton.setFont(new java.awt.Font("Times New Roman", 1, 12));
        sendEmailButton.setText("Send Email");

        emailInput.setFont(new java.awt.Font("Times New Roman", 0, 12));

        emailLabel.setFont(new java.awt.Font("Times New Roman", 1, 12));
        emailLabel.setText("Enter your email address:");

        messageInput.setColumns(20);
        messageInput.setRows(5);
        jScrollPane1.setViewportView(messageInput);

        messageLabel.setFont(new java.awt.Font("Times New Roman", 1, 12));
        messageLabel.setText("Please type a message below:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(titleLabel)
                                .addGap(126, 126, 126))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(messageLabel)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                .createSequentialGroup()
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jScrollPane1)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout
                                                                .createSequentialGroup()
                                                                .addComponent(addressLabel)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        Short.MAX_VALUE)
                                                                .addComponent(addressDisplay,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 174,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout
                                                                .createSequentialGroup()
                                                                .addComponent(typeLabel)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        Short.MAX_VALUE)
                                                                .addComponent(typeDisplay,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 174,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout
                                                                .createSequentialGroup()
                                                                .addComponent(numBedroomsLabel)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        Short.MAX_VALUE)
                                                                .addComponent(numBedroomsDisplay,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 174,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout
                                                                .createSequentialGroup()
                                                                .addComponent(furnishedLabel)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        Short.MAX_VALUE)
                                                                .addComponent(furnishedDisplay,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 174,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout
                                                                .createSequentialGroup()
                                                                .addComponent(quadrantLabel)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        Short.MAX_VALUE)
                                                                .addComponent(quadrantDisplay,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 174,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(dateLabel)
                                                                        .addComponent(emailLabel))
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                        16, Short.MAX_VALUE)
                                                                .addGroup(layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING,
                                                                        false)
                                                                        .addComponent(emailInput)
                                                                        .addComponent(dateDisplay,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                174,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout
                                                                .createSequentialGroup()
                                                                .addComponent(numBathroomsLabel)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        Short.MAX_VALUE)
                                                                .addComponent(numBathroomsDisplay,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 174,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                .addGroup(layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(sendEmailButton)
                                                                        .addComponent(doneButton))))
                                                .addGap(23, 23, 23))))
                        .addComponent(seperator, javax.swing.GroupLayout.Alignment.TRAILING));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(titleLabel)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(addressLabel)
                                        .addComponent(addressDisplay, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(typeLabel)
                                        .addComponent(typeDisplay, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(numBedroomsLabel)
                                        .addComponent(numBedroomsDisplay, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(numBathroomsLabel)
                                        .addComponent(numBathroomsDisplay, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(furnishedLabel)
                                        .addComponent(furnishedDisplay, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(quadrantLabel)
                                        .addComponent(quadrantDisplay, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(dateLabel)
                                        .addComponent(dateDisplay, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(doneButton)
                                .addGap(6, 6, 6)
                                .addComponent(seperator, javax.swing.GroupLayout.PREFERRED_SIZE, 10,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(emailInput, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(emailLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(messageLabel)
                                .addGap(3, 3, 3)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(sendEmailButton)
                                .addGap(7, 7, 7)));

        frame.pack();

        // If the send button is clicked, display a message box saying email sent and
        // dispose this frame.
        sendEmailButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent end_event) {
                if (emailInput.getText().length() == 0 || messageInput.getText().length() == 0) {
                    JOptionPane.showMessageDialog(null,
                            "Invalid input(s) to the email section values!",
                            "Email error",
                            JOptionPane.ERROR_MESSAGE);
                }
                String[] option = { "Great!" };
                JOptionPane.showOptionDialog(null, "Email has been sent to landlord", "Confirmation page",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, option, option[0]);
            }
        });

        // If the done button is clicked, dispose of this frame.
        doneButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent end_event) {
                frame.dispose();
                displayProperties();
            }
        });
    }
}
