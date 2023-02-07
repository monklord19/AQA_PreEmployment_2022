package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DemoButtonsPage extends BasePage {
    public WebDriver driver;

    public WebElement getDemoQAButtonsSubmenu(){
        return driver.findElement(By.xpath("//span[contains(text(), 'Buttons')]"));
    }
    public WebElement getDemoQADoubleClickButton(){
        return driver.findElement(By.id("doubleClickBtn"));
    }
    public WebElement getDemoQARightClickButton(){
        return driver.findElement(By.id("rightClickBtn"));
    }

    public WebElement getDemoClickMeButton(){
        return driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[3]/button"));
    }
    public DemoButtonsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
