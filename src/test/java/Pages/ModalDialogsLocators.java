package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ModalDialogsLocators {
    WebDriver driver;
    public ModalDialogsLocators(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public static final String alerts_xpath = "//*[@id=\"app\"]/div/div/div[2]/div/div[3]";
    public static final String modal_xpath = "//*[@id=\"item-4\"]";
    public static final String smallModal_xpath = "//*[@id=\"showSmallModal\"]";
    public static final String closeSmall_xpath = "//*[@id=\"closeSmallModal\"]";
    public static final String largeModal_xpath = "//*[@id=\"showLargeModal\"]";
    public static final String closeLarge_xpath = "//*[@id=\"closeLargeModal\"]";

    @FindBy(xpath = ModalDialogsLocators.alerts_xpath)
    @CacheLookup
    private
    WebElement alerts;

    @FindBy(xpath = ModalDialogsLocators.modal_xpath)
    @CacheLookup
    private
    WebElement modal;

    @FindBy(xpath = ModalDialogsLocators.smallModal_xpath)
    @CacheLookup
    private
    WebElement smallModal;

    @FindBy(xpath = ModalDialogsLocators.closeSmall_xpath)
    @CacheLookup
    private
    WebElement closeSmall;

    @FindBy(xpath = ModalDialogsLocators.largeModal_xpath)
    @CacheLookup
    private
    WebElement largeModal;

    @FindBy(xpath = ModalDialogsLocators.closeLarge_xpath)
    @CacheLookup
    private
    WebElement closeLarge;

    public WebElement getAlerts()
    {
        return alerts;
    }
    public WebElement getModal()
    {
        return modal;
    }
    public WebElement getSmallModal()
    {
        return smallModal;
    }
    public WebElement getCloseSmall()
    {
        return closeSmall;
    }
    public WebElement getLargeModal()
    {
        return largeModal;
    }
    public WebElement getCloseLarge()
    {
        return closeLarge;
    }














}
