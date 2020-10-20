package com.fair.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(linkText = "New Line of credit")
    private WebElement newLineOfCredit_link;

    public void newLineOfCredit() {
        newLineOfCredit_link.click();
    }



}
