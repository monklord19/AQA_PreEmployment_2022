package com.DemoQA.SeleniumTesting.Steps;

import com.DemoQA.PageObjects.Elements.*;
import com.DemoQA.PageObjects.HomePage;
import com.DemoQA.PageObjects.Widgets.Accordion;
import com.DemoQA.PageObjects.Widgets.ToolTips;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


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
        TextBox.ValidateTheFullName("Name:TestFullName");
        //TextBox.ValidateTheEmail("Email:TestEmail@invalid.com");
        //TextBox.ValidateTheCurrentAddress("Current Address :Test Niko Street No 40");
        //TextBox.ValidateThePermanentAddress("Permanent Address :Allina Street No 122");
    }


//Scenario no.3

    @And("User selects the element <Check Box>")
    public void userSelectsTheElementCheckBox() {
        CheckBox.ClickCheckBoxButton();
    }

    @When("User clicks the check box button <Home>")
    public void userClicksTheCheckBoxButtonHome() {
        CheckBox.ClickHomeCheckBoxButton();
    }

    @Then("A response message appears on the page")
    public void aResponseMessageAppearsOnThePage() {
        CheckBox.ValidateTextCheckBox("You have selected :");
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

    @Then("A success message is displayed")
    public void aSuccessMessageIsDisplayed() {
        ToolTips.HooverContrary().getText();
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
        HomePage.ClickElementsButton();
    }

    @And("User selects the button <Text Box>")
    public void userSelectsTheButtonTextBox() {
        TextBox.ClickTextBoxButton();
    }

    @When("^User enters name in the field (.*)$")
    public void userEntersNameInTheFieldFullName(String name) {
        TextBox.EnterFullName(name);
    }

    @And("^User enters email in the field (.*)$")
    public void userEntersEmailInTheFieldEmail(String email) {
        TextBox.EnterEmail(email);
    }

    @And("^User enters current address in the field (.*)$")
    public void userEntersCurrentAddressInTheFieldCurrentAddress(String address1) {
        TextBox.EnterCurrentAddress(address1);
    }

    @And("^User enters permanent address in the field (.*)$")
    public void userEntersPermanentAddressInTheFieldPermanentAddress(String address2) {
        TextBox.EnterPermanentAddress(address2);
    }

    @And("User clicks on the button Submit")
    public void userClicksOnTheButtonSubmit() {
        TextBox.ClickSubmitTextBox();
    }

    @Then("A new box with all the entered data is displayed.")
    public void aNewBoxWithAllTheEnteredDataIsDisplayed() {
        WebElement responseScenarioOutline = driver.findElement(By.xpath("//*[@id=\"output\"]"));
        //Boolean t = TextBox.ValidateResponseScenarioOutline().isDisplayed;
        Boolean t = driver.findElement(By.xpath("//*[@id=\"output\"]")).isDisplayed();
        if (t) {
            System.out.println("Element is dispalyed");
        } else {
            System.out.println("Element is not dispalyed");
        }

    }

//Scenario No. 8
    @And("User clicks on the <Web Tables> button from the <Elements> section")
    public void userClicksOnTheWebTablesButtonFromTheElementsSection() {
        WebTables.ClickOnWebTablesButton();
    }

    @When("User user clicks on the button {string}")
    public void userUserClicksOnTheButton(String arg0) {
        WebTables.ClickOnAddButton();
    }

    @And("User adds valid First Name,Last Name, Email, Age, Salary and Department")
    public void userAddsValidFirstNameLastNameEmailAgeSalaryAndDepartment() {
        WebTables.AddTextFirstName("Anton");
        WebTables.AddTextLastName("Marinela");
        WebTables.AddTextEmail("anton.marinela@gmail.com");
        WebTables.AddTextAge("30");
        WebTables.AddTextSalary("9000");
        WebTables.AddTextDepartment("IT");
    }

    @And("user clicks the button {string}")
    public void userClicksTheButton(String arg0) {
        WebTables.ClickSubmitButton();
    }

    @Then("A new row is added to the table")
    public void aNewRowIsAddedToTheTable() {
        WebTables.FirstNameValidation("Anton");
        WebTables.LastNameValidation("Marinela");
        WebTables.AgeValidation("30");
        WebTables.EmailValidation("anton.marinela@gmail.com");
        WebTables.SalaryValidation("9000");
        WebTables.DepartmentValidation("IT");
    }


//Scenario No. 9

    @Then("User clicks the Edit button")
    public void userClicksTheEditButton() {
        WebTables.ClickOnEditButton();
    }

    @And("User modifies the Email and clicks the Submit button")
    public void userModifiesTheEmailAndClicksTheSubmitButton() {
        WebTables.EditEmailField("anton.marinela@outlook.com");
    }

    @And("checks if the email was successfully updated on the table")
    public void checksIfTheEmailWasSuccessfullyUpdatedOnTheTable() {
        WebTables.ClickSubmitButton();
        WebTables.EmailValidation("anton.marinela@outlook.com");
    }

//Scenario No. 10

    @When("User clicks on the <Buttons> element")
    public void userClicksOnTheButtonsElement() {
        Buttons.ClickButtonsElement();
    }

    @And("User clicks on the button <Click Me>")
    public void userClicksOnTheButtonClickMe() {
        Buttons.ClickOnClickMe();
    }

    @Then("A response message is displayed")
    public void aResponseMessageIsDisplayed() {
        Buttons.ClickMeValidateResponse("You have done a dynamic click");
    }


}







