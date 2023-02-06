package Steps;

import Pages.Buttons;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ButtonsSteps {
    WebDriver driver = new ChromeDriver();
    Buttons buttons = new Buttons(driver);


    @Given("User open DemoQA awebsite {string}")
    public void userOpenDemoQAAWebsite(String url)

    {
        driver.get(url);
    }
    @When("User access the Elements from homepage")
    public void userAccessTheElementsFromHomePage(){

        buttons.clickElementsButton();
    }
    @And("User click the Buttons subcategory")
    public void userClickTheButtonsSubcategory(){
        buttons.clickButtons();
    }

    @And("User double click the first button")
    public void userDoubleClickTheFirstButton(){
        buttons.doubleClick();
    }

    @Then("A message will appear on the page")
    public void aMessageWillAppearOnThePage(){
        buttons.messageDouble();
    }

    @And("User makes a right click on the second button")
    public void userMakesARightClickOnTheSecondButton(){
        buttons.rightClick();
    }

    @Then("A message will appear")
    public void aMessageWillAppear(){
        buttons.messageRight();
    }

    @And("User make a left click on the last  button")
    public void userMakeALeftClickOnTheLastButton(){
        buttons.leftClick();
    }

    @Then("A message will appears bellow")
    public void aMessageWillAppearsBellow(){
        buttons.messageLeft();
    }

}
