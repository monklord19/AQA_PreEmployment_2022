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

    @FindBy(id = "user-name")
    @CacheLookup
    WebElement username;

    @FindBy(id = "password")
    @CacheLookup
    WebElement password;

    @FindBy(id = "login-button")
    @CacheLookup
    WebElement loginButton;

    @FindBy(xpath = "//h3[@data-test = 'error']")
    @CacheLookup
    WebElement errorMessage;

    @FindBy(className = "bm-burger-button")
    @CacheLookup
    WebElement hamburgerButton;

    @FindBy(xpath = "//a[@id = 'logout_sidebar_link']")
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

    public void clickLogin() throws InterruptedException {
        loginButton.click();
        Thread.sleep(3000);
    }

    public void checkHomePageOpened() {
        Assert.assertTrue(hamburgerButton.isDisplayed());
    }

    public void checkErrorMessage(String eMessage) {
        Assert.assertEquals(errorMessage.getText(), eMessage);
    }

    public void enterKeyLogin() throws InterruptedException {
        loginButton.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
    }

    public void clickHamburgerBtn() {
        hamburgerButton.click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(logoutButton));
    }

    public void clickLogoutButton() {
        logoutButton.click();
        PageFactory.initElements(driver, this);
        wait.until(ExpectedConditions.visibilityOf(loginButton));
    }

    public void checkLoginPageOpened() {
        Assert.assertTrue(username.isDisplayed());
    }
}
