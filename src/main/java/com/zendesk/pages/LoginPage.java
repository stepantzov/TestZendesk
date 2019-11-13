package com.zendesk.pages;

import com.zendesk.coreFunctions.ActionsSetup;
import com.zendesk.coreFunctions.DriverSetup;
import com.zendesk.utils.PropertiesReader;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.zendesk.coreFunctions.GlobalDefinitions.DELAY;
import static com.zendesk.coreFunctions.GlobalDefinitions.XPATH;

@Component
public class LoginPage extends ActionsSetup implements Page {
    private static final String loginPath = "/users/login";

    public LoginPage() {
    }

    @Autowired
    DriverSetup driverSetup;

    @Override
    public void navigateToPageUrl() {
        String fullPageUrl = PropertiesReader.get("base.site.url").concat(loginPath);

        driverSetup.getDriverInstance().get(fullPageUrl);
    }

    protected WebElement loginEnterFld() {
        return getElement("//*[@id=\"user_email\"]", DELAY, XPATH);
    }

    protected WebElement passwordEnterFld() {
        return getElement("//*[@id=\"user_password\"]", DELAY, XPATH);
    }

    protected WebElement signInBtn() {
        return getElement("//*[@id=\"user_new\"]/fieldset/div[3]/div/button", DELAY, XPATH);
    }
}