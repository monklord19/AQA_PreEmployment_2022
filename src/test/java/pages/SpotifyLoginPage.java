package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SpotifyLoginPage {

    @FindBy(id = "login-username")
    private WebElement usernameField;
    @FindBy(id = "login-password")
    private WebElement passwordField;
    @FindBy(css = "[class='Type__TypeElement-goli3j-0 dmuHFl sc-hKwDye fXzRSj']")
    private WebElement connectButton;
    @FindBy(css = "div[role='alert']")
    private WebElement wrongCredentialsAlert;
    @FindBy(css = ".Button-y0gtbx-0.hpTULc.lxEME.sc-dlVxhl")
    private WebElement continueWithAppleButton;

    WebDriver driver;

    public SpotifyLoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setUsernameField(String username) {
        usernameField.sendKeys(username);
    }

    public void setPasswordField(String password) {
        passwordField.sendKeys(password);

    }
    public void clickConnectButton(){
        connectButton.click();
    }
    public void assertError (String error){
        Assert.assertEquals(error, wrongCredentialsAlert.getText());
    }
    public void clickAppleButton(){
        continueWithAppleButton.click();
    }
}
