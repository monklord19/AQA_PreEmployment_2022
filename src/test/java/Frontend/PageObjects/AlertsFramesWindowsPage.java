package Frontend.PageObjects;

import Frontend.Locators.AlertsFramesWindowsLocators;
import Frontend.Steps.TestBase;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertsFramesWindowsPage extends TestBase {
    private AlertsFramesWindowsLocators alertsLocators= PageFactory.initElements(driver,AlertsFramesWindowsLocators.class);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    Actions actions = new Actions(driver);
    JavascriptExecutor javascriptExecutor=(JavascriptExecutor)driver;
    Alert alert;
    public void clickOnAlertsFrameWindowsSection(){
        WebElement alertsFrameWindows=alertsLocators.getAlertsFramesWindows();
        actions.moveToElement(alertsFrameWindows).click().build().perform();
    }
    public void clickOnAlertsSection() throws InterruptedException {
        WebElement alertsCategory=alertsLocators.getAlertsCategory();
//        javascriptExecutor.executeScript("arguments[0].scrollIntoView();",alertsCategory);
        alertsCategory.click();
        Thread.sleep(5000);
    }
    public void clickOnClickMeButtonForPromptBox() throws InterruptedException {
        actions.moveToElement( alertsLocators.getClickMePromptBtn()).click().build().perform();
        Thread.sleep(2000);
//        alertsLocators.getClickMePromptBtn().click();
    }
    public void switchToAlertBox(){
        alert=driver.switchTo().alert();
        String alertText=alert.getText();
        System.out.println("Alert text is: "+ alertText);
    }
    public void sendKeysToAlertBox(){
        driver.switchTo().alert().sendKeys("Madalina");
        driver.switchTo().alert().accept();
    }
    public void assertSuccessMessage(){
        WebElement successResultMessage=alertsLocators.getPromptResultMessage();
        Assert.assertEquals("You entered Madalina",successResultMessage.getText());
    }



}
