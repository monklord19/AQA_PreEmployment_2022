package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckBoxLocators {
    WebDriver driver;
    public CheckBoxLocators(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public static final String elementscategory_xpath = "//*[@id=\"app\"]/div/div/div[2]/div/div[1]";
    public static final String checkbox_xpath = "//*[@id=\"item-1\"]";
    public static final String expandall_jspath = "//span[contains(@class,'rct-title')]";
    public static final String notesbox_css = "#tree-node > ol > li > ol > li:nth-child(1) > ol > li:nth-child(1) > span > label > span.rct-checkbox > svg";
    public static final String angularbox_xpath = "//*[@id=\"tree-node\"]/div/button[1]/svg";
    public static final String generalbox_xpath = "//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li[2]/ol/li[4]/span/label/span[1]/svg";

    @FindBy(xpath = CheckBoxLocators.elementscategory_xpath)
    @CacheLookup
    private
    WebElement elementscategory;

    @FindBy(xpath = CheckBoxLocators.checkbox_xpath)
    @CacheLookup
    private
    WebElement checkbox;

    @FindBy(xpath = CheckBoxLocators.expandall_jspath)
    @CacheLookup
    private
    WebElement expandall;

    @FindBy(xpath = CheckBoxLocators.notesbox_css)
    @CacheLookup
    private
    WebElement notesbox;

    @FindBy(xpath = CheckBoxLocators.angularbox_xpath)
    @CacheLookup
    private
    WebElement angularbox;

    @FindBy(xpath = CheckBoxLocators.generalbox_xpath)
    @CacheLookup
    private
    WebElement generalbox;

    public WebElement getElementsCategory()
    {
        return elementscategory;
    }
    public WebElement getCheckBox()
    {
        return checkbox;
    }
    public WebElement getExpandAll()
    {
        return expandall;
    }
    public WebElement getNotes()
    {
        return notesbox;
    }
    public WebElement getAngular()
    {
        return angularbox;
    }
    public WebElement getGeneral()
    {
        return generalbox;
    }
}

