package com.zendesk.pages;

import com.zendesk.coreFunctions.ActionsSetup;
import com.zendesk.utils.Properties;
import org.openqa.selenium.WebElement;

public class LoginPage extends ActionsSetup implements Page {
    private static final String loginPath = "/users/login";

    @Override
    public void navigateToPageUrl() {
        String fullPageUrl = Properties.get("base.site.url").concat(loginPath);

        driverInstance.get(fullPageUrl);
    }

    protected static WebElement loginEnterFld() {
        return getElement("//*[@id=\"user_email\"]", DELAY, XPATH);
    }

    protected static WebElement passwordEnterFld() {
        return getElement("//*[@id=\"user_password\"]", DELAY, XPATH);
    }

    protected static WebElement signInBtn() {
        return getElement("//*[@id=\"user_new\"]/fieldset/div[3]/div/button", DELAY, XPATH);
    }
}