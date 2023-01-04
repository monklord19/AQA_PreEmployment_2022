package pages;

import junit.textui.TestRunner;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {

    @FindBy(id = "user-name")
    private WebElement usernameField;
    @FindBy(id = "password")
    private WebElement passwordField;
    @FindBy(id = "login-button")
    private WebElement logInButton;
    @FindBy(css = "h3")
    private WebElement wrongUsernameAndPassError;
    @FindBy(css = "h3")
    private WebElement passIsRequiredError;
    WebDriver driver;

    public LogInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterUsernameField(String username) {
        usernameField.sendKeys(username);
    }

    public void enterPasswordField(String password) {
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        logInButton.click();
    }

    public void usernameAndPassWrongError(String errorMessage) {
        Assert.assertEquals(wrongUsernameAndPassError.getText(), errorMessage);


    }

    public void passwordIsRequiredError(String errorPassRequired){
        Assert.assertEquals(passIsRequiredError.getText(),errorPassRequired);

    }
}

