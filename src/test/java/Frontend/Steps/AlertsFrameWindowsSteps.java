package Frontend.Steps;

import Frontend.PageObjects.AlertsFramesWindowsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;

public class AlertsFrameWindowsSteps extends TestBase{
    private AlertsFramesWindowsPage alertsPage = PageFactory.initElements(driver, AlertsFramesWindowsPage.class);
    @And("I click on Alerts,Frames & Windows section")
    public void iClickOnAlertsFramesWindowsSection() {
        alertsPage.clickOnAlertsFrameWindowsSection();
    }

    @And("I click on alerts section")
    public void iClickOnAlertsSection() throws InterruptedException {
        alertsPage.clickOnAlertsSection();
        alertsPage.clickOnAlertsSection();
    }

    @When("I click on click me button that opens a prompt box")
    public void iClickOnClickMeButtonThatOpensAPromptBox() throws InterruptedException {
        alertsPage.clickOnClickMeButtonForPromptBox();
    }

    @Then("Prompt box that require to enter my name appears")
    public void promptBoxThatRequireToEnterMyNameAppears() {
        alertsPage.switchToAlertBox();
    }

    @When("I enter my name and click ok")
    public void iEnterMyNameAndClickOk() {
        alertsPage.sendKeysToAlertBox();
    }

    @Then("My name is successfully entered")
    public void myNameIsSuccessfullyEntered() {
        alertsPage.assertSuccessMessage();
    }
}
