package com.DemoQA.SeleniumTesting.Steps;

import com.DemoQA.PageObjects.Elements.CheckBox;
import com.DemoQA.PageObjects.Elements.Links;
import com.DemoQA.PageObjects.Elements.RadioButton;
import com.DemoQA.PageObjects.Elements.TextBox;
import com.DemoQA.PageObjects.HomePage;
import com.DemoQA.PageObjects.Widgets.Accordion;
import com.DemoQA.PageObjects.Widgets.ToolTips;
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
        TextBox.ValidatePermanentAddress("Permanent Address :Allina Street No 122");
    }


//Scenario no.3

    @And("User selects the button <Check Box> on the <Elements> section")
    public void userSelectsTheButtonCheckBoxOnTheElementsSection() {
        CheckBox.ClickCheckBoxButton();

    }

    @When("User expands the Check Box List")
    public void userExpandsTheCheckBoxList() {
        CheckBox.HomeCheckBoxButton();
    }

    @And("User selects the options <Commands>, <Angular>, <Classified>")
    public void userSelectsTheOptionsCommandsAngularClassified() {
        CheckBox.CommandsCheckBox();
        CheckBox.AngularCheckBox();
        CheckBox.ClassifiedCheckbox();
    }

    @Then("A message {string} is displayed")
    public void aMessageIsDisplayed(String arg0) {
        CheckBox.ValidateTextCheckBox("You have selected :\n" +
                "commands\n" +
                "angular\n" +
                "classified");
    }

//Scenario No.4

    @And("User selects the <Links> section")
    public void userSelectsTheLinksSection() {
        Links.ClickLinks();
    }

    @When("User clicks on the <Moved> link that will send an api call")
    public void userClicksOnTheMovedLinkThatWillSendAnApiCall() {
        Links.ClickMovedLink();
    }

    @Then("The message {string} appears")
    public void theMessageAppears(String arg0) {
        Links.ValidateTextforMovedLink("Link has responded with staus 301 and status text Moved Permanently");
    }


//Scenario No. 5

    @Given("User selects the <Widgets> section")
    public void userSelectsTheWidgetsSection() {
        HomePage.ClickWidgetsButton();
    }

    @When("User clicks on the <Tool Tips> button on the <Widgets> section")
    public void userClicksOnTheToolTipsButtonOnTheWidgetsSection() {
        ToolTips.ClickToolTips();
    }

    @And("User is hovering the button <Contrary>")
    public void userIsHoveringTheButtonContrary() {
        ToolTips.HooverContrary();

    }

    @Then("The following message is displayed: {string}")
    public void theFollowingMessageIsDisplayed(String arg0) {


    }


//Scenario No.6

    @When("User clicks on the <Accordion> button from the <Widgets> section")
    public void userClicksOnTheAccordionButtonFromTheWidgetsSection() {
        Accordion.ClickAccordion();
    }

    @And("User selects the accordion <Why do we use it?>")
    public void userSelectsTheAccordionWhyDoWeUseIt() {
        Accordion.ClickWhyDoWeUSeIt();
    }

    @Then("The answer will push down")
    public void theAnswerWillPushDown() {
    }



//Scenario No.7


    @Given("User selects the <Elements> section on DemoQa homepage")
    public void userSelectsTheElementsSectionOnDemoQaHomepage() {
    }

    @And("User selects the button <Text Box>")
    public void userSelectsTheButtonTextBox() {
    }

    @When("User enters data in the fields <Full Name>, <Email>, <Current Address>, <Permanent Address>")
    public void userEntersDataInTheFieldsFullNameEmailCurrentAddressPermanentAddress() {
    }

    @And("User clicks on the button Submit")
    public void userClicksOnTheButtonSubmit() {
    }

    @Then("A new box with all the entered data is displayed.")
    public void aNewBoxWithAllTheEnteredDataIsDisplayed() {
    }
}







