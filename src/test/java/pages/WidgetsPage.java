package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WidgetsPage {
    WebDriver driver;
    @FindBy(css = ".show .menu-list li:nth-of-type(4)")
    private WebElement sliderButton;

    public WidgetsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void clickSliderButton(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Actions actions = new Actions(driver);
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");

        sliderButton.click();
    }

}
