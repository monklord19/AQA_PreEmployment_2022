package StepsDefinitions;

import Pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginSteps_POM {
    WebDriver driver = new ChromeDriver();
    LoginPage login = new LoginPage(driver);
//@Before
    @Given("I open login page")
    public void i_open_login_page() {

        String test_url = "https://www.saucedemo.com/";

        driver.manage().window().maximize();
        driver.get(test_url);
    }

    @When("^I enter (.*) and (.*)$")
    public void i_enter_username_and_password(String username, String password) {
        login.enterUserName(username);
        login.enterPassword(password);
    }

    @When("Click login button")
    public void click_login_button(){
        login.clickLogin();
    }

    @Then("Login successful, home page displayed")
    public void login_successful_home_page_displayed() {
        login.checkCartisDisplayed();
    }

    @Then("Error message displayed")
    public void errorMessageDisplayed() {
        login.errorMsgisDisplayed();
    }

    @And("Press enter key on keyboard")
    public void pressEnterKeyOnKeyboard() {

        login.pressEnterKey();
    }
    @When("I add the first item to Cart")
    public void iAddTheFirstItemToCart() {

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

    }

    @And("I open my shopping cart")
    public void iOpenMyShoppingCart(){
        driver.findElement(By.className("shopping_cart_badge")).click();
    }

    @Then("I should see the product in my shopping cart")
    public void iShouldSeeTheproductInMyShoppingCart(){
        WebElement element = driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div"));
        String strng = element.getText();
        System.out.println(strng);
        Assert.assertEquals("Sauce Labs Backpack", strng);
}
    @After
    public void closestep(){
        driver.quit();
    }

    @When("Click More Button")
    public void clickMoreButton(){
        driver.findElement(By.id("react-burger-menu-btn")).click();

    }

    @And("Click LOGOUT")
    public void clickLOGOUT() {
        driver.findElement(By.id("logout_sidebar_link")).click();
    }

    @Then("I should see login page")
    public void iShouldSeeLoginPage() {
        Assert.assertTrue(driver.findElement(By.className("bot_column")).isDisplayed());

    }


}



