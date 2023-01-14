package steps;

import demoPageObjects.BaseClass;
import demoPageObjects.MainPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class DemoSteps extends BaseClass {

    MainPage mainpage = new MainPage(driver);

    @Given("user is on {string} page")
    public void onDemoMainPage(String url) {
        driver.manage().window().maximize();
        driver.get(url);
    }

    @When("user clicks {string} category")
    public void userClicksCategoryCard(String category) {
        mainpage.clickOnCategoryCard(category);
    }
}
