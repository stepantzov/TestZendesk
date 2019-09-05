package com.zendesk.pageActions;

import com.zendesk.pages.LeadPage;
import org.openqa.selenium.WebDriver;

public class LeadPageActions extends LeadPage {
    private static WebDriver driver;

    protected LeadPageActions(WebDriver driver) {
        this.driver = driver;
    }

    public static String getLeadTitle() {
        return getText(leadTitleFullName());
    }

    public static String getLeadStatus() {
        return getText(leadStatus());
    }

    public static Boolean verifyUpdatedLeadStatusPresent(String updatedStatusName) {
        elementClick(filtersBarStatusItemsList());

        return filterBarSpecificStatusNamed(updatedStatusName).isDisplayed();
    }
}