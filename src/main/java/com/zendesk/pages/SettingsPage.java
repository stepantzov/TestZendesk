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
public class SettingsPage extends ActionsSetup implements Page {
    private static final String settingsPath = "/settings";
    private static final String leadsSettingPath = "/leads";

    public SettingsPage() {
    }

    @Autowired
    DriverSetup driverSetup;

    @Override
    public void navigateToPageUrl() {
        String fullPageUrl = PropertiesReader.get("base.site.url").concat(settingsPath).concat(leadsSettingPath);

        driverSetup.getDriverInstance().get(fullPageUrl);
    }

    protected WebElement sideBarLeadsItem() {
        return getElement("//li[@class='leads']", DELAY, XPATH);
    }

    protected WebElement leadStatusesTab() {
        return getElement("//*[@data-toggle='lead-status']", DELAY, XPATH);
    }

    protected WebElement editStatusBtn() {
        return getElement("//*[@id=\"lead-status\"]/div[1]/span[1]/div//span[1]/button", DELAY, XPATH);
    }

    protected WebElement leadStatusNameFld() {
        return getElement("//*[@id=\"lead-status\"]//span[1]//fieldset/div[2]//input", DELAY, XPATH);
    }

    protected WebElement saveLeadStatusName() {
        return getElement("//div[@class='control-group']//button[@class='btn btn-primary save']", DELAY, XPATH);
    }
}