package UITests.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.junit.Assert;

public class SpotifyLoginApple {
    public WebDriver driver;
    public SpotifyLoginApple(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = ".Button-y0gtbx-0.hpTULc.lxEME.sc-dlVxhl")
    public WebElement AppleButton;
    @FindBy(id = "sign-in")
    public WebElement ArrowButton;
    @FindBy(id = "account_name_text_field")
    public WebElement appleuser;
    @FindBy(id = "password_text_field")
    public WebElement applepass;
    @FindBy(className = "error pop-bottom tk-subbody-headline")
    public WebElement errorApple;



    public void clickAppleButton(){
        AppleButton.click();
    }
    public void setAppleUser(String user) {
        appleuser.sendKeys(user);

    }
    public void clickArrowButton(){
        ArrowButton.click();
    }

    public void setApplePass(String pass) {
        applepass.sendKeys(pass);

    }
    public void AppleError(String error){
        Assert.assertEquals(error, errorApple.getText());
    }


}
