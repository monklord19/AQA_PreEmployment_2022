package steps;

import pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class LogInTest {

    public WebDriver driver = new ChromeDriver();
    LoginPage LoginPage;

    //create driver
    /*@Before
    public void webdriverSetUp(){
        //System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver.exe");
    }*/

    @After
    public void close_browser(){

        driver.close();
    }

    @Given("I open the website")
    public void i_open_the_website(){
        driver.get("https://www.saucedemo.com");

    }

    @Then("I should be logged successfully")
    public void iShouldBeLoggedSuccessfully(){
        LoginPage.ClickLoginButton();
    }

    @And("I should see the corect picture and details for each product")
    public void iShouldSeeTheCorectPictureAndDetailsForEachProduct(){
    }


    @When("I enter the {string} and {string}")
    public void iEnterTheAnd(String username, String password){
        LoginPage = new LoginPage(driver);
        LoginPage.EnterUsername(username);
        LoginPage.EnterPassword(password);
    }

    @Then("I should not be logged successfully")
    public void iShouldNotBeLoggedSuccessfully(){

        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
    }

    @And("I should see the {string} message")
    public void iShouldSeeTheMessage(String errorMessage){

        LoginPage.ShowErrorMessage(errorMessage);
    }

    @Then("I shouldn't be able to login")
    public void iShouldnTBeAbleToLogin(){

        LoginPage.ClickLoginButton();
    }

    @Then("I should be able to login but with a longer waiting time")
    public void iShouldBeAbleToLoginButWithALongerWaitingTime(){

        LoginPage.ClickLoginButton();
    }

    @And("I should see the dog picture on each product")
    public void iShouldSeeTheDogPictureOnEachProduct(){

    }


    @And("I'm successfully login")
    public void iMSuccessfullyLogin(){
        LoginPage.ClickLoginButton();
    }

    @Then("I should be logged out successfully")
    public void iShouldBeLoggedOutSuccessfully() throws InterruptedException{
        driver.findElement(By.xpath("/html//a[@id='logout_sidebar_link']")).click();
        //driver.findElement(By.id("logout_sidebar_link")).click();
        //wait(2000);
    }

    @And("I click hamburger button")
    public void iClickHamburgerButton(){
        LoginPage.ClickHamburgerButton();

    }

    @And("I should see the menu and press logout button")
    public void iShouldSeeTheMenuAndPressLogoutButton(){
        LoginPage.ClickLogOutButton();
    }

    @And("I should see the login page again")
    public void iShouldSeeTheLoginPageAgain(){
    }
}

