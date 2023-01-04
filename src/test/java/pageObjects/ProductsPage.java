package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsPage {
    WebDriver driver;

    By inventoryList = By.className("inventory_list");
    By shoppingCartBadge = By.className("shopping_cart_badge");


    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addProductToCart(String productName) {
        WebElement inventoryListElement = driver.findElement(inventoryList);
        List<WebElement> productsList = inventoryListElement.findElements(
                By.xpath("./div[@class='inventory_item']"));
        for (WebElement product : productsList) {
            if (product.getText().contains(productName)) {
                WebElement addToCartButton = product.findElement(By.xpath("./div/div/button"));
                addToCartButton.click();
                break;
            }
        }
    }
    public boolean checkProductIsAdded(){
        WebElement shoppingCartElement = driver.findElement(shoppingCartBadge);
        return shoppingCartElement.isDisplayed();
    }

}
