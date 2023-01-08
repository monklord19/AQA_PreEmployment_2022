package Testing.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SpotifyLoginPage {
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
    @FindBy(id = "identifierNext")
    private WebElement btn_GoogleNextEmail;
    @FindBy(name = "password")
    private WebElement txt_GooglePassword;
    @FindBy(xpath = "//span[jsname='B34EJ']")
    private WebElement google_errMsg;
    @FindBy(id="login-username")
    private WebElement txt_spotifyEmail;
    @FindBy(id="login-password")
    private WebElement getTxt_spotifyPasword;
    @FindBy(id="login-button")
    private WebElement btn_spotifyLogIn;
    @FindBy(xpath = "//div[@role='alert']")
    private WebElement spotify_errMsg;

    public WebElement getBtn_spotifyAcceptCookies() {
        return btn_spotifyAcceptCookies;
    }

    public WebElement getBtn_SpotifyLogin() {
        return btn_SpotifyLogin;
    }

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

    public WebElement getBtn_continueWithGoogle() {
        return btn_continueWithGoogle;
    }

    public WebElement getTxt_GoogleEmail() {
        return txt_GoogleEmail;
    }

    public WebElement getBtn_GoogleNextEmail() {
        return btn_GoogleNextEmail;
    }

    public WebElement getTxt_GooglePassword() {
        return txt_GooglePassword;
    }
    public WebElement getGoogle_errMsg() {
        return google_errMsg;
    }

    public WebElement getTxt_spotifyEmail() {
        return txt_spotifyEmail;
    }

    public WebElement getGetTxt_spotifyPasword() {
        return getTxt_spotifyPasword;
    }

    public WebElement getBtn_spotifyLogIn() {
        return btn_spotifyLogIn;
    }

    public WebElement getSpotify_errMsg() {
        return spotify_errMsg;
    }
}
