package StepDefinitions;

import Pages.Homepage;
import Pages.LoginPage;
import Pages.ProductCard;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CartStepsDef {

    WebDriver driver = new ChromeDriver();
    LoginPage loginPage = new LoginPage(driver);
    ProductCard productCard = new ProductCard(driver);
    Homepage homepage = new Homepage(driver);

    @After
    public void closeBrowser() {
        driver.quit();
    }
    @Given("User is logged in on website {string} with username {string} and password {string}")
    public void userIsLoggedInOnWebsiteWithUsernameAndPassword(String url, String username, String password) {
        driver.get(url);
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        loginPage.clickOnLoginButton();
    }

    @When("User clicks on add to cart on product Sauce Labs Backpack")
    public void userClicksOnAddToCartOnProductSauceLabsBackpack() {
        productCard.addProductToCart();
    }

    @Then("Product is added to cart")
    public void productIsAddedToCart() {
        homepage.getCartIcon().click();
    }
}
