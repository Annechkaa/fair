package com.fair.pages;

import com.fair.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CreatedNewCreditLinePage extends BasePage {
    @FindBy(id = "notice")
    private WebElement successMessage;

    @FindBy(xpath = "//p[2]")
    private WebElement aprInfo;

    @FindBy(xpath = "//p[3]")
    private WebElement creditAvailableInfo;

    @FindBy(xpath = "//p[4]")
    private WebElement creditLineOpenedInfo;

    @FindBy(xpath = "//p[5]")
    private WebElement interest30DaysInfo;

    @FindBy(xpath = "//p[6]")
    private WebElement totalPayoff30DaysInfo;

    @FindBy(id = "transaction_type")
    private WebElement typeDropdown;

    @FindBy(xpath = "//input[@value='Save Transaction']")
    private WebElement saveTransactionButton;

    @FindBy(id = "transaction_amount")
    private WebElement amountInputBox;

    @FindBy(id = "transaction_applied_at")
    private WebElement appliedDayDropdown;

    @FindBy(linkText = "Back")
    private WebElement backLink;

    @FindBy(id = "transactions_table")
    private WebElement transactionsTable;

    @FindBy(xpath = "//tbody/tr/td[2]")
    private WebElement type;

    @FindBy(xpath = "//tbody/tr/td[3]")
    private WebElement amount;

    @FindBy(xpath = "//tbody/tr/td[4]")
    private WebElement principalBalance;

    @FindBy(xpath = "//tbody/tr/td[5]")
    private WebElement interest;


    public String getSuccessMessage() {

        return successMessage.getText();
    }

    public String getAPRInfo() {

        return aprInfo.getText();
    }

    public String getCreditAvailableInfo() {
        wait.until(ExpectedConditions.visibilityOf(creditAvailableInfo));

        return creditAvailableInfo.getText();
    }

    public String getOpenDateInfo() {

        return creditLineOpenedInfo.getText();
    }

    public String getInterestInfo() {

        return interest30DaysInfo.getText();
    }

    public String getTotalPayoffInfo() {

        return totalPayoff30DaysInfo.getText();
    }

    public void moneyOperation(String type, String amount, String day) {
        Select select = new Select(typeDropdown);
        wait.until(ExpectedConditions.elementToBeClickable(typeDropdown));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("transaction_type")));


        if (type.equals("Draw")) {
            select.selectByValue(type);


        } else if (type.equals("Payment")) {
            select.selectByValue(type);

        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("transaction_amount")));
        amountInputBox.sendKeys(amount);

        Select select1 = new Select(appliedDayDropdown);
        select1.selectByValue(day);

        saveTransactionButton.click();
        wait.until(ExpectedConditions.visibilityOf(this.amount));



    }


    public String getBalance() {


        return principalBalance.getText();

    }

    public String getInterest() {

        return interest.getText();

    }


}
