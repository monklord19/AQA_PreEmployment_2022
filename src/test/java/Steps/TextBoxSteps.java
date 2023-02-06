package Steps;

import Pages.TextBox;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TextBoxSteps {
    WebDriver driver = new ChromeDriver();
    TextBox textBox = new TextBox(driver);

    @Given("User is on DemoQA website {string}")
    public void userIsOnDemoQA(String url)
    {
        driver.get(url);
    }

    @When("User click on elements button")
    public void userClickOnElementsButton(){
        textBox.clickElements();
    }

    @And("User click on text box subcategory")
    public void userClickOnTextBoxSubcategory(){
        textBox.clickTextBox();
    }

    @And("User enter the full name field as {string}")
    public void userEnterTheFullNameFieldAs(String fullname){
        textBox.enterFullName(fullname);
    }

    @And("User enter the email field as {string}")
    public void userEnterTheEmailFieldAs(String email){
        textBox.enterEmail(email);
    }

    @And("User enter the current address field as {string}")
    public void userEnterTheCurrentAddressFieldAs(String currentaddress){
        textBox.enterCurrentAddress(currentaddress);
    }

    @And("User enter the permanent address field as {string}")
    public void userEnterThePermanentAddressFieldAs(String permanentaddress){
        textBox.enterPermanentAddress(permanentaddress);
    }

    @Then("User click on submit button")
    public void userClickOnSubmitButton(){
        textBox.clickSubmit();
    }

    @And("The information must appear below")
    public void theInformationMustAppearBellow(String text){
        textBox.checkText(text);
    }











}
