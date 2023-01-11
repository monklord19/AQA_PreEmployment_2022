package spotifyLoginPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FacebookLoginPage {
    WebDriver driver;
    WebDriverWait wait;
    By facebookAcceptCookieButton = By.xpath("//button[@data-cookiebanner='accept_button']");
    By facebookUsernameField = By.xpath("//input[@type='text']");
    By facebookPasswordField = By.xpath("//input[@type='password']");
    By facebookLoginButton = By.xpath("//button[@name='login']");
    By notAccountMessage = By.xpath("//div[@role='alert']");


    public FacebookLoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void acceptCookie() {
        WebElement facebookAcceptCookieButtonElement = driver.findElement(facebookAcceptCookieButton);
        facebookAcceptCookieButtonElement.click();
    }

    public void setFacebookUsername(String username) {
        WebElement facebookUsernameFieldElement = driver.findElement(facebookUsernameField);
        facebookUsernameFieldElement.sendKeys(username);
    }

    public void setFacebookPassword(String password) {
        WebElement facebookPasswordFieldElement = driver.findElement(facebookPasswordField);
        facebookPasswordFieldElement.sendKeys(password);
    }

    public void clickLogin(){
        WebElement facebookLoginButtonElement = driver.findElement(facebookLoginButton);
        facebookLoginButtonElement.click();
    }
    public boolean notAccountMessageIsDisplayed(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(notAccountMessage));
        WebElement notAccountMessageElement = driver.findElement(notAccountMessage);
        return notAccountMessageElement.isDisplayed();
    }
}
