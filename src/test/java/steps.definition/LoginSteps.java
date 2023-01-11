package steps.definition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import page.objects.LoginFlow;
import utils.BaseClass;
import utils.BrowserReader;

public class LoginSteps{
    WebDriver driver;
    LoginFlow loginFlow;
    public LoginSteps(BrowserReader readear){
        this.driver= readear.driver;
        loginFlow = new LoginFlow(driver);

    }

    @Given("user navigates to {string}")
    public void userNavigatesTo(String url) {
        driver.get(url);
    }

    @When("user enters username as {string} and password as {string}")
    public void userEntersUsernameAsAndPasswordAs(String username, String password) {
        loginFlow.setUsername(username);
        loginFlow.setPassword(password);
    }

    @And("user clicks on login")
    public void userClicksOnLogin() {
        loginFlow.clickLogin();

    }

    @Then("Home page opens")
    public void homePageOpens() {
        loginFlow.checkHomePageOpened();
    }

    @Then("Error message is displayed")
    public void errorMessageIsDisplayed() {
        loginFlow.checkErrorBtn();

    }

    @Then("error message is displayed {string}")
    public void errorMessageIsDisplayed(String errormsg) {
        loginFlow.errorMessage(errormsg);
    }

    @And("user hits RETURN\\/ENTER key")
    public void userHitsRETURNENTERKey() {
        loginFlow.hitReturnEnteKey();
    }
}
