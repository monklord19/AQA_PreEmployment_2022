package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import pageObjects.sauceLogin;

public class sauceSteps_POM {
    WebDriver driver = new ChromeDriver();
    sauceLogin login;

    //login = new sauceLogin(driver);

    @Given("On sauce website")
    public void onSauceWebsite() {
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
    }

    @When("^User enters (.*) and (.*)$")
    public void userEntersStandardUser(String username, String password) {
        login = new sauceLogin(driver);
        login.enterUsername(username);
        login.enterPassword(password);
    }


    @And("Clicks the login button")
    public void userClicksLoginButton() {
        login.clickLogin();
    }

    @Then("User should be logged in")
    public void userShouldBeLoggedIn() {
    }


//2nd scenario
//    @Given("On sauce website")
//    public void onSauceWebsite() {
//        driver.get("https://www.saucedemo.com/");
//        driver.manage().window().maximize();
//    }

    @When("User enters username as {string}")
    public void userEntersUsername(String username) {
        login = new sauceLogin(driver);
        login.enterUsername(username);
        //driver.findElement(By.id("user-name")).sendKeys("problem_user");
    }
//    @When("User enters username")
//    public void enterUsername (){
//        driver.findElement(sauceUsername).sendKeys(username);
//    }

    @And("Password as {string}")
    public void enterWrongPassword(String wrongPassword) {
        login = new sauceLogin(driver);
        login.enterWrongPassword(wrongPassword);
        //driver.findElement(By.id("password")).sendKeys("secret");
    }

//    @And("Clicks the login button2")
//    public void userClicksLoginButton2() {
//
//        driver.findElement(By.id("login-button")).click();
//    }

    @Then("An error message is displayed \"Epic sadface: Username and password do not match any user in this service\"")
    public void userShouldNotBeLoggedIn() {
        //driver.findElement(By.id("shopping_cart_container")).click();
    }


    ////////////////////////////////////////////////////////////////////////3rd scenario Adding a product to cart
//    @And("^User enters (.*) and (.*)$")
//    public void loginValidUser() {
//    }
//        login = new sauceLogin(driver);
//        login.enterUsername(username);
//        login.enterPassword(password);
//        driver.findElement(By.id("user-name")).sendKeys("standard_user");
//        driver.findElement(By.id("password")).sendKeys("secret_sauce");
//        driver.findElement(By.id("login-button")).click();
    @And("Password {string}")
    public void enterPassword(String password) {
        login = new sauceLogin(driver);
        login.enterPassword(password);
    }

    @When("Add to cart Sauce Labs Bike Light")
    public void addToCartBikeLight() {
        login.addToCartBikeLight();
    }

    @And("I check the cart")
    public void openCart() {
        login.clickCartIcon();
    }

    @Then("The item should be there")
    public void win() {
        login.assertBikeLight();
    }
}
////4th scenario
//    @Given("On sauce website3")
//    public void onSauceWebsite3() {
//        driver.get("https://www.saucedemo.com/");
//        driver.manage().window().maximize();
//    }
//    @When("User enters username as \"<username>\"")
//    public void enterUsername() {
//        driver.findElement(By.id("")).sendKeys();
//    }


/////////radio button
////    @Given("On demo site")
////    public void onDemoSite() {
////        driver.get("https://demoqa.com/radio-button");
////        driver.manage().window().maximize();
////    }
////
////    @When("User selects Impressive radio button")
////    public void selectsImpressive() {
////        driver.findElement(By.id("impressiveRadio")).click();
////    }
////
////    @Then("Check label is displayed correctly")
////    public void impressiveButtonIsSelected() {
////
////    }
//
//
//
