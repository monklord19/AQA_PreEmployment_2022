package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductCard extends Page {

    @FindBy(css = "#add-to-cart-sauce-labs-backpack")
    private WebElement addToCartButton;

    @FindBy(css = "#item_%s_title_link")
    private WebElement productLink;

    public ProductCard(WebDriver driver) {
        super(driver);
    }

    public void addProductToCart() {
        addToCartButton.click();
    }

    @Override
    public void waitUntilElementIsVisible(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("\nWait from ProductCard");
    }





}
