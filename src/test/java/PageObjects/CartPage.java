package PageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class CartPage extends  BasePage{
    public WebDriver driver;
    By cartList = By.className("cart_list");
    By cartButton = By.className("shopping_cart_link");

    public CartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void goToCartPage() {
        WebElement cartButtonElement = driver.findElement(cartButton);
        cartButtonElement.click();
    }

    public List<WebElement> getCartItemsNamesElements() {
        WebElement cartListElement = driver.findElement(cartList);
        return cartListElement.findElements(By.xpath("//*[contains (@class,'inventory_item_name')]"));
    }
}
