package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class fillFormBookStore {
    static WebDriver driver;
    WebDriver wait;
    By fillUserName = By.id("userName");
    By fillPassword = By.id("password");
    By clickLoginButton = By.id("login");

    public fillFormBookStore(WebDriver driver) {
        this.driver = driver;
    }

    public void fillUsernameAndPassword() {
        driver.findElement(fillUserName).sendKeys("testing");
        driver.findElement(fillPassword).sendKeys("Testing1!");
    }

    public void clickLogin() {
        driver.findElement(clickLoginButton).click();
    }

}
