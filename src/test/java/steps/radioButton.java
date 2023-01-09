package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class radioButton {
    public WebDriver driver = new ChromeDriver();

    @Given("On demo site")
    public void onDemoSite(){
        driver.get("https://demoqa.com/radio-button");
    }

    @When("User selects Impresive radio button")
    public void userSelectsImpresiveRadioButton(){
        driver.findElement(By.xpath("//div[@id='app']/div[@class='body-height']/div[@class='container playgound-body']/div[@class='row']/div[2]/div[2]/div[3]/label[@class='custom-control-label']")).click();
    }


    @Then("check if label {string} is displayed correctly")
    public void checkIfLabelIsDisplayedCorrectly(String ExpectedLabel){
        WebElement Label = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/p/span"));
        Assert.assertEquals(Label.getText(), ExpectedLabel);
    }
}
