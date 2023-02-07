package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DemoElementsPage extends BasePage {

    public WebDriver driver;

    By demoQAFullNameField = By.id("userName");
    By demoQAEmailField = By.id("userEmail");
    By demoQACurrentAddressField = By.id("currentAddress");
    By demoQaPermanentAddressField = By.id("permanentAddress");
    By registrationTablesFirstName = By.id("firstName");
    By registrationTablesLastName = By.id("lastName");
    By registrationTablesEmail = By.id("userEmail");
    By registrationTablesAge = By.id("age");
    By registrationTablesSalary = By.id("salary");
    By registrationTablesDepartment = By.id("department");
    By webTabletSearchNewItemCreated = By.id("searchBox");

    public WebElement enterDemoQAFullName(){
        return driver.findElement(demoQAFullNameField);
    }

    public WebElement enterDemoQAEmail(){
        return driver.findElement(demoQAEmailField);
    }

    public WebElement enterDemoQACurrentAddress(){
        return driver.findElement(demoQACurrentAddressField);
    }

    public WebElement enterDemoQaPermanentAddress(){
        return driver.findElement(demoQaPermanentAddressField);
    }

    public WebElement getDemoQASubmitButton(){
        return driver.findElement(By.id("submit"));
    }
    public WebElement getDemoQATextBoxSubmenu(){
        return driver.findElement(By.xpath("//span[contains(text(), 'Text Box')]"));
    }
    public WebElement getDownloadButton(){
        return driver.findElement(By.id("downloadButton"));
    }
    public WebElement getDemoQAWebTablesSubmenu(){
        return driver.findElement(By.xpath("//span[contains(text(), 'Web Tables')]"));
    }
    public WebElement getDemoQANewRecordButton(){
        return driver.findElement(By.id("addNewRecordButton"));
    }
    public WebElement enterRegistrationTablesFirstName(){
        return driver.findElement(registrationTablesFirstName);
    }
    public WebElement enterRegistrationTablesLastName(){
        return driver.findElement(registrationTablesLastName);
    }
    public WebElement enterRegistrationTablesEmail(){
        return driver.findElement(registrationTablesEmail);
    }
    public WebElement enterRegistrationTablesAge(){
        return driver.findElement(registrationTablesAge);
    }
    public WebElement enterRegistrationSalary(){
        return driver.findElement(registrationTablesSalary);
    }
    public WebElement enterRegistrationDepartment(){
        return driver.findElement(registrationTablesDepartment);
    }
    public WebElement getRegistrationSubmitButton(){
        return driver.findElement(By.id("submit"));
    }
    public WebElement searchNewItemCreated(){
        return driver.findElement(webTabletSearchNewItemCreated);
    }
    public WebElement getWebTablesDeleteIcon(){
        return driver.findElement(By.xpath("//span[contains(@title,'Delete')]"));
    }
    public DemoElementsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
