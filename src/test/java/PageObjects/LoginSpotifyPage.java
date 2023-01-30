package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


    public class LoginSpotifyPage extends BasePage {
    public WebDriver driver;


    // By Facebook
    By facebookEmailField = By.id("email");
    By facebookPasswordField = By.id("pass");
    public WebElement getFacebookButton() {
        return driver.findElement(By.xpath("//*[contains (@data-testid,'facebook-login')]"));
    }
    public WebElement enterFacebookEmail() {
        return driver.findElement(facebookEmailField);
    }
    public WebElement enterFacebookPassword(){
        return driver.findElement(facebookPasswordField);
    }
    public WebElement getLoginFacebookButton(){
        return driver.findElement(By.id("loginbutton"));
    }
    public WebElement getAllowFacebookCookies(){
        return driver.findElement(By.xpath("//*[contains (@data-testid,'cookie-policy-manage-dialog-accept-button')]"));
    }


    // By Apple
    By appleIdField = By.id("account_name_text_field");
    By applePasswordField = By.id("password_text_field");
    public WebElement getAppleButton() {
        return driver.findElement(By.xpath("//*[contains (@data-testid,'apple-login')]"));
    }
    public WebElement getSignInAppleButton(){
        return driver.findElement(signInButton);
    }
    public WebElement enterAppleId() {
        return driver.findElement(appleIdField);
    }
    public WebElement enterApplePassword() {
        return driver.findElement(applePasswordField);
    }


    // By Google

    public LoginSpotifyPage (WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    public WebElement enterGoogleEmail() {
        return driver.findElement(emailGoogleField);
    }
    public  WebElement getGoogleButton() {
        return driver.findElement(By.xpath("//*[contains (@data-testid,'google-login')]"));
    }
    public WebElement getGoogleNextButton() {
        return driver.findElement(nextButton);
    }
    By emailGoogleField = By.id("identifierId");


    // By Spotify
    By emailField = By.id("login-username");
    By passwordField = By.id("login-password");
    By loginButton = By.id("login-button");
    By nextButton = By.id("identifierNext");
    By signInButton = By.id("sign-in");
    public WebElement enterSpotifyEmail() {
        return driver.findElement(emailField);
    }
    public WebElement enterSpotifyPassword() {
        return driver.findElement(passwordField);
    }
    public WebElement clickLoginButtonOnSpotify() {
        return driver.findElement(loginButton);
    }
    public WebElement getNextButton() {
        return driver.findElement(nextButton);
    }
}

