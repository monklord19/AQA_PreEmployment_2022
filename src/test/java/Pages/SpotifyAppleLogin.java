package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SpotifyAppleLogin {
    protected WebDriver driver;
    protected WebDriverWait wait;
    private final By btn_continueApple = By.xpath("//button[@data-testid='apple-login']");
    private final By txt_appleName = By.id("account_name_text_field");
    private final By btn_appleLogin =By.id("sign-in");
    private final By txt_applePassword=By.id("password_text_field");
    private final By msg_errorApple =By.xpath("//*[starts-with(@id, 'unlock')]");

    public SpotifyAppleLogin(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
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
