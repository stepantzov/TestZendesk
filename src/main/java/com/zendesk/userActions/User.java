package com.zendesk.userActions;

import com.zendesk.pageActions.LeadPageActions;
import com.zendesk.pageActions.LoginPageActions;
import com.zendesk.pageActions.MainPageActions;
import com.zendesk.pageActions.SettingsPageActions;
import com.zendesk.pages.LeadPage;
import com.zendesk.pages.SettingsPage;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import static com.zendesk.coreFunctions.GlobalDefinitions.LOGIN;
import static com.zendesk.coreFunctions.GlobalDefinitions.PASSWORD;

@Component
@ComponentScan("com.zendesk")
public class User {
    @Autowired
    MainPageActions mainPageActions;

    @Autowired
    LeadPageActions leadPageActions;

    @Autowired
    SettingsPageActions settingsPageActions;

    @Autowired
    LoginPageActions loginPageActions;

    @Autowired
    SettingsPage settingsPage;

    @Autowired
    LeadPage leadPage;

    public void createAndViewNewLead(String firstName, String lastName) {
        mainPageActions.pressAddMenuBtn();
        mainPageActions.addItemNamed("Lead");

        mainPageActions.fillFirstName(firstName);
        mainPageActions.fillLastName(lastName);

        mainPageActions.clickSaveAndViewBtn();
    }

    public String getCreatedLeadTitle() {

        return leadPageActions.getLeadTitle();
    }

    public Boolean verifyIfLeadStatusCorrect() {
        return StringUtils.equals(leadPageActions.getLeadStatus(), "New");
    }

    public void openLeadStatusesTab() {
        settingsPage.navigateToPageUrl();
        settingsPageActions.openLeadStatusesTab();
    }

    public void changeTheExistingLeadStatus(String newLeadStatusName) {
        openLeadStatusesTab();

        settingsPageActions.pressEditExistingLeadStatus();
        settingsPageActions.fillNewLeadStatusName(newLeadStatusName);
        settingsPageActions.pressSaveNewLeadStatusName();
    }

    public boolean verifyIfChangedLeadStatusCorrect(String updatedStatusName) {
        leadPage.navigateToPageUrl();

        return leadPageActions.verifyUpdatedLeadStatusPresent(updatedStatusName);
    }

    public void logToZendeskWithCorrectCredentials() {
        loginPageActions.setLoginFld(LOGIN);
        loginPageActions.setPasswordFld(PASSWORD);

        loginPageActions.pressSignInBtn();
    }
}