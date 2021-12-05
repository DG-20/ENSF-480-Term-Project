/*
 * File Name: LoginController.java
 * Authors:
 *      Cheyenne Goh (UCID: 30040528)
 *      Divyansh Goyal (UCID: 30089488)
 *      Rui Guan(UCID: 30072848)
 *      Sajid Hafiz (UCID: 30061336)
 */
package Control_Layer;

import Data_Source_Layer.UserInfo;

import java.util.*;

/**
 * 
 */
public class LoginController extends Controller {

    /**
     * Default constructor
     */
    public LoginController() {
    }

    public UserInfo getValidation() {
        return validation;
    }

    public void setValidation(UserInfo validation) {
        this.validation = validation;
    }

    public UserInfo getValidate() {
        return validate;
    }

    public void setValidate(UserInfo validate) {
        this.validate = validate;
    }

    /**
     * 
     */
    private UserInfo validation;

    /**
     * 
     */
    private UserInfo validate;






    /**
     * @param email 
     * @param password 
     * @param userType 
     * @return
     */
    public boolean forwardUser(String email, String password, String userType) {
        // TODO implement here
        return false;
    }

    /**
     * 
     */
    public void LoginController() {
        // TODO implement here
    }

}