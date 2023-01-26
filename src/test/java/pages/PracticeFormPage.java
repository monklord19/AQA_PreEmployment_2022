package pages;

import net.bytebuddy.asm.Advice;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import javax.lang.model.element.Element;
import java.io.File;

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
    @FindBy(css = "input#subjectsInput")
    private WebElement subjectField;
    @FindBy(css = "label[for='hobbies-checkbox-2']")
    private WebElement readingCheckBox;
    @FindBy(css = "label[for='hobbies-checkbox-3']")
    private WebElement musicCheckbox;
    @FindBy(css = "input#uploadPicture")
    private WebElement chooseFileButton;
    @FindBy(id = "currentAddress")
    private WebElement currentAddressField;
    @FindBy(css = "#state [class=' css-1wy0on6']")
    private WebElement stateDropDown;
    @FindBy(css = "div:nth-of-type(6) > .group-header > .header-wrapper")
    private WebElement bSAPPclickable;
    @FindBy(css = "button#submit")
    private  WebElement submitButton;
    @FindBy(css = "button#submit")
    private  WebElement formSubmitButton;
    @FindBy(css = "div#example-modal-sizes-title-lg")
    private  WebElement thankYouText;


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

    public void setSubjectField(String subject) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("javascript:window.scrollBy(250,350)");
        subjectField.sendKeys(subject);
    }

    public void chooseHobbies() {
        readingCheckBox.click();
        musicCheckbox.click();

    }

    public void chooseProfilePic() {
        File file = new File("D:\\AQA_PreEmployment_2022\\amongUsPic.png");
        chooseFileButton.sendKeys(file.getAbsolutePath());
    }

    public void setCurrentAddressField(String address) {
        currentAddressField.sendKeys(address);
    }

//    public void clickStateDropDown() throws InterruptedException {
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
//        bSAPPclickable.click();
//        Thread.sleep(3000);
//        js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
//        stateDropDown.click();
//    }
    public void clickSubmitButton(){
        submitButton.click();
    }
    public void checkThanksText(){
        Assert.assertEquals("Thanks for submitting the form",thankYouText.getText());
    }
}
