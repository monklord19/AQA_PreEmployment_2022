package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsPage {
    WebDriver driver;

    private final By inventoryList = By.className("inventory_list");
    private final By shoppingCartBadge = By.className("shopping_cart_badge");
    private final By burgerMButton = By.className("bm-burger-button");
    private final By addToCartBtn = By.xpath("./div/div/button");
    private final By burgerM = By.className("bm-menu-wrap");


    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addProductToCart(String productName) {
        WebElement inventoryListElement = driver.findElement(inventoryList);
        List<WebElement> productsList = inventoryListElement.findElements(
                By.xpath("./div[@class='inventory_item']"));
        for (WebElement product : productsList) {
            if (product.getText().contains(productName)) {
                WebElement addToCartButtonElement = product.findElement(addToCartBtn);
                addToCartButtonElement.click();
                break;
            }
        }
    }

    public boolean checkProductIsAdded() {
        WebElement shoppingCartElement = driver.findElement(shoppingCartBadge);
        return shoppingCartElement.isDisplayed();
    }

    public void clickOnMeniuButton() {
        WebElement burgerMeniuButtonElement = driver.findElement(burgerMButton);
        burgerMeniuButtonElement.click();
    }

    public String checkBurgerMeniuIsOpened() {
        WebElement burgerMeniuElement = driver.findElement(burgerM);
        return burgerMeniuElement.getAttribute("aria-hidden");
    }

}
