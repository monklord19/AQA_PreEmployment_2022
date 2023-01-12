package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginSpotifyLocators {


    WebDriver driver;

    public LoginSpotifyLocators(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public static final String LOGIN_BUTTON_XPATH = "/html/body/div[3]/div/div[2]/div[1]/header/div[5]/button[2]/span";
    public static final String USERNAME_ID_SPOTIFY = "login-username";
    public static final String PASS_ID_SPOTIFY = "login-password";
    public static final String LOGIN_SPOT_XPATH = "//*[@id=\"login-button\"]/div[1]";
    public static final String SERROR_XPATH = "//span[contains(text(),'Incorrect')";



    public static final String CONTINUE_XPATH = "//*[@id=\"root\"]/div/div[2]/div/div/ul/li[2]/button";
    public static final String APPLE_ID = "account_name_text_field";
    public static final String PASS_ID = "password_text_field";
    public static final String SIGN_IN_ID = "sign_in";
    public static final String AERROR_CSS = "#errMsg";



    @FindBy(xpath = LoginSpotifyLocators.LOGIN_BUTTON_XPATH)
    @CacheLookup
    private
    WebElement loginButtonSpotify;

    @FindBy(id = LoginSpotifyLocators.USERNAME_ID_SPOTIFY)
    @CacheLookup
    private
    WebElement usernameSpotify;

    @FindBy(id = LoginSpotifyLocators.PASS_ID_SPOTIFY)
    @CacheLookup
    private
    WebElement passSpotify;

    @FindBy(xpath = LoginSpotifyLocators.LOGIN_SPOT_XPATH)
    @CacheLookup
    private
    WebElement logInSpotify;


    @FindBy(xpath = LoginSpotifyLocators.SERROR_XPATH)
    @CacheLookup
    private
    WebElement sErrorMessage;



    @FindBy(xpath = LoginSpotifyLocators.CONTINUE_XPATH)
    @CacheLookup
    private
    WebElement continueWithAppleBtn;
    @FindBy(id = LoginSpotifyLocators.APPLE_ID)
    @CacheLookup
    private
    WebElement appleId;

    @FindBy(id = LoginSpotifyLocators.PASS_ID)
    @CacheLookup
    private
    WebElement applePass;

    @FindBy(id = LoginSpotifyLocators.SIGN_IN_ID)
    private
    WebElement signIn;

    @FindBy(css = LoginSpotifyLocators.AERROR_CSS)
    @CacheLookup
    private
    WebElement aErrorMessage;


    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div/ul/li[1]/button")
    private WebElement continueWithFacebook;

    @FindBy(xpath = "/html/body/div[3]/div[2]/div/div/div/div/div[3]/button[2]")
    private WebElement cookiesButton;

    @FindBy(id = "email")
    private WebElement usernameField;
    @FindBy(id = "pass")
    private WebElement passField;
    @FindBy(id = "loginbutton")
    private WebElement fbLoginButton;
    @FindBy(css = "div[role='alert']")
    private WebElement fbAlert;




    public WebElement getLoginButtonSpotify () {
            return loginButtonSpotify;
        }

        public WebElement getUsernameSpotify () {
            return usernameSpotify;
        }

        public WebElement getPassSpotify () {
            return passSpotify;
        }

        public WebElement getLogInSpotify () {
            return logInSpotify;
        }

        public WebElement getSErrorMessage () {
            return sErrorMessage;
        }


    public WebElement getContinueWithApple() {return continueWithAppleBtn;}

    public WebElement getAppleId() {return appleId;}

    public WebElement getApplePass() {return applePass;}

    public WebElement getSignIn() {return signIn;}

    public WebElement getErrorMessage() {return aErrorMessage;}



    public WebElement getContinueWithFacebook() { return continueWithFacebook;}

    public WebElement getCookiesButton() {return cookiesButton;}

    public WebElement getUsernameField() {
        return usernameField;
    }

    public WebElement getPassField() {
        return passField;
    }

    public WebElement getFbLoginButton() {
        return fbLoginButton;
    }


    public WebElement getFbAlert() {
        return fbAlert;
    }
}


