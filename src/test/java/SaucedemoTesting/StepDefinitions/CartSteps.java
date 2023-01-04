package SaucedemoTesting.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.SaucedemoTesting.pageobjects.CartPage;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

public class CartSteps extends TestBase {
    private CartPage cart = PageFactory.initElements(driver, CartPage.class);

    @When("User click on Add to cart button for the product {string}")
    public void userClickOnAddToCartButtonForTheProduct(String productName) {
        cart.getBtn_addToCart_SLBTSH().click();
    }

    @And("User click on Cart pictogram")
    public void userClickOnCartPictogram() {
        cart.getCartIcon().click();
    }

    @Then("The product {string} is successfully added to the cart")
    public void theProductIsSuccessfullyAddedToTheCart(String productName) {

        Assert.assertEquals(cart.getItemNameContainer().getText(), productName);
    }

}
