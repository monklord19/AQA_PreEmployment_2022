package Steps;

import Pages.TextBox;
import Pages.WebTables;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class WebTablesSteps {
    WebDriver driver = new ChromeDriver();
    WebTables webTables = new WebTables(driver);

    @Given("User open the DemoQA webpage {string}")
    public void userOpenTheDemoQAWebpage(String url) {
        driver.get(url);
        Dimension dimension = new Dimension(1920, 1080);
        driver.manage().window().setSize(dimension);
    }

    @When("User open the elements category")
    public void userOpenTheElementsCategory() {

        webTables.clickTheElementsCategory();
    }

    @And("User click on webtables subcategory")
    public void userClickOnWebtableSubcategory() {
        webTables.clickWebTables();
    }

    @And("User click on add button to complete a registration form")
    public void userClickOnAddButtonToCompleteARegistrationForm() {
        webTables.clickAddButton();
    }

    @And("User populate the field with {string},{string},{string},{string},{string},{string}")
        public void userPopulateTheFieldWith(String firstname, String lastname, String emailemployee, String age, String salary, String department) {
        webTables.enterFirstName(firstname);
        webTables.enterLastName(lastname);
        webTables.enterEmailEmployee(emailemployee);
        webTables.enterAge(age);
        webTables.enterSalary(salary);
        webTables.enterDepartment(department);
    }

    @Then("User click the submit button")
    public void userClickTheSubmitButton(){
        webTables.clickSubmitButton();
    }
}
