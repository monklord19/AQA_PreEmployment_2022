package PageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    public WebDriver driver;
    By usernameInput = By.id("user-name");
    By passwordInput = By.id("password");
    By loginButton = By.id("login-button");

    public LoginPage (WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public WebElement getUserNameLabel() {
        return driver.findElement(usernameInput);
    }
    public WebElement getPasswordLabel() {
        return driver.findElement(passwordInput);
    }
    public WebElement getLoginButton() {
        return driver.findElement(loginButton);
    }
}
