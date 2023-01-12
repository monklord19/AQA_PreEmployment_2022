package UITests.stepsDefinitions;

import UITests.pageObjects.FacebookLoginSpotifyPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class SpotifyFacebookLogin extends SpotifyDefinitions {

    FacebookLoginSpotifyPage facebookLoginSpotifyPage;

    @And("Facebook login page is displayed")
    public void openSpotifyLoginPage() throws InterruptedException {
        facebookLoginSpotifyPage = new FacebookLoginSpotifyPage(driver);
        Thread.sleep(5000);
        Assert.assertTrue(facebookLoginSpotifyPage.isFacebookLogoDisplayed());
    }

    @And("User enters facebook username {word}")
    public void userEntersFacebookUsername(String keys) {
        facebookLoginSpotifyPage.sendKeysTo(facebookLoginSpotifyPage.facebookUsernameInput, keys);

    }

    @And("User enters facebook password {word}")
    public void userEntersFacebookPassword(String keys) {
        facebookLoginSpotifyPage.sendKeysTo(facebookLoginSpotifyPage.facebookPasswordInput, keys);
    }

    @And("User clicks on Facebook login button")
    public void userEntersFacebookPassword() {
        facebookLoginSpotifyPage.submitLogin();
    }

    @Then("Spotify main page should be displayed")
    public void spotifyMainPageDisplayed() throws InterruptedException {
        wait(10000);
        Assert.assertTrue(facebookLoginSpotifyPage.isSpotifyPageDisplayed());
    }
}







