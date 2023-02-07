package pages;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class AlertsFramesWindowsPage {
    WebDriver driver;
    WebDriverWait wait;

    public AlertsFramesWindowsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div/div[3]/div/div[2]")
    private WebElement alertsFrameAndWindow;
    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[3]/div/ul/li[2]/span")
    private WebElement AlertsButton;
    @FindBy(id = "alertButton")
    private WebElement AlertButton;


    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[3]/div/ul/li[1]/span")
    private WebElement BrowserWindowsButton;
    @FindBy(id = "tabButton")
    private WebElement NewTabButton;
    @FindBy(id = "windowButton")
    private WebElement NewWindowButton;


    public void wait(WebElement element){
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
        w.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void clickOnAlertsFrameWindowsPage(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("javascript:window.scrollBy(250,350)");

        wait(alertsFrameAndWindow);
        alertsFrameAndWindow.click();
    }

    public void clickAlertsButton(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("javascript:window.scrollBy(250,350)");

        wait(AlertsButton);
        AlertsButton.click();
    }


    public void clickAlertButton(){
        AlertButton.click();
    }

    public void displayedAlert(String alertMsg){
        Alert simpleAlert = driver.switchTo().alert();
        Assert.assertEquals(alertMsg, simpleAlert.getText());
    }

    public void closeAlert(){
        driver.switchTo().alert().accept();
    }

    public void BrowserWindows(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("javascript:window.scrollBy(250,350)");

        wait(BrowserWindowsButton);
        BrowserWindowsButton.click();
    }

    public void clickNewTabButton(){
        Set<String> currentHandles = driver.getWindowHandles();
        NewTabButton.click();
        Set<String> newHandles = driver.getWindowHandles();
        if (newHandles.size() > currentHandles.size()) {
            System.out.println("A new tab has been opened.");
        } else {
            System.out.println("A new tab has not been opened.");
        }
    }

    public void clickNewWindowButton(){
        int originalWindowsCount = driver.getWindowHandles().size();

        NewWindowButton.click();

        Set<String> allWindows = driver.getWindowHandles();
        int newWindowsCount = allWindows.size();

        if (newWindowsCount > originalWindowsCount) {
            System.out.println("A new window has been opened.");
        } else {
            System.out.println("No new window has been opened.");
        }
    }

}
