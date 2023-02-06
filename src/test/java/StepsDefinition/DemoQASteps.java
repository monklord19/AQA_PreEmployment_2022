package StepsDefinition;

import Locators.DemoQALocators;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pageObjects.DemoQAFlow;
import utils.BaseClass;
import utils.BrowserReader;

import java.io.FileNotFoundException;
import java.io.IOException;

public class DemoQASteps extends BaseClass {

    WebDriver driver;
    DemoQAFlow demoQAFlow;


    public DemoQASteps(BrowserReader readear) {
        this.driver = readear.driver;
        demoQAFlow = new DemoQAFlow(driver);
    }

    @Given("User is on {string}")
    public void userIsOnHttpsDemoqaCom(String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }

    //steps for #1 scenario

    @Given("User clicks on Elements")
    public void userClicksOnElements() {
        demoQAFlow.clickOnElements();
    }

    @When("User click on Text Box")
    public void userClickOnTextBox() {
        demoQAFlow.clickOnTextBox();
    }

    @And("User field in inputs with his information {string},{string},{string},{string}")
    public void userFieldInInputsWithHisInformation(String fullName, String email, String currentAddress, String permanentAddress) {
        demoQAFlow.informationInput(fullName, email, currentAddress, permanentAddress);
    }

    @And("User press submit button")
    public void userPressSubmitButton() {
        demoQAFlow.submitButton();
    }

    @Then("Users information should be displayed")
    public void usersInformationShouldBeDisplayed() {
        demoQAFlow.informationDisplayed();
    }

    // steps for # 1.1 scenario
    @And("I have a JSON file containing the data to be entered into the form")
    public void iHaveAJSONFileContainingTheDataToBeEnteredIntoTheForm() throws FileNotFoundException {
        demoQAFlow.JsonFileReader();
    }

    //steps for #2 scenario
    @Given("User is on https:\\/\\/demoqa.com\\/alerts")
    public void userIsOnHttpsDemoqaComAlerts(String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }

    @When("First case #{int} {string} user clicks Click Me")
    public void firstCaseUserClicksClickMe(int arg0, String arg1) {
        demoQAFlow.clickOnFirstCase();
    }

    @Then("A pop up with You clicked a button is displayed")
    public void aPopUpWithYouClickedAButtonIsDisplayed() {
        demoQAFlow.popUpFirstCase();
    }

    @When("Second case #{int} {string} user clicks Click me")
    public void secondCaseUserClicksClickMe(int arg0, String arg1) {
        demoQAFlow.clickOnSecondCase();
    }

    @Then("A pop us with This alert appeared after {int} seconds is displayed")
    public void aPopUsWithThisAlertAppearedAfterSecondsIsDisplayed(int arg0) {
        demoQAFlow.popUpSecondCase();
    }

    @When("Third case #{int} {string} user clicks Click Me")
    public void thirdCaseUserClicksClickMe(int arg0, String arg1) {
        demoQAFlow.clickOnThirdCase();
    }

    @Then("A pop up with Do you confirm action? is displayed")
    public void aPopUpWithDoYouConfirmActionIsDisplayed() {
        demoQAFlow.popUpThirdCase();
    }

    @When("Forth case #{int} {string} user clicks Click Me")
    public void forthCaseUserClicksClickMe(int arg0, String arg1) {
        demoQAFlow.clickOnForthCase();
    }

    @Then("A pop up with Please enter your name is displayed")
    public void aPopUpWithPleaseEnterYourNameIsDisplayed() {
        demoQAFlow.popUpForthCase();
    }

    //steps for #3 scenario

    @When("User clicks on small modal button")
    public void userClicksOnSmallModalButton() {
        demoQAFlow.clickOnSmallModal();
    }

    @Then("Small modal is displayed")
    public void smallModalIsDisplayed() {
        demoQAFlow.SmallModalDisplay();
    }

    @When("User clicks on large modal button")
    public void userClicksOnLargeModalButton() {
        demoQAFlow.clickOnLargeModal();
    }

    @Then("Large modal is displayed")
    public void largeModalIsDisplayed() {
        demoQAFlow.LargeModalDisplay();
    }

    //steps for #4 scenario

    @When("User clicks on Upload and Download")
    public void userClicksOnUploadAndDownload() {
        demoQAFlow.clickOnUploadAndDownload();
    }


    @Then("User select {string} and upload a file")
    public void userSelectAndUploadAFile(String arg0) {
        demoQAFlow.selectBrowse(arg0);
    }

    @When("User selects Download")
    public void userSelectsDownload() {
        demoQAFlow.selectDownload();
    }

    @Then("User downloads a file")
    public void userDownloadsAFile() {
        demoQAFlow.fileDownloaded();
    }

    //steps for #5 scenario

    @When("User hovers over the first button")
    public void userHoversOverTheFirstButton() {
        demoQAFlow.hoverButton();
    }


    @Then("A message is displayed")
    public void aMessageIsDisplayed() {
        demoQAFlow.displayMessage();
    }

    @When("User types some text into text field")
    public void userTypesSomeTextIntoTextField() {
        demoQAFlow.typeText();
        demoQAFlow.hoverTextInput();
    }

    @When("User hovers over the first text")
    public void userHoversOverTheFirstText() {
        demoQAFlow.firstTextHovered();
    }

    @When("User hovers over the second text")
    public void userHoversOverTheSecondText() {
        demoQAFlow.secondTextHovered();
    }

    //steps for #6 scenario

    @And("the box has a starting size of {int}x{int}")
    public void theBoxHasAStartingSizeOfX(int arg0, int arg1) {

        //no method needed to be implemented
    }


    @And("the minimum size of the box is {int}x{int}")
    public void theMinimumSizeOfTheBoxIsX(int arg0, int arg1) {

        //no method needed to be implemented
    }

    @And("the maximum size of the box is {int}x{int}")
    public void theMaximumSizeOfTheBoxIsX(int arg0, int arg1) {
        //no method needed to be implemented
    }

    @When("User resize the box")
    public void iResizeTheBox() {
        demoQAFlow.resizeBox();
    }

    @Then("the box should have a size of {int}x{int}")
    public void theBoxShouldHaveASizeOfX(int width, int height) {
        demoQAFlow.checkBoxSize(width, height);
    }

    @And("the box should not be smaller than {int}x{int}")
    public void theBoxShouldNotBeSmallerThanX(int minWidth, int minHeight) {
        demoQAFlow.checkMinSize(minWidth, minHeight);
    }

    @And("the box should not be larger than {int}x{int}")
    public void theBoxShouldNotBeLargerThanX(int maxWidth, int maxHeight) {
        demoQAFlow.checkMaxSize(maxWidth, maxHeight);
    }

    //steps for #7 scenario

    @And("User selects Cursor Style")
    public void userSelectsCursorStyle() {
        demoQAFlow.clickOnCursorStyle();
    }

    @When("User drag box center box and drop it in center")
    public void userDragBoxCenterBoxAndDropItInCenter() {
        demoQAFlow.moveToCenter();
    }


    @Then("Center box should be located in the center of the page")
    public void centerBoxShouldBeLocatedInTheCenterOfThePage() {
        demoQAFlow.locatedCenter();
    }

    @When("User drag box top left and drop it in the top left of the page")
    public void userDragBoxTopLeftAndDropItInTheTopLeftOfThePage() {
        demoQAFlow.moveToTopLeft();
    }

    @Then("Top left box should be located on top left")
    public void topLeftBoxShouldBeLocatedOnTopLeft() {
        demoQAFlow.locatedTopLeft();
    }

    @When("User drag box bottm and drop it in the bottom of the page")
    public void userDragBoxBottmAndDropItInTheBottomOfThePage() {
        demoQAFlow.moveToBottom();
    }

    @Then("The bottom box should be located on bottom of the page")
    public void theBottomBoxShouldBeLocatedOnBottomOfThePage() {
        demoQAFlow.locatedBottom();
    }

    //steps for #8 scenario

    @When("User click on Select Date")
    public void userClickOnSelectDate() {
        demoQAFlow.clickOnSelectDate();
    }
    @And("User select month")
    public void userSelectMonth() {
        demoQAFlow.selectMonth();
    }
    @And("User select year")
    public void userSelectYear() {
        demoQAFlow.selectYear();
    }
    @And("User select day")
    public void userSelectDay() {
        demoQAFlow.selectDay();
    }
    @Then("User should be able to see his date of birth")
    public void userShouldBeAbleToSeeHisDateOfBirth() {
        demoQAFlow.showBirthday();
    }

    //steps for #9 scenario

    @When("User sorts books as Author")
    public void userSortsBooksAsAuthor() {
        demoQAFlow.sortAsAuthor();
    }


    @And("Search for Author name as {string}")
    public void searchForAuthorNameAs(String author) {
        demoQAFlow.searchForAuthor(author);
    }

    @And("User click on it")
    public void userClickOnIt() {
        demoQAFlow.clickByAuthor();
    }

    @Then("Informations about the book is displayed")
    public void informationsAboutTheBookIsDisplayed() {
        demoQAFlow.informationForAuthor();
    }


    @When("User sorts books as Publisher")
    public void userSortsBooksAsPublisher() {
        demoQAFlow.sortAsPublisher();
    }

    @And("Search for Publisher as {string}")
    public void searchForPublisherAs(String publisher) {
        demoQAFlow.searchForPublisher(publisher);
    }

    @And("User perform click")
    public void userPerformClick() {
        demoQAFlow.clickByPublisher();
    }


    @Then("Information displayed")
    public void informationDisplayed() {
        demoQAFlow.informationForPublisher();
    }

    //steps for #10 scenario
    @When("User click on start button")
    public void userClickOnStartButton() {
        demoQAFlow.startButton();
    }
    @Then("User should see the progress")
    public void userShouldSeeTheProgress() {
        demoQAFlow.seeProgress();
    }
    @And("Reset it to start again")
    public void resetItToStartAgain() {
        // no method needed to be implemeted
    }

}






