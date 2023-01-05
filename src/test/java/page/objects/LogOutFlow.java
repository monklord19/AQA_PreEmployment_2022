package page.objects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LogOutFlow {

    WebDriver driver;
    WebDriverWait wait;
    PageLocators pageLocators;
    LoginFlow loginFlow;


    public LogOutFlow(WebDriver driver) {
        this.driver = driver;
        pageLocators = new PageLocators(driver);
        loginFlow = new LoginFlow(driver);
    }

    public void Login(String url, String username, String password) {
        driver.get(url);
        loginFlow.setUsername(username);
        loginFlow.setPassword(password);
        loginFlow.clickLogin();
        loginFlow.checkHomePageOpened();
    }

    public void goToSideMenu() {
        pageLocators.getHamburgerButton().click();
    }

    public void Logout() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement logoutButton = pageLocators.getLogoutButton();
        wait.until(ExpectedConditions.visibilityOf(logoutButton));
        Assert.assertTrue(logoutButton.isDisplayed());
        pageLocators.getLogoutButton().click();
    }

    public void CheckLoginPageOpened() {
        Assert.assertTrue(pageLocators.getUsername().isDisplayed());
    }
}
