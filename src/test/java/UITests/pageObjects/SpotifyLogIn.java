package UITests.pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SpotifyLogIn {
    public WebDriver driver;
    public SpotifyLogIn(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="login-username")
    public WebElement user;
    @FindBy(id="login-password")
    public WebElement pass;
    @FindBy(id="login-button")
    public WebElement btn;
    @FindBy(className = "Wrapper-sc-62m9tu-0 dupjdh encore-negative-set sc-ksdxgE gmnGJa")
    public WebElement ErrorMessage;


    public void setUser(String username) {
        user.sendKeys(username);
    }

    public void setPass(String password) {
        pass.sendKeys(password);

    }
    public void clickBtn(){
        btn.click();
    }
    public void Error (String error){
        Assert.assertEquals(error, ErrorMessage.getText());
    }


}
