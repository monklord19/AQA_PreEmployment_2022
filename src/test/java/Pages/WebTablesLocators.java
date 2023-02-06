package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebTablesLocators {
    WebDriver driver;
    public WebTablesLocators(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public static final String theelements_xpath = "//*[@id=\"app\"]/div/div/div[2]/div/div[1]";
    public static final String webtables_xpath = "//*[@id=\"item-3\"]";
    public static final String addbutton_xpath = "//*[@id=\"addNewRecordButton\"]";
    public static final String firstname_xpath = "//*[@id=\"firstName\"]";
    public static final String lastname_xpath = "//*[@id=\"lastName\"]";
    public static final String emailemployee_xpath = "//*[@id=\"userEmail\"]";
    public static final String age_xpath = "//*[@id=\"age\"]";
    public static final String salary_xpath = "//*[@id=\"salary\"]";
    public static final String department_xpath = "//*[@id=\"department\"]";
    public static final String submitbutton_xpath = "//*[@id=\"submit\"]";
    public static final String table_xpath = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]";
    public static final String editbutton_xpath = "//*[@id=\"edit-record-4\"]/svg";

    public static final String deletebutton_xpath = "//*[@id=\"edit-record-4\"]/svg";




    @FindBy(xpath = WebTablesLocators.theelements_xpath)
    @CacheLookup
    private
    WebElement theelements;

    @FindBy(xpath = WebTablesLocators.webtables_xpath)
    @CacheLookup
    private
    WebElement webtables;

    @FindBy(xpath = WebTablesLocators.addbutton_xpath)
    @CacheLookup
    private
    WebElement addbutton;

    @FindBy(xpath = WebTablesLocators.firstname_xpath)
    @CacheLookup
    private
    WebElement firstname;

    @FindBy(xpath = WebTablesLocators.lastname_xpath)
    @CacheLookup
    private
    WebElement lastname;

    @FindBy(xpath = WebTablesLocators.emailemployee_xpath)
    @CacheLookup
    private
    WebElement emailemployee;

    @FindBy(xpath = WebTablesLocators.age_xpath)
    @CacheLookup
    private
    WebElement age;

    @FindBy(xpath = WebTablesLocators.salary_xpath)
    @CacheLookup
    private
    WebElement salary;

    @FindBy(xpath = WebTablesLocators.department_xpath)
    @CacheLookup
    private
    WebElement department;

    @FindBy(xpath = WebTablesLocators.submitbutton_xpath)
    @CacheLookup
    private
    WebElement submitbutton;

    @FindBy(xpath = WebTablesLocators.table_xpath)
    @CacheLookup
    private
    WebElement table;

    @FindBy(xpath = WebTablesLocators.editbutton_xpath)
    @CacheLookup
    private
    WebElement edit;

    @FindBy(xpath = WebTablesLocators.deletebutton_xpath)
    @CacheLookup
    private
    WebElement delete;


    public WebElement getTheElements()
    {
        return theelements;
    }

    public WebElement getWebTables()
    {
        return webtables;
    }

    public WebElement getAddButton()
    {
        return addbutton;
    }

    public WebElement getFirstName()
    {
        return firstname;
    }
    public WebElement getLastName()
    {
        return lastname;
    }

    public WebElement getAge() { return age; }

    public WebElement getEmailEmployee()
    {
        return emailemployee;
    }

    public WebElement getSalary()
    {
        return salary;
    }

    public WebElement getDepartment()
    {
        return department;
    }

    public WebElement getSubmitButton()
    {
        return submitbutton;
    }

    public String getVerifyEmployee()
    {
        return table.getText();
    }

    public WebElement getEditButton()
    {
        return edit;
    }

    public WebElement getDeleteEmployee()
    {
        return delete;
    }













}
