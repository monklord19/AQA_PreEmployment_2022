import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LoginSteps {
    WebDriver driver = null;
    @Given("On sauce website")
    public void onSauceWebsite() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @And("User type a valid username")
    public void userTypeAValidUsername(){

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("User enter a valid password")
    public void userEnterAValidPassword(){

        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @When("User press the login button")
    public void userPressTheLoginButton(){
        driver.findElement(By.id("login-button")).click();

    }

    @Then("The login was successful")
    public void theLoginWasSuccessful(){
       driver.findElement(By.id("logout_sidebar_link")).isDisplayed();
    }

    @Given("Open the page")
    public void openThePage() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @And("User enter numbers as username")
    public void userEnterNumbersAsUsername(){

        driver.findElement(By.id("user-name")).sendKeys("1234");
    }

    @And("User enter numbers as password")
    public void userEnterNumbersAsPassword(){

        driver.findElement(By.id("password")).sendKeys("0987");
    }

    @When("User click the login button")
    public void userClickTheLoginButton(){
        driver.findElement(By.id("login-button")).click();

    }

    @Then("An error pop-up appears")
    public void anErrorPopupAppears(){
        String errorMessage = driver.findElement(By.cssSelector(".error >h3")).getText();
        Assert.assertEquals(errorMessage, "Epic sadface: Username and password do not match any user in this service");
    }
    @Given("Open the sauce page")
    public void openTheSaucePage() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @And("I enter a valid username")
    public void iEnterAValidUsername(){

        driver.findElement(By.id("user-name")).sendKeys("problem_user");
    }

    @And("I enter a different password")
    public void iEnterADifferentPassword(){

        driver.findElement(By.id("password")).sendKeys("secret_santa");
    }

    @When("Click on login button")
    public void clickOnLoginButton(){
        driver.findElement(By.id("login-button")).click();

    }

    @Then("An error message appears")
    public void anErrorMessageAppears(){
        String errorMessage = driver.findElement(By.cssSelector(".error >h3")).getText();
        Assert.assertEquals(errorMessage, "Epic sadface: Username and password do not match any user in this service");
    }

    @Given("Open the web page")
    public void openTheWebPage() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @And("I enter the username with capital letters")
    public void iEnterTheUsernameWithCapitalLetters(){

        driver.findElement(By.id("user-name")).sendKeys("PROBLEM_USER");
    }

    @And("I enter the password with capital letters")
    public void iEnterThePasswordWithCapitalLetters(){

        driver.findElement(By.id("password")).sendKeys("SECRET_SAUCE");
    }

    @When("Click the login button")
    public void clickTheLoginButton(){
        driver.findElement(By.id("login-button")).click();

    }

    @Then("Error pop-up appears")
    public void errorPopupAppears(){
        String errorMessage = driver.findElement(By.cssSelector(".error >h3")).getText();
        Assert.assertEquals(errorMessage, "Epic sadface: Username and password do not match any user in this service");
    }

    @Given("User open the sauce page")
    public void userOpenTheSaucePage() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @And("User enter special characters as username")
    public void userEnterSpecialCharactersAsUsername(){

        driver.findElement(By.id("user-name")).sendKeys("*^$#");
    }

    @And("User enter special characters as password")
    public void userEnterSpecialCharactersAsPassword(){

        driver.findElement(By.id("password")).sendKeys("*^%$#");
    }

    @When("User click on login button")
    public void userClickOnLoginButton(){
        driver.findElement(By.id("login-button")).click();

    }

    @Then("Error message appears")
    public void errorMessageAppears(){
        String errorMessage = driver.findElement(By.cssSelector(".error >h3")).getText();
        Assert.assertEquals(errorMessage, "Epic sadface: Username and password do not match any user in this service");
    }
}
