package com.zendesk.pageActions;

import com.zendesk.pages.LeadPage;
import org.springframework.stereotype.Component;

@Component
public class LeadPageActions extends LeadPage {
    public String getLeadTitle() {
        return getText(leadTitleFullName());
    }

    public String getLeadStatus() {
        return getText(leadStatus());
    }

    public Boolean verifyUpdatedLeadStatusPresent(String updatedStatusName) {
        elementClick(filtersBarStatusItemsList());

        return filterBarSpecificStatusNamed(updatedStatusName).isDisplayed();
    }
}