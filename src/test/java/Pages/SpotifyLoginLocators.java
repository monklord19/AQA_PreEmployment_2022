package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SpotifyLoginLocators {
    WebDriver driver;
    public SpotifyLoginLocators(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public static final String id_username = "login-username";
    public static final String id_password = "login-password";
    public static final String login_xpath = "//*[@id=\"login-button\"]/div[1]/span";
    public static final String error_xpath = "//*[@id=\"root\"]/div/div[2]/div/div/div[1]/span";


    public static final String login_with_google_xpath = "//*[@id=\"root\"]/div/div[2]/div/div/ul/li[3]/button";
    public static final String id_gmail = "indentifierId";
    public static final String cls_pass_google = "whs0nd";

    public static final String login_google_xpath = "//*[@id=\"passwordNext\"]/div/button/div[3]";

    public static final String error_google_xpath = "//*[@id=\\\"view_container\\\"]/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div[2]/div[2]/span";

    @FindBy(id = SpotifyLoginLocators.id_username)
    @CacheLookup
    private
    WebElement username;

    @FindBy (id = SpotifyLoginLocators.id_password)
    @CacheLookup
    private
    WebElement password;

    @FindBy (xpath = SpotifyLoginLocators.login_xpath)
    @CacheLookup
    private
    WebElement loginbutton;

    @FindBy (xpath = SpotifyLoginLocators.error_xpath)
    @CacheLookup
    private
    WebElement errorspotify;

    @FindBy(xpath = SpotifyLoginLocators.login_with_google_xpath)
    @CacheLookup
    private static
    WebElement googlelogin;

    @FindBy (id = SpotifyLoginLocators.id_gmail)
    @CacheLookup
    private
    WebElement gmail;

    @FindBy (className = SpotifyLoginLocators.cls_pass_google)
    @CacheLookup
    private
    WebElement passwordgmail;

    @FindBy (xpath = SpotifyLoginLocators.login_google_xpath)
    @CacheLookup
    private
    WebElement gmailbutton;

    @FindBy (xpath = SpotifyLoginLocators.error_google_xpath)
    @CacheLookup
    private
    WebElement errorgoogle;

    public WebDriver getDriver() {
        return driver;
    }

    public WebElement getUsername() {
        return username;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getLoginButton() {
        return loginbutton;
    }

    public WebElement getErrorPop_up() {
        return errorspotify;
    }

    public static WebElement getLoginWithGoogle() {
        return googlelogin;
    }

    public WebElement getGmail() {
        return gmail;
    }
    public WebElement getGooglePassword() {
        return passwordgmail;
    }

    public WebElement getLoginGoogle() {
        return gmailbutton;
    }

    public WebElement getErrorOfGoogle() {
        return errorgoogle;
    }











}
