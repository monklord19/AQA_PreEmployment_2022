package UITests.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage {
    private WebDriver driver;

    private WebElement addtocart_button;
    private  WebElement shopping_cart_container_button;

    private WebElement product_title;

    public void setAddtocart_button(WebElement addtocart_button) {
        this.addtocart_button = addtocart_button;
    }

    public void setShopping_cart_container_button(WebElement shopping_cart_container_button){
        this.shopping_cart_container_button = shopping_cart_container_button;
    }
    public void setProduct_title(WebElement product_title){
        this.product_title = product_title;
    }
    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getAddtocart_button() {
        return addtocart_button;
    }
    public WebElement getProduct_title(){
        return product_title;
    }

    public WebElement getShopping_cart_container_button() {
        return shopping_cart_container_button;
    }

    public void click_addtocart_button()
    {
        setAddtocart_button(driver.findElement(By.id("add-to-cart-sauce-labs-backpack")));
        setProduct_title(driver.findElement(By.id("item_4_title_link")));
        addtocart_button.click();

    }

    public void click_shopping_cart_container()
    {
        setShopping_cart_container_button(driver.findElement(By.id("shopping_cart_container")));
        shopping_cart_container_button.click();
    }
}
