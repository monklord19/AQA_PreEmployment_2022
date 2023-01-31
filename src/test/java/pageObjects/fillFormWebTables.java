package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class fillFormWebTables {
    WebDriver driver;

    By firstName = By.id("firstName");
    By lastName = By.id("lastName");
    By userEmail = By.id("userEmail");
    By age = By.id("age");
    By salary = By.id("salary");
    By department = By.id("department");

    By clickSubmitButton = By.id("submit");

    public fillFormWebTables(WebDriver driver) {
        this.driver = driver;
    }
    public void editFirstName() {
        driver.findElement(firstName).sendKeys("Cierra Test");
    }
    public void editLastName() {
        driver.findElement(lastName).sendKeys("Vega Testing");
    }
    public void editEmail() {
        driver.findElement(userEmail).sendKeys("test@cierra.com");
    }
    public void editAge() {
        driver.findElement(age).sendKeys("27");
    }
    public void editSalary() {
        driver.findElement(salary).sendKeys("2000");
    }
    public void editDepartment() {
        driver.findElement(department).sendKeys("QA");
    }
    public void editFields(){
        driver.findElement(firstName).sendKeys("Cierra Test");
        driver.findElement(lastName).sendKeys("Vega Testing");
        driver.findElement(userEmail).sendKeys("test@cierra.com");
        driver.findElement(age).sendKeys("27");
        driver.findElement(salary).sendKeys("2000");
        driver.findElement(department).sendKeys("QA");
    }
    public void clickSubmitButton() {
        driver.findElement(clickSubmitButton).click();
    }
}
