package page.objects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = LoginPageLocators.USERNAME_ID)
    @CacheLookup
    WebElement username;

    @FindBy(id = LoginPageLocators.PASSWORD_ID)
    @CacheLookup
    WebElement password;

    @FindBy(id = LoginPageLocators.LOGIN_ID)
    @CacheLookup
    WebElement loginButton;

    @FindBy(xpath = LoginPageLocators.ERROR_XPATH)
    @CacheLookup
    WebElement errorMessage;

    @FindBy(className = LoginPageLocators.HAMBURGER_BUTTON_CLS)
    @CacheLookup
    WebElement hamburgerButton;

    @FindBy(xpath = LoginPageLocators.LOGOUT_BUTTON_XPATH)
    @CacheLookup
    WebElement logoutButton;

    public void setUsername(String uname) {
        username.clear();
        username.sendKeys(uname);
    }

    public void setPassword(String psw) {
        password.clear();
        password.sendKeys(psw);
    }

    public void clickLogin() {
        loginButton.click();
    }

    public void checkHomePageOpened() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(hamburgerButton));
        Assert.assertTrue(hamburgerButton.isDisplayed());
    }

    public void checkErrorMessage(String eMessage) {
        Assert.assertEquals(errorMessage.getText(), eMessage);
    }

    public void enterKeyLogin() {
        loginButton.sendKeys(Keys.ENTER);
    }

    public void clickHamburgerBtn() {
        hamburgerButton.click();
    }

    public void clickLogoutButton() {
        wait.until(ExpectedConditions.visibilityOf(logoutButton));
        logoutButton.click();

    }

    public void checkLoginPageOpened() {
        PageFactory.initElements(driver, this);
        wait.until(ExpectedConditions.visibilityOf(loginButton));
        Assert.assertTrue(username.isDisplayed());
    }
}
