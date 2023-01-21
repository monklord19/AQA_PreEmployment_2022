package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LumaPageObjects {

    WebDriver driver;

    public LumaPageObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //locators for magneto website

    public static final String DropDown_Xpath = "//*[@id=\"ui-id-6\"]/span[1]";
    public static final String Bags_Xpath = "//*[@id=\"ui-id-25\"]/span";
    public static final String SavvyToteBag_Xpath = "//img[@alt=\"Savvy Shoulder Tote\"]";
    public static final String BtnAddToCart_Xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[5]/div/div/div[3]/div/div[1]/form/button";
    public static final String BtnShoopingCart_Xpath = "//a[@class='action showcart']";
    public static final String BagName_Xpath = "//*[@id=\"mini-cart\"]/li/div/div/strong/a";

    @FindBy(xpath = LumaPageObjects.DropDown_Xpath)
    @CacheLookup
    private WebElement dropDown;

    @FindBy(xpath = LumaPageObjects.Bags_Xpath)
    @CacheLookup
    private WebElement bagsMenu;

    @FindBy(xpath = LumaPageObjects.SavvyToteBag_Xpath)
    @CacheLookup
    private WebElement SavvyToteBag;

    @FindBy(xpath = LumaPageObjects.BtnAddToCart_Xpath)
    @CacheLookup
    private WebElement addToCart;

    @FindBy(xpath = LumaPageObjects.BtnShoopingCart_Xpath)
    @CacheLookup
    private WebElement shoppingCart;

    @FindBy(xpath = LumaPageObjects.BagName_Xpath)
    @CacheLookup
    private WebElement BagName;

    //getters

    public WebElement getDropDown(){
        return dropDown;
    }
    public WebElement getBagsMenu(){
        return bagsMenu;
    }
    public WebElement getSavvyToteBag(){
        return SavvyToteBag;
    }
    public WebElement getShoppingCart(){
        return shoppingCart;
    }
    public WebElement getAddToCart(){
        return addToCart;

    }
    public WebElement getBagName(){
        return BagName;
    }


}
