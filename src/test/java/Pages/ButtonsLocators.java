package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ButtonsLocators {
    WebDriver driver;
    public ButtonsLocators(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public static final String elementsButton_xpath = "//*[@id=\"app\"]/div/div/div[2]/div/div[1]";
    public static final String buttons_xpath = "//*[@id=\"item-4\"]";
    public static final String doubleClick_xpath = "//*[@id=\"doubleClickBtn\"]";
    public static final String messageDouble_xpath = "//*[@id=\"doubleClickMessage\"]";
    public static final String rightClick_xpath = "//*[@id=\"rightClickBtn\"]";
    public static final String messageRight_xpath = "//*[@id=\"rightClickMessage\"]";
    public static final String leftClick_class = "btn btn-primary";
    public static final String messageLeft_xpath = "//*[@id=\"dynamicClickMessage\"]";


    @FindBy(xpath = ButtonsLocators.elementsButton_xpath)
    @CacheLookup
    private
    WebElement elementsButton;
    @FindBy(xpath = ButtonsLocators.buttons_xpath)
    @CacheLookup
    private
    WebElement buttons;

    @FindBy(xpath = ButtonsLocators.doubleClick_xpath)
    @CacheLookup
    private
    WebElement doubleClick;

    @FindBy(xpath = ButtonsLocators.messageDouble_xpath)
    @CacheLookup
    private
    WebElement messageDouble;

    @FindBy(xpath = ButtonsLocators.rightClick_xpath)
    @CacheLookup
    private
    WebElement rightClick;

    @FindBy(xpath = ButtonsLocators.messageRight_xpath)
    @CacheLookup
    private
    WebElement messageRight;

    @FindBy(xpath = ButtonsLocators.leftClick_class)
    @CacheLookup
    private
    WebElement leftClick;

    @FindBy(xpath = ButtonsLocators.messageLeft_xpath)
    @CacheLookup
    private
    WebElement messageLeft;

    public WebElement getElementsButton()
    {
        return elementsButton;
    }
    public WebElement getButtons()
    {
        return buttons;
    }

    public WebElement getDoubleClick()
    {
        return doubleClick;
    }
    public WebElement getMessageDouble()
    {
        return messageDouble;
    }
    public WebElement getRightClick()
    {
        return rightClick;
    }
    public WebElement getMessageRight()
    {
        return messageRight;
    }
    public WebElement getLeftClick()
    {
        return leftClick;
    }
    public WebElement getMessageLeft()
    {
        return messageLeft;
    }










}
