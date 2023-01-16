package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SpotifyLoginPage extends MainPage {
    WebDriver driver;

    @FindBy(id = "login-username")
    private WebElement usernameField;

    @FindBy(id = "login-password")
    private WebElement passwordField;

    @FindBy (id= "login-button")
    private WebElement loginButtonSpotify;

    public void setUsernameField(String usernameText) {
        this.usernameField.sendKeys(usernameText);
    }
    public void setPasswordField(String passwordText) {
        this.passwordField.sendKeys(passwordText);
    }

    public SpotifyLoginPage(WebDriver driverWeb) {
        super(driverWeb);
        }
    public void clickLoginButton() {loginButtonSpotify.click();
    }

//    public static final String USERNAME_FIELD = 'login-username';
//    public static final String PASSWORD_FIELD = 'login-password';
//    public static final String SPOTIFY_LOGIN_BUTTON = 'login-button';
//    public static final String GOOGLE_LOGIN_BUTTON = 'google_login';
//    public static final String APPLE_LOGIN_BUTTON = 'apple_login';
//    public static final String FACEBOOK_LOGIN_BUTTON = 'facebook_login';


//        public WebElement  {}
//                username_field = driver.findElement (By.id ("login-username"));
//        driver = new ChromeDriver();
//        username_field.click();
//        username_field.send.keys ("user");
//
//        password_field = driver.findElement (By.id ("login-password"));
//        password_field.click();
//        password_field.send_keys ("password");
//
//        spotify_login_button = driver.findElement (By.id ("login-button"));
//        spotify_login_button.click();
//
//        google_login_button = driver.findElement (By.id ("google_login"));
//        google_login_button.click();
//
//        apple_login_button = driver.findElement (By.id ("apple_login"));
//        apple_login_button.click();
//
//        facebook_login_button = driver.findElement (By.id ("facebook_login"));
//        facebook_login_button.click();
//
}
