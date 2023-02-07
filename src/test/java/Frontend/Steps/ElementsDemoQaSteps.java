package Frontend.Steps;

import Frontend.PageObjects.ElementsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;

public class ElementsDemoQaSteps extends TestBase{
    private ElementsPage elementsPage = PageFactory.initElements(driver, ElementsPage.class);

    @And("I click on elements section")
    public void iClickOnElementsSection() {
        elementsPage.clickOnElementsSection();
    }

    // SELECT RADIO BUTTON SCENARIO
    @And("I click on Radio Button category")
    public void i_am_click_on_radio_button_category() {
        elementsPage.clickOnRadioButtonSection();

    }

    @When("I click on Impressive radio button")
    public void i_click_on_impressive_radio_button() {
        elementsPage.clickOnImpressiveRadioButton();

    }

    @Then("A message is displayed")
    public void the_message_is_displayed() {
        elementsPage.assertImpressiveMessage();

    }

    //HOME CHECKBOX SCENARIO
    @And("I click on CheckBox category")
    public void iClickOnCheckBoxCategory() {
        elementsPage.clickOnCheckBoxSection();
    }

    @When("I tick the Home checkbox")
    public void iTickTheHomeCheckbox() {
        elementsPage.clickOnHomeCheckbox();
    }

    @Then("You have selected message is displayed")
    public void youHaveSelectedMessageIsDisplayed() {
        elementsPage.assertHomeCheckboxMessage();
    }

    //TEXT BOX SCENARIO
    @And("I click on TextBox category")
    public void iClickOnTextBoxCategory() {
        elementsPage.clickOnTextBoxSection();
    }

    @When("I input all the text fields with all valid values")
    public void iInputAllTheTextFieldsWithAllValidValues() {
        elementsPage.fillingAllTextFieldsWithValidValues();
    }

    @Then("Submit button is clickable")
    public void submitButtonIsClickable() {
        elementsPage.clickSubmitButton();
    }

    @And("The values that I entered are displayed")
    public void theValuesThatIEnteredAreDisplayed() {
        elementsPage.assertTextBoxSection();
    }

    //WEB TABLES SCENARIO
    @And("I click on Web Tables category")
    public void iClickOnWebTablesCategory() {
        elementsPage.clickOnWebTablesSection();
    }

    @When("I add a User with all the necessary info")
    public void iAddAUserWithAllTheNecessaryInfo() {
        elementsPage.addAUserWithAllInfo();
    }

    @And("I click on Submit button")
    public void iClickOnSubmitButton() {
        elementsPage.clickSubmitButton();
    }

    @And("I search the User by First Name")
    public void iSearchTheUserByFirstName() {
        elementsPage.searchUserByFirstName();
    }

    @Then("The user is displayed on the Web Table")
    public void theUserIsDisplayedOnTheWebTable() throws InterruptedException {
        elementsPage.assertUserIsDisplayedOnWebTables();
    }

    //DOUBLE CLICK BUTTON SCENARIO
    @And("I click on Buttons category")
    public void iClickOnButtonsCategory(){
        elementsPage.clickOnButtonsCategory();
    }
    @When("I double click on Double click me button")
    public void iDoubleClickOnDoubleClickMeButton() throws InterruptedException {
        elementsPage.doubleClickButton();
    }

    @Then("The double click me message is displayed")
    public void theDoubleClickMeMessageIsDisplayed() {
        elementsPage.assertDoubleClickMessage();
    }
    //RIGHT CLICK BUTTON SCENARIO

    @When("I right click on Right click me button")
    public void iRightClickOnRightClickMeButton() throws InterruptedException {
        elementsPage.rightClickButton();
    }

    @Then("The right click me message is displayed")
    public void theRightClickMeMessageIsDisplayed() {
        elementsPage.assertRightClickMessage();
    }

    //UPLOAD FILE SECTION
    @And("I click on Upload and Download Section")
    public void iClickOnUploadAndDownloadSection() throws InterruptedException {
        elementsPage.clickOnUploadAndDownloadSection();
    }
    @When("I upload a file")
    public void iUploadAFile() throws InterruptedException {
        elementsPage.iUploadAFile();
    }
    @Then("File is uploaded")
    public void fileIsUploaded() {
        elementsPage.assertFileIsUploaded();
    }

    //LINKS WITH NEW TAB OPEN
    @And("I click on links section")
    public void iClickOnLinksSection() throws InterruptedException {
        elementsPage.clickOnLinksSection();
    }

    @When("I click on Home link")
    public void iClickOnHomeLink() throws InterruptedException {
        elementsPage.clickOnHomeLink();
    }
    @Then("DemoQa main page is opened")
    public void demoqaMainPageIsOpened() throws InterruptedException {
        elementsPage.switchToTab();
        elementsPage.assertOpenedTab();
    }



}
