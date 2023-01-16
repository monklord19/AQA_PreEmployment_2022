package steps;

import demoPageObjects.BaseClass;
import demoPageObjects.ElementPage;
import demoPageObjects.MainPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class DemoSteps extends BaseClass {

    MainPage mainpage = new MainPage(driver);
    ElementPage elementPage = new ElementPage(driver);

    @Given("user is on {string} page")
    public void onDemoMainPage(String url) {
        driver.manage().window().maximize();
        driver.get(url);
    }

    @When("user clicks on {string} category")
    public void userClicksCategoryCard(String category) {
        mainpage.clickOnCategoryCard(category);
    }

    @And("user clicks on {string} element item")
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

    @Then("message is diplayed: You have selected:{string}")
    public void messageIsDiplayed(String message) {
        Assert.assertEquals(message, elementPage.messageIsDisplayed(message));
    }

    @And("user double clicks on Double Click Me button")
    public void userDoubleClicksButton() {
        elementPage.doubleClickButtonAction();
    }

    @And("user right clicks on Right Click Me button")
    public void userRightClicksOnButton() {
        elementPage.rightClickButtonAction();
    }

    @And("user clicks on Click Me button")
    public void userClicksOnButton() {
        elementPage.clickButtonAction();
    }

    @Then("user receives confirmation messages")
    public void userReceivesConfirmationMessages() {
        Assert.assertTrue(elementPage.confirmationDoubleClickMessageIsDiplayed() &&
                elementPage.confirmationRightClickMessageIsDiplayed() &&
                elementPage.confirmationClickMessageIsDiplayed());
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

    @And("new line with: {string},{string},{string},{string},{string},{string} is registered")
    public void newLineIsAdded(String firstName, String lastName, String email, String age, String salary, String department) {
        List<String>data = new ArrayList<String>();
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

    @And("user clicks the edit button from the first line")
    public void userClicksEditButtonFromTheFirstLine() {
        elementPage.clickEditButton();
    }

    @And("user edits the age with {string} years")
    public void userEditsTheAge(String age) {
        elementPage.editAge(age);
    }

    @And("user clicks delete button on second line")
    public void userClicksDeleteButtonOnSecondLine() {
        elementPage.deleteSecondLine();
    }

    @And("user clicks on Upload button")
    public void userClicksOnUploadButton() {
        elementPage.clickUploadButton();
    }

    @And("age at first line is edited at {string}")
    public void ageAtFirstLineIsEdited(String newAge) {
        Assert.assertEquals(newAge,elementPage.checkEditedAge());
    }

    @And("{string}'s line is erased")
    public void secondLineIsErased(String firstName) {
        Assert.assertFalse(elementPage.checkIfNewFormIsRegistered().contains(firstName));
    }

    @And("user enters {string}")
    public void userEntersPath(String path) {
        elementPage.enterPath(path);
    }

    @And("file name {string} and path of document uploaded is displayed")
    public void pathOfDocumentUploadedIsDisplayed(String fileName) {
        Assert.assertTrue(elementPage.nameOfUploadedFile().contains(fileName));
    }
}
