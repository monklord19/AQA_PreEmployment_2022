package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class Header {
    public static final String cartIconId = "user-name";

    @FindBy(id = cartIconId)
    @CacheLookup
    private
    WebElement cartIcon;

    public WebElement getCartIcon() {
        return cartIcon;
    }
}
