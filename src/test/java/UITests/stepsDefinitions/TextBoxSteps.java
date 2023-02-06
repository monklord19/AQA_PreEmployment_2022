package UITests.stepsDefinitions;

import UITests.pageObjects.TextBoxPage;
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

public class TextBoxSteps {
    WebDriver driver;
    TextBoxPage textBoxPage;

    @Given("I navigate to Text Box page")
    public void iNavigateTo() {
        driver = new ChromeDriver();
        driver.get(Constants.BASE_URL + Endpoints.TEXT_BOX.get());
        driver.manage().window().maximize();
        textBoxPage = new TextBoxPage(driver);
    }

    @And("I see the Text Box Page opened")
    public void iSeeThePageFormOpened() {
        Assert.assertTrue(textBoxPage.isHeaderDisplayed());
    }

    @And("I enter the {string}: {string}")
    public void iEnterTheFullName(String inputName, String keys) {
        textBoxPage.enterTextFor(inputName, keys);
    }

    @When("I click submit button")
    public void iClickSubmit() {
        textBoxPage.clickSubmitButton();
        textBoxPage.emailInputHasErrors();
    }

    @Then("The output should be displayed with: {string}, {string}, {string}")
    public void theOutputShouldBeDisplayed(String name, String email, String currentAddress) {
        Assert.assertTrue(textBoxPage.isOutputDisplayed(name, email, currentAddress));
    }

    @Then("The email field has errors")
    public void theEmailFieldHasErrors() {
        Assert.assertTrue(textBoxPage.emailInputHasErrors());
    }
}
