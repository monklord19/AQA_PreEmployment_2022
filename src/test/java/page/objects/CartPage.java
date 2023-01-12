package page.objects;

import locators.CartPageLocators;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {

    CartPageLocators cartLocators;
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        actions = new Actions(driver);
        cartLocators = new CartPageLocators(driver);
    }

    public void clickOnAddToCartButton(String product) {
        WebElement productName = driver.findElement(By.xpath("//*[text() = '" + product + "']"));
        WebElement productWrapper = productName.findElement(By.xpath("ancestor::div[@class='inventory_item']"));
        actions.moveToElement(productName).perform();
        WebElement addToCart = productWrapper.findElement(By.xpath("//div[@class='pricebar']/button"));
        addToCart.click();
    }

    public void clickOnCartIcon() {
        cartLocators.getCartIcon().click();
    }

    public void checkProductAddedInCart(String productName, Double price, Integer quantity) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(cartLocators.getDescriptionLabel()));
        WebElement row = getProductRowByName(productName);
        Assert.assertTrue(row.findElement(By.className("inventory_item_price")).getText().equals("$" + price.toString()));
        Assert.assertTrue(row.findElement(By.className("cart_quantity")).getText().equals(quantity.toString()));
    }

    private WebElement getProductRowByName(String productName) {
        WebElement row = null;
        for (WebElement product : cartLocators.getCartProductList()) {
            WebElement productCartName = product.findElement(By.className("inventory_item_name"));
            if (productCartName.getText().equals(productName)) {
                row = product;
                break;
            }
        }
        return row;
    }
}
