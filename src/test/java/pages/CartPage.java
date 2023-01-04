package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage {
    @FindBy(css = "btn_small")
    private WebElement removeLinks;
    @FindBy(css = ".cart_quantity")
    private WebElement cartQuantity;
    @FindBy(css = "button#react-burger-menu-btn")
    private WebElement meniuButton;
    @FindBy(css = "a#inventory_sidebar_link")
    private WebElement productPageLink;
    @FindBy(css = ".inventory_item_name")
    private WebElement sauceLabsBackpack;
    @FindBy(css = "button#checkout")
    private WebElement checkoutButton;
    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void checkIfBagIsInCart(String bagName) {

        Assert.assertEquals(bagName, sauceLabsBackpack.getText());

    }

    public void clickCheckoutButton() {
        checkoutButton.click();
    }

}
