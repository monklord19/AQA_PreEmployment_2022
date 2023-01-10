package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    public WebDriver driver;
    By username = By.id("user-name");
    By password = By.id("password");
    By loginButton = By.id("login-button");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //Set username in textbox
    public WebElement setUsername() {
        return driver.findElement(username);
    }

    //Set password in text box
    public WebElement setPassword() {

        return driver.findElement(password);
    }

    //Click on login button
    public WebElement login() {
        return driver.findElement(loginButton);
    }
}
