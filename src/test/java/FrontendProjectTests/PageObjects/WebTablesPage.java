package FrontendProjectTests.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebTablesPage extends FormPage{

    @FindBy(id = "searchBox")
    private WebElement searchBox;
    @FindBy(id = "edit-record-1")
    private WebElement editRecord;
    @FindBy( id = "firstName")
    private WebElement firstName;
    @FindBy( id = "lastName")
    private WebElement lastName;
    @FindBy( id = "age")
    private WebElement age;
    @FindBy( id = "salary")
    private WebElement salary;
    @FindBy( id = "department")
    private WebElement department;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/div[1]/div[2]/div[1]/div")
    private WebElement row;
    public WebTablesPage(WebDriver driver) {
        super(driver);

    }
    public WebElement getSearchBox() {
        return searchBox;
    }

    public WebElement getEditRecord() {
        return editRecord;
    }

    public WebElement getFirstName() {
        return firstName;
    }

    public WebElement getLastName() {
        return lastName;
    }

    public WebElement getAge() {
        return age;
    }

    public WebElement getUserEmail() {
        return super.getUserEmailInput();
    }
    public WebElement getSubmitButton() {
        return super.getSubmitButton();
    }
    public WebElement getSalary() {
        return salary;
    }

    public WebElement getDepartment() {
        return department;
    }

    public WebElement getRow() {
        return row;
    }
}
