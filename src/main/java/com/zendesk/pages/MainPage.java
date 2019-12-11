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
public class MainPage extends ActionsSetup implements Page {
    private static final String mainPagePath = "/dashboards/main";

    @Autowired
    DriverSetup driverSetup;

    @Override
    public void navigateToPageUrl() {
        String fullPageUrl = PropertiesReader.get("base.site.url").concat(mainPagePath);

        driverSetup.getDriverInstance().get(fullPageUrl);
    }

    protected WebElement addDropdown() {
        return getElement("//*[@id=\"global-add\"]", DELAY, XPATH);
    }

    protected WebElement addDropdownItem(String item) {
        return getElement("//span[contains(text(), '" + item + "')]", DELAY, XPATH);
    }

    protected WebElement newLeadFirstName() {
        return getElement("//*[@placeholder=\"First Name\"]", DELAY, XPATH);
    }

    protected WebElement newLeadLastName() {
        return getElement("//*[@placeholder=\"Last Name\"]", DELAY, XPATH);
    }

    protected WebElement saveAndViewLeadBtn() {
        return getElement("//button[@data-action='save-and-visit']", DELAY, XPATH);
    }
}