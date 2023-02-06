package stepsDefinitions;

import io.cucumber.java.en.*;
import locators.pageLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class MyStepsPF {
    WebDriver driver = new ChromeDriver();
    pageLocators pfm;

    @Given("User is on demoqa page")
    public void userIsOnDemoqaPage() {
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
        pfm = new pageLocators(driver);
    }

    @Given("User clicks on Elements button")
    public void userClicksOnElementsButton() {

        pfm.userClicksOnElementsButton();
    }

    @When("User clicks on Radio Button")
    public void userClicksOnRadioButton() {
        pfm.userClicksOnRadioButton();
    }

    @When("User clicks on Yes option")
    public void userCLicksOnYesOption() {
        pfm.userCLicksOnYesOption();
    }
    @Then("You have selected Yes text appears")
    public void youHaveSelectedYesTextAppears() {
        pfm.youHaveSelectedYesTextAppears();
    }

    @When("User clicks on Check Box")
    public void userClicksOnCheckBox() {
        pfm.userClicksOnCheckBox();
    }
    @When("User clicks on Home Check Box")
    public void userClicksOnHomeCheckBox() {
        pfm.userClicksOnHomeCheckBox();
    }
    @Then("You have selected Home Desktop appears")
    public void youHaveSelectedHomeDesktopAppears() {
        pfm.youHaveSelectedHomeDesktopAppears();
    }

    @When("User clicks on Buttons button")
    public void user_clicks_on_buttons_button() {
        pfm.userClicksOnButtonsButton();
    }
    @When("User clicks on Click Me button")
    public void user_clicks_on_click_me_button() throws InterruptedException {
        pfm.userCLicksOnClickMeButton();
    }
    @Then("You have done a dynamic click text appears")
    public void you_have_done_a_dynamic_click_text_appears() {
        pfm.youHaveDoneADynamicClickTextAppears();
    }

    @And("User clicks on Text Box button")
    public void userClicksOnTextBoxButton() {
        pfm.userClicksOnTextBoxButton();
    }
    @When("User fills the text boxes")
    public void userFillsTheTextBoxes() {
        pfm.userFillsTheTextBoxes();
    }
    @When("User clicks on Submit button")
    public void userClicksOnSubmitButton() {
        pfm.userClicksOnSubmitButton();
    }
    @Then("The information is confirmed")
    public void theInformationIsConfirmed() {
        pfm.theInformationIsConfirmed();
    }

    @Given("User clicks on Web Tables button")
    public void userClicksOnWebTablesButton() {
        pfm.userClicksOnWebTablesButton();
    }
    @When("User clicks on Add button")
    public void userClicksOnAddButton() {
        pfm.userClicksOnAddButton();
    }
    @When("User fills the registration form and clicks submit")
    public void userFillsTheRegistrationFormAndClicksSubmit() {
        pfm.userFillsTheRegistrationFormAndClicksSubmit();
    }
    @Then("The information is successfully added")
    public void theInformationIsSuccessfullyAdded() {
        pfm.theInformationIsSuccessfullyAdded();
    }


    @When("User clicks on Links button")
    public void userClicksOnLinksButton() {
        pfm.userClicksOnLinksButton();
    }
    @When("User clicks on Home button")
    public void userClicksOnHomeButton() {
        pfm.userClicksOnHomeButton();
    }
    @Then("New tab opens on demoqa page")
    public void newTabOpensOnDemoqaPage() {
        pfm.newTabOpensOnDemoqaPage();
    }

    @When("User clicks on BrokenLinks button")
    public void userClicksOnBrokenLinksButton() {
        pfm.userClicksOnBrokenLinksButton();
    }
    @When("User clicks on ValidLink button")
    public void userClicksOnValidLinkButton() {
        pfm.userClicksOnValidLinkButton();
    }

    @When("User clicks on UploadAndDownload button")
    public void userClicksOnUploadAndDownloadButton() {
        pfm.userClicksOnUploadAndDownloadButton();
    }
    @When("User clicks on Download button")
    public void userClicksOnDownloadButton() {
        pfm.userClicksOnDownloadButton();
    }
    @Then("Sample file is downloaded")
    public void sampleFileIsDownloaded() {
        pfm.sampleFileIsDownloaded();
    }

    @When("User clicks on DynamicsProperties button")
    public void userClicksOnDynamicsPropertiesButton() {
        pfm.userClicksOnDynamicsPropertiesButton();
    }
    @When("User clicks on enableAfter button")
    public void userClicksOnEnableAfterButton() throws InterruptedException {
        pfm.userClicksOnEnableAfterButton();
    }
    @Then("Button enableAfter is available")
    public void buttonEnableAfterIsAvailable()  {
        pfm.buttonEnableAfterIsAvailable();
    }

    @When("User clicks on DoubleClickMeButton button")
    public void userClicksOnDoubleClickMeButton() throws InterruptedException {
        pfm.userClicksOnDoubleClickMeButton();
    }

    @When("You have done a double click text appears")
    public void youHaveDoneADoubleClickTextAppears() {
        pfm.youHaveDoneADoubleClickTextAppears();
    }

}
