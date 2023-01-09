package Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import Pages.LoginPage;

public class LoginSteps {
    WebDriver driver = new ChromeDriver();
    LoginPage loginPage = new LoginPage(driver);

    @Given("User go to {string}")
    public void userGoTo(String url) {

        driver.get(url);
    }

    @And("User type a valid username as {string}")
    public void userTypeAValidUsernameAs(String username) {

        loginPage.setUserName(username);
    }

    @And("User enter a valid password as {string}")
    public void userEnterAValidPasswordAs(String password) {

        loginPage.setPassword(password);
    }

    @When("User press the login button")
    public void userPressTheLoginButton() {
        loginPage.clickLoginButton();

    }

    @Then("The home page appears")
    public void theHomePageAppears() {
        loginPage.checkHomePageOpened();
    }

    @And("User click on login button")
    public void userClickOnLoginButton(){
        loginPage.clickLogoutButton();
    }



    @Given("User log in the Sauce site {string}")
    public void userLogInTheSauceSite(String url){
        driver.get(url);
    }

    @And("User enter invalid username as {string}")
    public void userEnterInvalidUsernameAs(String username){
        loginPage.setUserName(username);
    }

    @And("User enter invalid password as {string}")
    public void userEnterInvalidPasswordAs(String password){
        loginPage.setPassword(password);
    }

    @When("User press the button to login")
    public void userPressTheButtonToLogin(){
        loginPage.clickLoginButton();
    }

    @Then("Error message is displayed {string}")
    public void errorMessageIsDisplayed(String pop_up)
    {
        loginPage.checkErrorPop_up(pop_up);
    }

    @Given("User is logged in Sauce site")
    public void userIsLoggedInSauceSite() {
        userGoTo("https://www.saucedemo.com/");
        userTypeAValidUsernameAs("standard_user");
        userEnterAValidPasswordAs("secret_sauce");
        userPressTheLoginButton();
        theHomePageAppears();
    }

    @When("User click on hamburger button")
    public void userClickOnHamburgerButton(){
        loginPage.clickHamburgerBtn();
    }

    @And("User click on logout button")
    public void userClickOnLogoutButton(){
        loginPage.clickLogoutButton();
    }

    @Then("User is back on Login page")
    public void userIsBackOnLoginPage() {
        loginPage.checkLoginPageOpened();
    }

    @And("user presses Enter key")
    public void userPressesEnterKey() {
        loginPage.enterKeyLogin();
    }
    @When("User add an item pressing the cart button")
    public void userAddAnItemPressingTheCartButton(){
        loginPage.clickAddToCartButton();
    }


    @Then("The item should appear in cart")
    public void theItemShouldAppearInCart(){

    }

    @And("The cart page opens")
    public void theCartPageOpens(){
        driver.navigate().to("https://www.saucedemo.com/cart.html");
    }

}