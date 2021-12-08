/*
 * File Name: DisplayLL.java
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

public class DisplayLL implements Strategy {
  private InteractionForm myPropertyForm;

  public void display(String email) {
    myPropertyForm = new PropertyForm(email);
    EventQueue.invokeLater(() -> {
      JFrame frame = new JFrame("Landlord Homepage");
      frame.setSize(500, 500);
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

      JButton updateButton = new JButton("Update");
      c.gridx = 0;
      c.gridy = 0;
      container.add(updateButton, c);

      JButton logoutButton = new JButton("Logout");
      logoutButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
          StartUp startUp = new StartUp();
          startUp.welcome();
        }
      });

      JPanel buttonPanel = new JPanel();
      buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
      buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));
      buttonPanel.add(Box.createHorizontalGlue());
      buttonPanel.add(logoutButton);

      frame.getContentPane().add(panel, BorderLayout.CENTER);
      frame.getContentPane().add(buttonPanel, BorderLayout.PAGE_START);

      frame.pack();
      frame.setVisible(true);
    });
  }

  public DisplayLL() {}
}
