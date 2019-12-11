package com.zendesk.coreFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.TimeUnit;

import static com.zendesk.coreFunctions.GlobalDefinitions.*;

public class ActionsSetup {

    @Autowired
    DriverSetup driverSetup;

    protected WebElement getElement(String selector, int timeWaiting, String typeSelector) {
        return new WebDriverWait(driverSetup.getDriverInstance(), setTimeWaiting(timeWaiting, DELAY)).
                until(ExpectedConditions.presenceOfElementLocated(bySelector(selector, typeSelector)));
    }

    private static By bySelector(String selector, String typeSelector) {
        return XPATH.equals(type(typeSelector)) ? By.xpath(selector) : By.cssSelector(selector);
    }

    private static String type(String typeSelector) {
        String type = typeSelector;
        if (!XPATH.equals(type) && !CSS.equals(type)) {
            type = XPATH;
        }

        return type;
    }

    private static int setTimeWaiting(int timeWaiting, int defaultDelay) {
        if (defaultDelay == 0) {
            return defaultDelay;
        } else
            return timeWaiting;
    }

    protected void setImplicitWaitTime(int implicitWaitTime) {
        driverSetup.getDriverInstance().manage().timeouts().implicitlyWait(implicitWaitTime, TimeUnit.SECONDS);
    }

    protected String getText(WebElement element) {
        setImplicitWaitTime(IMPLICITDELAY);

        return element.getText();
    }

    protected void elementClick(WebElement element) {
        setImplicitWaitTime(IMPLICITDELAY);
        element.click();
    }

    protected void sendKeys(WebElement element, String fieldValue) {
        setImplicitWaitTime(IMPLICITDELAY);
        element.sendKeys(fieldValue);
    }
}