package com.zendesk.userActions;

import com.zendesk.pageActions.LeadPageActions;
import com.zendesk.pageActions.MainPageActions;
import com.zendesk.pageActions.SettingsPageActions;
import com.zendesk.pages.LeadPage;
import com.zendesk.pages.SettingsPage;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;

public class User extends MainPageActions {
    protected User(WebDriver driver) {
        super(driver);
    }

    public static void createAndViewNewLead(String firstName, String lastName) {
        MainPageActions.pressAddMenuBtn();
        MainPageActions.addItemNamed("Lead");

        MainPageActions.fillFirstName(firstName);
        MainPageActions.fillLastName(lastName);

        MainPageActions.clickSaveAndViewBtn();
    }

    public static String getCreatedLeadTitle() {

        return LeadPageActions.getLeadTitle();
    }

    public static Boolean verifyIfLeadStatusCorrect() {
        return StringUtils.equals(LeadPageActions.getLeadStatus(), "New");
    }

    public static void openLeadStatusesTab() {
        SettingsPage settingsPage = new SettingsPage();
        settingsPage.navigateToPageUrl();

        SettingsPageActions.openLeadStatusesTab();
    }

    public static void changeTheExistingLeadStatus(String newLeadStatusName) {
        openLeadStatusesTab();

        SettingsPageActions.pressEditExistingLeadStatus();
        SettingsPageActions.fillNewLeadStatusName(newLeadStatusName);
        SettingsPageActions.pressSaveNewLeadStatusName();
    }

    public static boolean verifyIfChangedLeadStatusCorrect(String updatedStatusName) {
        LeadPage leadPage = new LeadPage();
        leadPage.navigateToPageUrl();

        return LeadPageActions.verifyUpdatedLeadStatusPresent(updatedStatusName);
    }
}