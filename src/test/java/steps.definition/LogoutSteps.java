package steps.definition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import page.objects.LogOutFlow;
import utils.BaseClass;
import utils.BrowserReader;

public class LogoutSteps{
    LogOutFlow logoutFlow;
    WebDriver driver;
    public LogoutSteps(BrowserReader readear){
        this.driver= readear.driver;
        logoutFlow = new LogOutFlow(driver);

    }


    @Given("User is logged in {string}")
    public void userIsLoggedIn(String url) {
        logoutFlow.Login(
                 url,
                "standard_user",
                "secret_sauce"
        );
    }

    @When("User navigates to side menu")
    public void userNavigatesToSideMenu() {
        logoutFlow.goToSideMenu();
    }

    @And("User click on logout button")
    public void userClickOnLogoutButton() {
        logoutFlow.Logout();
    }

    @Then("User is redirected to login page")
    public void userIsRedirectedToLoginPage() {
        logoutFlow.CheckLoginPageOpened();
    }

}
