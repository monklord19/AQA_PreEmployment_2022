package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.sql.Driver;

public class WebTablesPage {
    WebDriver driver;
    @FindBy(id = "addNewRecordButton")
    private WebElement addButton;

    @FindBy(id = "firstName")
    private WebElement firstNameField;

    @FindBy(id = "lastName")
    private WebElement lastNameField;

    @FindBy(id = "userEmail")
    private WebElement emailField;

    @FindBy(id = "age")
    private WebElement ageField;

    @FindBy(id = "salary")
    private WebElement salaryField;

    @FindBy(id = "department")
    private WebElement departmentField;

    @FindBy(id = "submit")
    private WebElement submitButton;

    @FindBy(id = "searchBox")
    private WebElement searchBoxField;

    @FindBy(css = ".rt-tbody > div:nth-of-type(1) > div[role='row'] > div:nth-of-type(1)")
    private WebElement findJonnyFirstName;

    @FindBy(css = "span[title='Delete'] > svg")
    private WebElement deleteButton;


    public WebTablesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void clickAddButton(){
        addButton.click();
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

    public void setAgeField(String age) {
        ageField.sendKeys(age);
    }

    public void setSalaryField(String salary) {
        salaryField.sendKeys(salary);
    }

    public void setDepartmentField(String department) {
        departmentField.sendKeys(department);
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public void searchFieldFindJonny(String jonnyName){
        searchBoxField.sendKeys(jonnyName);
    }
    public void checkToFindJonny(){
        Assert.assertEquals(findJonnyFirstName.getText(),"Jonny");
    }
    public void deleteJonnyProfile(){
        deleteButton.click();
    }
}
