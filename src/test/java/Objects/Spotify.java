package Objects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

public class Spotify {
    WebDriver driver;
    WebDriverWait wait;
    SpotifyLocators spotifyLocators;

    public Spotify(WebDriver driver){
        this.driver = driver;
        spotifyLocators = new SpotifyLocators(driver);
    }

    public void acceptCookies(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(spotifyLocators.getAcceptCockie()));
        spotifyLocators.getAcceptCockie().click();
    }

    public void clickLoginButton(){
        spotifyLocators.getLoginButton().click();
    }

    public void enterUser(String username){
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(spotifyLocators.getUserSpotify()));
        spotifyLocators.getUserSpotify().clear();
        spotifyLocators.getUserSpotify().sendKeys(username);
    }

    public void enterPass(String password){
        spotifyLocators.getPassSpotify().clear();
        spotifyLocators.getPassSpotify().sendKeys(password);
    }

    public void loginSpotify(){
        spotifyLocators.getLoginSpotify().click();
    }

    public void throwErrMessage(String errorMsg){
        wait.until(ExpectedConditions.visibilityOf(spotifyLocators.getErrMessageSpotify()));
        Assert.assertEquals(spotifyLocators.getErrMessageSpotify().getText(), errorMsg);
    }


    public void continueWithGoogle(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(spotifyLocators.getContinueWithGoogle()));
        spotifyLocators.getContinueWithGoogle().click();

    }

    public void enterGoogleEmail(String emailGoogle){
        wait.until(ExpectedConditions.visibilityOf(spotifyLocators.getEmailAdressGoogle()));
        spotifyLocators.getEmailAdressGoogle().clear();
        spotifyLocators.getEmailAdressGoogle().sendKeys(emailGoogle, Keys.RETURN);
    }

    public void enterGogglePass(String googlePassword) throws InterruptedException {
        Thread.sleep(4000);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(spotifyLocators.getPassGoogle()));
        spotifyLocators.getPassGoogle().clear();
        spotifyLocators.getPassGoogle().sendKeys(googlePassword);

    }

    public void signWithGoogle(){
        wait.until(ExpectedConditions.elementToBeClickable(spotifyLocators.getContinuePath()));
        spotifyLocators.getContinuePath().click();
    }

    public void throwGoogleErrMessage(String googleError){
        wait.until(ExpectedConditions.visibilityOf(spotifyLocators.getErrorMessageGoogle()));
        Assert.assertEquals(spotifyLocators.getErrorMessageGoogle().getText(), googleError);

    }
}
