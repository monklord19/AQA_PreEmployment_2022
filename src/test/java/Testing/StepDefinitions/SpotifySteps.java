package Testing.StepDefinitions;

import Testing.Locators.SpotifyLocators;
import Testing.pageobjects.SpotifyPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.Testing.AppConfig;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SpotifySteps extends TestBase {
    private SpotifyPage spotifyPage = PageFactory.initElements(driver, SpotifyPage.class);
    private SpotifyLocators spotifyLocators = PageFactory.initElements(driver, SpotifyLocators.class);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    //Background
    @Given("User opens spotify site")
    public void userOpensSpotifySite() {
        driver.get(AppConfig.getSiteUrl());
    }

    @And("User click on spotify LogIn button")
    public void userClickOnSpotifyLogInButton() {
        spotifyPage.acceptSpotifyCookies();
        spotifyPage.clickSpotifyLogin();
    }

    //Login with facebook
    @When("User click on continue with facebook button")
    public void userClickOnContinueWithFacebookButton() {
        spotifyPage.continueWithFacebook();
    }

    @And("User enters a valid email and invalid password")
    public void validEmailInvalidPassword() {
        spotifyPage.setFacebookEmail();
        spotifyPage.setFacebookPassword();
        spotifyPage.clickFbLoginBtn();
    }

    @Then("An error message is displayed")
    public void errorMessage() {
        spotifyPage.errorMsgFb();
    }

    //Login with Google
    @When("User click on continue with google button")
    public void userClickOnContinueWithGoogleButton() {
        spotifyPage.continueWithGoogle();
    }

    @And("User enters valid email")
    public void userEntersValidEmail() {
        spotifyPage.setGoogleEmail();
    }

    @And("user click on next button")
    public void userClickOnNextButton() {
        spotifyPage.nextBtnGoogle();
    }

    @And("User enters invalid password")
    public void userEntersInvalidPassword() {
        spotifyPage.setGooglePassword();
    }

    @Then("error message is displayed")
    public void errorMessageIsDisplayed() {
        spotifyPage.errorMsgGoogle();
    }
//invalid login with spotify
    @When("User enters valid email and invalid password")
    public void userEntersValidEmailAndPassword() {
        spotifyPage.setSpotifyEmail();
        spotifyPage.setSpotifyPassword();
    }

    @And("user click on Login button")
    public void userClickOnLoginButton() {
        spotifyPage.spotifyLoginBtn();
    }

    @Then("error message appears")
    public void errorMessageIsDisplayedOnSpotify() {
        spotifyPage.errorMsgSpotify();
    }

    //Invalid login with Apple account
    @When("User click on continue with apple")
    public void userClickOnContinueWithApple() {
        spotifyPage.continueWithApple();
    }

    @And("User fill in the Apple ID")
    public void userFillInTheAppleID() {
        spotifyPage.setAppleID();
    }

    @And("User click next arrow")
    public void userClickNextArrow() {
        spotifyPage.clickSignInAppleBtn();
    }

    @And("User fill in the password field")
    public void userFillInThePasswordField() {
        spotifyPage.setApplePassword();
    }

    @Then("User is not logged and error is displayed")
    public void userIsNotLoggedAndErrorIsDisplayed() {
       // spotifyPage.errorMsgApple();
        Object expected = AppConfig.getErrorApple();
        Object actual=spotifyLocators.getAppleError();
        spotifyPage.assertErrorMessage(expected, actual);
    }

}
