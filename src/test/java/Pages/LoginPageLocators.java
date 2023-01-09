package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageLocators {
    WebDriver driver;

    public LoginPageLocators(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public static final String id_username = "user-name";
    public static final String id_password = "password";
    public static final String id_login = "login-button";
    public static final String error_xpath = "//h3[@data-test = 'error']";
    public static final String cls_hamburger_button = "bm-burger-button";
    public static final String xpath_logout_button = "//a[@id = 'logout_sidebar_link']";
    public static final String add_to_cart_button = "add-to-cart-sauce-labs-backpack";

    @FindBy (id = LoginPageLocators.id_username)
    @CacheLookup
    private
    WebElement username;

    @FindBy (id = LoginPageLocators.id_password)
    @CacheLookup
    private
    WebElement password;

    @FindBy (id = LoginPageLocators.id_login)
    @CacheLookup
    private
    WebElement loginButton;

    @FindBy (xpath = LoginPageLocators.error_xpath)
    @CacheLookup
    private
    WebElement errorPop_up;

    @FindBy(id= LoginPageLocators.add_to_cart_button)
    @CacheLookup
    private
    WebElement addToCartButton;

    @FindBy(className = LoginPageLocators.cls_hamburger_button)
    @CacheLookup
    private
    WebElement hamburgerButton;

    @FindBy(xpath = LoginPageLocators.xpath_logout_button)
    @CacheLookup
    private
    WebElement logoutButton;

    public WebElement getUserName() {
        return username;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getLoginButton() {

        return loginButton;
    }

    public WebElement getErrorPop_up() {
        return errorPop_up;
    }


    public void resetElement() {
        PageFactory.initElements(driver, this);
    }

    public WebElement getHamburgerButton() {
        return hamburgerButton;
    }
    public WebElement getLogoutButton() {
        return logoutButton;
    }
    public WebElement getAddToCartButton() {
        return addToCartButton;
    }
}
