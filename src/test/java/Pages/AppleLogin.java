package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class AppleLogin {
    WebDriver driver;
    WebDriverWait wait;

    AppleLoginLocators appleloginLocators;

    public AppleLogin(WebDriver driver) {
        this.driver = driver;
        appleloginLocators = new AppleLoginLocators(driver);
    }
    public void loginWithApple(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(appleloginLocators.getLoginWithApple()));
        appleloginLocators.getLoginWithApple().click();
    }

    public void enterAppleAccount(String accountapple){
        wait.until(ExpectedConditions.visibilityOf(appleloginLocators.getAppleAccount()));
        appleloginLocators.getAppleAccount().clear();
        appleloginLocators.getAppleAccount().sendKeys(accountapple, Keys.RETURN);

    }

    public void nextButtonApple(){
        wait.until(ExpectedConditions.elementToBeClickable(appleloginLocators.getNextButtonApple()));
        appleloginLocators.getNextButtonApple().click();
    }

    public void enterPassApple(String passapple){
        wait.until(ExpectedConditions.visibilityOf(appleloginLocators.getEnterPassApple()));
        appleloginLocators.getEnterPassApple().clear();
        appleloginLocators.getEnterPassApple().sendKeys(passapple, Keys.RETURN);

    }

    public void nextFinalButton(){
        wait.until(ExpectedConditions.elementToBeClickable(appleloginLocators.getNextFinalButton()));
        appleloginLocators.getNextFinalButton().click();
    }

    public void errorOfApple(String appleError){
        wait.until(ExpectedConditions.visibilityOf(appleloginLocators.getErrorOfApple()));
        Assert.assertEquals(appleloginLocators.getErrorOfApple().getText(), appleError);

    }




}