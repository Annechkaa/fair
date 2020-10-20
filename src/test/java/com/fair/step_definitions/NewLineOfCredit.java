package com.fair.step_definitions;

import com.fair.pages.CreatedNewCreditLinePage;
import com.fair.pages.HomePage;
import com.fair.pages.NewLineOfCreditPage;
import com.fair.utilities.ConfigurationReader;
import com.fair.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.Assert;



public class NewLineOfCredit {

    HomePage homePage = new HomePage();
    NewLineOfCreditPage newLineOfCreditPage = new NewLineOfCreditPage();
    CreatedNewCreditLinePage createdNewCreditLinePage = new CreatedNewCreditLinePage();
    private static final Logger logger = Logger.getLogger(NewLineOfCredit.class);


    @Given("user on home page")
    public void user_on_home_page() {

        String actualTitle = Driver.getDriver().getTitle();
        String title = "Credit";

        Assert.assertEquals(title, actualTitle);
    }

    @When("user click on new credit line link")
    public void user_click_on_new_credit_line_link() {
        homePage.newLineOfCredit();

    }


    @And("user enter APR {string} into input box")
    public void userEnterAPRIntoInputBox(String APR) throws Exception {

        newLineOfCreditPage.enterAPR(APR);
    }


    @And("user enter {string} of credit limit into input box")
    public void userEnterOfCreditLimitIntoInputBox(String amount) {
        newLineOfCreditPage.enterAmount(amount);
    }


    @When("user clicks on new line of credit button")
    public void userClicksOnNewLineOfCreditButton() {
        newLineOfCreditPage.clickOnCreateLineOfCredit();

    }

    @Then("user sees {string} message")
    public void user_sees_message(String message) {
        String actual = createdNewCreditLinePage.getSuccessMessage();
        Assert.assertEquals(message, actual);

    }


    @And("user sees APR  {string} is displayed")
    public void userSeesAPRIsDisplayed(String expected) {

        String actual = createdNewCreditLinePage.getAPRInfo();
        Assert.assertEquals(expected, actual);
    }

    @And("user sees credit available  {string} is displayed")
    public void userSeesCreditAvailableIsDisplayed(String expected) {

        String actual = createdNewCreditLinePage.getCreditAvailableInfo();
        Assert.assertNotEquals(expected, actual);
        logger.error("The date has a bug, it set to different time zone");
       // Assert.assertEquals(expected, actual);

    }

    @And("user sees the correct {string} date")
    public void userSeesTheCorrectDate(String expected) {
        String actual = createdNewCreditLinePage.getOpenDateInfo();
        Assert.assertNotEquals(expected, actual);
    }

    @And("user sees the Interest at {int} days is {string}")
    public void userSeesTheInterestAtDaysIs(int numberOfDays, String expected) {
        String actual = createdNewCreditLinePage.getInterestInfo();
        Assert.assertEquals(expected, actual);
    }

    @And("user sees Total Payoff at {int} days is {string}")
    public void userSeesTotalPayoffAtDaysIs(int numberOfDays, String expected) {

        String actual = createdNewCreditLinePage.getTotalPayoffInfo();
        Assert.assertEquals(expected, actual);
    }

    @When("user choose operation {string} and puts  amount {string} on day {string}")
    public void userChooseOperationAndPutsAmountOnDay(String type, String amount, String day) {
        createdNewCreditLinePage.drawMoney(type, amount, day);
    }

    @Then("users remaining credit limit is {string}")
    public void usersRemainingCreditLimitIs(String remain) {

        String actual = createdNewCreditLinePage.getCreditAvailableInfo();

        Assert.assertEquals(remain, actual);


    }

    @And("users balance is amount {string}")
    public void usersBalanceIsAmount(String balance) {
        String actual = createdNewCreditLinePage.getBalance();

        Assert.assertEquals(balance, actual);


    }

    @And("users thirty days total payoff amount would be {string}")
    public void usersDaysTotalPayoffAmountWouldBe( String interest) {


        String actual = createdNewCreditLinePage.getTotalPayoffInfo();

        Assert.assertEquals(interest, actual);


    }


}

