package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SpotifyHomepage extends Page{
    By allCookies = By.id("onetrust-accept-btn-handler");
    By loginButton = By.cssSelector(".ButtonInner-sc-14ud5tc-0.kuwYvr.encore-inverted-light-set");

    public SpotifyHomepage(WebDriver driver) {
        super(driver);
    }
    @Override
    public void waitUntilElementIsVisible(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Wait from SpotifyHomepage");
    }

    public WebElement acceptAllCookies() {
        return driver.findElement(allCookies);
    }

    public WebElement clickOnLoginButton() {
        return driver.findElement(loginButton);
    }
}
