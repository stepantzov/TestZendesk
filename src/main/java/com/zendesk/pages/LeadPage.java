package com.zendesk.pages;

import com.zendesk.coreFunctions.ActionsSetup;
import com.zendesk.coreFunctions.DriverSetup;
import com.zendesk.utils.PropertiesReader;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.zendesk.coreFunctions.GlobalDefinitions.*;

@Component
public class LeadPage extends ActionsSetup implements Page {
    private static final String leadPagePath = "/working/leads";

    public LeadPage() {
    }

    @Autowired
    DriverSetup driverSetup;

    @Override
    public void navigateToPageUrl() {
        String fullPageUrl = PropertiesReader.get("base.site.url").concat(leadPagePath);

        driverSetup.getDriverInstance().get(fullPageUrl);
    }

    protected WebElement leadTitleFullName() {
        return getElement("span.detail-title", DELAY, CSS);
    }

    protected WebElement leadStatus() {
        return getElement("//span[@class='lead-status']", DELAY, XPATH);
    }

    protected WebElement filtersBarStatusItemsList() {
        return getElement("//div[@class='_2Cj--CloudFilter--attribute' and text()='Status']", DELAY, XPATH);
    }

    protected WebElement filterBarSpecificStatusNamed(String statusName) {
        return getElement("//div[@class='_2gD--Ellipsis--Ellipsis' and text()='" + statusName + "']", DELAY, XPATH);
    }
}