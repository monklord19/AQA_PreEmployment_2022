package steps;

import demopageobjects.BaseClass;
import demopageobjects.ElementPage;
import demopageobjects.MainPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class DemoSteps extends BaseClass {

    BaseClass baseClass;
    ElementPage elementPage;
    MainPage mainPage;

    public DemoSteps(BaseClass baseClass) {
        this.baseClass = baseClass;
        elementPage = new ElementPage(baseClass.getDriver());
        mainPage = new MainPage(baseClass.getDriver());
    }
    @Given("user clicks on {string} category")
    public void userClicksCategoryCard(String category) {
        mainPage.clickOnCategoryCard(category);
    }

    @When("user clicks on {string} element item")
    public void userClicksOnElementItem(String elementItem) {
        elementPage.clickOnElementItems(elementItem);
    }

    @And("user clicks on expand Home button")
    public void userClicksOnExpandHomeButton() {
        elementPage.clickOnExpandHomeButton();
    }

    @And("user clicks on {string} checkbox;")
    public void userClicksOnDownloadCheckbox(String node) {
        elementPage.clickOnCheckbox(node);
    }

    @Then("message is displayed: You have selected:{string}")
    public void messageIsDisplayed(String message) {
        Assert.assertEquals(message, elementPage.messageIsDisplayed(message));
    }

    @And("user double clicks on Double Click Me button")
    public void userDoubleClicksButton() {
        elementPage.doubleClickButtonAction();
    }

    @Then("user receives Double Click confirmation messages")
    public void userReceivesDoubleClickConfirmationMessages() {
        Assert.assertTrue(elementPage.confirmationDoubleClickMessageIsDiplayed());
    }

    @When("user right clicks on Right Click Me button")
    public void userRightClicksOnButton() {
        elementPage.rightClickButtonAction();
    }

    @Then("user receives Right Click confirmation messages")
    public void userReceivesRightClickConfirmationMessages() {
        Assert.assertTrue(elementPage.confirmationRightClickMessageIsDiplayed());
    }

    @When("user clicks on Click Me button")
    public void userClicksOnButton() {
        elementPage.clickButtonAction();
    }

    @Then("user receives Click confirmation messages")
    public void userReceivesConfirmationMessages() {
        Assert.assertTrue(elementPage.confirmationClickMessageIsDiplayed());
    }

    @And("user clicks on Add button")
    public void userClicksOnAddButton() {
        elementPage.clickOnAddButton();
    }

    @And("user fills with: {string},{string},{string},{string},{string},{string} the registration form")
    public void userFillsTheRegistrationForm(String firstName, String lastName, String email, String age, String salary, String department) {
        elementPage.fillFirstNameField(firstName);
        elementPage.fillLastNameField(lastName);
        elementPage.fillEmailField(email);
        elementPage.fillAgeField(age);
        elementPage.fillSalaryField(salary);
        elementPage.fillDepartmentField(department);
    }

    @And("user clicks submit button")
    public void userClicksSubmitButton() {
        elementPage.clickRegistrationFormSubmitButton();
    }

    @Then("new line with: {string},{string},{string},{string},{string},{string} is registered")
    public void newLineIsAdded(String firstName, String lastName, String email, String age, String salary, String department) {
        List<String> data = new ArrayList<String>();
        data.add(firstName);
        data.add(lastName);
        data.add(email);
        data.add(age);
        data.add(salary);
        data.add(department);
        for (String value : data) {
            Assert.assertTrue(elementPage.checkIfNewFormIsRegistered().contains(value));
        }
    }

    @When("user clicks the edit button from the first line")
    public void userClicksEditButtonFromTheFirstLine() {
        elementPage.clickEditButton();
    }

    @And("user edits the age with {string} years")
    public void userEditsTheAge(String age) {
        elementPage.editAge(age);
    }

    @When("user clicks delete button on second line")
    public void userClicksDeleteButtonOnSecondLine() {
        elementPage.deleteSecondLine();
    }

    @And("user clicks on Upload button")
    public void userClicksOnUploadButton() {
        elementPage.clickUploadButton();
    }

    @Then("age at first line is edited at {string}")
    public void ageAtFirstLineIsEdited(String newAge) {
        Assert.assertEquals(newAge, elementPage.checkEditedAge());
    }

    @Then("{string}'s line is erased")
    public void secondLineIsErased(String firstName) {
        Assert.assertFalse(elementPage.checkIfNewFormIsRegistered().contains(firstName));
    }

    @And("user enters {string}")
    public void userEntersPath(String path) {
        elementPage.enterPath(path);
    }

    @Then("file name {string} and path of document uploaded is displayed")
    public void pathOfDocumentUploadedIsDisplayed(String fileName) {
        Assert.assertTrue(elementPage.nameOfUploadedFile().contains(fileName));
    }

    @Then("user gets and print the outer frame text:{string}")
    public void userGetsAndPrintTheOuterFrameText(String frame) {
        Assert.assertEquals(elementPage.outerFrameText(), frame);

    }

    @And("user gets and print the inner frame text:{string}")
    public void userGetsAndPrintTheInnerFrameText(String text) {
        Assert.assertTrue(elementPage.innerFrameText().contains(text));
    }

    @And("user clicks on the simple alert button to open it")
    public void userClicksOnTheSimpleAlertButtonToOpenIt() {
        elementPage.clickToOpenAlert();
    }

    @Then("user gets the alert message and close it with OK")
    public void userGetsTheAlertMessageAndCloseItWithOK() {
        Assert.assertTrue(elementPage.alertClickMessageIsDisplayed().contains("You clicked a button"));
    }

    @When("user clicks on the timer alert button to open it")
    public void userClicksOnTheTimerAlertButtonToOpenIt() {
        elementPage.clickToOpenTimerAlert();
    }

    @Then("user gets the timer alert message and close it with OK")
    public void userGetsTheTimerAlertMessageAndCloseItWithOK() {
        Assert.assertTrue(elementPage.alertTimerMessageIsDisplayed().contains("This alert appeared after 5 seconds"));
    }

    @When("user clicks on the confirm alert button to open it")
    public void userClicksOnTheConfirmAlertButtonToOpenIt() {
        elementPage.clickToOpenConfirmationAlert();
    }

    @Then("user gets the confirm alert message and close it with Cancel")
    public void userGetsTheConfirmAlertMessageAndCloseItWithOK() {
        Assert.assertTrue(elementPage.confirmationAlertMessageIsDisplayed().contains("You selected Cancel"));
    }

    @When("user clicks on the prompt alert button to open it")
    public void userClicksOnThePromptAlertButtonToOpenIt() {
        elementPage.clickToOpenPromptAlert();
    }

    @Then("user gets the prompt alert, write {string} and close it with OK")
    public void userGetsThePromptAlertWriteRaduAndCloseItWithOK(String name) {
        Assert.assertTrue(elementPage.promptAlertMessageIsDisplayed(name).contains(name));
    }

    @Then("user adds {int} days from current date in first date field")
    public void userAddsDateInFirstDateField(int days) {
        elementPage.selectDateInPickerMonthYearInputField(days);
        ;
    }

    @And("user adds {int} days and {int} hours from current date in seconds date field")
    public void userAddsJulyPMDateAndHourInFirstDateField(int days, int hours) {
        elementPage.selectDateAndTimeInputField(days, hours);
    }

    @And("user clicks on Simple button")
    public void userClicksOnSimpleButton() {
        elementPage.clickOnSimpleButton();
    }

    @And("user drag box and drop it on drop box")
    public void userDragBoxAndDropItOnDropBox() {
        elementPage.dragAndDropBox();
    }

    @Then("user receives confirmation message on drop box:{string}")
    public void userReceivesConfirmationMessageOnDropBoxDropped(String message) {
        Assert.assertEquals(elementPage.droppedMessageIsDisplayed(),message);
    }

    @And("user clicks {string} button")
    public void userClicksGridButton(String tab) {
        elementPage.clickTabType(tab);
    }

    @And("user clicks {string}")
    public void userSelectsAnd(String itemName) {
        elementPage.selectItemOnListTab(itemName);
    }

    @Then("{string} item is active")
    public void selectedItemIsActive(String itemName) {
        Assert.assertTrue(elementPage.selectedItemIsActive(itemName).contains("active"));
    }

    @And("user clicks on select value option")
    public void userClicksOnSelectValueOption() {
        elementPage.selectValueMeniu();
    }

    @And("user selects value {string}")
    public void userSelectsValueAnotherRootOption(String value) {
        elementPage.selectValue(value);
    }

    @Then("{string} value is selected")
    public void anotherRootOptionValueIsSelected(String singleValueMessage) {
        Assert.assertEquals(elementPage.singleValueIsSelected(),singleValueMessage);
    }

    @When("user clicks on select one value option")
    public void userClicksOnSelectOneValueOption() {
        elementPage.selectOneMeniu();
    }

    @Then("{string} one value is selected")
    public void mrOneValueIsSelected(String oneValue) {
        Assert.assertEquals(elementPage.oneValueIsSelected(),oneValue);
    }

    @When("user selects color {string} in old style select menu")
    public void userSelectsColorBlueInOldStyleSelectMenu(String color) {
        elementPage.selectOldStyleSelectMenu(color);
    }

    @Then("color {string} is selected")
    public void colorBlueIsSelected(String colorSelected) {
        Assert.assertTrue(elementPage.oldStyleSelectMennuSelection(colorSelected));
    }
}
