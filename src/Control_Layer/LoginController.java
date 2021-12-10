/*
 * File Name: LoginController.java
 * Authors:
 *      Cheyenne Goh (UCID: 30040528)
 *      Divyansh Goyal (UCID: 30089488)
 *      Rui Guan(UCID: 30072848)
 *      Sajid Hafiz (UCID: 30061336)
 */
package Control_Layer;

import Data_Source_Layer.*;

/*
 * LoginController is the Controller class for LoginForm.
 * This class extends Controller.
 * It's main responsibility is to forward the user-entered 
 * info to UserInfo and return whether the credentials are valid 
 * or not using a boolean to LoginForm.
 */
public class LoginController extends Controller {

    /*
     * Default constructor for LoginController.
     * This adds a new UserInfo object to myData.
     */
    public LoginController() {
        Database data = new UserInfo();
        myData.add(data);
    }

    /*
     * forwardUser takes in the user-entered parameters and sends it to validation
     * in UserInfo.
     * Then, it returns the value returned from that function regarding the
     * authenticity of the login.
     */
    public boolean forwardUser(String email, String password, String userType) {
        Database d = myData.get(0);
        UserInfo validate = (UserInfo) d;
        return validate.validation(email, password, userType);
    }
}