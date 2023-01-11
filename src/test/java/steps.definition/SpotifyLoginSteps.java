package steps.definition;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import page.objects.SpotifyFlow;
import io.cucumber.java.en.*;
import utils.BrowserReader;
import utils.DataUtil;


public class SpotifyLoginSteps{

    SpotifyFlow spotifyFlow;
    WebDriver driver;


    public SpotifyLoginSteps(BrowserReader readear) {
        this.driver = readear.driver;
        spotifyFlow = new SpotifyFlow(driver);

    }

    @Given("User navigates to Spotify {string}")
    public void userNavigatesToSpotify(String spotifyURL) {
        driver.get(spotifyURL);

    }

    @And("User accepts cookies")
    public void userAcceptsCookies() {
        spotifyFlow.cookies();
    }

    @And("User click on Log in button")
    public void userClickOnLogInButton() {
        spotifyFlow.clickOnLoginButton();

    }

    @When("User types username as {string} and password as {string}")
    public void userTypesUsernameAsAndPasswordAs(String username, String password) {
        spotifyFlow.typeUsername(username);
        spotifyFlow.typesPassword(password);

    }

    @And("User clicks Log in with Spotify")
    public void userClicksLogInWithSpotify() {
        spotifyFlow.loginSpotify();
    }

    @Then("Error message pops up as {string}")
    public void errorMessagePopsUpAs(String errorMsg) {
        spotifyFlow.throwErrorMsg(errorMsg);

    }

    @When("User clicks on Continue with Google")
    public void userClicksOnContinueWithGoogle() {
        spotifyFlow.continueWithGoogle();

    }

    @And("User types emailAdress as {string} and password as {string}")
    public void userTypesEmailAdressAsAndPasswordAs(String emailGoogle, String googlePassword) throws InterruptedException {
        spotifyFlow.typesGoogleEmail(emailGoogle);
        spotifyFlow.typesGooglePassword(googlePassword);

    }

    @And("User clicks on Login with google")
    public void userClicksOnLoginWithGoogle() {
        spotifyFlow.signInWithGoogle();

    }

    @Then("An error message pops us as {string}")
    public void anErrorMessagePopsUpAs(String googleErrorMsg) {
        spotifyFlow.throwGoogleErrorMsg(googleErrorMsg);
    }

    @When("User click on Continue with Facebook")
    public void userClickOnContinueWithFacebook() {
        spotifyFlow.continueWithFacebook();

    }
    @And("User waits for cookies to be accepted")
    public void userWaitsForCookiesToBeAccepted() {
        spotifyFlow.acceptFacebookCookies();
    }


    @And("User enters username as {string} and password as {string}")
    public void userEntersUsernameAsAndPasswordAs(String facebookId, String facebookPassword) {
        spotifyFlow.enterFacebookUsername(facebookId);
        spotifyFlow.enterFacebookPassword(facebookPassword);

    }

    @And("User click on Log in")
    public void userClickOnLogIn() {
        spotifyFlow.logInFacebook();

    }

    @Then("Error an error message is displayed as {string}")
    public void errorAnErrorMessageIsDisplayedAs(String facebookError) {
        spotifyFlow.throwFacebookErrorMsg(facebookError);
    }


    @When("User click on Continue with Apple")
    public void userClickOnContinueWithApple() {
        spotifyFlow.continueWithApple();
        
    }
    @And("User enters appleId as {string} and password as {string}")
    public void userEntersAppleIdAsAndPasswordAs(String appleId, String applePassword) {
        spotifyFlow.userTypesAppleId(appleId);
        spotifyFlow.proccedToPasswordField();
        spotifyFlow.userTypesApplePassword(applePassword);

    }

    @Then("An error message is displayed as {string}")
    public void anErrorMessageIsDisplayedAs(String appleError) {
        spotifyFlow.throwAppleErrorMsg(appleError);
    }


}
