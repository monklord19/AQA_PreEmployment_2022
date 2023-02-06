package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class CheckBox {
    WebDriver driver;
    WebDriverWait wait;

    CheckBoxLocators checkBoxLocators;

    public CheckBox(WebDriver driver) {
        this.driver = driver;
        checkBoxLocators = new CheckBoxLocators(driver);
    }

    public void clickElementsCategory()
    {
        checkBoxLocators.getElementsCategory().click();

    }

    public void clickCheckBox(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(checkBoxLocators.getCheckBox()));
        checkBoxLocators.getCheckBox().click();
    }
    public void clickExpandAll(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement expandAllButton = driver.findElement(By.cssSelector("#tree-node > div > button.rct-option.rct-option-expand-all > svg"));
        expandAllButton.click();
    }

    public void checkNotes() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement notes = driver.findElement(By.cssSelector("#tree-node > ol > li > ol > li:nth-child(1) > ol > li:nth-child(1) > span > label > span.rct-checkbox > svg"));
        notes.click();
    }
    public void checkAngular(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement angular = driver.findElement(By.cssSelector("#tree-node > ol > li > ol > li:nth-child(2) > ol > li:nth-child(1) > ol > li:nth-child(2) > span > label > span.rct-checkbox > svg"));
        angular.click();
    }

    public void checkGeneral(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement general = driver.findElement(By.cssSelector("#tree-node > ol > li > ol > li:nth-child(2) > ol > li:nth-child(2) > ol > li:nth-child(1) > span > label > span.rct-checkbox > svg"));
        general.click();
    }

    public void verifyTheText(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement result = driver.findElement(By.cssSelector("#result"));
        String resultMessage = result.getText();
        Assert.assertEquals(resultMessage, "You have selected :\n" +
                "notes\n" +
                "angular\n" +
                "public");
    }

}
