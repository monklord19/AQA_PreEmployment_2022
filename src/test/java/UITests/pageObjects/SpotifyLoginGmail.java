package UITests.pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SpotifyLoginGmail {
    public WebDriver driver;
    public SpotifyLoginGmail(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(className = "Type__TypeElement-goli3j-0 cWkmRE sc-hKwDye sc-kDTinF fXzRSj iSqHJa")
    public WebElement GoogleButton;
    @FindBy(className = "VfPpkd-RLmnJb")
    public WebElement InainteButton;
    @FindBy(id = "identifierId")
    public WebElement gmailuser;
    @FindBy(className = "whsOnd zHQkBf")
    public WebElement gmailpass;
    @FindBy(className = "OyEIQ uSvLId")
    public WebElement errorGmail;



    public void clickGoogleButton(){
        GoogleButton.click();
    }
    public void setGmailUser(String user) {
        gmailuser.sendKeys(user);

    }
    public void clickInainteButton(){
        InainteButton.click();
    }

    public void setGmailPass(String pass) {
        gmailpass.sendKeys(pass);

    }
    public void GoogleError(String error){
        Assert.assertEquals(error, errorGmail.getText());
    }

}
