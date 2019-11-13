package com.zendesk.pageActions;

import com.zendesk.pages.MainPage;
import org.springframework.stereotype.Component;

@Component
public class MainPageActions extends MainPage {
    public void pressAddMenuBtn() {
        elementClick(addDropdown());
    }

    public void addItemNamed(String itemName) {
        elementClick(addDropdownItem(itemName));
    }

    public void fillFirstName(String firstName) {
        sendKeys(newLeadFirstName(), firstName);
    }

    public void fillLastName(String lastName) {
        sendKeys(newLeadLastName(), lastName);
    }

    public void clickSaveAndViewBtn() {
        elementClick(saveAndViewLeadBtn());
    }
}