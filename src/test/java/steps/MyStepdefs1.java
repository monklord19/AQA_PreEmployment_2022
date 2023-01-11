package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageObjects.LoginPage;
import pageObjects.ProductsPage;

public class MyStepdefs1 extends BaseClass {
//    WebDriver driver;
    LoginPage loginPage = new LoginPage(driver);
    ProductsPage productsPage = new ProductsPage(driver);


    @Given("User is on the login page")
    public void onSauceWebsite() {

    }


    @When("user enters {string} in username field")
    public void setUsername(String username) {
        loginPage.setUsernameField(username);
    }

    @And("user enters {string} in password field")
    public void setPassword(String password) {
        loginPage.setPasswordField(password);
    }

    @And("user clicks on login button")
    public void clicksLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("current URL is: {string}")
    public void userShouldBeAbleToLogin(String expectedUrl) {
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);
        System.out.println("User logged in successfully");
    }

    @Then("error is displayed")
    public void errorIsDisplayed() {
        Assert.assertTrue(loginPage.isErrorDisplayed());
    }

    @And("message is: {string}")
    public void messageIs(String message) {
        Assert.assertEquals(message, loginPage.getErrorMessage());
    }

    @And("add product to cart: {string}")
    public void addProductToCart(String productName) {
        productsPage.addProductToCart(productName);
    }

    @And("check if the product is added")
    public void checkIfTheProductIsAdded() {
        Assert.assertTrue(productsPage.checkProductIsAdded());
    }


    @When("user clicks on burger meniu button")
    public void userClicksOnBurgerMeniuButton() {
        productsPage.clickOnMeniuButton();
    }

    @And("check if the meniu is opened")
    public void checkIfTheMeniuIsOpened() {
        Assert.assertEquals("false", productsPage.checkBurgerMeniuIsOpened());
    }

}






