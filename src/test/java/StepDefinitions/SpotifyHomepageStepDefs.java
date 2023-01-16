package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.SpotifyHomePage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpotifyHomepageStepDefs {
    WebDriver driver = new ChromeDriver();
    SpotifyHomePage spotifyHomePage = new SpotifyHomePage(driver);

    @Given("On the Spotify site")
    public void onTheSpotifySite() {
        driver.get("https://open.spotify.com/");
    }
    @Given("I click ACCEPT COOKIES")
    public void iClickACCEPTCOOKIES() {
        spotifyHomePage.clickAcceptCookies();
    }
    @When("I click Log in")
    public void iClickLogIn() {
        spotifyHomePage.clickLoginButton();
    }
    @Then("The Login - Spotify page opens")
    public void theLoginSpotifyPageOpens() {
        WebElement confirmationTextElement = driver.findElement(By.id("login-to-continue"));
        assertEquals ("To continue, log in to Spotify.", confirmationTextElement.getText());
    }

}




