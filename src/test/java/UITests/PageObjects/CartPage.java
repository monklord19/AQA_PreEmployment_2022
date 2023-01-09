package UITests.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class CartPage {
    private WebDriver driver;

    public WebElement getCustomByXPath(String xpath) {
        return driver.findElement(By.xpath(xpath));
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
}

