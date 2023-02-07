package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class DemoWidgetsPage extends BasePage{

    public WebDriver driver;
    public WebElement horizontalSlider(){
        return driver.findElement(By.className("range-slider"));
    }
    public DemoWidgetsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
