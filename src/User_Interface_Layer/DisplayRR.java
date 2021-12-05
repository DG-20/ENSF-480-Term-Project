package User_Interface_Layer;

public class DisplayRR implements Strategy {
  private InteractionForm mySearchForm;
  private InteractionForm mySubForm;
  private InteractionForm myNotifView;

  public void display(String email) {
    mySearchForm = new SearchForm();
    mySubForm = new SubscriptionForm(email);
    myNotifView = new NotificationView(email);
  }

  public DisplayRR() {}
}
