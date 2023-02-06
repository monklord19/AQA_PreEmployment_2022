package Steps;

import Pages.CheckBox;
import Pages.TextBox;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CheckBoxSteps {

    WebDriver driver = new ChromeDriver();
    CheckBox checkBox = new CheckBox(driver);

    @Given("User open DemoQA website {string}")
    public void userOpenDemoQA(String url)
    {
        driver.get(url);
    }

    @And("User click on elements category")
    public void userClickOnElementsCategory(){
        checkBox.clickElementsCategory();
    }

    @And("User click on checkbox subcategory")
    public void userClickOnCheckboxSubcategory(){
        checkBox.clickCheckBox();

    }

    @And("User click on expand all button")
    public void userClickOnExpandAllButton(){
        checkBox.clickExpandAll();

    }

    @And("User check the notes box")
    public void userCheckTheNotesBox(){
        checkBox.checkNotes();
    }

    @And("User check the angular box")
    public void userCheckTheAngularBox(){
        checkBox.checkAngular();
    }

    @And("User check the general box")
    public void userCheckTheGeneralBox(){
        checkBox.checkGeneral();
    }

    @Then("A text will appear below with the boxes marked")
    public void aTextWillAppearBellowWithTheBoxesMarked(){
        checkBox.verifyTheText();
    }
}
