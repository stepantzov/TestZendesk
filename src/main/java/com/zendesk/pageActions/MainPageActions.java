package com.zendesk.pageActions;

import com.zendesk.pages.MainPage;
import org.openqa.selenium.WebDriver;

public class MainPageActions extends MainPage {
    private static WebDriver driver;

    protected MainPageActions(WebDriver driver) {
        this.driver = driver;
    }

    protected static void pressAddMenuBtn(){
        elementClick(addDropdown());
    }

    protected static void addItemNamed(String itemName){
        elementClick(addDropdownItem(itemName));
    }

    protected static void fillFirstName(String firstName){
        sendKeys(newLeadFirstName(), firstName);
    }

    protected static void fillLastName(String lastName){
        sendKeys(newLeadLastName(), lastName);
    }

    protected static void clickSaveAndViewBtn(){
        elementClick(saveAndViewLeadBtn());
    }
}