package step.definitions;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.LoginSpotifyPage;

    public class LoginSpotifySteps {
        LoginSpotifyPage loginSpotifyPage;

        WebDriver driver = new ChromeDriver();

        public LoginSpotifySteps() {
            loginSpotifyPage = new LoginSpotifyPage(driver);
        }

        @Given("user navigates to Spotify {string}")
        public void userNavigatesToSpotify(String url) {
            driver.get(url);
        }

        @And("user clicks on Log in")
        public void userClicksOnLogIn() {
            loginSpotifyPage.clickOnLogin();
        }


        @When("user enters Spotify username {string} and password  as {string}")
        public void userEntersUsernameAndPasswordAs(String usern, String pass) {
            loginSpotifyPage.setUser(usern);
            loginSpotifyPage.setPass(pass);
        }


        @And("clicks on Spotify login")
        public void clicksOnLogin() {
            loginSpotifyPage.clickOnLoginSpotify();
        }

        @Then("Spotify error message is displayed {string}")
        public void spotifyErrorMessageIsDisplayed(String msg) {
            loginSpotifyPage.checkSErrorMessage(msg);
        }


        //Apple urm steps
        @And("user clicks on Continue with Apple")
        public void userClicksOnContinueWithApple() {
            loginSpotifyPage.clickOnContinueWithApple();
        }
//
//        @When("Enter apple id {string} ")
//        public void enterAppleId(String appleId) {
//            loginSpotifyPage.setAppleId(appleId);
//        }

        @When("Enter apple id {string} and Click AppleSignin")
        public void enterAppleIdAndClickAppleSignin(String appleId) {
            loginSpotifyPage.setAppleId(appleId);
            loginSpotifyPage.clickSignIn();
        }

        @And("Enter apple password {string}")
        public void enterApplePassword(String pass) {
            loginSpotifyPage.setApplePass(pass);
        }
        @And("Click AppleSignin")
        public void clickSignin() {
            loginSpotifyPage.clickSignIn();
        }
        @Then("Apple Error Message is displayed")
        public void errorMessageIsDisplayed(String msg) {
            loginSpotifyPage.checkAppleErrorMsg(msg);
        }




        //Fb urm steps


        @And("Click continue with Facebook")
        public void clickContinueWithFacebook() {
            loginSpotifyPage.clickContinueWithFacebook();
        }

        @When("Click on allow cookies")
        public void clickOnAllowCookies() {
            loginSpotifyPage.clickEsencialeCookies();
        }

        @And("Enter Invalid username{string} and invalid password{string}")
        public void enterInvalidUsernameAndInvalidPassword(String arg0, String arg1) {
            loginSpotifyPage.enterInvalidCredentials(arg0,arg1);
        }

        @And("Click connect button")
        public void clickConnectButton() {
            loginSpotifyPage.clickFbLoginButton();
        }

        @Then("Check to see if error is displayed")
        public void checkToSeeIfErrorIsDisplayed() {
            loginSpotifyPage.checkFbAlert();
        }
    }