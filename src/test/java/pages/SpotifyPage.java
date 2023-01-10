package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.PublicKey;
import java.time.Duration;

public class SpotifyPage {
    WebDriver driver;
    WebDriverWait wait;

    public SpotifyPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

//Email or username login

    @FindBy(id = "onetrust-accept-btn-handler")
    private WebElement AcceptCookiesButton;
    @FindBy(xpath = "//button[@data-testid='login-button']")
    private WebElement HomePageLoginButtonSpotify;
    @FindBy(id = "login-username")
    private WebElement EmailOrUsernameLogin;

    @FindBy(id = "login-password")
    private WebElement PasswordId;

    @FindBy(xpath = "//*[@id=\"login-button\"]/div[1]")
    private WebElement EmailLoginButton;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div/div[1]/span")
    private WebElement IncorectCredentialsErrorMessage;


    //AppleLogin
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div/ul/li[2]/button/span")
    private WebElement ContinueWithAppleButton;

    @FindBy(id = "account_name_text_field")
    private WebElement AppleId;

    @FindBy(xpath = "//*[@id=\"sign-in\"]/i")
    private WebElement AppleIdEnterButton;

    @FindBy(id = "password_text_field")
    private WebElement ApplePassword;
    @FindBy(xpath = "//*[@id=\"sign-in\"]/i")
    private WebElement ApplePasswordEnterButton;

    @FindBy(xpath = "//*[@id=\"alertInfo\"]")
    private WebElement AppleAutenthificationError;

    //GoogleLogin

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div/ul/li[3]/button")
    private WebElement GoggleLoginButton;
    @FindBy(id = "identifierId")
    private WebElement GoogleEmail;
    @FindBy(xpath = "//*[@id=\"identifierNext\"]/div/button/span")
    private WebElement GoogleEmailEnterButton;
    @FindBy(id = "identifierId")
    private WebElement GooglePassword;
    @FindBy(xpath = "//*[@id=\"passwordNext\"]/div/button/div[3]")
    private WebElement GooglePasswordlEnterButton;

    //FacebookLogin
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div/ul/li[1]/button/span")
    private WebElement LoginWithFacebookButton;

    @FindBy(xpath = "/html/body/div[3]/div[2]/div/div/div/div/div[3]/button[2]")
    private WebElement AcceptCookiesOnfacebookButton;

    @FindBy(id="email")
    private WebElement FacebookEmail;
    @FindBy(id = "pass")
    private WebElement FacebookPassword;
    @FindBy(xpath = "//*[@id=\"loginbutton\"]")
    private WebElement  facebokLoginButton;
    @FindBy(xpath = "//*[@id=\"globalContainer\"]/div[3]/div/div/div")
    private WebElement FacebookErrorMessage;
    public void AcceptCookies(){

        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(4));
        w.until(ExpectedConditions.elementToBeClickable(AcceptCookiesButton));
        AcceptCookiesButton.click();
        //driver.quit();
    }

    public void HomePageLoginButton(){
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
        w.until(ExpectedConditions.elementToBeClickable(HomePageLoginButtonSpotify));
        HomePageLoginButtonSpotify.click();
    }

    public void EnterUsernameorEmail(String username){
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
        w.until(ExpectedConditions.elementToBeClickable(EmailOrUsernameLogin));
        EmailOrUsernameLogin.sendKeys(username);
    }

    public void EnterPassword(String password){
        PasswordId.sendKeys(password);
    }

    public void ClickLoginButton(){
        EmailLoginButton.click();
    }

    public void ShowErrorMessageSpotify(String errorMessage){

        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
        w.until(ExpectedConditions.elementToBeClickable(IncorectCredentialsErrorMessage));
        Assert.assertEquals(errorMessage, IncorectCredentialsErrorMessage.getText());
    }

    public void AppleLoginButton(){
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
        w.until(ExpectedConditions.elementToBeClickable(ContinueWithAppleButton));
        ContinueWithAppleButton.click();
    }

    public void AppleIdInsert(String id){
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
        w.until(ExpectedConditions.elementToBeClickable(AppleId));
        AppleId.sendKeys(id);

    }

    public void AppleIdEnter(){
        AppleIdEnterButton.click();
    }

    public void ApplePasswordInsert(String password){
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
        w.until(ExpectedConditions.elementToBeClickable(ApplePassword));

        ApplePassword.sendKeys(password);

    }

    public void ApplePasswordEnter(){
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
        w.until(ExpectedConditions.elementToBeClickable(ApplePasswordEnterButton));
        ApplePasswordEnterButton.click();
    }

    public void getErrorAppleAuthentification(String ErrorMessage){
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
        w.until(ExpectedConditions.elementToBeClickable(AppleAutenthificationError));
        Assert.assertEquals(ErrorMessage, AppleAutenthificationError.getText());
    }

    //GoogleAuthentification
    public void GoogleLoginButtonClick(){
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
        w.until(ExpectedConditions.elementToBeClickable(GoggleLoginButton));
        GoggleLoginButton.click();
    }
    public void insertGoogleEmail(String email)
    {
        GoogleEmail.sendKeys(email);
    }
    public void enterGoogleEmail()
    {
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
        w.until(ExpectedConditions.elementToBeClickable(GoogleEmailEnterButton));
        GoogleEmailEnterButton.click();
    }
    public void LoginWithFacebook()
    {
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
        w.until(ExpectedConditions.elementToBeClickable(LoginWithFacebookButton));
        LoginWithFacebookButton.click();
    }

    public void AcceptFacebookCookies()
    {
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(8));
        w.until(ExpectedConditions.elementToBeClickable(AcceptCookiesOnfacebookButton));
        AcceptCookiesOnfacebookButton.click();
    }
    public void insertFacebookEmailandPassword(String email, String password)
    {
        FacebookEmail.sendKeys(email);
        FacebookPassword.sendKeys(password);
    }
    public void EnterFacebookLoginButton()
    {
        facebokLoginButton.click();
    }
    public void FacebookErrorMessage(String ErrorMessage)
    {
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
        w.until(ExpectedConditions.elementToBeClickable(FacebookErrorMessage));
        Assert.assertEquals(ErrorMessage, FacebookErrorMessage.getText());
        System.out.println(FacebookErrorMessage.getText());

    }


}
