package FrontendProjectTests.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormPage {
    public static WebDriver driver;
    @FindBy(id = "userName")
    private WebElement userNameInput;
    @FindBy(id = "userEmail")
    private WebElement userEmailInput;
    @FindBy(id = "currentAddress")
    private WebElement currentAddressInput;
    @FindBy(id = "permanentAddress")
    private WebElement permanentAddressInput;
    @FindBy(id= "submit")
    private WebElement submitButton;
    @FindBy(id = "output")
    private WebElement output;
    public FormPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public WebElement getUserNameInput() {
        return userNameInput;
    }

    public WebElement getUserEmailInput() {
        return userEmailInput;
    }

    public WebElement getCurrentAddressInput() {
        return currentAddressInput;
    }

    public WebElement getPermanentAddressInput() {
        return permanentAddressInput;
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }

    public WebElement getOutput() {
        return output;
    }
}
