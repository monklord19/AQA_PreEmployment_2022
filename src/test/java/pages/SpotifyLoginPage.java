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

    @FindBy (id= "facebook_login")
    private WebElement FacebookLoginButton;

    @FindBy (id= "google_login")
    private WebElement GoogleLoginButton;
    @FindBy (id= "apple_login")
    private WebElement AppleLoginButton;


    public void setUsernameField(String usernameText) {
        this.usernameField.sendKeys(usernameText);
    }
    public void setPasswordField(String passwordText) {
        this.passwordField.sendKeys(passwordText);
    }

    public SpotifyLoginPage(WebDriver driverWeb) {
        super(driverWeb);
        }
    public void clickLoginButton() {loginButtonSpotify.click(); }
    public void clickContinueWithFacebookButton() {FacebookLoginButton.click(); }
    public void clickContinueWithGoogleButton() {GoogleLoginButton.click(); }
    public void clickContinueWithAppleButton() {AppleLoginButton.click(); }

}
