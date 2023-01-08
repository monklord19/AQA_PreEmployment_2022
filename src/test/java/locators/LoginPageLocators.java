package locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageLocators {
    WebDriver driver;

    public LoginPageLocators(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public static final String USERNAME_ID = "user-name";
    public static final String PASSWORD_ID = "password";
    public static final String LOGIN_ID = "login-button";
    public static final String ERROR_XPATH = "//h3[@data-test = 'error']";
    public static final String HAMBURGER_BUTTON_CLS = "bm-burger-button";
    public static final String LOGOUT_BUTTON_XPATH = "//a[@id = 'logout_sidebar_link']";

    public static final String LOGIN_BUTTON_XPATH = "//span[@class='ButtonInner-sc-14ud5tc-0 kuwYvr encore-inverted-light-set']";
    public static final String USERNAME_ID_SPOTIFY = "login-username";
    public static final String PASS_ID_SPOTIFY = "login-password";
    public static final String LOGIN_SPOT_XPATH = "//span[text()='Log In']";

    public static final String SERROR_XPATH = "//span[contains(text(),'Incorrect')]";
    public static final String CONTINUE_XPATH = "//span[contains(text(),'Apple')]";
    public static final String APPLE_ID = "account_name_text_field";
    public static final String PASS_ID = "password_text_field";
    public static final String SIGN_IN_CSS = "i.shared-icon.icon_sign_in";
    public static final String AERROR_CSS = "#errMsg";

    @FindBy(id = LoginPageLocators.USERNAME_ID)
    @CacheLookup
    private
    WebElement username;

    @FindBy(id = LoginPageLocators.PASSWORD_ID)
    @CacheLookup
    private
    WebElement password;

    @FindBy(id = LoginPageLocators.LOGIN_ID)
    @CacheLookup
    private
    WebElement loginButton;

    @FindBy(xpath = LoginPageLocators.ERROR_XPATH)
    @CacheLookup
    private
    WebElement errorMessage;

    @FindBy(className = LoginPageLocators.HAMBURGER_BUTTON_CLS)
    @CacheLookup
    private
    WebElement hamburgerButton;

    @FindBy(xpath = LoginPageLocators.LOGOUT_BUTTON_XPATH)
    @CacheLookup
    private
    WebElement logoutButton;

    @FindBy(xpath = LoginPageLocators.LOGIN_BUTTON_XPATH)
    @CacheLookup
    private
    WebElement loginButtonSpotify;

    @FindBy(id = LoginPageLocators.USERNAME_ID_SPOTIFY)
    @CacheLookup
    private
    WebElement usernameSpotify;

    @FindBy(id = LoginPageLocators.PASS_ID_SPOTIFY)
    @CacheLookup
    private
    WebElement passSpotify;

    @FindBy(xpath = LoginPageLocators.LOGIN_SPOT_XPATH)
    @CacheLookup
    private
    WebElement logInSpotify;

    @FindBy(xpath = LoginPageLocators.SERROR_XPATH)
    @CacheLookup
    private
    WebElement sErrorMessage;
    @FindBy(xpath = LoginPageLocators.CONTINUE_XPATH)
    @CacheLookup
    private
    WebElement continueWithAppleBtn;
    @FindBy(id = LoginPageLocators.APPLE_ID)
    @CacheLookup
    private
    WebElement appleId;

    @FindBy(id = LoginPageLocators.PASS_ID)
    @CacheLookup
    private
    WebElement applePass;

    @FindBy(css = LoginPageLocators.SIGN_IN_CSS)
    private
    WebElement signInIcon;

    @FindBy(css = LoginPageLocators.AERROR_CSS)
    @CacheLookup
    private
    WebElement aErrorMessage;

    public WebElement getUsername() {
        return username;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getLoginButton() {

        return loginButton;
    }

    public WebElement getErrorMessage() {
        return errorMessage;
    }

    public WebElement getHamburgerButton() {
        return hamburgerButton;
    }

    public WebElement getLogoutButton() {
        return logoutButton;
    }

    public void resetElement() {
        PageFactory.initElements(driver, this);
    }

    //methods for Spotify login
    public WebElement getLoginButtonSpotify() {
        return loginButtonSpotify;
    }

    public WebElement getUsernameSpotify() {
        return usernameSpotify;
    }

    public WebElement getPassSpotify() {
        return passSpotify;
    }

    public WebElement getLogInSpotify() {
        return logInSpotify;
    }

    public WebElement getSErrorMessage() {
        return sErrorMessage;
    }

    public WebElement getContinueWithApple() {
        return continueWithAppleBtn;
    }

    public WebElement getAppleId() {
        return appleId;
    }

    public WebElement getApplePass() {
        return applePass;
    }

    public WebElement getSignInIcon() {
        return signInIcon;
    }

    public WebElement getAErrorMessage() {
        return aErrorMessage;
    }

}
