package com.fair.pages;

import com.fair.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NewLineOfCreditPage extends BasePage {


    @FindBy(xpath = "//input[@id='line_of_credit_apr']")
    private WebElement aprInputBox;

    @FindBy(id = "line_of_credit_credit_limit")
    private WebElement creditLimitInputBox;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement createLineOfCreditButton;

    @FindBy(linkText = "Back")
    private WebElement backLink;









    public void enterAPR(String APR) throws Exception {
      wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='line_of_credit_apr']")));
        aprInputBox.sendKeys(APR);
    }
    public void enterAmount(String amount){
        creditLimitInputBox.sendKeys(amount);
    }

    public void clickOnCreateLineOfCredit (){
       createLineOfCreditButton.click();
    }










}
