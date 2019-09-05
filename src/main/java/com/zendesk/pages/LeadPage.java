package com.zendesk.pages;

import com.zendesk.coreFunctions.ActionsSetup;
import com.zendesk.utils.Properties;
import org.openqa.selenium.WebElement;

public class LeadPage extends ActionsSetup implements Page {
    private static final String leadPagePath = "/working/leads";

    @Override
    public void navigateToPageUrl() {
        String fullPageUrl = Properties.get("base.site.url").concat(leadPagePath);

        driverInstance.get(fullPageUrl);
    }

    protected static WebElement leadTitleFullName() {
        return getElement("span.detail-title", DELAY, CSS);
    }

    protected static WebElement leadStatus() {
        return getElement("//span[@class='lead-status']", DELAY, XPATH);
    }

    protected static WebElement filtersBarStatusItemsList() {
        return getElement("//div[@class='_2Cj--CloudFilter--attribute' and text()='Status']", DELAY, XPATH);
    }

    protected static WebElement filterBarSpecificStatusNamed(String statusName) {
        return getElement("//div[@class='_2gD--Ellipsis--Ellipsis' and text()='" + statusName + "']", DELAY, XPATH);
    }
}