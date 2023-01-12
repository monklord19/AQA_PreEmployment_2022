package utils;

import Locators.SpotifyLocators;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseClass {

    WebDriverWait wait;
    SpotifyLocators spotifyLocators;
   public WebDriver driver;

    public void throwErrorMsg(String errorMsg) {
        wait.until(ExpectedConditions.visibilityOf(spotifyLocators.getErrormsgSpotify()));
        Assert.assertEquals(spotifyLocators.getErrormsgSpotify().getText(), errorMsg);
    }
    public void throwFacebookErrorMsg(String facebookError) {
        wait.until(ExpectedConditions.visibilityOf(spotifyLocators.getErrorMsgFacebook()));
        Assert.assertEquals(spotifyLocators.getErrorMsgFacebook().getText(), facebookError);

    }
    public void throwAppleErrorMsg(String appleError) {
        wait.until(ExpectedConditions.visibilityOf(spotifyLocators.getErrorMsgApple()));
        Assert.assertEquals(spotifyLocators.getErrorMsgApple().getText(), appleError);

    }

    public void cookies(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(spotifyLocators.getCookies()));
        spotifyLocators.getCookies().click();
    }


}
