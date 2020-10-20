package com.fair.pages;

import com.fair.utilities.Driver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    protected WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);

    public BasePage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }
}
