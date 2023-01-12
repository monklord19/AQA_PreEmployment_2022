package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleLoginLocators {
    WebDriver driver;
    public GoogleLoginLocators(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public static final String login_with_google_xpath = "//*[@id=\"root\"]/div/div[2]/div/div/ul/li[3]/button/span";

    public static final String another_account_xpath = "//*[@id=\"view_container\"]/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div/div/ul/li[3]/div/div/div[2]";
    public static final String name_gmail = "identifier";
    public static final String cls_pass_google = "whs0nd";

    public static final String login_google_xpath = "//*[@id=\"passwordNext\"]/div/button/span";

    public static final String error_google_xpath = "//*[@id=\"view_container\"]/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div[2]/div[2]/span";

    @FindBy(xpath = GoogleLoginLocators.login_with_google_xpath)
    @CacheLookup
    private static
    WebElement googlelogin;

    @FindBy(xpath = GoogleLoginLocators.another_account_xpath)
    @CacheLookup
    private
    WebElement another_account;

    @FindBy (name = GoogleLoginLocators.name_gmail)
    @CacheLookup
    private
    WebElement gmail;

    @FindBy (className = GoogleLoginLocators.cls_pass_google)
    @CacheLookup
    private
    WebElement passwordgmail;

    @FindBy (xpath = GoogleLoginLocators.login_google_xpath)
    @CacheLookup
    private
    WebElement gmailbutton;

    @FindBy (xpath = GoogleLoginLocators.error_google_xpath)
    @CacheLookup
    private
    WebElement errorgoogle;

    public WebElement getLoginWithGoogleCont() {
        return googlelogin;
    }

    public WebElement getAnotherAccount(){
        return another_account;
    }

    public WebElement getEnterGmail() {
        return gmail;
    }
    public WebElement getEnterPass() {
        return passwordgmail;
    }

    public WebElement getLoginWithGmail() {
        return gmailbutton;
    }

    public WebElement getErrorOfGoogle() {
        return errorgoogle;
    }







}