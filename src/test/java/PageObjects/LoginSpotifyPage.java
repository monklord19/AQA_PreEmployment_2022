package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LoginSpotifyPage {
    public WebDriver driver;
    By emailField = By.id("login-username");
    By passwordField = By.id("login-password");
    By loginButton = By.id("login-button");
    By emailGoogleField = By.id("identifierId");
    By nextButton = By.id("identifierNext");

    public LoginSpotifyPage (WebDriver driver) {
        this.driver = driver;
    }

    public WebElement enterEmail() {
        return driver.findElement(emailField);
    }

    public WebElement enterGoogleEmail() {
        return driver.findElement(emailGoogleField);
    }

    public WebElement enterPassword() {
        return driver.findElement(passwordField);
    }

    public WebElement clickLoginButton() {
        return driver.findElement(loginButton);
    }

    public  WebElement getGoogleButton() {
        return driver.findElement(By.xpath("//*[contains (@data-testid,'google-login')]"));
    }

    public WebElement getNextButton() {
        return driver.findElement(nextButton);
    }
}
