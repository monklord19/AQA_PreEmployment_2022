package UITests.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PracticeFormPage {

    WebDriver driver;
    public static final String title = "Practice Form";
    public static final By firstNameInput = By.id("firstName");
    public static final By lastNameInput = By.id("lastName");
    public static final By genderRadioButtonsMale = By.xpath("//label[@for='gender-radio-1']");
    public static final By genderRadioButtonsFemale = By.xpath("//label[@for='gender-radio-2']");
    public static final By genderRadioButtonsOther = By.xpath("//label[@for='gender-radio-3']");
    public static final By phoneNumberInput = By.id("userNumber");
    public static final By submitButton = By.id("submit");
    public static final By header = By.className("main-header");
    public static final By modalTitle = By.className("modal-title");

    public PracticeFormPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getElement(By locator) {
        return driver.findElement(locator);
    }

    public boolean isHeaderDisplayed(){
        return getElement(header).getText().equals(title);
    }


    public void enterFirstName(String text){
        getElement(firstNameInput).sendKeys(text);
    }

    public void enterLastName(String text) {
        getElement(lastNameInput).sendKeys(text);
    }

    public void selectGender(String text) {
        if(text.equals("Male")) getElement(genderRadioButtonsMale).click();
        if(text.equals("Female")) getElement(genderRadioButtonsFemale).click();
        if(text.equals("Other")) getElement(genderRadioButtonsOther).click();
    }

    public void enterPhoneNumber(String text) {
        getElement(phoneNumberInput).sendKeys(text);
    }

    public void clickSubmitButton() {
        getElement(submitButton).click();
    }

    public boolean isModalDisplayed() {
        return getElement(modalTitle).isDisplayed();
    }
}
