package pages;

import org.junit.Assert;
import org.openqa.selenium.support.CacheLookup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;
    @FindBy(id = "user-name")
    @CacheLookup
    private WebElement Username;
    @FindBy(id = "password")
    @CacheLookup
    private WebElement Password;
    @FindBy(xpath = "//*[@id=\"login-button\"]")
    @CacheLookup
    private WebElement LogInButton;
    @FindBy(xpath = "//*[@id=\"login_button_container\"]/div/form/div[3]")
    @CacheLookup
    private WebElement ErrorMessage;
    @FindBy(id = "react-burger-menu-btn")
    @CacheLookup
    private
    WebElement HamburgerButton;
    @FindBy(id = "logout_sidebar_link")
    @CacheLookup
    private
    WebElement LogOutButton;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void EnterUsername(String username){

        Username.sendKeys(username);
    }


    public void EnterPassword(String password){

        Password.sendKeys(password);
    }

    public void ClickLoginButton(){

        LogInButton.click();
    }

    public void ShowErrorMessage(String errorMessage){

        Assert.assertEquals(ErrorMessage.getText(), errorMessage);
    }

    public void ClickHamburgerButton(){
        HamburgerButton.click();

    }

    public void ClickLogOutButton(){
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(3));
        w.until(ExpectedConditions.elementToBeClickable(LogOutButton));
        //wait.until(ExpectedConditions.visibilityOf(LogOutButton));
        LogOutButton.click();
    }
}
