package Objects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;
    LoginPageLocators loginLocators;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        loginLocators = new LoginPageLocators(driver);
    }

    public void setUsername(String uname) {
        loginLocators.getUsername().clear();
        loginLocators.getUsername().sendKeys(uname);
    }
    public void setPassword(String psw) {
        loginLocators.getPassword().clear();
        loginLocators.getPassword().sendKeys(psw);
    }
    public void clickLogin() {
        loginLocators.getLoginButton().click();
    }
    public void checkHomePageOpened() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(loginLocators.getHamburgerButton()));
        Assert.assertTrue(loginLocators.getHamburgerButton().isDisplayed());
    }

    public void checkErrorMessage(String eMessage) {
        Assert.assertEquals(loginLocators.getErrorMessage().getText(), eMessage);
    }

    public void enterKeyLogin() {
        loginLocators.getLoginButton().sendKeys(Keys.ENTER);
    }

    public void clickHamburgerBtn() {
        loginLocators.getHamburgerButton().click();
    }

    public void clickLogoutButton() {
        wait.until(ExpectedConditions.visibilityOf(loginLocators.getLogoutButton()));
        loginLocators.getLogoutButton().click();
    }

    public void checkLoginPageOpened() {
        loginLocators.resetElement();
        wait.until(ExpectedConditions.visibilityOf(loginLocators.getLoginButton()));
        Assert.assertTrue(loginLocators.getUsername().isDisplayed());
    }

    public void clickAddToCartButton(){loginLocators.getAddToCartButton1().click();}


}
