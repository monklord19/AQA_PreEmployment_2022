package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutFinishPage {
    @FindBy(css = "div.complete-text")
    private WebElement ponyText;


    WebDriver driver;

    public CheckoutFinishPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void checkPonyText(String actuallyPonyText){

        Assert.assertEquals(actuallyPonyText, ponyText.getText() );

    }
}
