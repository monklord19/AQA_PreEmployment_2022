package UITests.PageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class  AppleLoginPage extends BasePage{
    WebDriverWait wait;
    public static final String userNameLocator = "//*[@id=\"account_name_text_field\"]";
    public static final String passwordLocator = "password_text_field";
    public static final String signinLocator = "sign-in";
    @FindBy(id = signinLocator)
    private WebElement signinButton;

    @FindBy(id = "alertInfo")
    private WebElement errorMessage;

    public AppleLoginPage(WebDriver driver)
    {
        AppleLoginPage.driver = driver;
        wait = new WebDriverWait(SpotifyPage.driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(userNameLocator))));
        setUsername_input(driver.findElement(By.xpath(userNameLocator)));
        setPassword_input(driver.findElement(By.id(passwordLocator)));


    }


    public void putUsername(String username) {
        username_input.sendKeys(username);
//        driver.findElement(By.xpath(userNameLocator)).sendKeys(username);
    }

    public void clickNext() {
        wait.until(ExpectedConditions.elementToBeClickable(signinButton));
        signinButton.click();
    }

    public void putPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(password_input));
        password_input.sendKeys(password);
    }

    public void checkErrorMessage(){
        wait.until(ExpectedConditions.visibilityOf(errorMessage));
        Assert.assertTrue(errorMessage.isDisplayed());
    }
}
