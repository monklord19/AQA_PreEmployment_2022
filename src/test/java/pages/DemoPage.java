package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoPage {
    @FindBy(css = ".category-cards > div:nth-of-type(1)")
    private WebElement elementsLink;
    WebDriver driver;

    public DemoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
public void clickOnElelments(){
        elementsLink.click();
}
}
