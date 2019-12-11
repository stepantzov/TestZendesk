package com.zendesk.pageActions;

import com.zendesk.pages.SettingsPage;
import org.springframework.stereotype.Component;

@Component
public class SettingsPageActions extends SettingsPage {
    public void openLeadStatusesTab() {
        elementClick(leadStatusesTab());
    }

    public void pressEditExistingLeadStatus() {
        elementClick(editStatusBtn());
    }

    public void fillNewLeadStatusName(String newStatusName) {
        leadStatusNameFld().clear();
        sendKeys(leadStatusNameFld(), newStatusName);
    }

    public void pressSaveNewLeadStatusName() {
        elementClick(saveLeadStatusName());
    }
}