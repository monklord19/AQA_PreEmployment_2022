package Objects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageLocators {
    WebDriver driver;

    public LoginPageLocators(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public static final String USERNAME_ID = "user-name";
    public static final String PASSWORD_ID = "password";
    public static final String LOGIN_ID = "login-button";
    public static final String ERROR_XPATH = "//h3[@data-test = 'error']";
    public static final String HAMBURGER_BUTTON_CLS = "bm-burger-button";
    public static final String LOGOUT_BUTTON_XPATH = "//a[@id = 'logout_sidebar_link']";
    public static final String ADD_TO_CART_BUTTON1 = "add-to-cart-sauce-labs-backpack";
   /* public static final String ADD_TO_CART_BUTTON2 = "add-to-cart-sauce-labs-bike-light";
    public static final String ADD_TO_CART_BUTTON3 = "add-to-cart-sauce-labs-bolt-t-shirt";
    public static final String ADD_TO_CART_BUTTON4 = "add-to-cart-sauce-labs-fleece-jacket";
    public static final String ADD_TO_CART_BUTTON5 = "add-to-cart-sauce-labs-onesie";
    public static final String ADD_TO_CART_BUTTON6 = "add-to-cart-test.allthethings()-t-shirt-(red)";*/

    @FindBy(id = LoginPageLocators.USERNAME_ID)
    @CacheLookup
    private
    WebElement username;

    @FindBy(id = LoginPageLocators.PASSWORD_ID)
    @CacheLookup
    private
    WebElement password;

    @FindBy(id = LoginPageLocators.LOGIN_ID)
    @CacheLookup
    private
    WebElement loginButton;

    @FindBy(id= LoginPageLocators.ADD_TO_CART_BUTTON1)
    @CacheLookup
    private
    WebElement addToCartButton1;
/*
    @FindBy(id= LoginPageLocators.ADD_TO_CART_BUTTON2)
    @CacheLookup
    private
    WebElement addToCartButton2;

    @FindBy(id= LoginPageLocators.ADD_TO_CART_BUTTON3)
    @CacheLookup
    private
    WebElement addToCartButton3;

    @FindBy(id= LoginPageLocators.ADD_TO_CART_BUTTON4)
    @CacheLookup
    private
    WebElement addToCartButton4;

    @FindBy(id= LoginPageLocators.ADD_TO_CART_BUTTON5)
    @CacheLookup
    private
    WebElement addToCartButton5;

    @FindBy(id= LoginPageLocators.ADD_TO_CART_BUTTON6)
    @CacheLookup
    private
    WebElement addToCartButton6;
*/
    @FindBy(xpath = LoginPageLocators.ERROR_XPATH)
    @CacheLookup
    private
    WebElement errorMessage;

    @FindBy(className = LoginPageLocators.HAMBURGER_BUTTON_CLS)
    @CacheLookup
    private
    WebElement hamburgerButton;

    @FindBy(xpath = LoginPageLocators.LOGOUT_BUTTON_XPATH)
    @CacheLookup
    private
    WebElement logoutButton;

    public WebElement getUsername() {
        return username;
    }
    public WebElement getPassword() {
        return password;
    }
    public WebElement getLoginButton() {

        return loginButton;
    }
    public WebElement getErrorMessage() {
        return errorMessage;
    }
    public WebElement getHamburgerButton() {
        return hamburgerButton;
    }
    public WebElement getLogoutButton() {
        return logoutButton;
    }
    public void resetElement() {
        PageFactory.initElements(driver, this);
    }
    public WebElement getAddToCartButton1(){return addToCartButton1;}
  /*  public WebElement getAddToCartButton2(){return addToCartButton2;}
    public WebElement getAddToCartButton3(){return addToCartButton3;}
    public WebElement getAddToCartButton4(){return addToCartButton4;}
    public WebElement getAddToCartButton5(){return addToCartButton5;}
    public WebElement getAddToCartButton6(){return addToCartButton6;}*/
}
