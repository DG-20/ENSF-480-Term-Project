package User_Interface_Layer;

public class DisplayUR implements Strategy {
  private InteractionForm mySearchForm;

  public void display(String email) {
    mySearchForm = new SearchForm();
  }

  public DisplayUR() {}
}
