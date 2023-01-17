package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class FacebookLogin {
    WebDriver driver;
    WebDriverWait wait;

    FacebookLoginLocators facebookloginLocators;

    public FacebookLogin(WebDriver driver) {
        this.driver = driver;
        facebookloginLocators = new FacebookLoginLocators(driver);
    }
    public void clickLoginWebpageSpotify(){
        facebookloginLocators.getLoginWebpageSpotify().click();
    }
    public void loginWithFacebook(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.visibilityOf(facebookloginLocators.getLoginWithFacebook()));
        facebookloginLocators.getLoginWithFacebook().click();
    }
   // public void allowCookie(){
     //   wait.until(ExpectedConditions.visibilityOf(facebookloginLocators.getAllowCookie()));
       // facebookloginLocators.getAllowCookie().click();
    //}


    public void enterFacebookAccount(String accountfacebook){
        wait.until(ExpectedConditions.visibilityOf(facebookloginLocators.getFacebookAccount()));
        facebookloginLocators.getFacebookAccount().clear();
        facebookloginLocators.getFacebookAccount().sendKeys(accountfacebook, Keys.RETURN);

    }
    public void enterPassFacebook(String passfacebook){
        wait.until(ExpectedConditions.visibilityOf(facebookloginLocators.getEnterPassFacebook()));
        facebookloginLocators.getEnterPassFacebook().clear();
        facebookloginLocators.getEnterPassFacebook().sendKeys(passfacebook, Keys.RETURN);

    }

    public void connectFacebook(){
        wait.until(ExpectedConditions.elementToBeClickable(facebookloginLocators.getConnectFacebook()));
        facebookloginLocators.getConnectFacebook().click();
    }

    public void errorOfFacebook(String facebookError){
        wait.until(ExpectedConditions.visibilityOf(facebookloginLocators.getErrorOfFacebook()));
        Assert.assertEquals(facebookloginLocators.getErrorOfFacebook().getText(), facebookError);

    }




}