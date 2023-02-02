package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoPage {


    WebDriver driver;
    @FindBy(css = ".category-cards > div:nth-of-type(1)")
    private WebElement elementsLink;
    @FindBy(css = ".category-cards > div:nth-of-type(2)")
    private WebElement formsLink;
    @FindBy(css = "div:nth-of-type(4) > div > .card-up")
    private WebElement widgetsLink;
    @FindBy(css = "div:nth-of-type(5) > div > .card-up")
    private WebElement interactionsLink;


    public DemoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnElelments() {
        elementsLink.click();
    }

    public void clickFormLink() {
        formsLink.click();
    }

    public void clickWidgetsLink() {
        widgetsLink.click();
    }
    public void clickInteractionsLink(){
        interactionsLink.click();
    }
}
