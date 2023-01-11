package spotifyLoginPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SpotifyMainPage {
    WebDriver driver;

    WebDriverWait wait;
    private final By loginButton = By.xpath("//button[@data-testid='login-button']");
    private final By closeCookieButton = By.id("onetrust-accept-btn-handler");

    public SpotifyMainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        }

    public void waitVisibility(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void closeCookie() {
        waitVisibility(closeCookieButton);
        WebElement closeCookieButtonElement = driver.findElement(closeCookieButton);
        closeCookieButtonElement.click();
    }

    public void clickLogin() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(closeCookieButton));
        WebElement loginPageButtonElement = driver.findElement(loginButton);
        loginPageButtonElement.click();
    }

}
