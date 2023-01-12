package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginSpotifyPage {

    WebDriver driver;
    WebDriverWait wait;
    LoginSpotifyLocators loginSpotifyLocators;

    public LoginSpotifyPage(WebDriver driver) {
        this.driver = driver;
        loginSpotifyLocators = new LoginSpotifyLocators(driver);
    }

    public void clickOnLogin() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOf(loginSpotifyLocators.getLoginButtonSpotify()));
        loginSpotifyLocators.getLoginButtonSpotify().click();
    }

    public void setUser(String uname) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(loginSpotifyLocators.getUsernameSpotify()));
        loginSpotifyLocators.getUsernameSpotify().clear();
        loginSpotifyLocators.getUsernameSpotify().sendKeys(uname);
    }


    public void setPass(String psw) {
        loginSpotifyLocators.getPassSpotify().clear();
        loginSpotifyLocators.getPassSpotify().sendKeys(psw);
    }

    public void clickOnLoginSpotify() {
        loginSpotifyLocators.getLogInSpotify().click();
    }

    public void checkSErrorMessage(String eMessage) {

        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOf(loginSpotifyLocators.getSErrorMessage()));
        Assert.assertEquals(loginSpotifyLocators.getSErrorMessage().getText(), eMessage);
    }


//Apple urm methods

    public void clickOnContinueWithApple() {
        wait= new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOf(loginSpotifyLocators.getContinueWithApple()));
        loginSpotifyLocators.getContinueWithApple().click();
    }

    public void setAppleId(String id) {
        wait= new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(loginSpotifyLocators.getAppleId()));
        loginSpotifyLocators.getAppleId().clear();
        loginSpotifyLocators.getAppleId().sendKeys(id);
    }

    public void setApplePass(String pass) {
        wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(loginSpotifyLocators.getApplePass()));
        loginSpotifyLocators.getApplePass().clear();
        loginSpotifyLocators.getApplePass().sendKeys(pass);
    }

    public void clickSignIn() {
        wait= new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.elementToBeClickable(loginSpotifyLocators.getSignIn()));
        loginSpotifyLocators.getSignIn().click();
    }

    public void checkAppleErrorMsg(String eMessage) {

        Assert.assertEquals(loginSpotifyLocators.getErrorMessage().getText(), eMessage);

// Fb
    }

    public void clickContinueWithFacebook() {
        loginSpotifyLocators.getContinueWithFacebook().click();
}

    public void clickEsencialeCookies() {

        loginSpotifyLocators.getCookiesButton().click();
    }


    public void enterInvalidCredentials(String username, String password) {
       loginSpotifyLocators.getUsernameField().sendKeys(username);
       loginSpotifyLocators.getPassField().sendKeys(password);
    }

    public void clickFbLoginButton() {

        loginSpotifyLocators.getFbLoginButton().click();

    }

    public void checkFbAlert() {
        Assert.assertTrue(FbAlert().isDisplayed());
    }

    private WebElement FbAlert() {
        loginSpotifyLocators.getFbAlert().getText();
        {
            return FbAlert();
        }


    }}
