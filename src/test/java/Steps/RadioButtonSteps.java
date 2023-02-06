package Steps;

import Pages.Buttons;
import Pages.RadioButton;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButtonSteps {
    WebDriver driver = new ChromeDriver();
    RadioButton radioButton = new RadioButton(driver);

    @Given("The user access DemoQa {string}")
    public void theUserAccessDemoQa(String url){
        driver.get(url);
    }
    @When("The user access Elements category")
    public void theUserAccessElementsCategory(){
        radioButton.openElements();
    }

    @And("User select the Radio Button subcategory")
    public void userSelectTheRadioButtonSubcategory(){
        radioButton.clickRadioButton();
    }

    @And("User select the Yes answer")
    public void userSelectTheYesAnswer(){
        radioButton.clickYes();
    }

    @Then("A message will appear with the chosen option")
    public void aMessageWillAppearWithTheChosenOption(){
        radioButton.messageRadioButton();
    }
}
