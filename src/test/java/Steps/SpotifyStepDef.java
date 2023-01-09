package Steps;

import Pages.SpotifyPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SpotifyStepDef {
    WebDriver driver;
    SpotifyPage spotifyPage = new SpotifyPage();

    @Given("Acces the test website for testing")
    public void accesTheTestWebsiteForTesting() {
       spotifyPage.URL();

    }

    @When("Write invalid credentials and press login button")
    public void writeInvalidCredentialsAndPressLoginButton() {
       spotifyPage.enterInvalidUser("invalidUser");
       spotifyPage.enterInvalidPassword("invalidPassword");

    }

    @And("User click on loggin button")
    public void userClickOnLogginButton() {
        spotifyPage.loginButton();

    }

    @Then("Warning message appears")
    public void warningMessageAppears() {
        spotifyPage.warningMessage();
        driver.close();
    }

}

