package page.objects;

import Locators.SpotifyLocators;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseClass;

import java.io.IOException;
import java.security.Key;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class SpotifyFlow extends BaseClass  {

    WebDriver driver;
    WebDriverWait wait;
    SpotifyLocators spotifyLocators;


    //login with spotify methods
    public SpotifyFlow (WebDriver driver){
        this.driver = driver;
        spotifyLocators = new SpotifyLocators(driver);
    }

    //overrided method for cookies changing wait.until with Thread.sleep
    @Override
    public void cookies(){
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            System.out.println("Exception catched");
        }
        spotifyLocators.getCookies().click();
    }

    public void clickOnLoginButton(){
        spotifyLocators.getLoginButton().click();
    }

    public void typeUsername(String username){
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(spotifyLocators.getUsernameSpotify()));
        spotifyLocators.getUsernameSpotify().clear();
        spotifyLocators.getUsernameSpotify().sendKeys(username);
    }

    public void typesPassword(String password){
        spotifyLocators.getPasswordSpotify().clear();
        spotifyLocators.getPasswordSpotify().sendKeys(password);
    }

    public void loginSpotify(){
        spotifyLocators.getLoginSpotify().click();
    }

    //overrided method for throwErrorMsg changing assertEquals with AssertTrue
    @Override
    public void throwErrorMsg(String errorMsg){
        wait.until(ExpectedConditions.visibilityOf(spotifyLocators.getErrormsgSpotify()));
        Assert.assertTrue(spotifyLocators.getErrormsgSpotify().isDisplayed());

    }

    //login with google methods
    public void continueWithGoogle(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(spotifyLocators.getContinueWithGoogle()));
        spotifyLocators.getContinueWithGoogle().click();

    }

    public void typesGoogleEmail(String emailGoogle){
        wait.until(ExpectedConditions.visibilityOf(spotifyLocators.getEmailAdressGoogle()));
        spotifyLocators.getEmailAdressGoogle().clear();
        spotifyLocators.getEmailAdressGoogle().sendKeys(emailGoogle, Keys.RETURN);
    }

    public void typesGooglePassword(String googlePassword) throws InterruptedException {
        Thread.sleep(4000);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(spotifyLocators.getPasswordGoogle()));
        spotifyLocators.getPasswordGoogle().clear();
        spotifyLocators.getPasswordGoogle().sendKeys(googlePassword);

    }

    public void signInWithGoogle(){
        wait.until(ExpectedConditions.elementToBeClickable(spotifyLocators.getContinuePath()));
        spotifyLocators.getContinuePath().click();
    }

    public void throwGoogleErrorMsg(String googleError){
        wait.until(ExpectedConditions.visibilityOf(spotifyLocators.getErrormsgGoogle()));
        Assert.assertEquals(spotifyLocators.getErrormsgGoogle().getText(), googleError);

    }

    //login with facebook methods
    public void continueWithFacebook(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(spotifyLocators.getContinueWithFacebook()));
        spotifyLocators.getContinueWithFacebook().click();

    }

    public void acceptFacebookCookies(){
        wait.until(ExpectedConditions.visibilityOf(spotifyLocators.getAcceptCookies()));
        spotifyLocators.getAcceptCookies().click();
    }

    public void enterFacebookUsername(String usernameFacebook){
        wait.until(ExpectedConditions.visibilityOf(spotifyLocators.getFacebookId()));
        spotifyLocators.getFacebookId().clear();
        spotifyLocators.getFacebookId().sendKeys(usernameFacebook);

    }
    public void enterFacebookPassword(String facebookPassword){
        wait.until(ExpectedConditions.visibilityOf(spotifyLocators.getFacebookPassword()));
        spotifyLocators.getFacebookPassword().clear();
        spotifyLocators.getFacebookPassword().sendKeys(facebookPassword);
    }

    public void logInFacebook(){
        wait.until(ExpectedConditions.elementToBeClickable(spotifyLocators.getLoginId()));
        spotifyLocators.getLoginId().click();

    }
    //overrided method for throwFacebookErrorMsg changing assertEquals with AssertTrue
    @Override
    public void throwFacebookErrorMsg(String facebookError){
        wait.until(ExpectedConditions.visibilityOf(spotifyLocators.getErrorMsgFacebook()));
        Assert.assertTrue(spotifyLocators.getErrorMsgFacebook().isDisplayed());

    }

    //login with apple methods

    public void continueWithApple(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(spotifyLocators.getContinueWithApple()));
        spotifyLocators.getContinueWithApple().click();
    }

    public void userTypesAppleId(String appleId){
        wait.until(ExpectedConditions.visibilityOf(spotifyLocators.getAppleId()));
        spotifyLocators.getAppleId().clear();
        spotifyLocators.getAppleId().sendKeys(appleId);
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        spotifyLocators.getAppleId().sendKeys(Keys.RETURN);


    }
    public void userTypesApplePassword(String applePassword){
        wait.until(ExpectedConditions.visibilityOf(spotifyLocators.getApplePassword()));
        spotifyLocators.getApplePassword().clear();
        spotifyLocators.getApplePassword().sendKeys(applePassword,Keys.RETURN);
    }
    public void proccedToPasswordField(){
        wait.until(ExpectedConditions.visibilityOf(spotifyLocators.getProccedTo()));
        spotifyLocators.getProccedTo().click();

    }

    //overrided method for throwAppleErrorMsg changing assertEquals with AssertTrue
    @Override
    public void throwAppleErrorMsg(String appleError){
        wait.until(ExpectedConditions.visibilityOf(spotifyLocators.getErrorMsgApple()));
        Assert.assertTrue(spotifyLocators.getErrorMsgApple().isDisplayed());

    }



}
