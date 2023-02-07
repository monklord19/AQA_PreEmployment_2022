package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DemoAlertsPage extends BasePage {
    public WebDriver driver;

    public WebElement getDemoAlertsFrameWindowsButton(){
        return driver.findElement(By.xpath("//h5[contains(text(), 'Alerts, Frame & Windows')]"));
    }

    public WebElement getDemoAlertsSubmenuButton(){
        return driver.findElement(By.xpath("//span[contains(text(), 'Alerts')]"));
    }

    public WebElement getDemoAlertButton(){
        return driver.findElement(By.id("alertButton"));
    }

    public WebElement getDemoTimerAlertButton(){
        return driver.findElement(By.id("timerAlertButton"));
    }

    public WebElement getDemoConfirmButton(){
        return driver.findElement(By.id("confirmButton"));
    }

    public WebElement getDemoPromptButton(){
        return driver.findElement(By.id("promtButton"));
    }

    public DemoAlertsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
