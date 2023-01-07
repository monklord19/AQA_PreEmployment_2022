package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPageObjects {
    WebDriver driver;
    By text_username = By.id("user-name");
    By text_password = By.id("password");
    By button_login = By.id("login-button");

    public loginPageObjects(WebDriver driver) {

       this.driver = driver;
    }
public void enterUsername(String username) {

        driver.findElement(text_username).sendKeys(username);
}

public void enterPassword(String password) {

        driver.findElement(text_password).sendKeys(password);
}

public void clickLogin() {
    driver.findElement(button_login).click();
    }

    public void validUsername(String username, String password) {
        driver.findElement(text_username).sendKeys(username);
        driver.findElement(text_password).sendKeys(password);
        driver.findElement(button_login).click();
    }
}
