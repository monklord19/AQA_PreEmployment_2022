package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class demoqaHomePage {
    WebDriver driver;
    @FindBy (css = "#app > div > div > div.home-body > div > div:nth-child(1)")
    private static WebElement elementsButton;

    @FindBy (css = "#app > div > div > div.home-body > div > div:nth-child(2)")
    private static WebElement formsButton;

    @FindBy (css = "#app > div > div > div.home-body > div > div:nth-child(4)")
    private static WebElement widgetsButton;

    public demoqaHomePage (WebDriver driverWeb) {
        this.driver = driverWeb;
        PageFactory.initElements(driver, this);
    }
    public static void clickElementsButton() {
        elementsButton.click();
    }

    public static void clickFormsButton() {
        formsButton.click();
    }

    public static void clickWidgetsButton() {
        widgetsButton.click();
    }

}
