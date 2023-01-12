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
    private final By continueWithGoogleButton = By.xpath("//button[@data-testid='google-login']");
    private final By spotifyUsernameField = By.xpath("//input[@id='login-username']");
    private final By spotifyPasswordField = By.xpath("//input[@id='login-password']");
    private final  By spotifyLoginButton = By.xpath("//button[@id='login-button']");
    private final By continueWithFacebookButton = By.xpath("//button[@data-testid='facebook-login']");
    private final By continueWithAppleButton = By.xpath("//button[@data-testid='apple-login']");
    private final By errorMessage = By.xpath("//span[contains(text(),'Incorrect username or password.')]");


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

    public void clickSpotifyLoginButton() {
        WebElement spotifyLoginButtonElement = driver.findElement(spotifyLoginButton);
        spotifyLoginButtonElement.click();
    }

    public boolean errorMessageIsDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        WebElement errorMessageElement = driver.findElement(errorMessage);
        return errorMessageElement.isDisplayed();
    }

    public void continueWithFacebook() {
        wait.until(ExpectedConditions.elementToBeClickable(continueWithFacebookButton));
        WebElement continueWithFacebookElement = driver.findElement(continueWithFacebookButton);
        continueWithFacebookElement.click();
    }

   public void continueWithApple(){
       wait.until(ExpectedConditions.elementToBeClickable(continueWithAppleButton));
       WebElement continueWithAppleButtonElement = driver.findElement(continueWithAppleButton);
       continueWithAppleButtonElement.click();
   }
}
