package page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageLocators {
    WebDriver driver;

    public PageLocators(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public static final String USERNAME_ID = "user-name";
    public static final String PASSWORD_ID = "password";
    public static final String LOGIN_ID = "login-button";
    public static final String HAMBURGER_BUTTON_CLS = "bm-burger-button";
    public static final String ERROR_BTN_CLS = "error-button";
    public static final String SHOPPING_CART_CLS = "shopping_cart_link";
    public static final String PAGE_TITLE_CLS = "title";
    public static final String LOGOUT_BUTTON_XPATH = "//a[@id = 'logout_sidebar_link']";
    @FindBy(id = PageLocators.USERNAME_ID)
    @CacheLookup
    private
    WebElement username;

    @FindBy(id = PageLocators.PASSWORD_ID)
    @CacheLookup
    private
    WebElement password;

    @FindBy(id = PageLocators.LOGIN_ID)
    @CacheLookup
    private
    WebElement loginButton;

    @FindBy(className = PageLocators.ERROR_BTN_CLS)
    @CacheLookup
    private
    WebElement errorBtn;

    @FindBy(className = PageLocators.HAMBURGER_BUTTON_CLS)
    @CacheLookup
    private
    WebElement hamburgerButton;
    @FindBy(className = PageLocators.SHOPPING_CART_CLS)
    @CacheLookup
    private
    WebElement shoppingCart;

    @FindBy(xpath = PageLocators.LOGOUT_BUTTON_XPATH)
    @CacheLookup
    private
    WebElement logoutButton;

    @FindBy(className = PageLocators.PAGE_TITLE_CLS)
    @CacheLookup
    private
    WebElement pageTitle;

    public WebElement getUsername() {
        return username;
    }
    public WebElement getPassword() {
        return password;
    }
    public WebElement getLoginButton() {

        return loginButton;
    }
    public WebElement getErrorBtn() {
        return errorBtn;
    }
    public WebElement getHamburgerButton() {
        return hamburgerButton;
    }
    public WebElement getShoppingCart() {
        return shoppingCart;
    }
    public WebElement getLogoutButton() {
        return logoutButton;
    }
    public WebElement getPageTitle() {
        return pageTitle;
    }

}
