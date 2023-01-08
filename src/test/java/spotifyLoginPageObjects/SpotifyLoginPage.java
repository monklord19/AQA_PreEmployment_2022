package spotifyLoginPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SpotifyLoginPage {
    WebDriver driver;
    WebDriverWait wait;
    By continueWithGoogleButton = By.xpath("//button[@data-testid='google-login']");

    public SpotifyLoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void continueWithGoogle() {
        wait.until(ExpectedConditions.elementToBeClickable(continueWithGoogleButton));
        WebElement continueWithGoogleElement = driver.findElement(continueWithGoogleButton);
        continueWithGoogleElement.click();
    }


}
