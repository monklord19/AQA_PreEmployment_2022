import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.CacheLookup;
public class FunctionsDefiniton {

    WebDriver driver;
    public void LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "user-name")
    @CacheLookup
    WebElement username;
    @FindBy(id = "password")
    @CacheLookup
    WebElement password;
    @FindBy(id = "login-button")
    @CacheLookup
    WebElement loginButton;
    public void setUsername(String usernameValue)
    {
        username.clear();
        username.sendKeys(usernameValue);
    }
    public void setPassword(String passwordValue)
    {
        password.clear();
        password.sendKeys(passwordValue);
    }
    public void pressLoginButton()
    {
        loginButton.click();
    }
}
