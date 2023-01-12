package steps;

import demoPageObjects.DemoMainPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class DemoSteps {
    WebDriver driver = new ChromeDriver();

    DemoMainPage demoMainPage = new DemoMainPage(driver);

    @Given("user is on demo main page")
    public void onDemoMainPage() {
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");
    }

//    @When("user clicks {string} button")
//    public void userClicksOnElementButton(String elementName) {
//        demoMainPage.clickElementButton(elementName);
//    }
}
