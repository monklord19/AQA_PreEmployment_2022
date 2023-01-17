package Steps;

import Pages.AppleLogin;
import Pages.FacebookLogin;
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

public class FacebookSteps {
    WebDriver driver = new ChromeDriver();
    FacebookLogin facebookloginPage = new FacebookLogin(driver);

    @Given("User open Webpage Spotify {string}")
    public void userOpenWebpageSpotify(String url){
        driver.get(url);
    }

    @And("User press the button Login Spotify")
    public void userPressTheButtonLoginSpotify(){
        facebookloginPage.clickLoginWebpageSpotify();
    }

    @And("User click on login with Facebook")
    public void userClickOnLoginWithFacebook(){
        facebookloginPage.loginWithFacebook();
    }

    @And("User enter a valid facebook account as {string}")
    public void userEnterAValidFacebookAccountAs(String accountfacebook){
        facebookloginPage.enterFacebookAccount(accountfacebook);
    }

    @And("User enter an invalid facebook password as {string}")
    public void userEnterAnInvalidFacebookPasswordAs(String passfacebook){
        facebookloginPage.enterPassFacebook(passfacebook);

    }
    @Then("User press connect facebook")
    public void userPressConnectFacebook(){
        facebookloginPage.connectFacebook();
    }

    @And("An error Facebook appears {string}")
    public void anErrorFacebookAppears(String facebookError){
        facebookloginPage.errorOfFacebook(facebookError);
        Assert.assertEquals(facebookError, "The password that you've entered is incorrect. Forgotten password?");
    }

}