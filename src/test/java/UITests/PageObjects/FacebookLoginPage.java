package UITests.PageObjects;

import net.bytebuddy.implementation.bytecode.member.FieldAccess;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class  FacebookLoginPage extends BasePage{
    private WebDriverWait wait;
    public static final String userNameLocator = "email";
    public static final String passwordLocator = "pass";
    public static final String loginButtonLocator = "loginbutton";
    @FindBy(xpath = "/html/body/div[3]/div[2]/div/div/div/div/div[3]/button[2]")
    private WebElement cookiesButton;

    @FindBy(xpath = "//*[@id=\"globalContainer\"]/div[3]/div/div/div")
    private WebElement messageError;

    public FacebookLoginPage(WebDriver driver)
    {
        wait = new WebDriverWait(SpotifyPage.driver, Duration.ofSeconds(20));
        FacebookLoginPage.driver = driver;
        PageFactory.initElements(driver, this);
        setUsername_input(driver.findElement(By.id(userNameLocator)));
        setPassword_input(driver.findElement(By.id(passwordLocator)));
        setLogin_button(driver.findElement(By.id(loginButtonLocator)));


    }

    public void clickLoginButton(){
        login_button.click();
    }

    public void acceptCookies(){
        wait.until(ExpectedConditions.elementToBeClickable(cookiesButton));
        cookiesButton.click();
    }
    public void checkErrorMessage(){
        Assert.assertTrue(messageError.isDisplayed());

    }
}
