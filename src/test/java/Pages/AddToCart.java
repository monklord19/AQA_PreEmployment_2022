package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class AddToCart {

    protected WebDriver driver;

    private By btn_addBackpack = By.id("add-to-cart-sauce-labs-backpack");

    private By btn_cartBadge = By.id("shopping_cart_badge");

    private By txt_backpackName =By.xpath("//*[@id=\"item_4_title_link\"]/div");

    public AddToCart(WebDriver driver) {
        this.driver = driver;
        if (!driver.getTitle().equals("Swag Labs")) {
            throw new IllegalStateException("This is not Login Page of Saucedemo website. The current page is" + driver.getCurrentUrl());
        }
    }
    public void addProductToCart() {
        driver.findElement(btn_addBackpack).click();
    }
    public void clickShoppingCart(){
        driver.findElement(btn_cartBadge).click();
    }
}
