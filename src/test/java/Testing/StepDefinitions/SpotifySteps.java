package Testing.StepDefinitions;

import Testing.pageobjects.SpotifyLoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.Testing.AppConfig;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SpotifySteps extends TestBase {
    private SpotifyLoginPage spotify = PageFactory.initElements(driver, SpotifyLoginPage.class);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @Given("User opens spotify site")
    public void userOpensSpotifySite() {
        driver.get(AppConfig.getSiteUrl());
    }

    @And("User click on spotify LogIn button")
    public void userClickOnSpotifyLogInButton() {
        wait.until(ExpectedConditions.visibilityOf(spotify.getBtn_spotifyAcceptCookies()));
        spotify.getBtn_spotifyAcceptCookies().click();
        spotify.getBtn_SpotifyLogin().click();
    }
    @When("User click on continue with facebook button")
    public void userClickOnContinueWithFacebookButton() {
        spotify.getBtn_continueWithFB().click();
        wait.until(ExpectedConditions.visibilityOf(spotify.getBtn_fb_allowCookies()));
        spotify.getBtn_fb_allowCookies().click();
    }
    @And("User enters a valid email as {string} and invalid password as {string}")
    public void userEntersAValidEmailAsMada_linaYahooComAndInvalidPasswordAsTest(String email, String pwd) {
        spotify.getTxt_fb_emailField().sendKeys(email);
        spotify.getTxt_fb_passField().sendKeys(pwd);
        spotify.getBtn_fb_Login().click();
    }
    @Then("The error message is displayed {string}")
    public void errorMessage(String errMsg) {
        Assert.assertEquals(spotify.getFb_errMsg().getText(), errMsg);
    }

    @When("User click on continue with google button")
    public void userClickOnContinueWithGoogleButton() {
        spotify.getBtn_continueWithGoogle().click();
    }

    @And("User enters valid email as {string}")
    public void userEntersValidEmailAsMada_linaYahooCom(String email) {
        spotify.getTxt_GoogleEmail().sendKeys(email);
    }

    @And("user click on next button")
    public void userClickOnNextButton() {
        spotify.getBtn_GoogleNextEmail().click();
    }

    @And("User enters invalid password as {string}")
    public void userEntersInvalidPasswordAsTestAndClickOnNextButton(String pwd) {
        spotify.getTxt_GooglePassword().sendKeys(pwd);
    }

    @Then("error message is displayed {string}")
    public void errorMessageIsDisplayed(String googleErr) {
        Assert.assertEquals(spotify.getGoogle_errMsg().getText(),googleErr);
    }

    @When("User enters valid email as {string} and invalid password as {string}")
    public void userEntersValidEmailAndPassword(String email, String pwd) {
        spotify.getTxt_spotifyEmail().sendKeys(email);
        spotify.getGetTxt_spotifyPasword().sendKeys(pwd);
    }
    @And("user click on Login button")
    public void userClickOnLoginButton() {
        spotify.getBtn_SpotifyLogin().click();
    }
    @Then("error message appears {string}")
    public void errorMessageIsDisplayedOnSpotify(String spotifyErr) {
        Assert.assertEquals(spotify.getSpotify_errMsg().getText(),spotifyErr);
    }
}
