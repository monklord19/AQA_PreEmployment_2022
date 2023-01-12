package UITests.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FacebookLoginSpotifyPage {

    private WebDriver driver;

    public By spotifyTitle = By.xpath("//title[contains(text(),'Spotify')]");
    public By facebookLogo = By.className("fb_logo");

    public By facebookUsernameInput = By.id("email");
    public By facebookPasswordInput = By.id("pass");

    public By facebookLoginButton = By.id("loginbutton");

    public FacebookLoginSpotifyPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isFacebookLogoDisplayed() {
        return driver.findElement(facebookLogo).isDisplayed();
    }

    public void sendKeysTo(By element, String keys) {
        driver.findElement(element).sendKeys(keys);
    }

    public void submitLogin() {
        driver.findElement(facebookLoginButton).click();
    }

    public boolean isSpotifyPageDisplayed() {
        return driver.findElement(spotifyTitle).isDisplayed();
    }
}
