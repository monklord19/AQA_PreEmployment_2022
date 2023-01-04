package UITests.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.junit.Assert;



public class loginPage {
    public WebDriver driver;
    public loginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "user-name")
    public WebElement user;
    @FindBy(id = "password")
    public WebElement pass;
    @FindBy(id = "login-button")
    public WebElement loginBtn;
    @FindBy(css = "h3")
    public WebElement WrongUsernameValidPassword;


    public void enterUser(String username) {
        user.sendKeys(username);
    }

    public void enterPass(String password) {
        pass.sendKeys(password);
    }

    public void clickLoginButton() {
        loginBtn.click();
    }

    public void WrongUserValidPass(String errorMessage) {
        Assert.assertEquals(WrongUsernameValidPassword.getText(), errorMessage);
        driver.quit();

    }






}
