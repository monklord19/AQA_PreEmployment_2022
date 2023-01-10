package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class SpotifyLogin {
    WebDriver driver;
    WebDriverWait wait;

    SpotifyLoginLocators spotifyloginLocators;

    public SpotifyLogin(WebDriver driver) {
        this.driver = driver;
        spotifyloginLocators = new SpotifyLoginLocators(driver);
    }

    public void setUsername(String username){
        spotifyloginLocators.getUsername().clear();
        spotifyloginLocators.getUsername().sendKeys(username);
    }

    public void setPassword(String password){
        spotifyloginLocators.getPassword().clear();
        spotifyloginLocators.getPassword().sendKeys(password);
    }

    public void clickLoginButton() {
        spotifyloginLocators.getLoginButton().click();
    }

    public void checkErrorPop_up(String pop_up){
        Assert.assertEquals(spotifyloginLocators.getErrorPop_up().getText(), pop_up);
    }

    public void loginWithGoogleCont(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        Object spotifyLocators;
        wait.until(ExpectedConditions.visibilityOf(SpotifyLoginLocators.getLoginWithGoogle()));
        spotifyloginLocators.getLoginWithGoogle().click();
    }

    public void enterGmail(String gmail){
        wait.until(ExpectedConditions.visibilityOf(spotifyloginLocators.getGmail()));
        spotifyloginLocators.getGmail().clear();
        spotifyloginLocators.getGmail().sendKeys(gmail, Keys.RETURN);

    }

    public void enterPass(String pass){
        wait.until(ExpectedConditions.visibilityOf(spotifyloginLocators.getGooglePassword()));
        spotifyloginLocators.getGooglePassword().clear();
        spotifyloginLocators.getGooglePassword().sendKeys(pass, Keys.RETURN);

    }

    public void loginWithGmail(){
        wait.until(ExpectedConditions.elementToBeClickable(spotifyloginLocators.getLoginGoogle()));
        spotifyloginLocators.getLoginGoogle().click();
    }

    public void errorOfGoogle(String googleError){
        wait.until(ExpectedConditions.visibilityOf(spotifyloginLocators.getErrorOfGoogle()));
        Assert.assertEquals(spotifyloginLocators.getErrorOfGoogle().getText(), googleError);

    }

}

