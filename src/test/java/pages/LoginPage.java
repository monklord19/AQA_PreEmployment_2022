package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;
    @FindBy(id = "user-name")
    private WebElement Username;
    @FindBy(id = "password")
    private WebElement Password;
    @FindBy(xpath = "//*[@id=\"login-button\"]")
    private WebElement LogInButton;
    @FindBy(xpath = "//*[@id=\"login_button_container\"]/div/form/div[3]")
    private WebElement ErrorMessage;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setUsername(String username){
        Username.sendKeys(username);
    }


    public void setPassword(String password){

        Password.sendKeys(password);
    }

    public void ClickLoginButton(){
        LogInButton.click();
    }
    public void  ShowErrorMessage(String errorMessage)
    {
        String actualMsg = errorMessage;
        if (actualMsg.contains(errorMessage)) {
            System.out.println("The error message is corect");
        } else {
            System.out.println("Test Case Failed - error message not corect");
            System.out.println(actualMsg);
        }
    }

    public void getErrorMessage(String errorMessage){
        String actualMsg = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]")).getText();
        if (actualMsg.contains(errorMessage)) {
            System.out.println("The error message is corect");
        } else {
            System.out.println("Test Case Failed - error message not corect");
            System.out.println(actualMsg);
        }
        ;
    }
}
