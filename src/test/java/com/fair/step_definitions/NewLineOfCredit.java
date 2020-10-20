package com.fair.step_definitions;

import com.fair.pages.CreatedNewCreditLinePage;
import com.fair.pages.HomePage;
import com.fair.pages.NewLineOfCreditPage;
import com.fair.utilities.BrowserUtils;
import com.fair.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import javafx.util.converter.LocalDateTimeStringConverter;
import org.apache.log4j.Logger;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class NewLineOfCredit {
    SoftAssertions softAssertions = new SoftAssertions();

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
        logger.error("When you enter a any number with fallowing letter e and then + operator and " +
                "again number the system cannot handle it and allows to create new line");
    }


    @And("user enter {string} of credit limit into input box")
    public void userEnterOfCreditLimitIntoInputBox(String amount) {
        newLineOfCreditPage.enterAmount(amount);
        logger.error("When you enter a any number with fallowing letter e and then + operator and " +
                "again number the system cannot handle it and allows to create new line");

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
        softAssertions.assertThat(actual).isEqualTo(expected);
        BrowserUtils.takeScreenshot();

        logger.error("Credit line does not display correct when you just create a new credit line, " +
                "but it works properly when you apply draw or payment operations and save them");


    }

    @And("user sees the correct {string} date")
    public void userSeesTheCorrectDate(String expected) {
        LocalDate now = LocalDate.now();
        DateTimeFormatter d = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
        expected += now.format(d);
        String actual = createdNewCreditLinePage.getOpenDateInfo();
        softAssertions.assertThat(actual).isEqualTo(expected);
        BrowserUtils.takeScreenshot();

        logger.error("The date has a bug, it set to different time zone after 9pm it shows the next day date");
    }

    @And("user sees the Interest at {int} days is {string}")
    public void userSeesTheInterestAtDaysIs(int numberOfDays, String expected) {
        String actual = createdNewCreditLinePage.getInterestInfo();
        Assert.assertEquals(expected, actual);
        BrowserUtils.takeScreenshot();
        logger.error("In same cases calculation is wrong, so the function does not work properly");
    }

    @And("user sees Total Payoff at {int} days is {string}")
    public void userSeesTotalPayoffAtDaysIs(int numberOfDays, String expected) {

        String actual = createdNewCreditLinePage.getTotalPayoffInfo();
        Assert.assertEquals(expected, actual);
        logger.error("In same cases calculation is wrong, so the function does not work properly");

    }

    @When("user choose operation {string} and puts  amount {string} on day {string}")
    public void userChooseOperationAndPutsAmountOnDay(String type, String amount, String day) {
        createdNewCreditLinePage.moneyOperation(type, amount, day);
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
    public void usersDaysTotalPayoffAmountWouldBe(String interest) {


        String actual = createdNewCreditLinePage.getTotalPayoffInfo();

        Assert.assertEquals(interest, actual);
        logger.error("In same cases calculation is wrong, so the function does not work properly");


    }


    @When("user pay back {string} {string} on day {string}")
    public void userPayBackOnDay(String type, String amount, String day) {

        createdNewCreditLinePage.moneyOperation(type, amount, day);
    }

    @Then("user sees error {string} message")
    public void userSeesErrorMessage(String message) {


        String actual = newLineOfCreditPage.getErrorMessage();
        Assert.assertEquals(message, actual);
        BrowserUtils.takeScreenshot();


    }
}

