package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

public class CartSteps {
    WebDriver driver = new ChromeDriver();
    LogInPage logInPage = new LogInPage(driver);
    CartPage cartPage = new CartPage(driver);
    CheckoutPage checkoutPage = new CheckoutPage(driver);
    ProductsPage productsPage = new ProductsPage(driver);
    CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
    CheckoutFinishPage checkoutFinishPage = new CheckoutFinishPage(driver);


    @Given("You are on the login page1")
    public void youAreOnTheLoginPage() {
        driver.get("https://www.saucedemo.com/");


    }

    @Given("Login on the page")
    public void loginOnThePage() {

        logInPage.enterUsernameField("standard_user");
        logInPage.enterPasswordField("secret_sauce");
        logInPage.clickLoginButton();

    }


    @When("Add Sauce Labs Backpack in Cart")
    public void goBackToProductPage() {

        productsPage.addBagToCart();


    }

    @And("Go to cart")
    public void goToCart() {
        productsPage.clickCartLink();
    }

    @Then("Make sure item is in cart")
    public void makeSureItemIsInCart() {

        cartPage.checkIfBagIsInCart("Sauce Labs Backpack");
    }

    //SCENARIO 2
    @When("Click checkout button")
    public void clickCheckoutButton() {

        cartPage.clickCheckoutButton();
    }

    @And("Complete checkout first name with {string} last name with {string} and the zip code with {string}")
    public void completeCheckoutFirstNameWithLastNameWithAndTheZipCodeWith(String firstName, String secName, String zipCode) {

        checkoutPage.checkoutInformationField(firstName, secName, zipCode);

    }

    @And("Click continue button")
    public void clickContinueButton() {

        checkoutPage.clickContinueButton();
    }

    @And("Make sure  the Shipping Information is {string}")
    public void makeSureTheShippingInformationIs(String shippingInfo) {

        checkoutOverviewPage.checkInformationText(shippingInfo);
    }

    @And("Click finish button")
    public void clickFinishButton() {

        checkoutOverviewPage.clickFinishButton();
    }

    @Then("Make sure  the {string} TEXT IS DISPLAYED")
    public void makeSureTheTEXTISDISPLAYED(String thankYouText) {

        checkoutFinishPage.checkPonyText(thankYouText);
    }



//SCENARIO 2


}
