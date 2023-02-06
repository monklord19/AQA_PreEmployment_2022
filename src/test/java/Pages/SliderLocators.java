package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SliderLocators {
    WebDriver driver;
    public SliderLocators(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public static final String widgets_xpath = "//*[@id=\"app\"]/div/div/div[2]/div/div[4]";
    public static final String slider_id = "item-3";

    @FindBy(xpath = SliderLocators.widgets_xpath)
    @CacheLookup
    private
    WebElement widgets;

    @FindBy(xpath = SliderLocators.slider_id)
    @CacheLookup
    private
    WebElement slider;

    public WebElement getWidgets()
    {
        return widgets;
    }

    public WebElement getSlider()
    {
        return slider;
    }

}
