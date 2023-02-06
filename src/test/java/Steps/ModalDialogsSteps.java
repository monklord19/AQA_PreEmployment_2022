package Steps;

import Pages.CheckBox;
import Pages.ModalDialogs;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ModalDialogsSteps {
    WebDriver driver = new ChromeDriver();
    ModalDialogs modalDialogs = new ModalDialogs(driver);

    @Given("User access the DemoQa page {string}")
    public void userAccessTheDemoQaPage(String url)
    {
        driver.get(url);
    }

    @When("User click on Alerts Frame Windows category")
    public void userClickOnAlertsFrameWindowsCategory(){
        modalDialogs.clickAlertsFrameWindows();
    }

    @And("User scrolling the page down")
    public void userScrollingThePageDown(){
        modalDialogs.scroolingThePage();
    }

    @And("User open the Modal Dialogs subcategory")
    public void userOpenTheModalDialogsSubcategory(){
        modalDialogs.clickModalDialogs();
    }

    @And("User click on Small modal button")
    public void userClickOnSmallModelButton(){
        modalDialogs.clickSmallModal();
    }

    @Then("User is able to see a simple modal and press to close")
    public void userIsAbleToSeeASimpleModelAndPressToClose(){
        modalDialogs.closeSmallModal();
    }

    @And("User click on Large modal button")
    public void userClickOnLargeModelButton(){
        modalDialogs.clickLargeModal();
    }

    @Then("User is able to see a bigger modal and press to close")
    public void userIsAbleToSeeABiggerModalAndPressToClose(){
        modalDialogs.closeLargeModal();
    }
}
