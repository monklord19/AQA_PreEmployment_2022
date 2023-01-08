//package StepsDefinitions;
//
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import org.junit.Assert;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//public class MyStepdefs1 {
//    WebDriver driver = new ChromeDriver();
//    @Given("On sauce website")
//    public void onSauceWebsite() {
//
//        driver.get("https://www.saucedemo.com/");
//    }
//
//    @When("User enters valid credentials")
//    public void userEntersValidCredentials() {
//    }
//
//    @Then("User should be logged in")
//    public void userShouldBeLoggedIn() {
//    }
//    @Given("On demo site")
//    public void onDemoSite() {
//        String test_url = "https://demoqa.com/radio-button";
//
//        WebDriver driver = null;
//        driver.manage().window().maximize();
//        driver.get(test_url);
//    }
//
//    @When("User selects Impresive radio button")
//    public void userSelectsImpresiveRadioButton() {
//        driver.findElement(By.id("impressiveRadio")).click();
//
//    }
//
//    @Then("check labe is displayed correctly")
//    public void checkLabeIsDisplayedCorrectly() {
//        WebElement element = driver.findElement(By.className("text-success"));
//        String strng = element.getText();
//        System.out.println(strng);
//        Assert.assertEquals("Impressive", strng);
//    }
//
//
//
//}
