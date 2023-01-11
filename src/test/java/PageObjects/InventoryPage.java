package PageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class InventoryPage extends BasePage{
    public WebDriver driver;
    By inventoryList = By.id("inventory_container");

    public InventoryPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public List<WebElement> getInventoryItemsBuyButtons() {
        WebElement inventoryListElement = driver.findElement(inventoryList);
        return inventoryListElement.findElements(By.xpath("//button[starts-with (@id,'add-to-cart')]"));
    }

    public List<WebElement> getInventoryItemsNamesElements() {
        WebElement inventoryListElement = driver.findElement(inventoryList);
        return inventoryListElement.findElements(By.xpath("//*[contains (@class,'inventory_item_name')]"));
    }

    public void addItemToCart(WebElement item) {
        item.click();
    }
}
