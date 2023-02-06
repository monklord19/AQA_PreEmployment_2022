package UITests.stepsDefinitions;

import UITests.pageObjects.PracticeFormPage;
import UITests.pageObjects.RadioButtonPage;
import io.cucumber.java.After;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.Constants;
import utils.Endpoints;

public class RadioButtonSteps {
    WebDriver driver;
    RadioButtonPage radioButtonPage;

    @Given("I navigate to Radio Button Page")
    public void navigateToPracticeFormPage() {
        driver = new ChromeDriver();
        driver.get(Constants.BASE_URL + Endpoints.RADIO_BUTTON.get());
        driver.manage().window().maximize();
        radioButtonPage = new RadioButtonPage(driver);
    }

    @And("I see the Radio Button Page opened")
    public void seeThePageOpen() {
        Assert.assertTrue(radioButtonPage.isHeaderDisplayed());
    }

    @When("I click on {string} radio button")
    public void iClickRadioButton(String radioButtonLabel) {
        radioButtonPage.clickRadioButton(radioButtonLabel);
    }

    @Then("I can see the text {string} displayed")
    public void iSeeTheText(String radioButtonLabel) {
        radioButtonPage.isOutputTextDisplayed(radioButtonLabel);
    }
}
