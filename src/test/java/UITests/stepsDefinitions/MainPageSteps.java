package UITests.stepsDefinitions;

import UITests.pageObjects.MainPage;
import io.cucumber.java.After;
import io.cucumber.java.de.Wenn;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.Constants;

public class MainPageSteps {

    WebDriver driver;
    MainPage mainPage;
    @Given("I navigate to Main Page")
    public void navigateToPracticeFormPage(){
        driver = new ChromeDriver();
        driver.get(Constants.BASE_URL);
        driver.manage().window().maximize();
        mainPage = new MainPage(driver);
    }

    @And("I see the Main Page opened")
    public void seeTheMainPageOpen(){
        Assert.assertTrue(mainPage.isLogoDisplayed());
    }

    @Then("I see the category cards displayed")
    public void seeTheCategoriesDisplayed(){
        Assert.assertTrue(mainPage.areCategoryCardsDisplayed());
    }

    @Wenn("I click on the first category")
    public void iClickFirstCategory(){
        mainPage.clickCategory();
    }

    @Then("I can see the right page displayed")
    public void iSeeTheRightPageDisplayed() {
        Assert.assertTrue(mainPage.isCorrectHeaderDisplayed());
    }
}
