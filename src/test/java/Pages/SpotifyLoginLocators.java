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

    //Login with spotify
    public static final String login_spotify_xpath = "//*[@id=\"main\"]/div/div[2]/div[1]/header/div[5]/button[2]/span";

    public static final String id_username = "login-username";
    public static final String xpath_password = "//*[@id=\"login-password\"]";
    public static final String login_xpath = "//*[@id=\"login-button\"]/div[1]";
    public static final String error_xpath = "//*[@id=\"root\"]/div/div[2]/div/div/div[1]/span";

    //Login via gmail



    //spotify login
    @FindBy(xpath = SpotifyLoginLocators.login_spotify_xpath)
    @CacheLookup
    private
    WebElement loginspotify;

    @FindBy(id = SpotifyLoginLocators.id_username)
    @CacheLookup
    private
    WebElement spotify_username;

    @FindBy (xpath = SpotifyLoginLocators.xpath_password)
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


    public WebElement getLoginSpotify(){
        return loginspotify;
    }

    public WebElement getUsername() {
        return spotify_username;
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
}
