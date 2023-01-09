package page.objects;

import Locators.PageLocators;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginFlow {
    WebDriver driver;
    WebDriverWait wait;
    PageLocators pageLocators;


    public LoginFlow(WebDriver driver) {
        this.driver = driver;
        pageLocators = new PageLocators(driver);
    }


    public void setUsername(String username) {
        pageLocators.getUsername().clear();
        pageLocators.getUsername().sendKeys(username);
    }

    public void setPassword(String password) {
        pageLocators.getPassword().clear();
        pageLocators.getPassword().sendKeys(password);
    }

    public void clickLogin() {
        pageLocators.getLoginButton().click();
    }


    public void checkHomePageOpened() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement pageTitle = pageLocators.getPageTitle();
        wait.until(ExpectedConditions.visibilityOf(pageTitle));
        Assert.assertTrue(pageTitle.isDisplayed());
    }

    public void checkErrorBtn() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement errorBtn = pageLocators.getErrorBtn();
        wait.until(ExpectedConditions.visibilityOf(errorBtn));
        Assert.assertTrue(errorBtn.isDisplayed());
    }

    public void errorMessage(String errormsg){
        WebElement errorBtn = pageLocators.getErrorBtn();
        Assert.assertTrue(errorBtn.isDisplayed());
    }
    public void hitReturnEnteKey(){
        pageLocators.getPassword().sendKeys(Keys.RETURN);
    }

}