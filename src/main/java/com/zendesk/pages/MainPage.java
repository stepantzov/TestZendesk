package com.zendesk.pages;

import com.zendesk.coreFunctions.ActionsSetup;
import com.zendesk.utils.Properties;
import org.openqa.selenium.WebElement;

public class MainPage extends ActionsSetup implements Page {
    private static final String mainPagePath = "/dashboards/main";

    @Override
    public void navigateToPageUrl() {
        String fullPageUrl = Properties.get("base.site.url").concat(mainPagePath);

        driverInstance.get(fullPageUrl);
    }

    protected static WebElement addDropdown() {
        return getElement("//*[@id=\"global-add\"]", DELAY, XPATH);
    }

    protected static WebElement addDropdownItem(String item) {
        return getElement("//span[contains(text(), '" + item + "')]", DELAY, XPATH);
    }

    protected static WebElement newLeadFirstName() {
        return getElement("//*[@placeholder=\"First Name\"]", DELAY, XPATH);
    }

    protected static WebElement newLeadLastName() {
        return getElement("//*[@placeholder=\"Last Name\"]", DELAY, XPATH);
    }

    protected static WebElement saveAndViewLeadBtn() {
        return getElement("//button[@data-action='save-and-visit']", DELAY, XPATH);
    }
}