package page.objects;

import Locators.SpotifyLocators;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SpotifyFlow {

    WebDriver driver;
    WebDriverWait wait;
    SpotifyLocators spotifyLocators;

    //login with spotify methods
    public SpotifyFlow(WebDriver driver){
        this.driver = driver;
        spotifyLocators = new SpotifyLocators(driver);
    }

    public void cookies(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(spotifyLocators.getCookies()));
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

    public void throwErrorMsg(String errorMsg){
        wait.until(ExpectedConditions.visibilityOf(spotifyLocators.getErrormsgSpotify()));
        Assert.assertEquals(spotifyLocators.getErrormsgSpotify().getText(), errorMsg);
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

    public void throwFacebookErrorMsg(String facebookError){
        wait.until(ExpectedConditions.visibilityOf(spotifyLocators.getErrorMsgFacebook()));
        Assert.assertEquals(spotifyLocators.getErrorMsgFacebook().getText(),facebookError);

    }


}
