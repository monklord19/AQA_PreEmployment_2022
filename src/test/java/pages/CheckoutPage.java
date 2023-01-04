package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {

    @FindBy(css = "input#first-name")
    private WebElement firstNameField;
    @FindBy(id = "last-name")
    private WebElement lastNameField;
    @FindBy(id = "postal-code")
    private WebElement zipCodeField;
    @FindBy(id = "continue")
    private WebElement continueButton;
    WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void checkoutInformationField(String firstName, String secName, String zipCode) {
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(secName);
        zipCodeField.sendKeys(zipCode);

    }
    public void clickContinueButton(){
        continueButton.click();
    }
}
