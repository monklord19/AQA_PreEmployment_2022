package org.SaucedemoTesting.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage {
    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']")
    private WebElement btn_addToCart_SLBTSH;
    @FindBy(xpath = "//button[@id='remove-sauce-labs-bolt-t-shirt']")
    private WebElement btn_removeFromCart_SLBTSH;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private WebElement cartIcon;
    @FindBy(xpath = "//div[@class='inventory_item_name']")
    private WebElement itemNameContainer;

    public WebElement getBtn_addToCart_SLBTSH() {
        return btn_addToCart_SLBTSH;
    }

    public WebElement getBtn_removeFromCart_SLBTSH() {
        return btn_removeFromCart_SLBTSH;
    }

    public WebElement getCartIcon() {
        return cartIcon;
    }

    public WebElement getItemNameContainer() {
        return itemNameContainer;
    }
}
