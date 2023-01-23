package pages;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PracticeFormPage {

    WebDriver driver;
    @FindBy(id = "firstName")
    private WebElement firstNameField;
    @FindBy(id = "lastName")
    private WebElement lastNameField;
    @FindBy(id = "userEmail")
    private WebElement emailField;
    @FindBy(css = "div#genterWrapper > .col-md-9.col-sm-12 > div:nth-of-type(1)")
    private WebElement maleCheckBox;
    @FindBy(id = "userNumber")
    private WebElement phoneNumberField;
    @FindBy(id = "dateOfBirthInput")
    private WebElement dateOfBirthField;
    @FindBy(css = ".subjects-auto-complete__control")
    private WebElement subjectField;
    @FindBy(id = "hobbies-checkbox-2")
    private WebElement readingCheckBox;
    @FindBy(id = "hobbies-checkbox-3")
    private WebElement musicCheckbox;
    @FindBy(id = "uploadPicture")
    private WebElement chooseFileButton;
    @FindBy(id = "currentAddress")
    private WebElement currentAddressField;
    @FindBy(css = "div#state .css-tlfecz-indicatorContainer")
    private WebElement stateDropDown;


    public PracticeFormPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setFirstNameField(String firstName) {
        firstNameField.sendKeys(firstName);
    }

    public void setLastNameField(String lastName) {
        lastNameField.sendKeys(lastName);
    }

    public void setEmailField(String email) {
        emailField.sendKeys(email);
    }

    public void selectMaleCheckBox() {
        maleCheckBox.click();
    }

    public void setPhoneNumberField(String phoneNumber) {
        phoneNumberField.sendKeys(phoneNumber);
    }

    public void checkDate() {
        Assert.assertTrue(currentAddressField.isDisplayed());

    }

    public void setSubjectField() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("javascript:window.scrollBy(250,350)");
        Thread.sleep(2000);
        Actions act = new Actions(driver);
        act.sendKeys(Keys.TAB).build().perform();
        act.sendKeys(Keys.RETURN).build().perform();
        subjectField.click();
        subjectField.clear();
        subjectField.sendKeys("literature");
    }

    public void chooseProfilePic() {
        chooseFileButton.click();
        chooseFileButton.sendKeys("C:/Users/tonia/Desktop/amongUsPic.png");
    }
}
