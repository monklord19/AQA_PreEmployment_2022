package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SpotifyLoginFbPage {

    @FindBy(xpath = "/html/body/div[3]/div[2]/div/div/div/div/div[3]/button[2]")
    private WebElement cookiesButton;

    @FindBy(id = "email")
    private WebElement usernameField;
    @FindBy(id = "pass")
    private WebElement passField;
    @FindBy(id = "loginbutton")
    private WebElement loginButton;
    @FindBy(css = "div[role='alert']")
    private WebElement fbAlert;


    WebDriver driver;

    public SpotifyLoginFbPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickEsencialeCookies() {
        cookiesButton.click();
    }

    public void enterInvalidCredentials(String username, String password) {
        usernameField.sendKeys(username);
        passField.sendKeys(password);
    }

    public void clickFbLoginButton() {
        loginButton.click();
    }
    public void checkFbAlert(){
        Assert.assertTrue(fbAlert.isDisplayed());
    }
}
