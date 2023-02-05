package UITests;

import PageFactory.DemoQPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.io.IOException;

import static PageFactory.ConfigReader.*;

public class DemoQSteps extends BaseTest {
    WebDriver driver = new ChromeDriver();
    DemoQPage ObjectPage = new DemoQPage(driver);

    //@Before
    public void IamOnDemoqPage(){
        String test_url = "https://demoqa.com";

        driver.manage().window().maximize();
        driver.get(test_url);

    }

    @Given("I am on TextBox page")
    public void iAmOnTextBoxPage() {
        ObjectPage.goToElementsMenu();

        ObjectPage.goToTextBoxPage();

    }

    @When("I fill all text boxex")
    public void iFillAllTextBoxex() throws IOException {
        ObjectPage.enterUserName(getUsername());
        ObjectPage.enterEmail(getEmail());
        ObjectPage.enterCurrentAdress(getCurrentAdress());
        ObjectPage.enterPermanentAdress(getPermanentAdress());


    }

    @And("Click submit button")
    public void clickSubmitButton() {
        ObjectPage.clickSubmit();
    }

    @Then("My form is displayed")
    public void myFormIsDisplayed() throws IOException {
        ObjectPage.verifyCorrectForm();
    }
    @Given("I am on buttons page")
    public void iAmOnButtonsPage() {
        ObjectPage.goToElementsMenu();
        ObjectPage.goToButtonsMenu();
    }

    @When("I perform all tipes of click")
    public void iPerformAllTipesOfClick() {
       ObjectPage.performClickButtons();

    }

    @Then("Messege is displayed")
    public void messegeIsDisplayed() {
        ObjectPage.verifyMessagesforButtons();
    }
    @Given("I am on CheckBox page")
    public void iAmOnCheckBoxpage() {
        ObjectPage.goToElementsMenu();
        ObjectPage.goToCheckBoxPage();
    }


    @When("I click plus to see more")
    public void iClickPlusToSeeMore() {
        ObjectPage.clickPlusToSeeMore();

    }

    @And("I select Classified folder")
    public void iSelectClassifiedFolder() throws InterruptedException {
        ObjectPage.selectClassifiedCheckBox();
    }
    @Then("Green message appears")
    public void greenMessageAppears() {
        WebElement element = driver.findElement(By.className("text-success"));
        String string = element.getText();
        System.out.println(string);
        Assert.assertEquals("classified", string);

    }
    @Given("I am on Select menu page")
    public void iAmOnSelectMenuPage() {
       ObjectPage.goToWidgetsMenu();
       ObjectPage.goToSelectMenu();
    }

    @When("I select multi options")
    public void iSelectMultiOptions() {

        ObjectPage.SelectMyOptionsInMenu();
    }

    @Then("Options are displayed")
    public void optionsAreDisplayed() {
        ObjectPage.verifyMyOptionsInMenu();

    }
    @Given("I am on upload-download page")
    public void iAmOnUploadDownloadPage() {
        ObjectPage.goToElementsMenu();
        ObjectPage.goToUploadMenu();
    }

    @When("I click download button")
    public void iClickDownloadButton() {
        ObjectPage.clickDownloadFile();
    }
    @And("I click upload button,I select file and click open")
    public void iClickUploadButtonISelectFileAndClickOpen() {
        ObjectPage.clickUploadFile();


    }


    @Then("File is downloaded and uploaded")
    public void fileIsDownloadedAndUploaded() {
        ObjectPage.verifyUploadedandDownloadedSuccessfull();

    }


    @Given("I am on Radio Buttons page")
    public void iAmOnRadioButtonsPage() {
        ObjectPage.goToElementsMenu();
        ObjectPage.goToRadioButtonsMenu();
    }

    @When("I select Impressive button")
    public void iSelectImpressiveButton() {
        ObjectPage.clickRadioButton();
    }

    @Then("Message Impressive is displayed")
    public void messageImpressiveIsDisplayed() {
        ObjectPage.verifyRadioButtonMessage();

    }

    @Given("I am on Progress bar page")
    public void iAmOnProgressBarPage() {
        ObjectPage.goToWidgetsMenu();
        ObjectPage.goToProgressBarMenu();
    }

    @When("I click start button")
    public void iClickStartButton() {
        ObjectPage.clickStartProgressBar();
    }

    @And("I wait for progressing")
    public void iWaitForProgressing() {
        ObjectPage.waitForProgressBar();
    }

    @Then("Progress bar is finished and reseted")
    public void progressBarIsFinishedAndReseted() {
        ObjectPage.resetProgressBar();
    }

    @Given("I am on Slider page")
    public void iAmOnSliderPage() {
        ObjectPage.goToWidgetsMenu();
        ObjectPage.goToSliderMenu();
    }

    @When("I click and move slider")
    public void iClickAndMoveSlider() throws InterruptedException {
        ObjectPage.moveSliderToEnd();

    }

    @Then("I go to end of slider")
    public void iGoToEndOfSlider() {
    ObjectPage.checkSliderValue();
    }

    @Given("I am on Accordian menu page")
    public void iAmOnAccordianMenuPage() {
        ObjectPage.goToWidgetsMenu();
        ObjectPage.goToAccordianMenu();
    }

    @When("I click on first section")
    public void iClickOnFirstSection() {
       ObjectPage.clickOnSection1Heading();
       ObjectPage.checkSection1ContentisDisplayed();
    }

    @And("I click on second section")
    public void iClickOnSecondSection() throws InterruptedException {
        ObjectPage.clickOnSection2Heading();
        ObjectPage.checkSection2ContentisDisplayed();

    }

    @And("I click on third section")
    public void iClickOnThirdSection() {
        ObjectPage.clickOnSection3Heading();

    }

    @Then("Message for third section is displayed")
    public void messageforThirdSectionIsDisplayed() {
        ObjectPage.checkSection3ContentisDisplayed();
    }


    @Given("I am on Alerts page")
    public void iAmOnAlertsPage() {
        ObjectPage.goToAlertsFrameMenu();
        ObjectPage.goToAlertsMenu();
    }

    @When("I click on alert button")
    public void iClickOnAlertButton() {
        ObjectPage.clickonAlertButton();
        ObjectPage.IacceptAllert();
    }


    @And("I click on timer alert button")
    public void iClickOnTimerAlertButton() {
        ObjectPage.clickonTimerAlertButtonandWait();
        ObjectPage.IacceptAllert();
    }

    @And("I click on confirm button")
    public void iClickOnConfirmButton() {
        ObjectPage.clickConfirmButton();
        ObjectPage.IacceptAllert();
    }

    @And("I click on prompt button and send my name")
    public void iClickOnPromptButtonAndSendMyName() {
        ObjectPage.clickPromptAllertButtonandSendmyName("AndreeaC");
    }

    @Then("I check message alert displayed")
    public void iCheckMessageAlertDisplayed() {
        ObjectPage.checkAlertMessage();
        ObjectPage.checkPromptAlertMessage();

    }

//    @After
//    public void close(){
//        driver.quit();
//    }
}
