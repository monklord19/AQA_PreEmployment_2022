package SpotifyPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    WebDriver driver;

    WebDriverWait wait;
    By loginButton = By.xpath("//button[@data-testid='login-button']");

    By closeCookieButton = By.id("onetrust-accept-btn-handler");


    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    public void closeCookie() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(closeCookieButton));
        WebElement closeCookieButtonElement = driver.findElement(closeCookieButton);
        closeCookieButtonElement.click();
    }

    public void clickLogin() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(closeCookieButton));
        WebElement loginPageButtonElement = driver.findElement(loginButton);
        loginPageButtonElement.click();
    }
}
