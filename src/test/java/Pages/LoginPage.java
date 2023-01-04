package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    protected WebDriver driver;
    private By txt_username = By.id("user-name");
    private By txt_password = By.id("password");
    private By btn_login = By.id("login-button");
    private By btn_cart = By.id("shopping_cart_container");
    private By btn_error = By.className("error-button");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUserName(String username) {
        driver.findElement(txt_username).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(txt_password).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(btn_login).click();
    }

    public void checkCartisDisplayed() {
        Assert.assertTrue(driver.findElement(btn_cart).isDisplayed());

    }

    public void errorMsgisDisplayed() {
        Assert.assertTrue(driver.findElement(btn_error).isDisplayed());
    }

    public void pressEnterKey() {
        driver.findElement(btn_login).sendKeys(Keys.ENTER);
    }

}
