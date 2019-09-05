package com.zendesk.userActions;

import com.zendesk.pageActions.LoginPageActions;
import org.openqa.selenium.WebDriver;

public class Login extends LoginPageActions {
    public Login(WebDriver driverInstance) {
        super(driverInstance);
    }

    public static void logWithCorrectTrialCredentials(){
        LoginPageActions.setLoginFld(LOGIN);
        LoginPageActions.setPasswordFld(PASSWORD);
        LoginPageActions.pressSignInBtn();
    }
}