package steps;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import spotifyLoginPageObjects.*;

public class SpotifyLoginSteps extends BaseClass {

    SpotifyMainPage spotifyMainPage = new SpotifyMainPage(driver);

    SpotifyLoginPage spotifyLoginPage = new SpotifyLoginPage(driver);

    GmailLoginPage gmailLoginPage = new GmailLoginPage(driver);

    FacebookLoginPage facebookLoginPage = new FacebookLoginPage(driver);

    AppleLoginPage appleLoginPage = new AppleLoginPage(driver);

    @Given("user is on {string} page")
    public void onSpotifyPage(String url) {
        driver.get(url);
    }

    @And("user closes cookie")
    public void userClosesCookie() throws InterruptedException {
        spotifyMainPage.closeCookie();
    }

    @And("user goes to login page")
    public void userGoesToLoginPage() throws InterruptedException {
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

    @Then("inccorect username and password message is displayed")
    public void messageIsDisplayedIncorrectUsernameOrPassword() {
        Assert.assertTrue(spotifyLoginPage.errorMessageIsDisplayed());
    }

    @When("user click continue with Facebook")
    public void userClickContinueWithFacebook() {
        spotifyLoginPage.continueWithFacebook();
    }

    @And("user accept cookies")
    public void userAcceptCookies() {
        facebookLoginPage.acceptCookie();
    }

    @And("user enters {string} in Facebook username field")
    public void userEntersFacebookUsername(String username) {
        facebookLoginPage.setFacebookUsername(username);
    }

    @And("user enters {string} in Facebook password field")
    public void userEntersFacebookPassword(String password) {
        facebookLoginPage.setFacebookPassword(password);
    }

    @And("user clicks on Facebook login button")
    public void userClicksOnFacebookLoginButton() {
        facebookLoginPage.clickLogin();
    }

    @Then("not account message is displayed")
    public void notAccountMessageIsDisplayed() {
        Assert.assertTrue(facebookLoginPage.notAccountMessageIsDisplayed());
    }

    @When("user click continue with Apple")
    public void userClickContinueWithApple() {
        spotifyLoginPage.continueWithApple();
    }

    @And("user enters {string} in Apple username field")
    public void userEntersAppleUsername(String username) {
        appleLoginPage.setAppleUsername(username);
    }

    @And("user clicks submit button")
    public void userClicksUsernameSubmitButton() {
        appleLoginPage.clicksSigninButton();
    }

    @And("user enters {string} in Apple password field")
    public void userEntersApplePassword(String password) {
        appleLoginPage.setApplePassword(password);
    }

    @And("user get alert message")
    public void userGetErrorMessage() {
        Assert.assertTrue(appleLoginPage.alertMessageIsDisplayed());
    }

    @And("error message is: {string}")
    public void errorMessageIsThisAppleIDHasBeenLockedForSecurityReasons(String message) {
        Assert.assertEquals(message,appleLoginPage.getTextMessage());
    }
}
