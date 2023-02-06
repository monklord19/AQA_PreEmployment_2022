package UITests.stepsDefinitions;

import UITests.pageObjects.ButtonsPage;
import UITests.pageObjects.PracticeFormPage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.Constants;
import utils.Endpoints;

public class ButtonsSteps {

    WebDriver driver;
    ButtonsPage buttonsPage;

    @Given("I navigate to Buttons Page")
    public void navigateToPracticeFormPage(){
        driver = new ChromeDriver();
        driver.get(Constants.BASE_URL + Endpoints.BUTTONS.get());
        driver.manage().window().maximize();
        buttonsPage = new ButtonsPage(driver);

    }


    @And("I see the Buttons Page opened")
    public void seeThePageOpen(){
        Assert.assertTrue(buttonsPage.isHeaderDisplayed());
    }

    @When("I double click the button")
    public void doubleClickTheButton() {
        buttonsPage.doubleClickButton();
    }

    @Then("I can see double click message displayed")
    public void doubleClickMessageDisplayed() {
        Assert.assertTrue(buttonsPage.isDoubleClickMessageDisplayed());
    }

    @When("I right click the button")
    public void rightClickTheButton() {
        buttonsPage.rightClickButton();
    }

    @Then("I can see right click message displayed")
    public void rightClickMessageDisplayed() {
        Assert.assertTrue(buttonsPage.isRightClickMessageDisplayed());
    }
}

