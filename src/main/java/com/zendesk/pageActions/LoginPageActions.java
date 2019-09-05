package com.zendesk.pageActions;

import com.zendesk.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class LoginPageActions extends LoginPage {
    private static WebDriver driver;

    protected LoginPageActions(WebDriver driver) {
        this.driver = driver;
    }

    protected static void setLoginFld(String loginValue) {
        sendKeys(loginEnterFld(), loginValue);
    }

    protected static void setPasswordFld(String passwordValue) {
        sendKeys(passwordEnterFld(), passwordValue);
    }

    protected static void pressSignInBtn() {
        elementClick(signInBtn());
    }
}