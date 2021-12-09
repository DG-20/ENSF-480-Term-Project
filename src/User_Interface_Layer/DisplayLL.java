/*
 * File Name: DisplayLL.java
 * Authors:
 *      Cheyenne Goh (UCID: 30040528)
 *      Divyansh Goyal (UCID: 30089488)
 *      Rui Guan(UCID: 30072848)
 *      Sajid Hafiz (UCID: 30061336)
 */
package User_Interface_Layer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * A class which displays the homepage of the LandLord. 
 * This class then calls upon myPropertyForm based on the choice the user makes.
 * This class extends the JFrame class and implements the Strategy interface.
 */
public class DisplayLL extends javax.swing.JFrame implements Strategy {

    // Default constructor which intializes the PropertyForm member variable.
    public DisplayLL() {
        myPropertyForm = new PropertyForm();
    }

    private InteractionForm myPropertyForm;

    // Getter and Setter.
    public InteractionForm getMyPropertyForm() {
        return myPropertyForm;
    }

    public void setMyPropertyForm(InteractionForm myPropertyForm) {
        this.myPropertyForm = (PropertyForm) myPropertyForm;
    }

    // Displays the homepage of the LandLord.
    public void display(String email) {
        // Setting the JFrame's properties.
        JFrame f = this;
        f.setVisible(true);
        f.setLocationRelativeTo(null);

        // Creating new elements to be added to the JFrame.
        JLabel jLabel1 = new javax.swing.JLabel();
        JButton updateListingB = new javax.swing.JButton();
        JButton registerPropertyB = new javax.swing.JButton();
        JButton logoutB = new javax.swing.JButton();

        // Setting the default close operation to exit on close.
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        // Setting texts of the elements.
        jLabel1.setText("Click one of the following options:");

        updateListingB.setText("Update a Listing");
        updateListingB.setActionCommand("Update a Listing");

        registerPropertyB.setText("Register a Property");
        logoutB.setBackground(new java.awt.Color(255, 0, 0));
        logoutB.setText("LOGOUT");

        // Creating a new layout (horizontal and vertical) to fixate the places and
        // sizes of all elements.
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(140, 140, 140)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(registerPropertyB,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 215,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(updateListingB,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 215,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(21, 21, 21)
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98,
                                                        Short.MAX_VALUE)
                                                .addComponent(logoutB)))
                                .addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(logoutB))
                                .addGap(16, 16, 16)
                                .addComponent(updateListingB, javax.swing.GroupLayout.PREFERRED_SIZE, 104,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(registerPropertyB, javax.swing.GroupLayout.PREFERRED_SIZE, 108,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(23, Short.MAX_VALUE)));

        // Packs all elements according to their set sizes and locations.
        pack();

        // If the update listing button was clicked, hide this GUI page and call upon
        // browseProperties in myPropertyForm.
        updateListingB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                ((PropertyForm) myPropertyForm).browseProperties();

            }
        });

        // If the register property button was clicked, hide this GUI page and calling
        // startRegistration in myPropertyForm.
        registerPropertyB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                ((PropertyForm) myPropertyForm).startRegistration();
            }
        });

        // If the logout button was clicked, dispose of this frame and call upon the
        // main function in StartUp again.
        logoutB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                StartUp.main(new String[] { "" });
            }
        });
    }
}