package User_Interface_Layer;
// import LoginController.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginForm extends InteractionForm {
  private String inputEmail;
  private String inputPassword;
  private String userType; // not relevant

  public boolean startLogin() { // boolean not used (can be void)
    EventQueue.invokeLater(() -> {
      JFrame frame = new JFrame("Start Login");
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

      Container container = new Container();
      container.setLayout(new GridBagLayout());

      JPanel panel = new JPanel();
      panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
      panel.setLayout(new BorderLayout());
      panel.add(container);

      GridBagConstraints c = new GridBagConstraints();
      c.fill = GridBagConstraints.HORIZONTAL;

      JLabel loginLabel = new JLabel("Login");
      loginLabel.setBorder(BorderFactory.createEmptyBorder(0, 5, 10, 0));
      c.gridx = 0;
      c.gridy = 0;
      c.gridwidth = 2;
      container.add(loginLabel, c);

      JLabel emailLabel = new JLabel("Email:", JLabel.TRAILING);
      c.gridwidth = 1;
      c.gridy = 1;
      container.add(emailLabel, c);
      JTextField emailTextField = new JTextField(10);
      c.gridx = 1;
      emailLabel.setLabelFor(emailTextField);
      container.add(emailTextField, c);

      JLabel passwordLabel = new JLabel("Password:", JLabel.TRAILING);
      c.gridx = 0;
      c.gridy = 2;
      container.add(passwordLabel, c);
      JPasswordField passwordField = new JPasswordField(10);
      c.gridx = 1;
      passwordLabel.setLabelFor(passwordField);
      container.add(passwordField, c);

      JButton okButton = new JButton("OK");
      okButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          inputEmail = emailTextField.getText();
          inputPassword = String.valueOf(passwordField.getPassword());
          if (inputEmail.length() > 0 && inputPassword.length() > 0) {
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            GUIHomePage guiHomePage = new GUIHomePage(inputEmail);
            guiHomePage.setDisplayStrategy(userType);
            guiHomePage.performStrategy();
          }
        }
      });

      JPanel buttonPanel = new JPanel();
      buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
      buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));
      buttonPanel.add(Box.createHorizontalGlue());
      buttonPanel.add(okButton);

      frame.getContentPane().add(panel, BorderLayout.CENTER);
      frame.getContentPane().add(buttonPanel, BorderLayout.PAGE_END);

      frame.pack();
      frame.setVisible(true);
    });
    return true;
  }

  public LoginForm(String userType) {
    this.userType = userType;

  }

  public String getInputEmail() {
    return inputEmail;
  }

  public String getInputPassword() {
    return inputPassword;
  }
}
