/*
 * File Name: DisplayUR.java
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
 * DisplayUR is a class which displays the homepage of any user which selected "No Account"
 * on the welcome page.
 * This provides two options, search and exit.
 * It extends the JFrame class and implement the Strategy interface.
 */
public class DisplayUR extends javax.swing.JFrame implements Strategy {
        /*
         * Default constructor.
         */
        public DisplayUR() {
                mySearchForm = new SearchForm();
        }

        private InteractionForm mySearchForm;

        /*
         * Display the Landlord's Home Page.
         */
        public void display(String email) {
                // Setting JFrame properties.
                JFrame f = this;
                f.setVisible(true);
                f.setTitle("NO ACCOUNT HOMEPAGE");
                f.setSize(450, 270);
                f.setLocationRelativeTo(null);

                // Creating JFrame elements.
                JLabel titleLabel = new JLabel();
                JButton exitButton = new JButton();
                JButton searchButton = new JButton();

                // Setting the font and text of the created elements.
                titleLabel.setFont(new java.awt.Font("Times New Roman", 1, 14));
                titleLabel.setText("Please click one of the following options:");

                exitButton.setFont(new java.awt.Font("Times New Roman", 1, 12));
                exitButton.setText("Exit");

                searchButton.setFont(new java.awt.Font("Times New Roman", 1, 12));
                searchButton.setText("Create a new search");

                // Creating a new layout (both horizontal and vertical) to fixate the size and
                // positions of each element along with spaces between them.
                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(f.getContentPane());
                f.getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addGap(90, 90, 90)
                                                                .addComponent(titleLabel)
                                                                .addContainerGap(97, Short.MAX_VALUE))
                                                .addGroup(layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(exitButton,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(searchButton,
                                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE))
                                                                .addContainerGap()));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addGap(22, 22, 22)
                                                                .addComponent(titleLabel)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(searchButton,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                75,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                21,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(exitButton,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                75,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap()));

                // If the search button was clicked, hide this GUI page and call upon
                // createSearchQuery in mySearchForm.
                searchButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                f.setVisible(false);
                                ((SearchForm) mySearchForm).createSearchQuery();
                        }
                });

                // If the exit button was clicked, dispose of this frame and call upon the main
                // function in StartUp.
                exitButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                f.dispose();
                                StartUp.main(new String[] { "" });
                        }
                });
        }
}
