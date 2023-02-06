package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RadioButtonLocators {
    WebDriver driver;
    public RadioButtonLocators(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public static final String openElements_xpath = "//*[@id=\"app\"]/div/div/div[2]/div/div[1]";
    public static final String radio_xpath = "//*[@id=\"item-2\"]";
    public static final String yes_id = "yesRadio";
    public static final String messageRadio_xpath = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/p";



    @FindBy(xpath = RadioButtonLocators.openElements_xpath)
    @CacheLookup
    private
    WebElement openElements;

    @FindBy(xpath = RadioButtonLocators.radio_xpath)
    @CacheLookup
    private
    WebElement radio;

    @FindBy(xpath = RadioButtonLocators.yes_id)
    @CacheLookup
    private
    WebElement yes;

    @FindBy(xpath = RadioButtonLocators.messageRadio_xpath)
    @CacheLookup
    private
    WebElement messageRadio;



    public WebElement getOpenElements()
    {
        return openElements;
    }

    public WebElement getRadio() { return radio; }

    public WebElement getYes() { return yes; }

    public WebElement getMessageRadio() { return messageRadio; }

}
