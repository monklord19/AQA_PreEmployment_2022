package Objects;
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

    public static final String ACCEPT_COOKIE_ID = "onetrust-accept-btn-handler";
    public static final String LOGIN_XPATH = "//span[@class='ButtonInner-sc-14ud5tc-0 kuwYvr encore-inverted-light-set']";
    public static final String USER_ID = "login-username";
    public static final String PASS_ID = "login-password";
    public static final String LOGIN_SPOTIFY_XPATH = "//*[@id=\"login-button\"]/div[1]/span";
    public static final String ER_MESSAGE_XPATH = "//*[@id=\"root\"]/div/div[2]/div/div/div[1]/span";

    public static final String CONT_WITH_GOOGLE_XPATH = "//*[@id=\"root\"]/div/div[2]/div/div/ul/li[3]/button/span";
    public static final String EMAIL_ADRESS_NAME = "identifier";
    public static final String PASSWORD_CLS = "whsOnd";
    public static final String CONTINUE_XPATH = "//*[@id=\"passwordNext\"]/div/button/span";
    public static final String GOOGLE_MESSAGE_XPATH = "//*[@id=\"view_container\"]/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div[2]/div[2]/span";

    @FindBy(id = SpotifyLocators.ACCEPT_COOKIE_ID)
    @CacheLookup
    private WebElement acceptCockie;

    @FindBy(xpath = SpotifyLocators.LOGIN_XPATH)
    @CacheLookup
    private WebElement loginButton;

    @FindBy(id = SpotifyLocators.USER_ID)
    @CacheLookup
    private WebElement userSpotify;

    @FindBy(id = SpotifyLocators.PASS_ID)
    @CacheLookup
    private WebElement passSpotify;

    @FindBy(xpath = SpotifyLocators.LOGIN_SPOTIFY_XPATH)
    @CacheLookup
    private WebElement loginSpotify;
    @FindBy(xpath = SpotifyLocators.ER_MESSAGE_XPATH)
    @CacheLookup
    private WebElement errMessageSpotify;

    @FindBy(xpath = SpotifyLocators.CONT_WITH_GOOGLE_XPATH)
    @CacheLookup
    private WebElement continueWithGoogle;

    @FindBy(name = SpotifyLocators.EMAIL_ADRESS_NAME)
    @CacheLookup
    private WebElement emailAdressGoogle;

    @FindBy(className = SpotifyLocators.PASSWORD_CLS)
    @CacheLookup
    private WebElement passGoogle;

    @FindBy(xpath = SpotifyLocators.CONTINUE_XPATH)
    @CacheLookup
    private WebElement continuePath;

    @FindBy(xpath = SpotifyLocators.GOOGLE_MESSAGE_XPATH)
    @CacheLookup
    private WebElement errorMessageGoogle;


    public WebDriver getDriver() {
        return driver;
    }

    public WebElement getAcceptCockie() {
        return acceptCockie;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

    public WebElement getUserSpotify() {
        return userSpotify;
    }

    public WebElement getPassSpotify() {
        return passSpotify;
    }

    public WebElement getLoginSpotify() {
        return loginSpotify;
    }

    public WebElement getErrMessageSpotify() {
        return errMessageSpotify;
    }

    public WebElement getContinueWithGoogle() {
        return continueWithGoogle;
    }

    public WebElement getEmailAdressGoogle() {
        return emailAdressGoogle;
    }

    public WebElement getPassGoogle() {
        return passGoogle;
    }

    public WebElement getContinuePath() {
        return continuePath;
    }

    public WebElement getErrorMessageGoogle() {
        return errorMessageGoogle;
    }
}
