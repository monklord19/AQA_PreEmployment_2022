package UITests.steps;

import UITests.pageObjects.SpotifyHome;
import UITests.pageObjects.SpotifyLogIn;
import UITests.pageObjects.SpotifyLoginApple;
import UITests.pageObjects.SpotifyLoginGmail;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SpotifyStepDef {
    WebDriver driver = new ChromeDriver();
    SpotifyHome spotifyhome = new SpotifyHome(driver);
    SpotifyLogIn spotifylogpage = new SpotifyLogIn(driver);
    SpotifyLoginApple spotifylogApplepage = new SpotifyLoginApple(driver);
    SpotifyLoginGmail spotifyloggmail = new SpotifyLoginGmail(driver);
    @Given("user navigates to login Spotify webpage")
    public void userNavigatesToLoginSpotifyWebpage() {
       driver.get("https://open.spotify.com/");
       spotifyhome.clickLogInSpotify();

    }

    //Login with Apple

    @When("user clicks on login with Apple")
    public void userClicksOnLoginWithApple() {
        spotifylogApplepage.clickAppleButton();
    }

    @And("user enters appleId as {string} and password as {string}")
    public void userEntersAppleIdAsAndPasswordAs(String user, String pass) {
        spotifylogApplepage.setAppleUser(user);
        spotifylogApplepage.clickArrowButton();
        spotifylogApplepage.setApplePass(pass);
        spotifylogApplepage.clickArrowButton();
    }

    @Then("error message pop-up {string}")
    public void errorMessagePopUp(String error) {
        spotifylogApplepage.AppleError(error);
    }


    //Login Spotify

    @When("user enters username as {string} and password as {string}")
    public void userEntersUsernameAsAndPasswordAs(String username, String password) {
        spotifylogpage.setUser(username);
        spotifylogpage.setPass(password);
        spotifylogpage.clickBtn();
    }

    @Then("error message appears {string}")
    public void errorMessageAppears(String error) {
        spotifylogpage.Error(error);
    }

//Login with Gmail
    @When("user clicks on login with Gmail")
    public void userClicksOnLoginWithGmail() {
        spotifyloggmail.clickGoogleButton();
    }

    @And("user enters gmail as {string} and password as {string}")
    public void userEntersGmailAsAndPasswordAs(String user, String pass) {
        spotifyloggmail.setGmailUser(user);
        spotifyloggmail.clickInainteButton();
        spotifyloggmail.setGmailPass(pass);
        spotifyloggmail.clickInainteButton();
    }

    @Then("error message  {string}")
    public void errorMessage(String error) {
        spotifyloggmail.GoogleError(error);
    }
}

