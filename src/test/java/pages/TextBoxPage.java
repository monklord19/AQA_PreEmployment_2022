package pages;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import static java.awt.SystemColor.window;

public class TextBoxPage {

    @FindBy(id = "userName")
    private WebElement fullNameField;
    @FindBy(id = "userEmail")
    private WebElement emailField;
    @FindBy(id = "currentAddress")
    private WebElement currentAddressField;
    @FindBy(id = "permanentAddress")
    private WebElement permanentAddressField;
    @FindBy(css = "button#submit")
    private WebElement submitButton;
    @FindBy(css = "button#submit")
    private WebElement informationTextBox;


    WebDriver driver;

    public TextBoxPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setFullNameField(String name) {
        fullNameField.sendKeys(name);
    }

    public void setEmailField(String email) {
        emailField.sendKeys(email);
    }

    public void setCurrentAddressField(String currAddress) {
        currentAddressField.sendKeys(currAddress);
    }

    public void setPermanentAddressField(String perAddress) {
        permanentAddressField.sendKeys(perAddress);

    }

    public void clickSubmitButton() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("javascript:window.scrollBy(250,350)");
       submitButton.click();
    }

    public void checkInfoBox() {
     Assert.assertTrue(informationTextBox.isDisplayed());
    }


}
