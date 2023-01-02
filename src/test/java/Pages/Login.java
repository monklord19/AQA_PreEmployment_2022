package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class Login {
    WebDriver driver;
    WebElement usernameInput;
    WebElement passwordInput;
    WebElement loginButton;

    public WebElement getUsernameInput() {
        return driver.findElement(By.id("user-name"));
    }
    public WebElement getPasswordInput() {
        return driver.findElement(By.id("password"));
    }
    public WebElement getLoginButton() {
        return driver.findElement(By.id("login-button"));
    }

    public Login(WebDriver driver) {
        this.driver = driver;
    }

    public void inputUsername(String username) {
        getUsernameInput().sendKeys(username);
    }

    public void inputPassword(String password) {
        getPasswordInput().sendKeys(password);
    }

    public void clickLoginButton() {
        getLoginButton().click();
    }
}
