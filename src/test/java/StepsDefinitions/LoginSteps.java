//package StepsDefinitions;
//
//import io.cucumber.java.After;
//import io.cucumber.java.Before;
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import org.junit.Assert;
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//public class LoginSteps {
//    WebDriver driver = new ChromeDriver();
//@Before
//    @Given("I open login page")
//    public void i_open_login_page()  {
//        String test_url = "https://www.saucedemo.com/";
//
//        driver.manage().window().maximize();
//        driver.get(test_url);
//    }
//
//    @When("^I enter (.*) and (.*)$")
//    public void i_enter_username_and_password(String username, String password)  {
//        driver.findElement(By.id("user-name")).sendKeys(username);
//        driver.findElement(By.id("password")).sendKeys(password);
//
//    }
//
//    @And("Click login button")
//    public void click_login_button() {
//        driver.findElement(By.id("login-button")).click();
//    }
//
//    @Then("Login successful, home page displayed")
//    public void login_successful_home_page_displayed(){
//        Assert.assertTrue(driver.findElement(By.id("shopping_cart_container")).isDisplayed());
//
//        }
//
//
//    @Then("Error message displayed")
//    public void errorMessageDisplayed()  {
//        Assert.assertTrue(driver.findElement(By.className("error-button")).isDisplayed());
//        }
//
//
//    @And("Press enter key on keyboard")
//    public void pressEnterKeyOnKeyboard() {
//        driver.findElement(By.id("login-button")).sendKeys(Keys.ENTER);
//
//    }
//    @When("I add the first item to Cart")
//    public void iAddTheFirstItemToCart() throws InterruptedException {
//
//        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
//        Thread.sleep(2000);
//
//    }
//
//    @And("I open my shopping cart")
//    public void iOpenMyShoppingCart() throws InterruptedException {
//        driver.findElement(By.className("shopping_cart_badge")).click();
//        Thread.sleep(1000);
//    }
//
//    @Then("I should see the product in my shopping cart")
//    public void iShouldSeeTheproductInMyShoppingCart() throws InterruptedException {
//        WebElement element = driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div"));
//        String strng = element.getText();
//        System.out.println(strng);
//        Assert.assertEquals("Sauce Labs Backpack", strng);
//        Thread.sleep(2000);
//    }
//    @After
//    public void closestep(){
//        driver.quit();
//    }
//
//}
//
//
//
