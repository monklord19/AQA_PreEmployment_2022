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
    public void user_clicks_on_add_to_cart_button_having_product_as(String product) {
        cartPage.clickOnAddToCartButton(product);
    }

    @When("user clicks on Cart icon")
    public void user_clicks_on_cart_icon() {
        cartPage.clickOnCartIcon();
    }

    @Then("product {string} with Price {double} and Quantity {int} is added to the Cart")
    public void product_with_price_quantity_and_total_price_is_added_to_the_cart(String productName, Double price, Integer quantity) {
        cartPage.checkProductAddedInCart(productName, price, quantity);
    }
}
