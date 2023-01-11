package UITests.PageObjects;

//cookies button
//first login button
//username input
//password input
//spotify account login button
//facebook account login button
//
//error message


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SpotifyPage{
    public static WebDriver driver;
     private WebDriverWait wait;
    @FindBy(id = "onetrust-accept-btn-handler")
    private WebElement cookies_button;

    @FindBy(xpath = "//*[@id=\"main\"]/div/div[2]/div[1]/header/div[5]/button[2]")
    private WebElement login_button;

    @FindBy(id = "login-username")
    private WebElement username_input;

    @FindBy(id = "login-password")
    private WebElement password_input;

    @FindBy(id = "login-button")
    private WebElement spotify_account_login_button;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div/ul/li[1]/button")
    private WebElement facebook_account_login_button;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div/ul/li[2]/button")
    private WebElement apple_account_login_button;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div/ul/li[3]/button")
    private WebElement google_account_login_button;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div/div[1]/span")
    private WebElement error_message;

    public SpotifyPage(WebDriver driver){
        SpotifyPage.driver = driver;
        wait = new WebDriverWait(SpotifyPage.driver, Duration.ofSeconds(60));
        PageFactory.initElements(driver, this);
    }


    public WebElement getGoogle_account_login_button() {
        return google_account_login_button;
    }

    public void setGoogle_account_login_button(WebElement google_account_login_button) {
        this.google_account_login_button = google_account_login_button;
    }

    public WebElement getApple_account_login_button() {
        return apple_account_login_button;
    }

    public void setApple_account_login_button(WebElement apple_account_login_button) {
        this.apple_account_login_button = apple_account_login_button;
    }

    public WebElement getFacebook_account_login_button() {
        return facebook_account_login_button;
    }

    public void setFacebook_account_login_button(WebElement facebook_account_login_button) {
        this.facebook_account_login_button = facebook_account_login_button;
    }

    public WebElement getSpotify_account_login_button() {
        return spotify_account_login_button;
    }

    public void setSpotify_account_login_button(WebElement spotify_account_login_button) {
        this.spotify_account_login_button = spotify_account_login_button;
    }

    public WebElement getPassword_input() {
        return password_input;
    }

    public void setPassword_input(WebElement password_input) {
        this.password_input = password_input;
    }

    public WebElement getUsername_input() {
        return username_input;
    }

    public void setUsername_input(WebElement username_input) {
        this.username_input = username_input;
    }

    public WebElement getLogin_button() {
        return login_button;
    }

    public void setLogin_button(WebElement login_button) {
        this.login_button = login_button;
    }
    public WebElement getError_message() {
        return error_message;
    }

    public void setError_message(WebElement error_message) {
        this.error_message = error_message;
    }
    public WebElement getCookies_button() {
        return cookies_button;
    }

    public void setCookies_button(WebElement cookies_button) {
        this.cookies_button = cookies_button;
    }

    public void acceptCookies(){
        wait.until(ExpectedConditions.elementToBeClickable(getCookies_button()));
        cookies_button.click();
    }
    public void clickFirstLoginButton(){
        getLogin_button().click();
    }
    public void putCredentials(String user, String password){
        wait.until(ExpectedConditions.visibilityOf(username_input));
        username_input.sendKeys(user);
        password_input.sendKeys(password);
    }
    public void clickSpotifyLogin(){
        wait.until(ExpectedConditions.elementToBeClickable(spotify_account_login_button));
        spotify_account_login_button.click();
    }

    public void checkErrorMessage(String errorMessage){
        wait.until(ExpectedConditions.visibilityOf(error_message));
        Assert.assertTrue(error_message.getText().equalsIgnoreCase(errorMessage));
    }


    public void checkIfErrorMessageDisplay() {
        wait.until(ExpectedConditions.visibilityOf(error_message));
        Assert.assertTrue(error_message.isDisplayed());
    }

    public void clickLoginWithFacebook() {
        wait.until(ExpectedConditions.elementToBeClickable(facebook_account_login_button));
        facebook_account_login_button.click();
    }

    public void clickLoginWithApple() {
        wait.until(ExpectedConditions.elementToBeClickable(apple_account_login_button));
        apple_account_login_button.click();
    }
}

