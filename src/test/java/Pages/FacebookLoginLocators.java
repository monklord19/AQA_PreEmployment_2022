package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FacebookLoginLocators {
    WebDriver driver;
    public FacebookLoginLocators(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public static final String login_webpagespotify_xpath = "//*[@id=\"main\"]/div/div[2]/div[1]/header/div[5]/button[2]/span";

    public static final String loginfacebook_xpath = "/html/body/div[1]/div/div[2]/div/div/ul/li[1]/button";
    public static final String accountfacebook_id = "email";
    public static final String passfacebook_id = "pass";
    public static final String continuefacebook_id = "loginbutton";

    public static final String error_facebook_xpath = "/html/body/div[1]/div[2]/div[3]/div/div/div";

    @FindBy(xpath = FacebookLoginLocators.login_webpagespotify_xpath)
    @CacheLookup
    private
    WebElement loginwebpagespotify;


    @FindBy(xpath = FacebookLoginLocators.loginfacebook_xpath)
    @CacheLookup
    private
    WebElement loginfacebook;

    @FindBy(id = FacebookLoginLocators.accountfacebook_id)
    @CacheLookup
    private
    WebElement accountfacebook;

    @FindBy(xpath = FacebookLoginLocators.passfacebook_id)
    @CacheLookup
    private
    WebElement passfacebook;

    @FindBy(id = FacebookLoginLocators.continuefacebook_id)
    @CacheLookup
    private
    WebElement continuefacebook;

    @FindBy(xpath = FacebookLoginLocators.error_facebook_xpath)
    @CacheLookup
    private
    WebElement errorfacebook;


    public WebElement getLoginWebpageSpotify()
    {
        return loginwebpagespotify;
    }
    public WebElement getLoginWithFacebook()
    {
        return loginfacebook;
    }

    public WebElement getFacebookAccount(){
        return accountfacebook;
    }

    public WebElement getEnterPassFacebook(){
        return passfacebook;
    }

    public WebElement getConnectFacebook(){
        return continuefacebook;
    }

    public WebElement getErrorOfFacebook(){
        return errorfacebook;
    }

}