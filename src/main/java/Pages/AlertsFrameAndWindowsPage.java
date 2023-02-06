package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AlertsFrameAndWindowsPage extends Page{
    public AlertsFrameAndWindowsPage(WebDriver driver) {
        super(driver);
    }

    By browserWindowsElem = By.xpath("//span[text()='Browser Windows']");
    By newWindowBtnElem = By.cssSelector("#windowButton");
    By textFromNewWindowElem = By.cssSelector("#sampleHeading");
    By alertsElem = By.xpath("//span[text()='Alerts']");
    By firstClickMeBtnElem = By.cssSelector("#alertButton");



    private WebElement browserWindows() {
        return driver.findElement(browserWindowsElem);
    }
    private WebElement newWindowBtn() {
        return driver.findElement(newWindowBtnElem);
    }
    private WebElement textFromNewWindow() {
        return driver.findElement(textFromNewWindowElem);
    }
    private WebElement alerts() {
        return driver.findElement(alertsElem);
    }
    private WebElement firstClickMeBtn() {
        return driver.findElement(firstClickMeBtnElem);
    }


    public void clickOnBrowserWindows() {
        browserWindows().click();
    }
    public void clickOnNewWindowBtnElem() {
        newWindowBtn().click();
    }
    public String getTextFromNewWindow() {
       return textFromNewWindow().getText();
    }
    public void clickOnAlerts() {
        alerts().click();
    }
    public void clickOnFirstClickMeBtn() {
        firstClickMeBtn().click();
    }
}
