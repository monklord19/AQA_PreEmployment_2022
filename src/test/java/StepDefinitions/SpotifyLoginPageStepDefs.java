package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.SpotifyLoginPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SpotifyLoginPageStepDefs {
    WebDriver driver = new ChromeDriver();
    SpotifyLoginPage spotifyLoginPage = new SpotifyLoginPage(driver);

    @Given("On the Spotify Login page")
    public void onTheSpotifyLoginPage() {
        driver.get("https://accounts.spotify.com/en/login");
    }

    @When("I enter invalid username and password")
    public void iEnterInvalidUsernameAndPassword() {
        spotifyLoginPage.setUsernameField("Invalid Username");
        spotifyLoginPage.setPasswordField("Invalid Password");
    }

    @And("I click Log in button")
    public void iClickLogInButton() {
        spotifyLoginPage.clickLoginButton();
    }

    @Then("I am unable to log in and error message is displayed")
    public void iAmUnableToLogInAndErrorMessageIsDisplayed() {
        assertTrue (driver.getPageSource().contains("Incorrect username or password."));
    }

}
