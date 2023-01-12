package spotifyLoginPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AppleLoginPage {
    WebDriver driver;
    WebDriverWait wait;
    private final By usernameField = By.xpath("//input[@can-field='accountName']");
    private final By usernameSigninButton = By.xpath("//button[@id='sign-in']");
    private final By passwordField = By.xpath("//input[@can-field='password']");
    private final By alertMessage = By.xpath("//h2[@id='alertInfo']");

    public AppleLoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }
    public void setAppleUsername(String username){
        WebElement usernameFieldElement = driver.findElement(usernameField);
        usernameFieldElement.sendKeys(username);
    }
    public void clicksSigninButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameSigninButton));
        WebElement usernameSigninButtonElement = driver.findElement(usernameSigninButton);
        usernameSigninButtonElement.click();
    }
    public void setApplePassword(String password){
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        WebElement passwordFieldElement = driver.findElement(passwordField);
        passwordFieldElement.sendKeys(password);
    }
    public boolean alertMessageIsDisplayed(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(alertMessage));
        WebElement alertMessageElement = driver.findElement(alertMessage);
        return alertMessageElement.isDisplayed();
    }
    public String getTextMessage(){
        WebElement textMessageElement = driver.findElement(alertMessage);
        return textMessageElement.getText();
    }

}
