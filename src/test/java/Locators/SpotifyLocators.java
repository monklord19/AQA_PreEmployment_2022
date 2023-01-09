package Locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SpotifyLocators {
    WebDriver driver;

    public SpotifyLocators(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //locators for login with spotify
    public static final String ACCEPT_COOKIES_ID = "onetrust-accept-btn-handler";
    public static final String LOGIN_XPATH = "//span[@class='ButtonInner-sc-14ud5tc-0 kuwYvr encore-inverted-light-set']";
    public static final String USERNAME_ID = "login-username";
    public static final String PASSWORD_ID = "login-password";
    public static final String LOGIN_SPOTIFY_XPATH = "//*[@id=\"login-button\"]/div[1]/span";
    public static final String ERROR_MSG_XPATH = "//*[@id=\"root\"]/div/div[2]/div/div/div[1]/span";


    //locators for login with google accounts

    public static final String CONTINUE_WITH_GOOGLE_XPATH = "//*[@id=\"root\"]/div/div[2]/div/div/ul/li[3]/button/span";
    public static final String EMAIL_ADRESS_NAME = "identifier";
    public static final String PASSWORD_CLS = "whsOnd";
    public static final String CONTINUE_XPATH = "//*[@id=\"passwordNext\"]/div/button/span";
    public static final String GOOGLE_ERRORMSG_XPATH = "//*[@id=\"view_container\"]/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div[2]/div[2]/span";

    //locators for login with facebook

    public static final String CONTINUW_WITH_FACEBOOK_XPATH = "//span[@class='Type__TypeElement-goli3j-0 dmuHFl sc-hKwDye sc-kDTinF sc-iqseJM fXzRSj iSqHJa cSNvew']";
    public static final String COOKIES_FACEBOOK_XPATH = "/html/body/div[3]/div[2]/div/div/div/div/div[3]/button[2]";
    public static final String FACEBOOK_ID = "email";
    public static final String FACEBOOK_PASSWORD_ID = "pass";
    public static final String LOG_IN_ID = "loginbutton";
    public static final String FACEBOOK_ERRORMSG_XPATH = "//*[@id=\"facebook\"]/body/div[2]/h1";


    // spotify accounts

    @FindBy(id = SpotifyLocators.ACCEPT_COOKIES_ID)
    @CacheLookup
    private WebElement cookies;

    @FindBy(xpath = SpotifyLocators.LOGIN_XPATH)
    @CacheLookup
    private WebElement loginButton;

    @FindBy(id = SpotifyLocators.USERNAME_ID)
    @CacheLookup
    private WebElement usernameSpotify;

    @FindBy(id = SpotifyLocators.PASSWORD_ID)
    @CacheLookup
    private WebElement passwordSpotify;

    @FindBy(xpath = SpotifyLocators.LOGIN_SPOTIFY_XPATH)
    @CacheLookup
    private WebElement loginSpotify;
    @FindBy(xpath = SpotifyLocators.ERROR_MSG_XPATH)
    @CacheLookup
    private WebElement errormsgSpotify;

    //google accounts

    @FindBy(xpath = SpotifyLocators.CONTINUE_WITH_GOOGLE_XPATH)
    @CacheLookup
    private WebElement continueWithGoogle;

    @FindBy(name = SpotifyLocators.EMAIL_ADRESS_NAME)
    @CacheLookup
    private WebElement emailAdressGoogle;

    @FindBy(className = SpotifyLocators.PASSWORD_CLS)
    @CacheLookup
    private WebElement passwordGoogle;

    @FindBy(xpath = SpotifyLocators.CONTINUE_XPATH)
    @CacheLookup
    private WebElement continuePath;

    @FindBy(xpath = SpotifyLocators.GOOGLE_ERRORMSG_XPATH)
    @CacheLookup
    private WebElement errormsgGoogle;

    //facebook accounts

    @FindBy(xpath = SpotifyLocators.CONTINUW_WITH_FACEBOOK_XPATH)
    @CacheLookup
    private WebElement continueWithFacebook;

    @FindBy(xpath = SpotifyLocators.COOKIES_FACEBOOK_XPATH)
    @CacheLookup
    private WebElement acceptCookies;

    @FindBy(id = SpotifyLocators.FACEBOOK_ID)
    @CacheLookup
    private WebElement facebookId;

    @FindBy(id = SpotifyLocators.FACEBOOK_PASSWORD_ID)
    @CacheLookup
    private WebElement facebookPassword;

    @FindBy(id = SpotifyLocators.LOG_IN_ID)
    @CacheLookup
    private WebElement loginId;

    @FindBy(xpath = FACEBOOK_ERRORMSG_XPATH)
    @CacheLookup
    private WebElement errorMsgFacebook;

    //getters for spotify
    public  WebElement getCookies(){
        return cookies;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

    public WebElement getUsernameSpotify() {
        return usernameSpotify;
    }

    public WebElement getPasswordSpotify() {
        return passwordSpotify;
    }

    public WebElement getLoginSpotify() {
        return loginSpotify;
    }

    public WebElement getErrormsgSpotify() {
        return errormsgSpotify;
    }

    // getters for google

    public WebElement getContinueWithGoogle() {
        return continueWithGoogle;
    }

    public WebElement getEmailAdressGoogle() {
        return emailAdressGoogle;

    }

    public WebElement getPasswordGoogle() {
        return passwordGoogle;

    }

    public WebElement getContinuePath() {
        return continuePath;

    }

    public WebElement getErrormsgGoogle() {
        return errormsgGoogle;
    }


    // getters for facebook

    public WebElement getContinueWithFacebook(){
        return  continueWithFacebook;
    }

    public  WebElement getAcceptCookies(){
        return acceptCookies;
    }

    public WebElement getFacebookId(){
        return facebookId;
    }

    public WebElement getFacebookPassword(){
        return facebookPassword;
    }
    public WebElement getLoginId(){
        return loginId;
    }
    public  WebElement getErrorMsgFacebook(){
        return errorMsgFacebook;
    }

}


