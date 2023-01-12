package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AppleLoginLocators {
    WebDriver driver;
    public AppleLoginLocators(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public static final String loginapple_xpath = "//*[@id=\"root\"]/div/div[2]/div/div/ul/li[2]/button";
    public static final String account_id = "account_name_text_field";
    public static final String next_button_xpath = "//*[@id=\"sign-in\"]/i";
    public static final String passapple_id = "password_text_field";
    public static final String next_xpath = "//*[@id=\"sign-in\"]/i";

    public static final String error_apple_xpath = "//*[@id=\"signin\"]/div[1]/div[2]/div";


    @FindBy(xpath = AppleLoginLocators.loginapple_xpath)
    @CacheLookup
    private
    WebElement loginapple;

    @FindBy(id = AppleLoginLocators.account_id)
    @CacheLookup
    private
    WebElement accountapple;

    @FindBy(xpath = AppleLoginLocators.next_button_xpath)
    @CacheLookup
    private
    WebElement next_button;

    @FindBy(id = AppleLoginLocators.passapple_id)
    @CacheLookup
    private
    WebElement passapple;

    @FindBy(xpath = AppleLoginLocators.next_xpath)
    @CacheLookup
    private
    WebElement next_final;

    @FindBy(xpath = AppleLoginLocators.error_apple_xpath)
    @CacheLookup
    private
    WebElement error_apple;

    public WebElement getLoginWithApple()
    {
        return loginapple;
    }

    public WebElement getAppleAccount(){
        return accountapple;
    }

    public WebElement getNextButtonApple(){
        return next_button;
    }

    public WebElement getEnterPassApple(){
        return passapple;
    }

    public WebElement getNextFinalButton(){
        return next_final;
    }

    public WebElement getErrorOfApple(){
        return error_apple;
    }
}