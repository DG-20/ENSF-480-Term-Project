package User_Interface_Layer;

// DONE
public class GUIHomePage {
  private String email;
  private Strategy displayStrategy;

  public void performStrategy() {
    displayStrategy.display(email);
  }

  public void setDisplayStrategy(String userType) {
    if (userType.equals("Landlord")) {
      displayStrategy = new DisplayLL();
    }
    else if (userType.equals("Manager")) {
      displayStrategy = new DisplayManager();
    }
    else if (userType.equals("Registered Renter")) {
      displayStrategy = new DisplayRR();
    }
    else {
      displayStrategy = new DisplayUR();
    }
  }

  public GUIHomePage(String email) {
    this.email = email;
    displayStrategy = new DisplayUR();
  }
}
