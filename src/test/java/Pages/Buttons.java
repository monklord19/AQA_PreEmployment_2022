package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class Buttons {
    WebDriver driver;
    WebDriverWait wait;

    ButtonsLocators buttonsLocators;

    public Buttons(WebDriver driver) {
        this.driver = driver;
        buttonsLocators = new ButtonsLocators(driver);
    }

    public void clickElementsButton()
    {
        buttonsLocators.getElementsButton().click();

    }
    public void clickButtons(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(buttonsLocators.getButtons()));
        buttonsLocators.getButtons().click();
    }

    public void doubleClick(){
        Actions actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOf(buttonsLocators.getDoubleClick()));
        WebElement doubleclick = driver.findElement(By.xpath("//*[@id=\"doubleClickBtn\"]"));
        actions.doubleClick(doubleclick).perform();
    }
    public void messageDouble(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(buttonsLocators.getMessageDouble()));
        String messageD = buttonsLocators.getMessageDouble().getText();
        Assert.assertEquals(messageD, "You have done a double click");
    }

    public void rightClick(){
        Actions actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(buttonsLocators.getRightClick()));
        WebElement rightclick = buttonsLocators.getRightClick();
        actions.contextClick(rightclick).perform();
    }
    public void messageRight(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(buttonsLocators.getMessageRight()));
        String messageR = buttonsLocators.getMessageRight().getText();
        Assert.assertEquals(messageR, "You have done a right click");
    }

    public void leftClick(){

        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement clickButton = driver.findElement(By.xpath("//button[contains(text(),'Click Me')]//following::button[2]"));
        clickButton.click();
    }

    public void messageLeft(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(buttonsLocators.getMessageLeft()));
        String messageL = buttonsLocators.getMessageLeft().getText();
        Assert.assertEquals(messageL, "You have done a dynamic click");
    }








}
