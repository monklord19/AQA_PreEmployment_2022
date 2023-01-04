package Steps;

import Pages.CartPage;
import Pages.LoginPage;
import Pages.ProductPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Stepdefinitions {
   LoginPage loginPage = new LoginPage();
   ProductPage productPage = new ProductPage();
   CartPage cartPage = new CartPage();

//Scenario1
     @Given("User open test website")
     public void userOpenTestWebsite() {
         loginPage.URL("https://www.saucedemo.com/");
     }


    @Given("Entering valid credentials")
    public void entering_valid_credentials() {
        loginPage .enterUsernameField("standard_user");
        loginPage .enterPasswordField("secret_sauce");


    }

    @When("I click the login button")
    public void i_click_the_login_button() {
        loginPage.clickLoginButton();
    }


    @Then("User is on ProductPage")
            public void userIsOnProductPage(){
productPage.LogoIsDisplayed();
        }



    //Scenario2

    @Given("Navigate to product page")
    public void navigateToProductPage() {

        loginPage .enterUsernameField("standard_user");
        loginPage .enterPasswordField("secret_sauce");
        loginPage .clickLoginButton();

    }
    @And("Backpack added to cart")
    public void backpackAddedToCart() {
        productPage .addBagToCart();
    }

    @When("Navigate to the cart")
    public void navigateToTheCart() {
        productPage .clickCartButton();
    }

    @Then("The product should be there")
    public void theProductShouldBeThere() {
        cartPage .checkIfTheBagIsInCart("Sauce Labs Backpack");


    }



    }

