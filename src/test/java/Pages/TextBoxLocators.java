package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TextBoxLocators {
    WebDriver driver;
    public TextBoxLocators(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public static final String elements_xpath = "//*[@id=\"app\"]/div/div/div[2]/div/div[1]";
    public static final String textbox_xpath = "//*[@id=\"item-0\"]";
    public static final String fullname_xpath = "//*[@id=\"userName\"]";
    public static final String email_xpath = "//*[@id=\"userEmail\"]";
    public static final String currentaddress_xpath = "//*[@id=\"currentAddress\"]";
    public static final String permanentaddress_xpath = "//*[@id=\"permanentAddress\"]";
    public static final String submit_id = "submit";
    public static final String text_xpath = "//*[@id=\"output\"]/div";


    @FindBy(xpath = TextBoxLocators.elements_xpath)
    @CacheLookup
    private
    WebElement elements;

    @FindBy(xpath = TextBoxLocators.textbox_xpath)
    @CacheLookup
    private
    WebElement textbox;

    @FindBy(xpath = TextBoxLocators.fullname_xpath)
    @CacheLookup
    private
    WebElement fullname;

    @FindBy(xpath = TextBoxLocators.email_xpath)
    @CacheLookup
    private
    WebElement email;

    @FindBy(xpath = TextBoxLocators.currentaddress_xpath)
    @CacheLookup
    private
    WebElement currentaddress;

    @FindBy(xpath = TextBoxLocators.permanentaddress_xpath)
    @CacheLookup
    private
    WebElement permanentaddress;

    @FindBy(xpath = TextBoxLocators.submit_id)
    @CacheLookup
    private
    WebElement submit;

    @FindBy(xpath = TextBoxLocators.text_xpath)
    @CacheLookup
    private
    WebElement text;

    public WebElement getElements()
    {
        return elements;
    }

    public WebElement getTextBox() { return textbox; }

    public WebElement getFullName() { return fullname; }

    public WebElement getEmail() { return email; }

    public WebElement getCurrentAddress() { return currentaddress; }
    public WebElement getPermanentAddress() { return permanentaddress; }
    public WebElement getSubmit() { return submit; }

    public WebElement getText() { return text; }

}
