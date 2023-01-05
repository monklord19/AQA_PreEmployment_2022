package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By usernameField = By.id("user-name");
    By passwordField = By.id("password");
    By loginButton = By.id("login-button");
    By errorMessageElement = By.xpath("//h3[@data-test='error']");


    public void setUsernameField(String username) {
        WebElement usernameElement = driver.findElement(usernameField);
        usernameElement.sendKeys(username);
    }

    public void setPasswordField(String password) {
        WebElement passwordElement = driver.findElement(passwordField);
        passwordElement.sendKeys(password);
    }

    public void clickLoginButton() {
        WebElement loginElement = driver.findElement(loginButton);
        loginElement.click();
    }
    public boolean isErrorDisplayed(){
        WebElement errorElement = driver.findElement(errorMessageElement);
        return errorElement.isDisplayed();
    }
    public String getErrorMessage(){
        WebElement errorElement = driver.findElement(errorMessageElement);
        return errorElement.getText();
    }

}
