package pages;

import com.sun.source.tree.IfTree;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v106.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage  {

    @FindBy(css = ".peek")
    private WebElement productsPageLogo;

    @FindBy(css = "#shopping_cart_container")
    private WebElement cartLink;

    @FindBy(css = "button#add-to-cart-sauce-labs-backpack")
    private WebElement bagAddToCardButton;
    WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void LogoIsDisplayed() {
        Assert.assertTrue(productsPageLogo.isDisplayed());
    }

    public void clickCartLink() {
        cartLink.click();
    }

    public void addBagToCart() {
        bagAddToCardButton.click();
    }
}
