package User_Interface_Layer;

public class DisplayManager implements Strategy {
  private InteractionForm mySummaryForm;
  private InteractionForm myChangePF;
  private InteractionForm myPropertyForm;

  public void display(String email) {
    mySummaryForm = new SummaryForm();
    myChangePF = new ChangePeriodFeesForm();
    myPropertyForm = new PropertyForm(email);
  }

  public DisplayManager() {}
}
