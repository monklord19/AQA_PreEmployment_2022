package SaucedemoTesting.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    protected WebDriver driver;
    private By txt_username = By.id("user-name");
    private By txt_password = By.id("password");
    private By btn_login = By.id("login-button");
    private By btn_hamburger = By.className("bm-burger-button");
    private By btn_logout = By.xpath("//a[@id = 'logout_sidebar_link']");
    private By errorMessage = By.xpath("//h3[@data-test = 'error']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        if (!driver.getTitle().equals("Swag Labs")) {
            throw new IllegalStateException("This is not Login Page.The current page is" + driver.getCurrentUrl());
        }
    }

    public void enterUsername(String username) {
        driver.findElement(txt_username).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(txt_password).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(btn_login).click();
    }

    public void pressEnter() {
        driver.findElement(btn_login).sendKeys(Keys.ENTER);
    }

    public void checkHamburgerButtonIsDisplayed() {
        driver.findElement(btn_hamburger).isDisplayed();
    }

}