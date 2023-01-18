package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.SpotifyLoginPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SpotifyLoginPageStepDefs {
    WebDriver driver = new ChromeDriver();
    SpotifyLoginPage spotifyLoginPage = new SpotifyLoginPage(driver);

    @Given("On the Spotify Login page")
    public void onTheSpotifyLoginPage() {
        driver.get("https://accounts.spotify.com/en/login");
    }

    @When("I enter invalid username and password")
    public void iEnterInvalidUsernameAndPassword() {
        spotifyLoginPage.setUsernameField("Invalid Username");
        spotifyLoginPage.setPasswordField("Invalid Password");
    }

    @And("I click Log in button")
    public void iClickLogInButton() {
        spotifyLoginPage.clickLoginButton();
    }

    @Then("I am unable to log in and error message is displayed")
    public void iAmUnableToLogInAndErrorMessageIsDisplayed() {
        assertTrue(driver.getPageSource().contains("Incorrect username or password."));
    }

    @When("I click Continue with Facebook")
    public void iClickContinueWithFacebook() {
        spotifyLoginPage.clickContinueWithFacebookButton();
    }

    @Then("The Facebook login page opens")
    public void theFacebookLoginPageOpens() {
        driver.get("https://www.facebook.com/login");
    }


    @When("I click Continue with Apple")
    public void iClickContinueWithApple() {
        spotifyLoginPage.clickContinueWithAppleButton();
    }

    @Then("The Apple login page opens")
    public void theAppleLoginPageOpens() {
        driver.get("https://appleid.apple.com/auth/authorize?client_id=com.spotify.accounts&response_type=code&response_mode=form_post&scope=name%20email&state=AQDK8wyKleaziBWUIEv1aqBil87uFFpG9ZKsDHWy2oD7RvyhMGHMGObPhJUenYKchxCGVNfLC7k%2BoAZ5SBEci5LWhPu2jX0axaRhv4yYoAe40r3iEf062G2uouJJuFOaSmxprEaBLc9bPZK6CD5VyH%2BCu3Wyyu4JmK2Hwb%2B%2Fcuopgt3MbAiBGoTBdpJnNAyRZAFGFbwOb3Kq&redirect_uri=https%3A%2F%2Faccounts.spotify.com%2Flogin%2Fapple%2Fredirect");
    }

    @When("I click Continue with Google")
    public void iClickContinueWithGoogle() {
        spotifyLoginPage.clickContinueWithGoogleButton();
    }

    @Then("The Google login page opens")
    public void theGoogleLoginPageOpens() {
        driver.get("https://accounts.google.com/o/oauth2/v2/auth/identifier?response_type=code&access_type=offline&client_id=1046568431490-ij1gi5shcp2gtorls09frkc56d4mjbe2.apps.googleusercontent.com&state=AQDD3vlCewYJwc%2F551fvrI8uWTlk15nSpoJDwSEhlSm1uo9r0WH%2B6yT7LkRQVPunVx8zDVZRR5W5DxUacwPQ7VcD5hEq5oiQZreEK383%2FuJBkWmWjU%2Fs7RFk%2BLFvxG%2BfB%2BCi3GwPtJmXWP6qfrBDxM%2FIjulOpwy2yvOUOLY%2Bo5NRw3kCO3%2B3Ew%2FtifrMitaPOiMvYy6xU3%2Bq&scope=profile%20email%20openid&redirect_uri=https%3A%2F%2Faccounts.spotify.com%2Flogin%2Fgoogle%2Fredirect&service=lso&o2v=2&flowName=GeneralOAuthFlow");
    }
}