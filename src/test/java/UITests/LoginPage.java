package UITests;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;
    
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /*private final WebElement usrname = driver.findElement(By.id("user-name"));
    private final WebElement psword = driver.findElement(By.id("password"));
    private final WebElement loginButton = driver.findElement(By.id("login-button"));
    private final WebElement errorMessage = driver.findElement(By.cssSelector(".error-message-container.error"));
     */

    public static final String usernameId = "user-name";
    public static final String passwordId = "password";
    public static final String loginId = "login-button";
    public static final String errorMessageXpath = "//h3[@data-test = 'error']";

    @FindBy(id = usernameId)
    @CacheLookup
    private
    WebElement username;

    @FindBy(id = passwordId)
    @CacheLookup
    private
    WebElement password;

    @FindBy(id = loginId)
    @CacheLookup
    private
    WebElement loginButton;

    @FindBy(xpath = errorMessageXpath)
    @CacheLookup
    private
    WebElement errorMessage;
    


    public WebElement getUsername() {
        return username;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getLoginButton() {

        return loginButton;
    }

    public WebElement getErrorMessage() {
        return errorMessage;
    }


    public void setUsername(String uname) {
        getUsername().clear();
        getUsername().sendKeys(uname);
    }

    public void setPassword(String psw) {
        getPassword().clear();
        getPassword().sendKeys(psw);
    }

    public void clickOnLoginButton() {
        getLoginButton().click();
    }

    public String checkErrorMessage() {
        return errorMessage.getText();
    }


    /*public void typeUsername(String username) {
        usrname.clear();
        usrname.sendKeys(username);
    }

    public void typePassword(String password) {
        psword.clear();
        psword.sendKeys(password);
    }

    public void clickOnLoginButton() {
        loginButton.click();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

     */
}


