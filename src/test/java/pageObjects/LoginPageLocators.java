package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.awt.*;


public class LoginPageLocators {
    public WebDriver driver;


    public static final String usernameId = "user-name";
    public static final String passwordId = "password";
    public static final String loginId = "login-button";
    public static final String errorMessageXpath = "//h3[@data-test = 'error']]";
    public static final String hamburgerButtonCls = "bm-burger-button";

//    @FindBy(xpath = Element.LOGIN_BUTTON_XPATH)
//    @CacheLookup
//    private
//    WebElement loginButtonSpotify;


    private WebElement username;
    private WebElement password;
    private WebElement login;

    private WebElement loginButton;
    private WebElement errorText;
    private WebElement hamburgerButton;


//
//    private WebElement LOGIN_BUTTON = driver.findElement(By.xpath("loginButtonSpotify"));
//
//    private WebElement USERNAME_ID = driver.findElement(By.id("login-username"));
//    private WebElement PASS_ID = driver.findElement(By.id("login-password"));

    //    private WebElement LOGIN= driver.findElement(By.xpath("logInSpotify"));
    public LoginPageLocators(WebDriver driver) {
        this.driver = driver;

    }
public void initialize() {
    username = driver.findElement(By.id(usernameId));
    password = driver.findElement(By.id(passwordId));
    login = driver.findElement(By.xpath("//span[text()='Log In']"));
    loginButton = driver.findElement(By.id(loginId));
    errorText = driver.findElement(By.xpath(errorMessageXpath));
    hamburgerButton = driver.findElement(By.className(hamburgerButtonCls));
}
//
//    public WebElement getLoginButtonSpotify() {
//        return loginButtonSpotify;
//    }
//    public WebElement getUsernameSpotify(){
//        return usernameSpotify;
//    }
//    public WebElement getPassSpotify(){
//        return passSpotify;
//    }
//    public WebElement getLoginInSpotify() {
//        return logInSpotify;
//    }
//
//    public WebElement getErrorMessage(){
//        return ErrorMessage;
//    }
//
//
//


    public WebElement getUsername() {
        return username;
    }


    public WebElement getPassword() {
        return password;
    }


    public WebElement getLoginButton() {

        return loginButton;
    }


    public WebElement getErrorText() {
        return errorText;
    }

    public WebElement getHamburgerButton() {
        return hamburgerButton;
    }
// public WebElement getElement() {
//      return element;
//  }

}

