package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CartPage {
    WebDriver driver = new ChromeDriver();
    public void checkIfTheBagIsInCart(String backPackName) {
        WebElement bagName = driver.findElement(By.cssSelector("a#item_4_title_link > .inventory_item_name"));
        Assert.assertEquals(backPackName,bagName.getText());
    }
}
