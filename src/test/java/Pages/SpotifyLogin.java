package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class SpotifyLogin{
    WebDriver driver;
    WebDriverWait wait;

    SpotifyLoginLocators spotifyloginLocators;

    public SpotifyLogin(WebDriver driver){
        this.driver = driver;
        spotifyloginLocators = new SpotifyLoginLocators(driver);
    }


    //login with spotify

    public void clickLoginSpotify(){
        spotifyloginLocators.getLoginSpotify().click();
    }

    public void setUsername(String spotify_username){
        wait = new WebDriverWait(driver, Duration.ofSeconds(90));
        wait.until(ExpectedConditions.visibilityOf(spotifyloginLocators.getUsername()));
        spotifyloginLocators.getUsername().clear();
        spotifyloginLocators.getUsername().sendKeys(spotify_username, Keys.RETURN);
    }

    public void setPassword(String password){
        spotifyloginLocators.getPassword().clear();
        spotifyloginLocators.getPassword().sendKeys(password);
    }

    public void clickLoginButton(){
        spotifyloginLocators.getLoginButton().click();
    }

    public void checkErrorPop_up(String pop_up){
        Assert.assertEquals(spotifyloginLocators.getErrorPop_up().getText(), pop_up);
    }
}

