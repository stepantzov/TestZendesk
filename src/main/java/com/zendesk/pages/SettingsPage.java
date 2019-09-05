package com.zendesk.pages;

import com.zendesk.coreFunctions.ActionsSetup;
import com.zendesk.utils.Properties;
import org.openqa.selenium.WebElement;

public class SettingsPage extends ActionsSetup implements Page {
    private static final String settingsPath = "/settings";
    private static final String leadsSettingPath = "/leads";

    @Override
    public void navigateToPageUrl() {
        String fullPageUrl = Properties.get("base.site.url").concat(settingsPath).concat(leadsSettingPath);

        driverInstance.get(fullPageUrl);
    }

    /*protected static WebElement settingsDropdown() {
        return getElement("#user-dd > a", DELAY, CSS);
    }

    protected static WebElement settingsDropdownSettingsItem() {
        return getElement("#user-dd > ul > li.settings > a", DELAY, CSS);
    }*/

    protected static WebElement sideBarLeadsItem(){
        return getElement("//li[@class='leads']", DELAY, XPATH);
    }

    protected static WebElement leadStatusesTab(){
        return getElement("//*[@data-toggle='lead-status']", DELAY, XPATH);
    }

    protected static WebElement editStatusBtn(){
        return getElement("//*[@id=\"lead-status\"]/div[1]/span[1]/div//span[1]/button", DELAY, XPATH);
    }

    protected static WebElement leadStatusNameFld(){
        return getElement("//*[@id=\"lead-status\"]//span[1]//fieldset/div[2]//input", DELAY, XPATH);
    }

    protected static WebElement saveLeadStatusName(){
        return getElement("//div[@class='control-group']//button[@class='btn btn-primary save']", DELAY, XPATH);
    }
}