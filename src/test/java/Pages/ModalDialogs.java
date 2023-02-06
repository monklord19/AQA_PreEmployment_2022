package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ModalDialogs {
    WebDriver driver;
    WebDriverWait wait;
    ModalDialogsLocators modalDialogsLocators;

    public ModalDialogs (WebDriver driver)
    {
        this.driver = driver;
        driver.manage().window().maximize();
        modalDialogsLocators = new ModalDialogsLocators(driver);
    }

    public void clickAlertsFrameWindows()
    {
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));;
        WebElement alertFrame = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[3]"));
        alertFrame.click();

    }

    public void scroolingThePage(){
        WebElement element = driver.findElement(By.tagName("body"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
        for (int i = 0; i < 5; i++) {
            actions.sendKeys(Keys.PAGE_DOWN);
            actions.perform();
        }
    }

    public void clickModalDialogs(){
        driver.get("https://demoqa.com/modal-dialogs");
    }

    public void clickSmallModal(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(modalDialogsLocators.getSmallModal()));
        modalDialogsLocators.getSmallModal().click();
    }

    public void closeSmallModal(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(modalDialogsLocators.getCloseSmall()));
        modalDialogsLocators.getCloseSmall().click();
    }

    public void clickLargeModal(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(modalDialogsLocators.getLargeModal()));
        modalDialogsLocators.getLargeModal().click();
    }

    public void closeLargeModal(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(modalDialogsLocators.getCloseLarge()));
        modalDialogsLocators.getCloseLarge().click();
    }

}
