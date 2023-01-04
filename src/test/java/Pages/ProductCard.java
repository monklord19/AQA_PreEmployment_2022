package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductCard {

    @FindBy(css = "#add-to-cart-sauce-labs-backpack")
    private WebElement addToCartButton;

    @FindBy(css = "#item_%s_title_link")
    private WebElement productLink;
    WebDriver driver;

    public ProductCard(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addProductToCart() {
        addToCartButton.click();
    }






}
