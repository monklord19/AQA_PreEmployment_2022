package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Slider {

    WebDriver driver;
    WebDriverWait wait;

    SliderLocators sliderLocators;


    public Slider(WebDriver driver) {
        this.driver = driver;
        driver.manage().window().maximize();
        sliderLocators = new SliderLocators(driver);
    }

    public void clickWidgets()
    {
        sliderLocators.getWidgets().click();

    }
    public void scroolingThePageDown(){
        WebElement element = driver.findElement(By.tagName("body"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
        for (int i = 0; i < 5; i++) {
            actions.sendKeys(Keys.PAGE_DOWN);
            actions.perform();
        }
    }
    public void clickSlider()
    {
        driver.get("https://demoqa.com/slider");
    }

    public void slideToRight() throws InterruptedException {
        WebElement slider = driver.findElement(By.cssSelector("#sliderContainer > div.col-9 > span > input"));

        Actions actions = new Actions(driver);
        Thread.sleep(3000);
        actions.clickAndHold(slider).moveByOffset(700, 100).release().perform();
    }
}