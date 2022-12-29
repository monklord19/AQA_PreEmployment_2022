package pages;

import com.sun.source.tree.IfTree;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {

    @FindBy(css = ".peek")
    private WebElement productsPageLogo;
    WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public void LogoIsDisplayed() {
        Assert.assertTrue(productsPageLogo.isDisplayed());
        if (productsPageLogo.isDisplayed()) {
            driver.quit();
        }

    }


}
