//package StepsDefinitions;
//
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import org.junit.Assert;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import pages.loginPageObjects;
//
//
//public class loginPageSteps {
//
//    WebDriver driver = new ChromeDriver();
//    loginPageObjects login;
//    //ValidLogin
//    @Given("User is on URL")
//    public void userIsOnUrl() {
//        driver.get("https://www.saucedemo.com/");
//        System.out.println("I am in POM");
//    }
//    @When("^User enters (.*) and (.*)$")
//    public void userEntersUsernameAndPassword(String username, String password) {
//
//        login = new loginPageObjects(driver);
//        login.enterUsername(username);
//        login.enterPassword(password);
//      //  driver.findElement(By.id("user-name")).sendKeys(username);
//        //driver.findElement(By.id("password")).sendKeys(password);
//    }
//
//
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
//    public void failedSignInUsernameIsRequiredw() {
//        driver.quit();
//    }
//
//
//}
