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

import java.util.*;

/**
 * 
 */
public class LoginController extends Controller {

    /**
     * Default constructor
     */
    public LoginController() {
        Database data = new UserInfo();
        myData.add(data);
    }

    /**
     * @param email 
     * @param password 
     * @param userType 
     * @return
     */
    public boolean forwardUser(String email, String password, String userType) {
        Database d = myData.get(0);
        UserInfo validate = (UserInfo)d;
        return validate.validation(email, password, userType);
    }
}