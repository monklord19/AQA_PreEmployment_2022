package Steps;

import Pages.AppleLogin;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import Pages.LoginPage;

public class AppleSteps {
    WebDriver driver = new ChromeDriver();
    AppleLogin appleloginPage = new AppleLogin(driver);

    @Given("User open Spotify {string}")
        public void userOpenSpotify(String url){
            driver.get(url);
        }

    @And("User press the Login Spotify")
    public void userPressTheLoginSpotify(){
        appleloginPage.clickLoginSpotifyPage();
    }

    @And("User click on login with Apple")
    public void userClickOnLoginWithApple(){
        appleloginPage.loginWithApple();
    }

    @And("User enter a valid apple account as {string}")
    public void userEnterAValidAppleAccountAs(String accountapple){
        appleloginPage.enterAppleAccount(accountapple);
    }

    @And("User press continue button")
    public void userPressContinueButton(){
        appleloginPage.nextButtonApple();
    }

    @And("User enter an invalid apple password as {string}")
    public void userEnterAnInvalidApplePasswordAs(String passapple){
        appleloginPage.enterPassApple(passapple);

    }
    @Then("User press the final continue button")
    public void userEnterTheFinalContinueButton(){
        appleloginPage.nextFinalButton();
    }

    @And("An errorapple appears {string}")
    public void anErrorappleAppears(String appleError){
        appleloginPage.errorOfApple(appleError);
        Assert.assertEquals(appleError, "Your Apple ID or password was incorrect. Forgotten your password?");
    }




}