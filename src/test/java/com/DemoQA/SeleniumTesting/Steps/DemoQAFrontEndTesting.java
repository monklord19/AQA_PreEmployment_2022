package com.DemoQA.SeleniumTesting.Steps;

import com.DemoQA.PageObjects.Elements.RadioButton;
import com.DemoQA.PageObjects.Elements.TextBox;
import com.DemoQA.PageObjects.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;


public class DemoQAFrontEndTesting {

    WebDriver driver;

//Scenario no.1
    @Given("User selects the <Elements> section")
    public void userSelectsTheElementsSection() {
        HomePage.ClickElementsButton();
    }

    @And("User clicks on the <Radio Button> element")
    public void userClicksOnTheRadioButtonElement() {
        RadioButton.ClickRadioButton();
    }

    @When("User selects the option <Yes>")
    public void userSelectsTheOptionYes() {
        RadioButton.ClickYesOnRadioButton();
    }

    @Then("The message {string} is displayed")
    public void theMessageIsDisplayed(String arg0) {
        RadioButton.ValidateYesOptionOnRadioButton("You have selected Yes");
  }


//Scenario no.2

    @And("User selects the button <Text Box> on the <Elements> section")
    public void userSelectsTheButtonTextBoxOnTheElementsSection() {
        TextBox.ClickTextBoxButton();
    }

    @When("User completes the fields <Full Name>, <Email>, <Current Address>, <Permanent Address>")
    public void userCompletesTheFieldsFullNameEmailCurrentAddressPermanentAddress() {
        TextBox.EnterFullName("TestFullName");
        TextBox.EnterEmail("TestEmail@invalid.com");
        TextBox.EnterCurrentAddress("Test Niko Street No 40");
        TextBox.EnterPermanentAddress("Allina Street No 122");
    }

    @And("User clicks on the Submit button")
    public void userClicksOnTheSubmitButton() {
        TextBox.ClickSubmitTextBox();
    }

    @Then("A new box is displayed with all information previously entered.")
    public void aNewBoxIsDisplayedWithAllInformationPreviouslyEntered() {
        TextBox.ValidateFullName("Name:TestFullName");
        TextBox.ValidateEmail("Email:TestEmail@invalid.com");
        TextBox.ValidateCurrentAddress("Current Address :Test Niko Street No 40");
        TextBox.ValidatePermanentAddress("Permananet Address :Allina Street No 122");
    }


//Scenario no.3

    @And("User selects the button <Check Box> on the <Elements> section")
    public void userSelectsTheButtonCheckBoxOnTheElementsSection() {
    }

    @When("User expands the Check Box List")
    public void userExpandsTheCheckBoxList() {
    }

    @And("User selects the options <Commands>, <Angular>, <Classified>")
    public void userSelectsTheOptionsCommandsAngularClassified() {
    }


    @Then("A message {string} is displayed")
    public void aMessageIsDisplayed(String arg0) {

    }
}







