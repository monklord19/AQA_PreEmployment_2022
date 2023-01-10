//package stepDefinitions;
//
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.By;
////import pageObjects.LoginPage;
//
//public class LoginSteps {
//    //    System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chrome\\chromedriver_win32\\chromedriver.exe");
//    WebDriver driver = new ChromeDriver();
//
//    @Given("On sauce website")
//    public void onSauceWebsite() {
//        driver.get("https://www.saucedemo.com/");
//        driver.manage().window().maximize();
//    }
//
//    @When("User enters username")
//    public void userEntersStandardUser() {
//        driver.findElement(By.id("user-name")).sendKeys("standard_user");
//    }
//
//    @And("Password")
//    public void userEntersPass() {
//
//        driver.findElement(By.id("password")).sendKeys("secret_sauce");
//    }
//
//    @And("Clicks the login button")
//    public void userClicksLoginButton() {
//
//        driver.findElement(By.id("login-button")).click();
//    }
//
//    @Then("User should be logged in")
//    public void userShouldBeLoggedIn() {
//    }
//
//    //2nd scenario
//    @Given("On sauce website2")
//    public void onSauceWebsite2() {
//        driver.get("https://www.saucedemo.com/");
//        driver.manage().window().maximize();
//    }
//
//    @When("User enters username2")
//    public void userEntersUsername() {
//
//        driver.findElement(By.id("user-name")).sendKeys("problem_user");
//    }
//
//    @And("Wrong password")
//    public void userEntersPassword() {
//
//        driver.findElement(By.id("password")).sendKeys("secret");
//    }
//
//    @And("Clicks the login button2")
//    public void userClicksLoginButton2() {
//
//        driver.findElement(By.id("login-button")).click();
//    }
//
//    @Then("User should not be logged in")
//    public void userShouldNotBeLoggedIn2() {
////        driver.findElement(By.id("shopping_cart_container")).click();
//    }
//
//    //3rd scenario Adding a product to cart
//    @Given("I am already logged in")
//    public void LoginPage(String username, String password) {
//        driver.get("https://www.saucedemo.com/");
//        driver.findElement(By.id("user-name")).sendKeys("standard_user");
//        driver.findElement(By.id("password")).sendKeys("secret_sauce");
//        driver.findElement(By.id("login-button")).click();
//    }
//
//    @When("I click on the ADD TO CART button corresponding to the Sauce Labs Bike Light")
//    public void addToCartBikeLight() {
//
//        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
//    }
//
//    @And("I check the cart")
//    public void openCart() {
//
//        driver.findElement(By.id("shopping_cart_container")).click();
//    }
//
//    @Then("The item should be there")
//    public void win() {
//    }
//}
////4th scenario
////    @Given("On sauce website3")
////    public void onSauceWebsite3() {
////        driver.get("https://www.saucedemo.com/");
////        driver.manage().window().maximize();
////    }
////    @When("User enters username as \"<username>\"")
////    public void enterUsername() {
////        driver.findElement(By.id("")).sendKeys();
////    }
//
//
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
