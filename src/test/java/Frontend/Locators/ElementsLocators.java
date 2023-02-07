package Frontend.Locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ElementsLocators {
    //ELEMENTS SECTION
    @FindBy(xpath = "//*[name()='path' and contains(@d,'M16 132h41')]")
    @CacheLookup
    private WebElement elementsSection;

    public WebElement getElementsSection() {
        return elementsSection;
    }

    //RADIO BUTTON SECTION
    @FindBy(xpath = "//div[@class='element-list collapse show']//li[@id='item-2']")
    @CacheLookup
    private WebElement radioButtonSection;
    @FindBy(xpath = "//label[normalize-space()='Impressive']")
    @CacheLookup
    private WebElement impressiveRadioButton;
    @FindBy(xpath = "//p[@class='mt-3']")
    @CacheLookup
    private WebElement impressiveMessage;

    public WebElement getImpressiveRadioButton() {
        return impressiveRadioButton;
    }

    public WebElement getImpressiveMessage() {
        return impressiveMessage;
    }

    public WebElement getRadioButtonSection() {
        return radioButtonSection;
    }

    //CHECK BOX SECTION
    @FindBy(xpath = "//div[@class='element-list collapse show']//li[@id='item-1']")
    @CacheLookup
    private WebElement checkBoxSection;
    @FindBy(xpath = "//span[@class='rct-checkbox']//*[name()='svg']")
    @CacheLookup
    private WebElement homeCheckBox;
    @FindBy(xpath = "//span[normalize-space()='home']")
    @CacheLookup
    private WebElement homeCheckBoxMessage;

    public WebElement getCheckBoxSection() {
        return checkBoxSection;
    }

    public WebElement getHomeCheckBox() {
        return homeCheckBox;
    }

    public WebElement getHomeCheckBoxMessage() {
        return homeCheckBoxMessage;
    }

    //TEXT BOX SECTION
    @FindBy(xpath = "//div[@class='element-list collapse show']//li[@id='item-0']")
    @CacheLookup
    private WebElement textBoxSection;
    @FindBy(id = "userName")
    @CacheLookup
    private WebElement fullNameTextField;
    @FindBy(id = "userEmail")
    @CacheLookup
    private WebElement emailTextField;
    @FindBy(id = "currentAddress")
    @CacheLookup
    private WebElement currentAddressTextField;
    @FindBy(id = "permanentAddress")
    @CacheLookup
    private WebElement permanentAddressTExtField;
    @FindBy(id = "submit")
    @CacheLookup
    private WebElement submitButton;
    @FindBy(id = "name")
    @CacheLookup
    private WebElement nameFromTextBoxSection;

    public WebElement getTextBoxSection() {
        return textBoxSection;
    }

    public WebElement getFullNameTextField() {
        return fullNameTextField;
    }

    public WebElement getEmailTextField() {
        return emailTextField;
    }

    public WebElement getCurrentAddressTextField() {
        return currentAddressTextField;
    }

    public WebElement getPermanentAddressTExtField() {
        return permanentAddressTExtField;
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }

    public WebElement getNameFromTextBoxSection() {
        return nameFromTextBoxSection;
    }

    //WEB TABLES SECTION
    @FindBy(xpath = "//span[normalize-space()='Web Tables']")
    @CacheLookup
    private WebElement webTablesSection;
    @FindBy(id = "addNewRecordButton")
    @CacheLookup
    private WebElement addButton;
    @FindBy(id = "firstName")
    @CacheLookup
    private WebElement firstNameTextField;
    @FindBy(xpath = "//input[@id='lastName']")
    @CacheLookup
    private WebElement lastName;
    @FindBy(id = "age")
    @CacheLookup
    private WebElement ageTextField;
    @FindBy(id = "salary")
    @CacheLookup
    private WebElement salaryTextField;
    @FindBy(id = "department")
    @CacheLookup
    private WebElement departmentTextField;
    @FindBy(id = "searchBox")
    @CacheLookup
    private WebElement searchBox;
    @FindBy(xpath = "//span[@id='basic-addon2']//span//*[name()='svg']")
    @CacheLookup
    private WebElement searchLoopIcon;//svg element
    @FindBy(xpath = "(//div[@role='gridcell'])[1]")
    @CacheLookup
    private WebElement tableGridCell;

    public WebElement getWebTablesSection() {
        return webTablesSection;
    }

    public WebElement getAddButton() {
        return addButton;
    }

    public WebElement getFirstNameTextField() {
        return firstNameTextField;
    }

    public WebElement getLastName() {
        return lastName;
    }

    public WebElement getAgeTextField() {
        return ageTextField;
    }

    public WebElement getSalaryTextField() {
        return salaryTextField;
    }

    public WebElement getDepartmentTextField() {
        return departmentTextField;
    }

    public WebElement getSearchBox() {
        return searchBox;
    }

    public WebElement getSearchLoopIcon() {
        return searchLoopIcon;
    }

    public WebElement getTableGridCell() {
        return tableGridCell;
    }


    //BUTTONS SECTION
    @FindBy(xpath = "//span[normalize-space()='Buttons']")
    @CacheLookup
    private WebElement buttonsSection;
    @FindBy(id = "doubleClickBtn")
    @CacheLookup
    private WebElement doubleClickMeButton;
    @FindBy(id = "rightClickBtn")
    @CacheLookup
    private WebElement rightClickButton;
    @FindBy(id = "doubleClickMessage")
    @CacheLookup
    private WebElement doubleClickMessage;
    @FindBy(id = "rightClickMessage")
    @CacheLookup
    private WebElement rightClickMessage;

    public WebElement getButtonsSection() {
        return buttonsSection;
    }

    public WebElement getDoubleClickMeButton() {
        return doubleClickMeButton;
    }

    public WebElement getRightClickButton() {
        return rightClickButton;
    }

    public WebElement getDoubleClickMessage() {
        return doubleClickMessage;
    }

    public WebElement getRightClickMessage() {
        return rightClickMessage;
    }

    //UPLOAD FILE SECTION
    @FindBy(xpath = "//span[normalize-space()='Upload and Download']")
    @CacheLookup
    private WebElement uploadAndDownloadSection;
    @FindBy(xpath = "//input[@id='uploadFile']")
    @CacheLookup
    private WebElement chooseFileButton;
    @FindBy(xpath = "//p[@id='uploadedFilePath']")
    @CacheLookup
    private WebElement uploadedFilePath;

    public WebElement getUploadAndDownloadSection() {
        return uploadAndDownloadSection;
    }

    public WebElement getChooseFileButton() {
        return chooseFileButton;
    }

    public WebElement getUploadedFilePath() {
        return uploadedFilePath;
    }
    //LINKS section
    @FindBy(xpath = "//div[@class='element-list collapse show']//li[@id='item-5']")
    @CacheLookup
    private WebElement linksSection;
    @FindBy(id="simpleLink")
    @CacheLookup
    private WebElement homeLink;
    @FindBy(xpath = "//img[@alt='Selenium Online Training']")
    @CacheLookup
    private WebElement seleniumImage;

    public WebElement getLinksSection() {
        return linksSection;
    }

    public WebElement getHomeLink() {
        return homeLink;
    }

    public WebElement getSeleniumImage() {
        return seleniumImage;
    }
}
