package spotifyLoginPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SpotifyLoginPage {
    WebDriver driver;
    WebDriverWait wait;
    By continueWithGoogleButton = By.xpath("//button[@data-testid='google-login']");
    By spotifyUsernameField = By.xpath("//input[@id='login-username']");
    By spotifyPasswordField = By.xpath("//input[@id='login-password']");
    By spotifyLoginButton = By.xpath("//button[@id='login-button']");

    By errorMessage = By.xpath("//span[contains(text(),'Incorrect username or password.')]");

    public SpotifyLoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void continueWithGoogle() {
        wait.until(ExpectedConditions.elementToBeClickable(continueWithGoogleButton));
        WebElement continueWithGoogleElement = driver.findElement(continueWithGoogleButton);
        continueWithGoogleElement.click();
    }

    public void setSpotifyUsername(String username) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(spotifyUsernameField));
        WebElement spotifyUsernameFieldElement = driver.findElement(spotifyUsernameField);
        spotifyUsernameFieldElement.sendKeys(username);
    }

    public void setSpotifyPassword(String password) {
        WebElement spotifyPasswordFieldElement = driver.findElement(spotifyPasswordField);
        spotifyPasswordFieldElement.sendKeys(password);
    }

    public void clickSpotifyLoginButton(){
        WebElement spotifyLoginButtonElement = driver.findElement(spotifyLoginButton);
        spotifyLoginButtonElement.click();
    }

    public boolean errorMessageIsDisplayed(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        WebElement errorMessageElement = driver.findElement(errorMessage);
        return errorMessageElement.isDisplayed();
    }

}
