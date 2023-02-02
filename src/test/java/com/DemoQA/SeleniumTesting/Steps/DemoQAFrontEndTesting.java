package com.DemoQA.SeleniumTesting.Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import selenium.PageObjects.ElementsPage;
import selenium.PageObjects.HomePage;


public class DemoQAFrontEndTesting {

    WebDriver driver;

//Scenario no.1
    @Given("User selects the <Elements> section")
    public void userSelectsTheElementsSection() {

        HomePage.ClickElementsButton();
    }

    @And("User clicks on the <Radio Button> element")
    public void userClicksOnTheRadioButtonElement() {

        ElementsPage.ClickRadioButton();
    }

    @When("User selects the option <Yes>")
    public void userSelectsTheOptionYes() {
        ElementsPage.ClickYesOnRadioButton();
    }


    @Then("The message {string} is displayed")
    public void theMessageIsDisplayed(String arg0) {
        ElementsPage.ValidateYesOptionOnRadioButton("You have selected Yes");
  }


//Scenario no.2

    @Given("User selects the button Text Box on the <Elements> section")
    public void userSelectsTheButtonTextBoxOnTheElementsSection() {
        HomePage.ClickElementsButton();
        ElementsPage.ClickTextBoxButton();
    }

    @When("User completes the fields <Full Name>, <Email>, <Current Address>, <Permanent Address>")
    public void userCompletesTheFieldsFullNameEmailCurrentAddressPermanentAddress() {
        ElementsPage.EnterFullName("TestFullName");
        ElementsPage.EnterEmail("TestEmail@invalid.com");
        ElementsPage.EnterCurrentAddress("Test Niko Street No 40");
        ElementsPage.EnterPermanentAddress("Allina Street No 122");
    }

    @And("User clicks on the Submit button")
    public void userClicksOnTheSubmitButton() {
        ElementsPage.ClickSubmitTextBox();
    }

    @Then("A new box is displayed with all information previously entered.")
    public void aNewBoxIsDisplayedWithAllInformationPreviouslyEntered() {
        ElementsPage.ValidateFullName("Name:TestFullName");
        ElementsPage.ValidateEmail("Email:TestEmail@invalid.com");
        ElementsPage.ValidateCurrentAddress("Current Address :Test Niko Street No 40");
        ElementsPage.ValidatePermanentAddress("Permananet Address :Allina Street No 122");
    }
}







