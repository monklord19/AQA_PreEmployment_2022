package steps;

import org.junit.After;
import org.junit.Before;
import pages.SpotifyPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SpotifyTest {
    public WebDriver driver = new ChromeDriver();

    //SpotifyPage SpotifyPage;
    SpotifyPage SpotifyPage = new SpotifyPage(driver);

/*
   @After
    public void quit(){
       driver.close();
    }
*/

    @Given("I open spotify website")
    public void iOpenSpotifyWebsite(){
        driver.get("https://open.spotify.com/");
        driver.manage().window().maximize();
    }

    @When("I accept cookies")
    public void iAcceptCookies(){
        SpotifyPage.AcceptCookies();
    }

    @Then("I enter username {string} and password {string}")
    public void iEnterUsernameAndPassword(String username, String password){
        SpotifyPage.EnterUsernameorEmail(username);
        SpotifyPage.EnterPassword(password);
    }

    @And("I press log in button")
    public void iPressLogInButton(){
        SpotifyPage.ClickLoginButton();
    }

    @Then("I sould see the error {string}")
    public void iSouldSeeTheError(String message){
        SpotifyPage.ShowErrorMessageSpotify(message);
    }


    //Apple Login

    @And("I chose to login with Apple")
    public void iChoseToLoginWithApple(){
        SpotifyPage.AppleLoginButton();
    }

    @When("I add the apple id {string} and press enter key")
    public void iAddTheAppleIdAndPressEnterKey(String id){
        SpotifyPage.AppleIdInsert(id);
        SpotifyPage.AppleIdEnter();
    }

    @And("i enter password {string} and press the enter key")
    public void iEnterPasswordAndPressTheEnterKey(String password){
        SpotifyPage.ApplePasswordInsert(password);
        SpotifyPage.ApplePasswordEnter();
    }

    @And("I press home login button")
    public void iPressHomeLoginButton(){
        SpotifyPage.HomePageLoginButton();
    }

    @Then("I shoud see the apple error message {string}")
    public void iShoudSeeTheAppleErrorMessage(String errorMessage){
        SpotifyPage.getErrorAppleAuthentification(errorMessage);
    }

    @And("I chose to login with Google Account")
    public void iChoseToLoginWithGoogleAccount(){
        SpotifyPage.GoogleLoginButtonClick();
    }

    @Then("I enter email {string} and press next button")
    public void iEnterEmailAndPressNextButton(String email){
        SpotifyPage.insertGoogleEmail(email);
        SpotifyPage.enterGoogleEmail();
    }

    @And("I enter password {string} and press next button")
    public void iEnterPasswordAndPressNextButton(String arg0){

    }

    @And("I should see an error")
    public void iShouldSeeAnError(){
    }

    @And("I chose to login with Facebook Account")
    public void iChoseToLoginWithFacebookAccount(){
        SpotifyPage.LoginWithFacebook();
    }

    @And("I accept facebook cookies")
    public void iAcceptFacebookCookies(){
        SpotifyPage.AcceptFacebookCookies();
    }

    @When("I insert email {string} and password {string}")
    public void iInsertEmailAndPassword(String email, String password){
        SpotifyPage.insertFacebookEmailandPassword(email, password);
    }

    @And("I press Login Button")
    public void iPressLoginButton(){
        SpotifyPage.EnterFacebookLoginButton();
    }

    @Then("I should see the error {string}")
    public void iShouldSeeTheError(String error){
        SpotifyPage.FacebookErrorMessage(error);
    }
}
