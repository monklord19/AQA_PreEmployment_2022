package steps;

import demoPageObjects.BaseClass;
import demoPageObjects.ElementPage;
import demoPageObjects.MainPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class DemoSteps extends BaseClass {

    MainPage mainpage = new MainPage(driver);
    ElementPage elementPage = new ElementPage(driver);

    @Given("user is on {string} page")
    public void onDemoMainPage(String url) {
        driver.manage().window().maximize();
        driver.get(url);
    }

    @When("user clicks {string} category")
    public void userClicksCategoryCard(String category) {
        mainpage.clickOnCategoryCard(category);
    }

    @And("user clicks on {string} element item")
    public void userClicksOnElementItem(String elementItem) {
        elementPage.clickOnElementItems(elementItem);
    }

    @And("user clicks on expand Home button")
    public void userClicksOnExpandHomeButton() {
        elementPage.clickOnExpandHomeButton();
    }

    @And("user clicks on {string} checkbox;")
    public void userClicksOnDownloadCheckbox(String node) {
        elementPage.clickOnCheckbox(node);
    }

    @Then("message is diplayed: You have selected:{string}")
    public void messageIsDiplayed(String message) {
        Assert.assertEquals(message,elementPage.messageIsDisplayed(message));
    }
}
