package Testing.pageobjects;

import Testing.Locators.SpotifyLocators;
import Testing.StepDefinitions.TestBase;
import org.Testing.AppConfig;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SpotifyPage extends TestBase {

    private SpotifyLocators spotifyLocators = PageFactory.initElements(driver, SpotifyLocators.class);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    private String errMsg;


    //Spotify accept cookies and click signIn
    public void acceptSpotifyCookies() {
        wait.until(ExpectedConditions.visibilityOf(spotifyLocators.getBtn_spotifyAcceptCookies()));
        spotifyLocators.getBtn_spotifyAcceptCookies().click();
    }

    public void clickSpotifyLogin() {
        spotifyLocators.getBtn_SpotifyLogin().click();
    }

    //Invalid login with Facebook
    public void continueWithFacebook() {
        spotifyLocators.getBtn_continueWithFB().click();
        wait.until(ExpectedConditions.visibilityOf(spotifyLocators.getBtn_fb_allowCookies()));
        spotifyLocators.getBtn_fb_allowCookies().click();
    }

    public void setFacebookEmail() {
        spotifyLocators.getTxt_fb_emailField().sendKeys(AppConfig.getEmail());
    }

    public void setFacebookPassword() {
        spotifyLocators.getTxt_fb_passField().sendKeys(AppConfig.getPassword());
    }

    public void clickFbLoginBtn() {
        spotifyLocators.getBtn_fb_Login().click();
    }

    public void errorMsgFb() {
        Assert.assertEquals(spotifyLocators.getFb_errMsg().getText(), AppConfig.getErrorFacebook());
    }

    //Invalid login with Google
    public void continueWithGoogle() {
        spotifyLocators.getBtn_continueWithGoogle().click();
    }

    public void setGoogleEmail() {
        spotifyLocators.getTxt_GoogleEmail().sendKeys(AppConfig.getEmail());
    }

    public void setGooglePassword() {
        spotifyLocators.getTxt_GooglePassword().sendKeys(AppConfig.getPassword());
    }

    public void nextBtnGoogle() {
        spotifyLocators.getBtn_GoogleNext().click();
    }

    public void errorMsgGoogle() {
        Assert.assertEquals(spotifyLocators.getGoogle_errMsg().getText(), AppConfig.getErrorGoogle());
    }

    //Invalid login with spotify account
    public void spotifyLoginBtn() {
        spotifyLocators.getBtn_LogInWithSpotify().click();
    }

    public void setSpotifyEmail() {
        spotifyLocators.getTxt_spotifyEmail().sendKeys(AppConfig.getEmail());
    }

    public void setSpotifyPassword() {
        spotifyLocators.getTxt_spotifyPassword().sendKeys(AppConfig.getPassword());
    }

    public void errorMsgSpotify() {
        Assert.assertEquals(spotifyLocators.getSpotify_errMsg().getText(), AppConfig.getErrorSpotify());
    }

    //login with apple
    public void continueWithApple() {
        spotifyLocators.getBtn_continueWithApple().click();
    }

    public void setAppleID() {
        spotifyLocators.getAppleId().sendKeys(AppConfig.getAppleId());
    }
    public void setApplePassword(){
        wait.until(ExpectedConditions.visibilityOf(spotifyLocators.getApplePassword()));
        spotifyLocators.getApplePassword().clear();
        spotifyLocators.getApplePassword().sendKeys(AppConfig.getPassword());
    }

    public void clickSignInAppleBtn() {
        wait.until(ExpectedConditions.visibilityOf(spotifyLocators.getBtn_appleSignIn()));
        spotifyLocators.getBtn_appleSignIn().click();
    }
    public void errorMsgApple(){
        Assert.assertEquals(spotifyLocators.getAppleError().getText(), AppConfig.getErrorApple());
    }


    public void assertErrorMessage(Object expected,Object actual){
        expected=spotifyLocators.getAppleError().getText();
        actual=AppConfig.getErrorApple();
        Assert.assertEquals(expected,actual);
    }





}
