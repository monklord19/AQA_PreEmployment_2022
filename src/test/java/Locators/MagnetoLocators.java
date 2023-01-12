package Locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MagnetoLocators {

    WebDriver driver;

    public MagnetoLocators(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //locators for magneto website

    public static final String GEAR_DROP_DOWN_XPATH = "//*[@id=\"ui-id-6\"]/span[1]";
    public static final String BAGS_XPATH = "//*[@id=\"ui-id-25\"]/span";
    public static final String BAG_TOTE_XPATH = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[5]/div";
    public static final String ADD_TO_CART_BTN_XPATH = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[5]/div/div/div[3]/div/div[1]/form/button";
    public static final String SHOPPING_CART_XPATH = "/html/body/div[2]/header/div[2]/div[1]/a";
    public static final String MESSAGE_XPATH = "//*[@id=\"mini-cart\"]/li/div/div/strong/a";

    @FindBy(xpath = MagnetoLocators.GEAR_DROP_DOWN_XPATH)
    @CacheLookup
    private WebElement dropDown;

    @FindBy(xpath = MagnetoLocators.BAGS_XPATH)
    @CacheLookup
    private WebElement bags;

    @FindBy(xpath = MagnetoLocators.BAG_TOTE_XPATH)
    @CacheLookup
    private WebElement toteBag;

    @FindBy(xpath = MagnetoLocators.ADD_TO_CART_BTN_XPATH)
    @CacheLookup
    private WebElement addToCart;

    @FindBy(xpath = MagnetoLocators.SHOPPING_CART_XPATH)
    @CacheLookup
    private WebElement shoppingCart;

    @FindBy(xpath = MagnetoLocators.MESSAGE_XPATH)
    @CacheLookup
    private WebElement message;

    //getters

    public WebElement getDropDown(){
        return dropDown;
    }
    public WebElement getBags(){
        return bags;
    }
    public WebElement getToteBag(){
        return toteBag;
    }
    public WebElement getShoppingCart(){
        return shoppingCart;
    }
    public WebElement getAddToCart(){
        return addToCart;

    }
    public WebElement getMessage(){
        return message;
    }


}
