package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Homepage {

    WebDriver driver;
    By cartIcon1 = By.cssSelector("#shopping_cart_container");

    public Homepage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getCartIcon() {
        return driver.findElement(cartIcon1);
    }

}
