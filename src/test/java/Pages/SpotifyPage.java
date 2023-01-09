package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SpotifyPage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    private final By btn_CookieButton = By.id("onetrust-accept-btn-handler");
    private final By btn_connect = By.xpath("//button[@data-testid='login-button']");
    private final By btn_continueGoogle = By.cssSelector(".sc-hBUSln [class='Button-y0gtbx-0 hpTULc']");
    private final By txt_googleAccount = By.id("identifierId");
    private final By btn_clicknextG = By.cssSelector("#identifierNext [jscontroller]");
    private final By btn_TryAgainG =By.xpath("//*[@id=\"next\"]/div/button");
    private final By txt_spotifyname = By.id("login-username");
    private final By txt_spotifypassword = By.id("login-password");
    private final By btn_spotifyLogin = By.xpath("//*[@id=\"login-button\"]/div[1]");
    private final By msg_errorSpotify = By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[1]/span");
    private final By btn_continueApple = By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/ul/li[2]/button");
    private final By txt_appleName = By.id("account_name_text_field");
    private final By btn_appleLogin =By.id("sign-in");
    private final By txt_applePassword=By.id("password_text_field");
    private final By msg_errorApple =By.id("unlock-account-1673214474053-8");


    public SpotifyPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
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
    public void clickChooseApple() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(btn_continueApple));
        driver.findElement(btn_continueApple).click();
    }
    public void enterAppleName(String name){
        wait.until(ExpectedConditions.visibilityOfElementLocated(txt_appleName));
        driver.findElement(txt_appleName).sendKeys(name);
    }
    public void clickAppleNext(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(btn_appleLogin));
        driver.findElement(btn_appleLogin).click();
    }
    public void enterApplePassword(String password){
        wait.until(ExpectedConditions.visibilityOfElementLocated(txt_applePassword));
        driver.findElement(txt_applePassword).sendKeys(password);
    }
    public void verifyErrorApple(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(msg_errorApple));
        Assert.assertTrue(driver.findElement(msg_errorApple).isDisplayed());
    }
}
