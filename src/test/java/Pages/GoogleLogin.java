package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class GoogleLogin{
    WebDriver driver;
    WebDriverWait wait;

    GoogleLoginLocators googleloginLocators;

    public GoogleLogin(WebDriver driver){
        this.driver = driver;
        googleloginLocators = new GoogleLoginLocators(driver);
    }

    public void loginWithGoogleCont(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(googleloginLocators.getLoginWithGoogleCont()));
        googleloginLocators.getLoginWithGoogleCont().click();
    }

    public void anotherAccount(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(googleloginLocators.getAnotherAccount()));
        googleloginLocators.getAnotherAccount().click();
    }

    public void enterGmail(String gmail){
        wait.until(ExpectedConditions.visibilityOf(googleloginLocators.getEnterGmail()));
        googleloginLocators.getEnterGmail().clear();
        googleloginLocators.getEnterGmail().sendKeys(gmail, Keys.RETURN);

    }

    public void enterPass(String passwordgmail){
        wait.until(ExpectedConditions.visibilityOf(googleloginLocators.getEnterPass()));
        googleloginLocators.getEnterPass().clear();
        googleloginLocators.getEnterPass().sendKeys(passwordgmail, Keys.RETURN);

    }

    public void loginWithGmail(){
        wait.until(ExpectedConditions.elementToBeClickable(googleloginLocators.getLoginWithGmail()));
        googleloginLocators.getLoginWithGmail().click();
    }

    public void errorOfGoogle(String googleError){
        wait.until(ExpectedConditions.visibilityOf(googleloginLocators.getErrorOfGoogle()));
        Assert.assertEquals(googleloginLocators.getErrorOfGoogle().getText(), googleError);

    }











}



