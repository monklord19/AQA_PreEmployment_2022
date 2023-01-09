package StepDefinition;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import Base.BaseClass;
import java.sql.Driver;
import java.sql.Time;
import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import Objects.Spotify;

public class SpotityLoginSteps {

    WebDriver driver = new ChromeDriver();
    Spotify spotify = new Spotify(driver);;

    @Given("user gets to {string}")
    public void userGetsTo(String url) {
        driver.get(url);
    }
    
    @And("user click on Log in button")
    public void userClickOnLogInButton() {
        spotify.clickLoginButton();
    }


    @And("user accepts cookies")
    public void userAcceptsCookies() {
        spotify.acceptCookies();
    }

    @Then("user enter username as {string} and password as {string}")
    public void userEnterUsernameAsAndPasswordAs(String user, String pass) {
        spotify.enterUser(user);
        spotify.enterPass(pass);
    }

    @And("user click Log in with Spotify")
    public void userClickLogInWithSpotify() {
        spotify.loginSpotify();
    }

    @Then("pop up appears containing{string}")
    public void popUpAppearsContaining(String SpotifyError) {
        spotify.throwErrMessage(SpotifyError);
    }

    @When("user click on Continue with Google button")
    public void userClickOnContinueWithGoogleButton() {
        spotify.continueWithGoogle();
    }

    @And("user enters emailAdress as {string} and password as {string}")
    public void userEntersEmailAdressAsAndPasswordAs(String email, String pass) {
        spotify.enterGoogleEmail(email);
        spotify.enterGoogleEmail(pass);
    }

    @And("user click on Login with google")
    public void userClickOnLoginWithGoogle() {
        spotify.signWithGoogle();
    }


    @Then("pop up appears {string}")
    public void popUpAppears(String googleError) {
        spotify.throwErrMessage(googleError);
    }
}
