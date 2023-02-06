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

public class RadioButton {
    WebDriver driver;
    WebDriverWait wait;

    RadioButtonLocators radioButtonLocators;

    public RadioButton(WebDriver driver) {
        this.driver = driver;
        driver.manage().window().maximize();
        radioButtonLocators = new RadioButtonLocators(driver);
    }

    public void openElements()
    {
        radioButtonLocators.getOpenElements().click();

    }
    public void clickRadioButton(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(radioButtonLocators.getRadio()));
        radioButtonLocators.getRadio().click();
    }

    public void clickYes(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement yesTick = driver.findElement(By.className("custom-control-label"));
        yesTick.click();
    }
    public void messageRadioButton(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(radioButtonLocators.getMessageRadio()));
        String messageRadio = radioButtonLocators.getMessageRadio().getText();
        Assert.assertEquals(messageRadio, "You have selected Yes");
    }


}
