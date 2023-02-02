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
    @FindBy(css = ".show .menu-list li:nth-of-type(2)")
    private WebElement autoCompleteButton;
    @FindBy(css = ".show .menu-list li:nth-of-type(8)")
    private WebElement menuButton;
    @FindBy(css = ".show .menu-list li:nth-of-type(9)")
    private WebElement selectMenuButton;

    public WidgetsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void clickSliderButton() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");

        sliderButton.click();
    }

    public void clickAutoCompleteButton(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("javascript:window.scrollBy(250,350)");
        autoCompleteButton.click();
    }

    public void clickMenuButton() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");

        menuButton.click();
    }
    public void clickSelectMenuButton() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");

        selectMenuButton.click();
    }
}
