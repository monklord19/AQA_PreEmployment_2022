package UITests.steps;


import UITests.pageObjects.loginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class MyStepdefs1 {
    WebDriver driver = new ChromeDriver();
    loginPage loginpage;

    @Given("On sauce website")
    public void onSauceWebsite() {

        driver.get("https://www.saucedemo.com/");
    }

    //valid credentials
    @When("User enters valid credentials")
    public void userEntersValidCredentials() {
        loginpage = new loginPage(driver);
        loginpage.enterUser("standard_user");
        loginpage.enterPass("secret_sauce");
        loginpage.clickLoginButton();
    }

    @Then("User should be logged in")
    public void userShouldBeLoggedIn() {
        driver.findElement(By.id("logout_sidebar_link")).isDisplayed();
    }

    //invalid username and valid password
    @When("user logging in using {string} and password as {string}")
    public void userLoggingInUsingAndPasswordAs(String arg0, String arg1) {
        loginpage = new loginPage(driver);
        loginpage.enterUser("random_user");
        loginpage.enterPass("secret_sauce");
        loginpage.clickLoginButton();
    }

    @Then("error message displayed {string}")
    public void errorMessageDisplayed(String arg0) {
       loginpage.WrongUserValidPass("Epic sadface: Username and password do not match any user in this service");
    }


    //title verify (challenge)
    @When("user opens website")
    public void userOpensWebsite() {

    }

    @Then("display title {string}")
    public void displayTitle(String arg0) {
        // declare and initialize the variable to store the expected title of the webpage.
        String expectedTitle = "Swag Labs";

        // fetch the title of the web page and save it into a string variable
        String actualTitle = driver.getTitle();

        // compare the expected title of the page with the actual title of the page and print the result
        if (expectedTitle.equals(actualTitle))
        {
            System.out.println("Verification Successful - The correct title is displayed on the web page.");
        }
        else
        {
            System.out.println("Verification Failed - An incorrect title is displayed on the web page.");
        }
    }
}

