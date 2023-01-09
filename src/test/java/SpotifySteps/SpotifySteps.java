package SpotifySteps;

import SpotifyPages.GmailLogin;
import SpotifyPages.SpotifyLogin;
import SpotifyPages.MainPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SpotifySteps {
    WebDriver driver = new ChromeDriver();

    MainPage spotifyMainPage = new MainPage(driver);

    SpotifyLogin spotifyLoginPage = new SpotifyLogin(driver);

    GmailLogin gmailLoginPage = new GmailLogin(driver);

    @Given("user is on the main page")
    public void onSpotifyPage() {
        driver.get("https://www.spotify.com/");
    }

    @And("user closes cookie")
    public void userClosesCookie() {
        spotifyMainPage.closeCookie();
    }

    @And("user goes to login page")
    public void userGoesToLoginPage() {
        spotifyMainPage.clickLogin();
    }

    @When("user clicks continue with Google")
    public void clickContinueWithGoogle() {
        spotifyLoginPage.continueWithGoogle();
    }

    @And("user enters {string} characters in username field")
    public void userEntersGmailAccountinUsernameField(String username) {
        gmailLoginPage.setGmailUsername(username);
    }

    @And("user clicks on Gmail login button")
    public void clicksOnGmailLoginButton() {
        gmailLoginPage.clickOnLoginGmailButton();
    }

    @Then("error message is displayed")
    public void userReceivesErrorMessage() {
        Assert.assertTrue(gmailLoginPage.messageAccountNotFoundDisplayed());
    }

    @When("user enters {string} in Spotify username field")
    public void userEntersSpotifyUsername(String username) {
        spotifyLoginPage.setSpotifyUsername(username);
    }

    @And("user enters {string} in Spotify password field")
    public void userEntersSpotifyPassword(String password) {
        spotifyLoginPage.setSpotifyPassword(password);
    }

    @And("user clicks on Spotify login button")
    public void clickLoginButton() {
        spotifyLoginPage.clickSpotifyLoginButton();
    }

    @Then("invalid username and password message is displayed")
    public void messageIsDisplayedInvalidUsernameOrPassword() {
        Assert.assertTrue(spotifyLoginPage.errorMessageIsDisplayed());
    }
}
