package locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPageLocators {

    WebDriver driver;

    public CartPageLocators(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public static final String CART_ICON_XPATH = "//a[@class='shopping_cart_link']";
    public static final String DESCRIPTION_CLASS = "cart_desc_label";

    @FindBy(xpath = CartPageLocators.CART_ICON_XPATH)
    @CacheLookup
    private
    WebElement cartIcon;

    @FindBy(className = CartPageLocators.DESCRIPTION_CLASS)
    @CacheLookup
    private
    WebElement descriptionLabel;

    @FindAll(@FindBy(className = "cart_list"))
    @CacheLookup
    private List<WebElement> cartProductList;

    public WebElement getCartIcon() {
        return cartIcon;
    }

    public WebElement getDescriptionLabel() {
        return descriptionLabel;
    }

    public List<WebElement> getCartProductList() {
        return cartProductList;
    }

}
