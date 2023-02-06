package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class WebTables {
    WebDriver driver;
    WebDriverWait wait;

    WebTablesLocators webTablesLocators;

    public WebTables(WebDriver driver) {
        this.driver = driver;
        driver.manage().window().maximize();
        webTablesLocators = new WebTablesLocators(driver);
    }

    public void clickTheElementsCategory()
    {
        webTablesLocators.getTheElements().click();

    }
    public void clickWebTables(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(webTablesLocators.getWebTables()));
        webTablesLocators.getWebTables().click();
    }

    public void clickAddButton(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(webTablesLocators.getAddButton()));
        webTablesLocators.getAddButton().click();
    }

    public void enterFirstName(String firstname){
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(webTablesLocators.getFirstName()));
        webTablesLocators.getFirstName().clear();
        webTablesLocators.getFirstName().sendKeys(firstname, Keys.RETURN);

    }

    public void enterLastName(String lastname){
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(webTablesLocators.getLastName()));
        webTablesLocators.getLastName().clear();
        webTablesLocators.getLastName().sendKeys(lastname, Keys.RETURN);

    }

    public void enterEmailEmployee(String emailemployee){
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(webTablesLocators.getEmailEmployee()));
        webTablesLocators.getEmailEmployee().clear();
        webTablesLocators.getEmailEmployee().sendKeys(emailemployee, Keys.RETURN);

    }

    public void enterAge(String age){
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(webTablesLocators.getAge()));
        webTablesLocators.getAge().clear();
        webTablesLocators.getAge().sendKeys(age, Keys.RETURN);

    }

    public void enterSalary(String salary){
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(webTablesLocators.getSalary()));
        webTablesLocators.getSalary().clear();
        webTablesLocators.getSalary().sendKeys(salary, Keys.RETURN);

    }

    public void enterDepartment(String department){
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(webTablesLocators.getDepartment()));
        webTablesLocators.getDepartment().clear();
        webTablesLocators.getDepartment().sendKeys(department, Keys.RETURN);

    }
    public void clickSubmitButton(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        webTablesLocators.getSubmitButton().click();
    }
}
