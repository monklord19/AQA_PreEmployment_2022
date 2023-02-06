package Steps;

import Pages.BookStoreApplication;
import Pages.Buttons;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BookStoreApplicationSteps {
    WebDriver driver = new ChromeDriver();
    BookStoreApplication bookStoreApplication = new BookStoreApplication(driver);

    @Given("The user open DemoQa website {string}")
    public void theUserOpenDemaQaWebsite(String url){
        driver.get(url);
    }

    @When("User open BookStoreApplication")
    public void userOpenBookStoreApplication(){
        bookStoreApplication.clickBookStoreApplication();
    }

    @And("User type a book")
    public void userTypeABook(){
        bookStoreApplication.typeBook();
    }

    @Then("Check the book by author")
    public void checkTheBookByAuthor(){
        bookStoreApplication.checkBookByAuthor();
    }
}
