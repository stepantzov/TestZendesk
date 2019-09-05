package com.zendesk.pageActions;

import com.zendesk.pages.SettingsPage;
import org.openqa.selenium.WebDriver;

public class SettingsPageActions extends SettingsPage {
    private static WebDriver driver;

    public SettingsPageActions(WebDriver driver) {
        this.driver = driver;
    }

    public static void openLeadStatusesTab() {
        elementClick(leadStatusesTab());
    }

    public static void pressEditExistingLeadStatus() {
        elementClick(editStatusBtn());
    }

    public static void fillNewLeadStatusName(String newStatusName) {
        leadStatusNameFld().clear();
        sendKeys(leadStatusNameFld(), newStatusName);
    }

    public static void pressSaveNewLeadStatusName(){
        elementClick(saveLeadStatusName());
    }
}