/*
 * File Name: StartUp.java
 * Authors:
 *      Cheyenne Goh (UCID: 30040528)
 *      Divyansh Goyal (UCID: 30089488)
 *      Rui Guan (UCID: 30072848)
 *      Sajid Hafiz (UCID: 30061336)
 */

package User_Interface_Layer;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StartUp {
  private String userType;
  private LoginForm login;
  // private InteractionForm homePage; // not used

  public boolean loginPage() { // boolean not used (can be void)
    login = new LoginForm(userType);
    login.startLogin();
    return true;
  }

  public void welcome() {
    EventQueue.invokeLater(() -> {
      JFrame frame = new JFrame("Welcome");
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

      Container container = new Container();
      container.setLayout(new GridBagLayout());

      JPanel panel = new JPanel();
      panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
      panel.setLayout(new BorderLayout());
      panel.add(container);

      GridBagConstraints c = new GridBagConstraints();
      c.fill = GridBagConstraints.HORIZONTAL;
      c.ipadx = 10;
      c.ipady = 10;

      JLabel chooseOneLabel = new JLabel("Choose one:");
      chooseOneLabel.setBorder(BorderFactory.createEmptyBorder(0, 5, 10, 0));
      c.gridx = 0;
      c.gridy = 0;
      c.gridwidth = 2;
      container.add(chooseOneLabel, c);

      JButton managerButton = new JButton("Manager");
      c.gridwidth = 1;
      c.gridy = 1;
      container.add(managerButton, c);
      managerButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          userType = "Manager";
          frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
          loginPage();
        }
      });

      JButton registeredRenterButton = new JButton("Registered Renter");
      c.gridy = 2;
      container.add(registeredRenterButton, c);
      registeredRenterButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          userType = "Registered Renter";
          frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
          loginPage();
        }
      });

      JButton noAccountButton = new JButton("No Account");
      c.gridy = 3;
      container.add(noAccountButton, c);
      noAccountButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          userType = "Unregistered Renter";
          frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
          loginPage();
        }
      });

      JButton landlordButton = new JButton("Landlord");
      landlordButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          userType = "Landlord";
          frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
          loginPage();
        }
      });
      c.gridx = 1;
      c.gridy = 1;
      c.gridheight = 3;
      c.fill = GridBagConstraints.VERTICAL;
      container.add(landlordButton, c);

      frame.getContentPane().add(panel, BorderLayout.CENTER);
      frame.pack();
      frame.setVisible(true);
    });
  }

  // public void homePage() {
  // }

  public static void main(String args[]) {
    StartUp startUp = new StartUp();
    startUp.welcome();
  }

  public StartUp() {}
}