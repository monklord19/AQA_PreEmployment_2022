package pages;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SpotifyLoginApplePage {

    @FindBy(id = "account_name_text_field")
    private WebElement appleIdField;
    @FindBy(id = "sign-in")
    private WebElement singInButton;
    @FindBy(id = "password_text_field")
    private WebElement passfield;
    @FindBy(id = "alertInfo")
    private WebElement alertInfo;

    WebDriver driver;

    public SpotifyLoginApplePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void setAppleIdField(String username) {
        appleIdField.sendKeys(username);

    }
    public void clickInButton(){
        singInButton.click();
    }

    public void setPassfield(String pass) {
        passfield.sendKeys(pass);

    }
public void checkTheError(String error){
    Assert.assertEquals(error, alertInfo.getText());
}
}
