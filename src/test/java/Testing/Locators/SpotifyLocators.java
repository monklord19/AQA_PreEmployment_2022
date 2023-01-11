package Testing.Locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SpotifyLocators {
    @FindBy(id="onetrust-accept-btn-handler")
    private WebElement btn_spotifyAcceptCookies;
    @FindBy(xpath = "//button[@data-testid='login-button']")
    private WebElement btn_SpotifyLogin;
    @FindBy(xpath = "//button[@data-testid='facebook-login']")
    private WebElement btn_continueWithFB;
    @FindBy(xpath = "//button[@data-cookiebanner='accept_only_essential_button']")
    private WebElement btn_fb_allowCookies;
    @FindBy(id = "email")
    private WebElement txt_fb_emailField;
    @FindBy(id="pass")
    private WebElement txt_fb_passField;
    @FindBy(id = "loginbutton")
    private WebElement btn_fb_Login;
    @FindBy(className = "_4rbf" )
    private WebElement fb_errMsg;
    @FindBy(xpath ="//button[@data-testid='google-login']" )
    private WebElement btn_continueWithGoogle;
    @FindBy(id = "identifierId")
    private WebElement txt_GoogleEmail;
    @FindBy(xpath = "//div[@id='passwordNext']//div[3]")
    private WebElement btn_GoogleNext;
    @FindBy(name = "password")
    private WebElement txt_GooglePassword;
    @FindBy(xpath = "//span[jsname='B34EJ']")
    private WebElement google_errMsg;
    @FindBy(id="login-username")
    private WebElement txt_spotifyEmail;
    @FindBy(id="login-password")
    private WebElement txt_spotifyPassword;
    @FindBy(id="login-button")
    private WebElement btn_LogInWithSpotify;
    @FindBy(xpath = "//div[@role='alert']")
    private WebElement spotify_errMsg;
    @FindBy(xpath = "//button[@data-testid='apple-login']")
    private WebElement btn_continueWithApple;
    @FindBy(id="account_name_text_field")
    private WebElement appleId;
    @FindBy(css="i.shared-icon.icon_sign_in")
    private WebElement btn_appleSignIn;
    @FindBy(id="password_text_field")
    private WebElement applePassword;
    @FindBy (css= "#errMsg")
    private WebElement appleError;

//general getters
    public WebElement getBtn_spotifyAcceptCookies() {
        return btn_spotifyAcceptCookies;
    }

    public WebElement getBtn_SpotifyLogin() {
        return btn_SpotifyLogin;
    }
//getters for facebook login
    public WebElement getBtn_continueWithFB() {
        return btn_continueWithFB;
    }

    public WebElement getBtn_fb_allowCookies() {
        return btn_fb_allowCookies;
    }

    public WebElement getTxt_fb_emailField() {
        return txt_fb_emailField;
    }

    public WebElement getTxt_fb_passField() {
        return txt_fb_passField;
    }

    public WebElement getFb_errMsg() {
        return fb_errMsg;
    }

    public WebElement getBtn_fb_Login() {
        return btn_fb_Login;
    }
//getters for google login
    public WebElement getBtn_continueWithGoogle() {
        return btn_continueWithGoogle;
    }

    public WebElement getTxt_GoogleEmail() {
        return txt_GoogleEmail;
    }

    public WebElement getBtn_GoogleNext() {
        return btn_GoogleNext;
    }

    public WebElement getTxt_GooglePassword() {
        return txt_GooglePassword;
    }
    public WebElement getGoogle_errMsg() {
        return google_errMsg;
    }
//getters for spotify login
    public WebElement getTxt_spotifyEmail() {
        return txt_spotifyEmail;
    }

    public WebElement getTxt_spotifyPassword() {
        return txt_spotifyPassword;
    }

    public WebElement getBtn_LogInWithSpotify() {
        return btn_LogInWithSpotify;
    }

    public WebElement getSpotify_errMsg() {
        return spotify_errMsg;
    }

//getters for apple login
    public WebElement getBtn_continueWithApple() {
        return btn_continueWithApple;
    }

    public WebElement getAppleId() {
        return appleId;
    }

    public WebElement getBtn_appleSignIn() {
        return btn_appleSignIn;
    }

    public WebElement getApplePassword() {
        return applePassword;
    }

    public WebElement getAppleError() {
        return appleError;
    }
}
