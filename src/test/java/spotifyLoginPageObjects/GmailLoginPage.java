package spotifyLoginPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GmailLoginPage {
    WebDriver driver;
    WebDriverWait wait;

    By gmailUsernameField = By.xpath("//input[@type='email']");
    By gmailLoginButton = By.xpath("//div[@class='qhFLie']/div/div/button");
    By messageAccountNotFound = By.xpath("//div[contains(text(),'Contul Google nu a fost găsit')]");

    public GmailLoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    public void setGmailUsername(String username) {
        WebElement gmailUsernameFieldElement = driver.findElement(gmailUsernameField);
        gmailUsernameFieldElement.sendKeys(username);
    }

    public void clickOnLoginGmailButton(){
        WebElement gmailLoginButtonElement = driver.findElement(gmailLoginButton);
        gmailLoginButtonElement.click();
    }

    public boolean messageAccountNotFoundDisplayed(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(messageAccountNotFound));
        WebElement messageAccountNotFoundElement = driver.findElement(messageAccountNotFound);
        return messageAccountNotFoundElement.isDisplayed();
    }

}
