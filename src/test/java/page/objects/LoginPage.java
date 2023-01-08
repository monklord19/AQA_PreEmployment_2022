package page.objects;

import locators.LoginPageLocators;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;
    LoginPageLocators loginLocators;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        loginLocators = new LoginPageLocators(driver);
    }

    public void setUsername(String uname) {
        loginLocators.getUsername().clear();
        loginLocators.getUsername().sendKeys(uname);
    }

    public void setPassword(String psw) {
        loginLocators.getPassword().clear();
        loginLocators.getPassword().sendKeys(psw);
    }

    public void clickLogin() {
        loginLocators.getLoginButton().click();
    }

    public void checkHomePageOpened() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(loginLocators.getHamburgerButton()));
        Assert.assertTrue(loginLocators.getHamburgerButton().isDisplayed());
    }

    public void checkErrorMessage(String eMessage) {
        Assert.assertEquals(loginLocators.getErrorMessage().getText(), eMessage);
    }

    public void enterKeyLogin() {
        loginLocators.getLoginButton().sendKeys(Keys.ENTER);
    }

    public void clickHamburgerBtn() {
        loginLocators.getHamburgerButton().click();
    }

    public void clickLogoutButton() {
        wait.until(ExpectedConditions.visibilityOf(loginLocators.getLogoutButton()));
        loginLocators.getLogoutButton().click();

    }

    public void checkLoginPageOpened() {
        loginLocators.resetElement();
        wait.until(ExpectedConditions.visibilityOf(loginLocators.getLoginButton()));
        Assert.assertTrue(loginLocators.getUsername().isDisplayed());
    }

    //methods for Spotify login
    public void clickOnLogin(){
        loginLocators.getLoginButtonSpotify().click();
    }

    public void setUser(String uname) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(loginLocators.getUsernameSpotify()));
        loginLocators.getUsernameSpotify().clear();
        loginLocators.getUsernameSpotify().sendKeys(uname);
    }

    public void setPass(String psw) {
        loginLocators.getPassSpotify().clear();
        loginLocators.getPassSpotify().sendKeys(psw);
    }

    public void clickOnLoginSpotify(){
        loginLocators.getLogInSpotify().click();
    }

    public void checkSErrorMessage(String eMessage) {
        wait.until(ExpectedConditions.visibilityOf(loginLocators.getSErrorMessage()));
        Assert.assertEquals(loginLocators.getSErrorMessage().getText(), eMessage);
    }

    public void clickOnContinueWithApple(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(loginLocators.getContinueWithApple()));
        loginLocators.getContinueWithApple().click();
    }

    public void setAppleId(String id){
        wait.until(ExpectedConditions.visibilityOf(loginLocators.getAppleId()));
        loginLocators.getAppleId().clear();
        loginLocators.getAppleId().sendKeys(id);
    }

    public void setApplePass(String pass){
        wait.until(ExpectedConditions.visibilityOf(loginLocators.getApplePass()));
        loginLocators.getApplePass().clear();
        loginLocators.getApplePass().sendKeys(pass);
    }

    public void clickOnSignInIcon(){
        wait.until(ExpectedConditions.elementToBeClickable(loginLocators.getSignInIcon()));
        loginLocators.getSignInIcon().click();
    }

    public void checkAppleErrorMsg(String eMessage) {
        wait.until(ExpectedConditions.visibilityOf(loginLocators.getAErrorMessage()));
        Assert.assertEquals(loginLocators.getAErrorMessage().getText(), eMessage);
    }
}
