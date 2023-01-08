package step.definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.objects.CartPage;

public class CartSteps extends BaseClass {

    public CartPage cartPage;

    public CartSteps(TestContext context) {
        this.driver = context.driver;
        cartPage = new CartPage(driver);
    }

    @When("user clicks on Add to cart button having Product as {string}")
    public void userClicksOnAddToCartButtonHavingProductAs(String product) {
        cartPage.clickOnAddToCartButton(product);
    }

    @When("user clicks on Cart icon")
    public void userClicksOnCartIcon() {
        cartPage.clickOnCartIcon();
    }

    @Then("product {string} with Price {double} and Quantity {int} is added to the Cart")
    public void productWithPriceQuantityAndTotalPriceIsAddedToTheCart(String productName, Double price, Integer quantity) {
        cartPage.checkProductAddedInCart(productName, price, quantity);
    }
}
