package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

public class DemoQaSteps {
    WebDriver driver = new ChromeDriver();
    DemoPage demoPage = new DemoPage(driver);
    TextBoxPage textBoxPage = new TextBoxPage(driver);
    DemoElementsPage demoElementsPage = new DemoElementsPage(driver);
    CheckBoxPage checkBoxPage = new CheckBoxPage(driver);
    WebTablesPage webTablesPage = new WebTablesPage(driver);
    PracticeFormPage practiceFormPage =new PracticeFormPage(driver);
    FormsPage formsPage = new FormsPage(driver);
    @Before
    public void maxPage() {
        driver.manage().window().maximize();
    }

//    @After
//    public void closePage() {
//
//        driver.quit();
//    }

    @Given("You are on the demoQa page")
    public void youAreOnTheDemoQaPage() {
        driver.get("https://demoqa.com/");
    }

    @Given("User Clicks on Text box")
    public void clickOnTheTextBoxLink() {
        demoPage.clickOnElelments();
        demoElementsPage.clickTextBoxLink();
    }

    @And("Complete the full name field with {string} and the email field with {string}")
    public void completeTheFullNameFieldWithAndTheEmailFieldWith(String fullName, String email) {
        textBoxPage.setFullNameField(fullName);
        textBoxPage.setEmailField(email);
    }


    @And("Complete the current address with {string} and  the permanent address with {string}")
    public void completeTheCurrentAddressWithAndThePermanentAddressWith(String currentAddress, String permanentAddress) {
        textBoxPage.setCurrentAddressField(currentAddress);
        textBoxPage.setPermanentAddressField(permanentAddress);
    }


    @When("Click the Submit button")
    public void clickTheSubmitButton() {
        textBoxPage.clickSubmitButton();
    }


    @Then("The information field will be displayed")
    public void theInformationFieldWillBeDisplayed() {
        textBoxPage.checkInfoBox();
    }
//Test 2

    @Given("Click on Check box")
    public void clickOnCheckBox() {
        demoPage.clickOnElelments();
        demoElementsPage.clickCheckBox();
    }

    @And("Click on expand all button")
    public void clickOnExpandAllButton() {
        checkBoxPage.clickExpandButton();
    }

    @When("Select React, Angular,Veu")
    public void selectReactAngularVeu() throws InterruptedException {
        checkBoxPage.clickTheCheckBoxes();
    }

    @Then("The specific select message should be displayed")
    public void theSpecificSelectMessageShouldBeDisplayed() {
        checkBoxPage.checkResultForm("You have selected :\n" + "workspace\n" + "react\n" + "angular\n" + "veu");
    }

    //test 3
    @Given("Click web tables")
    public void clickWebTables() {
        demoPage.clickOnElelments();
        demoElementsPage.clickWebTables();
    }

    @And("Click Add button")
    public void clickAddButton() {
        webTablesPage.clickAddButton();
    }

    @And("Fill the Registration form")
    public void fillTheRegistrationForm() {
        webTablesPage.setFirstNameField("Jonny");
        webTablesPage.setLastNameField("Mellow");
        webTablesPage.setEmailField("jonny@gmail.com");
        webTablesPage.setAgeField("50");
        webTablesPage.setSalaryField("5000");
        webTablesPage.setDepartmentField("first department");
    }

    @And("Click the Submit")
    public void clickTheSubmit() {
        webTablesPage.clickSubmitButton();
    }

    @When("Search for  the new person in the table")
    public void searchForTheNewPersonInTheTable() {
        webTablesPage.searchFieldFindJonny("Jonny");
    }

    @And("Check if the registration was a success")
    public void checkIfTheRegistrationWasASuccess() {
        webTablesPage.checkToFindJonny();
    }

    @Then("Click delete button for the new registration")
    public void clickDeleteButtonForTheNewRegistration() {
        webTablesPage.deleteJonnyProfile();
    }
//test 4
    @Given("Click on practice form")
    public void clickOnPracticeForm() {
        demoPage.clickFormLink();
        formsPage.clickPracticeForm();

    }


    @And("Fill out the register form")
    public void fillOutTheRegisterForm() throws InterruptedException {
        practiceFormPage.setFirstNameField("Jonny");
        practiceFormPage.setLastNameField("Boy");
        practiceFormPage.setEmailField("jonnyboy@gmds.com");
        practiceFormPage.selectMaleCheckBox();
        practiceFormPage.setPhoneNumberField("1234567890");
        practiceFormPage.checkDate();
        practiceFormPage.setSubjectField("literature");
        practiceFormPage.chooseHobbies();
        practiceFormPage.chooseProfilePic();
        practiceFormPage.setCurrentAddressField("ceva adressa acolo mnoo");
//        practiceFormPage.clickStateDropDown();
    }

    @When("Click submit button")
    public void clickSubmitButton() {
        practiceFormPage.clickSubmitButton();
    }

    @Then("Check the Thanks message")
    public void checkTheThanksMessage() {
        practiceFormPage.checkThanksText();
    }
}
