package steps;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.SpotifyHomePage;
import pages.SpotifyLoginApplePage;
import pages.SpotifyLoginPage;
import pages.*;
import java.util.concurrent.TimeUnit;


public class SpotifyLoginSteps {
    WebDriver driver = new ChromeDriver();
    SpotifyHomePage spotifyHomePage = new SpotifyHomePage(driver);
    SpotifyLoginPage spotifyLoginPage = new SpotifyLoginPage(driver);
    SpotifyLoginApplePage spotifyLoginApplePage = new SpotifyLoginApplePage(driver);


    @Given("You are on the spotify page")
    public void youAreOnTheSpotifyPage() {
        driver.get("https://open.spotify.com");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Given("Accept the cookies")
    public void acceptTheCookies() {
        spotifyHomePage.clickAcceptCookiesButton();
    }

    @And("Click login button")
    public void clickLoginButton() {
        spotifyHomePage.clickLoginButton();
    }

    @When("enter wrong username {string} and invalid password {string}")
    public void enterWrongUsernameAndInvalidPassword(String username, String password) {
        spotifyLoginPage.setUsernameField(username);
        spotifyLoginPage.setPasswordField(password);
    }

    @And("Click the conecteaza-te button")
    public void clickTheConecteazaTeButton() {
        spotifyLoginPage.clickConnectButton();
    }

    @Then("Error is displayed {string}")
    public void errorIsDisplayed(String error) {
        spotifyLoginPage.assertError(error);
    }

    //sc2
    @And("Click on continue with apple")
    public void clickOnContinueWithApple() {
        spotifyLoginPage.clickAppleButton();
    }

    @When("Enter wrong Apple id {string} and click continue")
    public void enterWrongAppleIdAndClickContinue(String arg0) {
        spotifyLoginApplePage.setAppleIdField(arg0);
        spotifyLoginApplePage.clickInButton();
    }

    @And("enter invalid password {string} and click continue")
    public void enterInvalidPasswordAndClickContinue(String arg0) {
        spotifyLoginApplePage.setPassfield(arg0);
        spotifyLoginApplePage.clickInButton();
    }

    @Then("the error is displayed {string}")
    public void theErrorIsDisplayed(String arg0) {
        spotifyLoginApplePage.checkTheError(arg0);
    }


}
