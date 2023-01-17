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

    public static final String login_spotify_webpage_xpath = "//*[@id=\"main\"]/div/div[2]/div[1]/header/div[5]/button[2]/span";
    public static final String login_with_google_xpath = "//*[@id=\"root\"]/div/div[2]/div/div/ul/li[3]/button/span";

    public static final String another_account_xpath = "//*[@id=\"view_container\"]/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div/div/ul/li[3]/div";
    public static final String xpath_gmail = "//*[@id=\"identifierId\"]";
    public static final String cls_pass_google = "whs0nd";

    public static final String xpath_move_on = "//*[@id=\"identifierNext\"]/div/button/div[3]";

    public static final String login_google_xpath = "//*[@id=\"passwordNext\"]/div/button/span";

    public static final String error_google_xpath = "//*[@id=\"view_container\"]/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div[2]/div[2]/span";

    @FindBy(xpath = GoogleLoginLocators.login_spotify_webpage_xpath)
    @CacheLookup
    private
    WebElement loginspotifywebpage;
    @FindBy(xpath = GoogleLoginLocators.login_with_google_xpath)
    @CacheLookup
    private static
    WebElement googlelogin;

    @FindBy(xpath = GoogleLoginLocators.another_account_xpath)
    @CacheLookup
    private
    WebElement another_account;

    @FindBy (xpath = GoogleLoginLocators.xpath_gmail)
    @CacheLookup
    private
    WebElement gmail;

    @FindBy (xpath = GoogleLoginLocators.xpath_move_on)
    @CacheLookup
    private
    WebElement move_on;

    @FindBy (className = GoogleLoginLocators.cls_pass_google)
    @CacheLookup
    private
    WebElement pass;

    @FindBy (xpath = GoogleLoginLocators.login_google_xpath)
    @CacheLookup
    private
    WebElement gmailbutton;

    @FindBy (xpath = GoogleLoginLocators.error_google_xpath)
    @CacheLookup
    private
    WebElement errorgoogle;

    public WebElement getConnectPage(){
        return loginspotifywebpage;
    }
    public WebElement getLoginWithGoogleCont() {
        return googlelogin;
    }

    public WebElement getAnotherAccount(){
        return another_account;
    }

    public WebElement getEnterGmail() {
        return gmail;
    }

    public WebElement getMoveOn(){
        return move_on;
    }
    public WebElement getEnterPass() {
        return pass;
    }

    public WebElement getLoginWithGmail() {
        return gmailbutton;
    }

    public WebElement getErrorOfGoogle() {
        return errorgoogle;
    }







}