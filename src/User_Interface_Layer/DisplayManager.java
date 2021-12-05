/*
 * File Name: DisplayManager.java
 * Authors:
 *      Cheyenne Goh (UCID: 30040528)
 *      Divyansh Goyal (UCID: 30089488)
 *      Rui Guan (UCID: 30072848)
 *      Sajid Hafiz (UCID: 30061336)
 */

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
