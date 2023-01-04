package UITests.steps;

import UITests.pageObjects.FunctionsDefiniton;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class MyStepdefs1 {
    WebDriver driver = new ChromeDriver();
    FunctionsDefiniton loginPage=new FunctionsDefiniton(driver);

    @Given("open the loginPage")
    public void onSauceWebsite() {

        driver.get("https://www.saucedemo.com/");

    }

    @When("I type the username {string} and the password {string}")
    public void iTypeTheUsernameAndThePassword(String username, String password) {
        loginPage.setUsername(username);
        loginPage.setPassword(password);
    }

    @And("I click on login")
    public void iClickOnLogin() throws InterruptedException {
        loginPage.pressLoginButton();
    }

    @Then("I should be logged in")
    public void iShouldBeLoggedIn() {
        driver.navigate().to("https://www.saucedemo.com/inventory.html");
    }

    @And("I press the refresh button of the webpage")
    public void iPressTheRefreshButtonOfTheWebpage() {
        loginPage.refreshPage();
    }
    @And("A pop-up saying {string} should appear")
    public void aPopUpSayingShouldAppear(String errorMessages) {
        loginPage.errorMessage(errorMessages);
    }
    @After
    public void close_browser() {
        driver.close();
    }
    @When("I add a backpack to cart")
    public void iAddABackpackToCart() {
        loginPage.addBackpackToCart();
    }
    @And("I open the shopping cart")
    public void iOpenTheShoppingCart() throws InterruptedException {
        loginPage.openShoppingCart();
    }


    @Then("Item in cart should be called {string}")
    public void itemInCartShouldBeCalled(String itemTitle) {
       loginPage.checkItemName(itemTitle);
    }

    @Given("User is logged in")
    public void userIsLoggedIn() throws InterruptedException {
        onSauceWebsite();
        iTypeTheUsernameAndThePassword("standard_user","secret_sauce" );
        iClickOnLogin();

    }


    @When("I click on the menu button")
    public void iClickOnTheMenuButton() throws InterruptedException {
        loginPage.clickMenuButton();
    }

    @And("I press logout")
    public void iPressLogout() throws InterruptedException {
        loginPage.clickLogout();
    }

    @Then("The username and password fields should be empty")
    public void theUsernameAndPasswordFieldsShouldBeEmpty() throws InterruptedException{

        loginPage.checkEmptyUsernameAndPassword();
    }
}
