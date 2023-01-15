package demoPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementPage {
    WebDriver driver;
    WebDriverWait wait;

    By expandHomeButton = By.xpath("//button[@title='Toggle']");
    By doubleClickButton = By.id("doubleClickBtn");
    By rightClickButton = By.id("rightClickBtn");
    By clickButton = By.xpath("//button[contains(text(),'Click Me')]//following::button[2]");
    By doubleClickMessage = By.id("doubleClickMessage");
    By rightClickMessage = By.id("rightClickMessage");
    By clickMessage = By.id("dynamicClickMessage");

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

    public void doubleClickButtonAction() {
        Actions actions = new Actions(driver);
        WebElement doubleClickButtonElement = driver.findElement(doubleClickButton);
        actions.doubleClick(doubleClickButtonElement).perform();
    }

    public void rightClickButtonAction() {
        Actions actions = new Actions(driver);
        WebElement rightClickButtonElement = driver.findElement(rightClickButton);
        actions.contextClick(rightClickButtonElement).perform();
    }

    public void clickButtonAction() {
        WebElement clickButtonElement = driver.findElement(clickButton);
        clickButtonElement.click();
    }

    public void confirmationMessagesAreDisplayed(){
        WebElement doubleClickMesageElement = driver.findElement(doubleClickMessage);
        WebElement rightClickMessageElement = driver.findElement(rightClickMessage);
        WebElement clickMessageElement= driver.findElement(clickMessage);
        doubleClickMesageElement.isDisplayed();
        rightClickMessageElement.isDisplayed();
        clickMessageElement.isDisplayed();
    }
}
