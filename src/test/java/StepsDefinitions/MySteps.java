//package StepsDefinitions;
//
//import io.cucumber.java.en.*;
//import org.junit.Assert;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import pages.pageObjects;
//
//// This file runs with pageObjects file. This is Page Object model.
//public class MySteps {
//    WebDriver driver = new ChromeDriver();
//    pageObjects pom;
//
//    @Given("User is on demoqa page")
//    public void userIsOnDemoqaPage() {
//        driver.get("https://demoqa.com/");
//        driver.manage().window().maximize();
//        pom = new pageObjects(driver);
//    }
//
//    @Given("User clicks on Elements button")
//    public void userClicksOnElementsButton() {
//        pom.userClicksOnElementsButton();
////        driver.findElement(By.className("card-up")).click();
//    }
//
//    @When("User clicks on Radio Button")
//    public void userClicksOnRadioButton() {
//        pom.userClicksOnRadioButton();
////        driver.findElement(By.id("item-2")).click();
//    }
//
//    @When("User clicks on Yes option")
//    public void userCLicksOnYesOption() {
//        pom.userCLicksOnYesOption();
////        driver.findElement(By.className("custom-control-label")).click();
//    }
//    @Then("You have selected Yes text appears")
//    public void youHaveSelectedYesTextAppears() {
//        pom.youHaveSelectedYesTextAppears();
////        WebElement text = driver.findElement(By.className("mt-3"));
////        String expectedText = "You have selected Yes";
////        Assert.assertEquals(expectedText, text.getText());
//    }
//
//    @When("User clicks on Check Box")
//    public void userClicksOnCheckBox() {
//        pom.userClicksOnCheckBox();
//    }
//    @When("User clicks on Home Check Box")
//    public void userClicksOnHomeCheckBox() {
//        pom.userClicksOnHomeCheckBox();
//    }
//    @Then("You have selected Home Desktop appears")
//    public void youHaveSelectedHomeDesktopAppears() {
//        pom.youHaveSelectedHomeDesktopAppears();
//    }
//
//}
