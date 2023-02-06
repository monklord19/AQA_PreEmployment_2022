package StepDefinitions;

import Pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DemoqaStepDef {

    WebDriver driver = new ChromeDriver();
    DemoqaHomepage homepage = new DemoqaHomepage(driver);
    ElementsPage elementsPage = new ElementsPage(driver);
    AlertsFrameAndWindowsPage alertsFrameAndWindowsPage = new AlertsFrameAndWindowsPage(driver);
    WidgetsPage widgetsPage = new WidgetsPage(driver);
    InteractionsPage interactionsPage = new InteractionsPage(driver);
    Actions action = new Actions(driver);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));


    @Given("User is on Demoqa website")
    public void userIsOnDemoqaWebsite() {
        System.out.println("User is on Demoqa homepage");
    }

    @When("User clicks on Elements card")
    public void userClicksOnElementsCard() {
        action.moveToElement(homepage.bookStoreApplicationCard()).perform();
        wait.until(ExpectedConditions.visibilityOf(homepage.elementsCard()));
        homepage.elementsCard().click();
    }

    @And("User clicks on Text Box from Elements category")
    public void userClicksOnTextBoxFromElementsCategory() {
        elementsPage.clickOnTextBox();
    }

    @And("User enters Full Name, Email, Current Address, Permanent Address and clicks on Submit button")
    public void userEntersFullNameEmailCurrentAddressPermanentAddressAndClicksOnSubmitButton() {
        elementsPage.setFullName();
        elementsPage.setEmail();
        elementsPage.setCurrentAddress();
        elementsPage.setPermanentAddress();
        elementsPage.moveToBrokenLinks();
        elementsPage.clickOnSubmitBtn();
    }

    @Then("Output with all details is displayed")
    public void outputWithAllDetailsIsDisplayed() {
        String outputBox = elementsPage.getOutputBoxText();
        Assertions.assertTrue(outputBox.contains("Francesca"));
    }

    @And("User clicks on Check Box from Elements category")
    public void userClicksOnCheckBoxFromElementsCategory() {
        elementsPage.clickOnCheckBox();
    }

    @And("User clicks on Home check box")
    public void userClicksOnHomeCheckBox() {
        elementsPage.clickOnHomeCheckBox();
    }

    @Then("Message with result is displayed")
    public void messageWithResultIsDisplayed() {
        String msg = elementsPage.getMsgFromCheckBox();
        Assertions.assertTrue(msg.contains("You have selected :\n" + "home\n" + "desktop\n" + "notes\n" + "commands\n" + "documents\n" + "workspace\n" + "react\n" + "angular\n" + "veu\n" + "office\n" + "public\n" + "private\n" + "classified\n" + "general\n" + "downloads\n" + "wordFile\n" + "excelFile"));
    }

    @And("User clicks on Buttons from Elements category")
    public void userClicksOnButtonsFromElementsCategory() {
        elementsPage.clickOnButtons();
    }

    @And("User double clicks on Double Click Me button")
    public void userDoubleClicksOnDoubleClickMeButton() {
        elementsPage.doubleClickOnDoubleClickBtn();
    }

    @Then("Confirmation message that user doubled clicked on button is displayed")
    public void confirmationMessageThatUserDoubledClickedOnButtonIsDisplayed() {
        String msg = elementsPage.getDoubleClickMsg();
        Assertions.assertTrue(msg.contains("You have done a double click"));
    }

    @And("User clicks on Links from Elements category")
    public void userClicksOnLinksFromElementsCategory() {
        elementsPage.clickOnLinks();
    }

    @And("User clicks on Home link")
    public void userClicksOnHomeLink() {
        elementsPage.clickOnHomeLink();
    }

    @Then("New tab is opened")
    public void newTabIsOpened() {
        driver.getWindowHandles().forEach(tab->driver.switchTo().window(tab));
        WebElement categoryCards = driver.findElement(By.cssSelector(".category-cards"));
        Assertions.assertTrue(categoryCards.isDisplayed());
    }

    @And("User clicks on Upload and Download from Elements category")
    public void userClicksOnUploadAndDownloadFromElementsCategory() {
        elementsPage.clickOnUploadAndDownload();
    }

    @And("User clicks on Choose file button and selects file")
    public void userClicksOnChooseFileButtonAndSelectsFile() {
        elementsPage.selectFile();
    }

    @Then("Name of the selected file and the path is displayed")
    public void nameOfTheSelectedFileAndThePathIsDisplayed() {
        Assertions.assertTrue(elementsPage.filePathIsDisplayed());
    }

    @When("User clicks on Alerts, Frame & Windows card")
    public void userClicksOnAlertsFrameWindowsCard() {
        action.moveToElement(homepage.bookStoreApplicationCard()).perform();
        wait.until(ExpectedConditions.visibilityOf(homepage.alertsFrameAndWindowsCard()));
        homepage.alertsFrameAndWindowsCard().click();
    }

    @And("User clicks on Browser Windows from Alerts, Frame & Windows category")
    public void userClicksOnBrowserWindowsFromAlertsFrameWindowsCategory() {
        alertsFrameAndWindowsPage.clickOnBrowserWindows();
    }

    @And("User clicks on New Window button")
    public void userClicksOnNewWindowButton() {
        alertsFrameAndWindowsPage.clickOnNewWindowBtnElem();
    }

    @Then("New window is displayed")
    public void newWindowIsDisplayed() {
        driver.getWindowHandles().forEach(window->driver.switchTo().window(window));
        String text = alertsFrameAndWindowsPage.getTextFromNewWindow();
        Assertions.assertTrue(text.contains("sample page"));
        driver.close();
    }

    @And("User clicks on Alerts from Alerts, Frame & Windows category")
    public void userClicksOnAlertsFromAlertsFrameWindowsCategory() {
        alertsFrameAndWindowsPage.clickOnAlerts();
    }

    @And("User clicks on the first Click me button")
    public void userClicksOnTheFirstClickMeButton() {
        alertsFrameAndWindowsPage.clickOnFirstClickMeBtn();
    }

    @Then("Alert box is displayed and user clicks on Ok button to close the alert box")
    public void alertBoxIsDisplayedAndUserClicksOnOkButtonToCloseTheAlertBox() {
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        Assertions.assertTrue(alertText.contains("You clicked a button"));
        alert.accept();
    }

    @When("User clicks on Widgets card")
    public void userClicksOnWidgetsCard() {
        action.moveToElement(homepage.bookStoreApplicationCard()).perform();
        wait.until(ExpectedConditions.visibilityOf(homepage.widgetsCard()));
        homepage.widgetsCard().click();
    }


    @And("User clicks on Select Menu from Widgets category")
    public void userClicksOnSelectMenuFromWidgetsCategory() {
        widgetsPage.moveToBookStore();
        widgetsPage.clickOnSelectMenu();
    }

    @And("User clicks on Select Title container from Select One option and selects Mrs.")
    public void userClicksOnSelectTitleContainerFromSelectOneOptionAndSelectsMrs() {
        widgetsPage.clickOnSelectTitleElem();
        widgetsPage.clickOnMrsOption();
    }

    @Then("Mrs. option is displayed")
    public void mrsOptionIsDisplayed() {
        String option = widgetsPage.getSelectedOptionText();
        Assertions.assertTrue(option.contains("Mrs."));
    }

    @When("User clicks on Interactions card")
    public void userClicksOnInteractionsCard() {
        action.moveToElement(homepage.bookStoreApplicationCard()).perform();
        wait.until(ExpectedConditions.visibilityOf(homepage.interactionsCard()));
        homepage.interactionsCard().click();
    }

    @And("User clicks on Droppable from Interactions category")
    public void userClicksOnDroppableFromInteractionsCategory() {
        interactionsPage.clickOnDroppable();
    }

    @And("User drags Drag me box and drops it on the Drop here box")
    public void userDragsDragMeBoxAndDropsItOnTheDropHereBox() {
       interactionsPage.dragAndDrop();
    }

    @Then("Message Dropped! is displayed inside the box")
    public void messageDroppedIsDisplayedInsideTheBox() {
        String droppedMsg = interactionsPage.getDroppedMessage();
        Assertions.assertTrue(droppedMsg.contains("Dropped!"));
    }


    @And("User clicks on Progress Bar from Widgets category")
    public void userClicksOnProgressBarFromWidgetsCategory() {
        widgetsPage.clickOnProgressBar();
    }

    @And("User clicks on Start button")
    public void userClicksOnStartButton() {
        widgetsPage.clickOnStartBtnElem();
    }

    @Then("Progress is completed and process can be reseted")
    public void progressIsCompletedAndProcessCanBeReseted() throws InterruptedException {
        widgetsPage.moveToProgress();
        Thread.sleep(12000);
        Assertions.assertTrue(widgetsPage.resetBtnIsDisplayed());

    }

}
