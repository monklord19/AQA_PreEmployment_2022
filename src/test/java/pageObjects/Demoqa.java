package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Demoqa {
    WebDriver driver;
    //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    By clickElementsButton = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[1]/span/div/div[1]");
    By assertExcelFileText = By.className("text-success");
    By clickTextBoxButton = By.id("item-0");
    By clickRadioButtonButton = By.id("item-2");
    By clickYesRadioButton = By.xpath("//*[@id=\"yesRadio\"]");
    By scroll = By.id("item-5");
    By clickWebTables = By.id("item-3");
    By clickEditCierra = By.id("edit-record-1");

    public Demoqa(WebDriver driver) {
        this.driver = driver;
    }

    public void clickElements() {
        driver.findElement(clickElementsButton).click();
    }

    public void assertExcelFileText() {
        String youHaveSelected = driver.findElement(By.className("text-success")).getText();
        String assertExcelFileText = "excelFile";
        Assert.assertEquals(youHaveSelected, assertExcelFileText);
    }

    public void clickTextBox() {
        driver.findElement(clickTextBoxButton).click();
    }

    public void clickRadioButton() {
        WebElement element = driver.findElement(scroll);
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();

        WebElement Radio = driver.findElement(clickRadioButtonButton);
        actions.moveToElement(Radio);
        Radio.click();

        //driver.findElement(clickRadioButtonButton).click();
    }

    public void yesRadioButton() {
//        Actions actions = new Actions(driver);
//        WebElement Yes = driver.findElement(clickYesRadioButton);
//        actions.moveToElement(Yes);
//        Yes.click();

        //wait.until(ExpectedConditions.elementToBeClickable(clickYesRadioButton)).click();

        //Yes.click();
        driver.findElement(clickYesRadioButton).sendKeys(Keys.RETURN);
        //driver.findElement(clickYesRadioButton).click();
    }

    public void clickWebTablesButton() {
        WebElement element = driver.findElement(scroll);
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
        driver.findElement(clickWebTables).click();
    }

    public void clickEditCierraInfo() {
        driver.findElement(clickEditCierra).click();
        //wait.until(ExpectedConditions.elementToBeClickable(clickEditCierra)).click();
    }

//    public void editFields() {
//        driver.findElement(editForm);
//    }
}
