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
        return null;
    }

    /**
     * 
     */
    public void LoginController() {
        // TODO implement here
    }

}