package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SpotifyPage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    private final By btn_CookieButton = By.id("onetrust-accept-btn-handler");
    private final By btn_connect = By.xpath("//button[@data-testid='login-button']");
    private final By btn_continueGoogle = By.xpath("//button[@data-testid='google-login']");
    private final By txt_googleAccount = By.id("identifierId");
    private final By btn_clicknextG = By.cssSelector("#identifierNext [jscontroller]");
    private final By btn_TryAgainG =By.xpath("//*[@id=\"next\"]/div/button");
    private final By txt_spotifyname = By.id("login-username");
    private final By txt_spotifypassword = By.id("login-password");
    private final By btn_spotifyLogin = By.xpath("//button[@id='login-button']");
    private final By msg_errorSpotify = By.xpath("//span[contains(text(), \"Nume\")]");
//    private final By btn_continueApple = By.xpath("//button[@data-testid='apple-login']");
//    private final By txt_appleName = By.id("account_name_text_field");
//    private final By btn_appleLogin =By.id("sign-in");
//    private final By txt_applePassword=By.id("password_text_field");
//    private final By msg_errorApple =By.xpath("//*[starts-with(@id, 'unlock')]");
    private final By btn_continueFacebook = By.xpath("//button[@data-testid='facebook-login']");
    private final By btn_closeFacebookCookies =By.xpath("//button[@data-cookiebanner='accept_button']");
    private final By txt_FacebookEmail=By.id("email");
    private final By txt_FacebookPassword=By.id("pass");
    private final By btn_FacebookLogin=By.id("loginbutton");
    private final By msg_errorFacebook=By.xpath("//div[@role='alert']");


    public SpotifyPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }
    public void closeCookie(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(btn_CookieButton));
        WebElement closeCookieButtonElement = driver.findElement(btn_CookieButton);
        closeCookieButtonElement.click();
    }
    public void Connect(){
        driver.findElement(btn_connect).click();
    }
    public void clickChooseGoogle() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(btn_continueGoogle));
        driver.findElement(btn_continueGoogle).click();
    }
    public void enterAccount(String account){
        driver.findElement(txt_googleAccount).sendKeys(account);
    }
    public void clickBtnNext(){
        driver.findElement(btn_clicknextG).click();
    }
    public void verifyTryAgainIsDisplayed(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(btn_TryAgainG));
        Assert.assertTrue(driver.findElement(btn_TryAgainG).isDisplayed());
    }

    public void enterSpotifyname(String name){
        wait.until(ExpectedConditions.visibilityOfElementLocated(txt_spotifyname));
        driver.findElement(txt_spotifyname).sendKeys(name);
    }
    public void enterSpotifyPassword(String password){
        wait.until(ExpectedConditions.visibilityOfElementLocated(txt_spotifypassword));
        driver.findElement(txt_spotifypassword).sendKeys(password);
    }
    public void clickSpotifyLogin(){
        driver.findElement(btn_spotifyLogin).click();
    }
    public void verifyErrorSpotify(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(msg_errorSpotify));
        WebElement element = driver.findElement(msg_errorSpotify);
        String strng = element.getText();
        System.out.println(strng);
        Assert.assertEquals("Nume utilizator sau parolă incorectă.", strng);
    }

    public void clickChooseFacebook(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(btn_continueFacebook));
        driver.findElement(btn_continueFacebook).click();
    }
    public void enterFacebookAccount(String arg0) {
        driver.findElement(txt_FacebookEmail).sendKeys(arg0);
    }
    public void enterFacebookpassword(String password){
        driver.findElement(txt_FacebookPassword).sendKeys(password);
    }
    public void clickSigninFacebook(){
        driver.findElement(btn_FacebookLogin).click();
    }
    public void verifyFacebookError(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(msg_errorFacebook));
        Assert.assertTrue(driver.findElement(msg_errorFacebook).isDisplayed());

    }
    public void clikCloseFacebookCookies() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(btn_closeFacebookCookies));
        WebElement element = driver.findElement(btn_closeFacebookCookies);
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
        element.click();
    }
}
