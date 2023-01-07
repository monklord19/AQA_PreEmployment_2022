//package StepsDefinitions;
//
//import io.cucumber.java.en.*;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.junit.Assert;
//
//public class MyStepsDefinitions {
//
//    WebDriver driver = new ChromeDriver();
//
//    //ValidLogin
//    @Given("User is on URL")
//    public void userIsOnUrlSauceDemo() {
//        driver.get("https://www.saucedemo.com/");
//    }
//    @When("^User enters (.*) and (.*)$")
//    public void userEntersUsernameAndPassword(String username, String password) {
//        driver.findElement(By.id("user-name")).sendKeys(username);
//        driver.findElement(By.id("password")).sendKeys(password);
//    }
//    @And("User clicks on login button")
//    public void userClicksOnLoginButton() {
//        driver.findElement(By.id("login-button")).click();
//    }
//    @Then("User is successfully logged in")
//    public void userIsSuccessfullyLoggedIn() {
//        Assert.assertTrue(driver.findElement(By.className("title")).isDisplayed());
//        driver.quit();
//    }
//
//    //LockedOutUser
//    @When("User enters credentials")
//    public void userEntersCredentials() {
//        driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
//        driver.findElement(By.id("password")).sendKeys("secret_sauce");
//    }
//
//    @Then("Failed sign-in with error msg")
//    public void failedSignInWithErrorMsg() {
//        driver.quit();
//    }
//
//    //NoPassword
//    @Then("Failed sign-in. Password required")
//    public void failedSignInPasswordRequired() {
//        driver.quit();
//    }
//
//    //WrongPassword
//    @Then("Failed sign-in. Wrong password")
//    public void failedSignInWrongPassword() {
//        driver.quit();
//    }
//
//    //NoUsername
//    @Then("Failed sign-in. Username is required")
//    public void failedSignInUsernameIsRequired() {
//        driver.quit();
//    }
//
//
//}
