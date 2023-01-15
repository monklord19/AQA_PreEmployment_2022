package demoPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementPage {
    WebDriver driver;
    WebDriverWait wait;

    By expandHomeButton = By.xpath("//button[@title='Toggle']");

    public ElementPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void clickOnElementItems(String elementItem) {
        String categoryElementItemXpath = "//span[contains(text(),'" + elementItem + "')]";
        WebElement meniuItemsElement = driver.findElement(By.xpath(categoryElementItemXpath));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", meniuItemsElement);
        wait.until(ExpectedConditions.visibilityOf(meniuItemsElement));
        meniuItemsElement.click();
    }

    public void clickOnExpandHomeButton() {
        WebElement expandHomeButtonElement = driver.findElement(expandHomeButton);
        expandHomeButtonElement.click();
    }

    public void clickOnCheckbox(String node) {
        String checkboxXpath = "//*[@id='tree-node-" + node.toLowerCase() + "']//following-sibling::span[@class='rct-checkbox']";
        WebElement checkboxElement = driver.findElement(By.xpath(checkboxXpath));
        checkboxElement.click();
    }

    public String messageIsDisplayed(String message) {
        By messageIsDisplayed = By.xpath("//span[@class='text-success' and text()='" + message + "']");
        WebElement messageIsDisplayedElement = driver.findElement(messageIsDisplayed);
        return messageIsDisplayedElement.getText();
    }

}
