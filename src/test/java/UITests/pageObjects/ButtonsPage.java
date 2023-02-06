package UITests.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ButtonsPage {

    WebDriver driver;
    Actions actions;
    public static String title = "Buttons";
    public static final By header = By.className("main-header");
    public static final By doubleClickButton = By.id("doubleClickBtn");
    public static final By rightClickButton = By.id("rightClickBtn");
    public static final By doubleClickMessage = By.id("doubleClickMessage");
    public static final By rightClickMessage = By.id("rightClickMessage");



    public ButtonsPage(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
    }

    public WebElement getElement(By locator) {
        return driver.findElement(locator);
    }


    public boolean isHeaderDisplayed() {
        return getElement(header).getText().equals(title);
    }

    public void doubleClickButton() {
        WebElement element = getElement(doubleClickButton);
        actions.doubleClick(element).perform();
    }

    public boolean isDoubleClickMessageDisplayed() {
        return getElement(doubleClickMessage).isDisplayed();
    }

    public void rightClickButton() {
        WebElement element = getElement(rightClickButton);
        actions.contextClick(element).perform();
    }

    public boolean isRightClickMessageDisplayed() {
        return getElement(rightClickMessage).isDisplayed();
    }

}
