package UITests.stepsDefinitions;
import UITests.pageObjects.HomePage;
import UITests.pageObjects.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyStepdefs1 {

    WebDriver driver;
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

    @Given("On sauce website")
    public void onSauceWebsite() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @When("User enters valid credentials")
    public void userEntersValidCredentials() {
        driver.findElement(loginPage.getUsernameInput()).sendKeys("user name valid");

    }

    @Then("User should be logged in")
    public void userShouldBeLoggedIn() {
    }

    @Given("I enter random numbers on the username")
    public void enterRandomNumbers(){
        driver.findElement(loginPage.getUsernameInput()).sendKeys("standard_user");
    }
    @When("I press the login button")
    public void pressLoginButton(){
        driver.findElement(loginPage.getLoginButton()).click();

    }
    @Then("Login shouldn't work")
    public void loginNotWorking(){
        boolean isErrorDisplayed =  driver.findElement(loginPage.getErrorMessageContainer()).isDisplayed();
        Assert.assertTrue(isErrorDisplayed);
    }
    @And("I let password blank")
    public void letPasswordBlank() {};

    @Given("I enter the username {word}")
    public void enterTheUsername(String username){
        driver.findElement(loginPage.getUsernameInput()).sendKeys(username);
    }

    @And("I enter the password {word}")
    public void iEnterThePassword(String password) {
        driver.findElement(loginPage.getPasswordInput()).sendKeys(password);
    };

    @Then("I should be logged in")
    public void userIsLoggedIn() {
        boolean isShoppingCartDisplayed = driver.findElement(homePage.shoppingCartContainer).isDisplayed();
        Assert.assertTrue(isShoppingCartDisplayed);
    }

    @And("I press ADD TO CART button on the first product")
    public void pressAddToCartButton() {
        WebElement firstItem = driver.findElement(homePage.inventoryItem);
        firstItem.findElement(homePage.addToCartButton).click();
    }

    @Then("The cart is not empty")
    public void cartIsNotEmpty() {
        boolean cartBadgeIsDisplayed = driver.findElement(homePage.cartQuantityBadge).isDisplayed();
        Assert.assertTrue(cartBadgeIsDisplayed);
    }

}
