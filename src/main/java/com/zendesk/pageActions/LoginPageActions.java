package com.zendesk.pageActions;

import com.zendesk.pages.LoginPage;
import org.springframework.stereotype.Component;

@Component
public class LoginPageActions extends LoginPage {
    public void setLoginFld(String loginValue) {
        sendKeys(loginEnterFld(), loginValue);
    }

    public void setPasswordFld(String passwordValue) {
        sendKeys(passwordEnterFld(), passwordValue);
    }

    public void pressSignInBtn() {
        elementClick(signInBtn());
    }
}