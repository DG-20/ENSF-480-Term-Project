/*
 * File Name: DisplayRR.java
 * Authors:
 *      Cheyenne Goh (UCID: 30040528)
 *      Divyansh Goyal (UCID: 30089488)
 *      Rui Guan (UCID: 30072848)
 *      Sajid Hafiz (UCID: 30061336)
 */

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
