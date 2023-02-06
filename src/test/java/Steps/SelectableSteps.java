package Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelectableSteps {
    WebDriver driver = new ChromeDriver();

    @Given("The user is on DemoQa {string}")
    public void theUserIsOnDemoQa(String url){
        driver.get(url);
    }

    @When("User open the interactions category")
    public void userOpenTheInteractionsCategory(){
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[5]")).click();
    }

    @And("User click on selectable")
    public void userClickOnSelectable(){
      driver.get("https://demoqa.com/selectable");
    }

    @And("User selects the first and the last label")
    public void userSelectsTheFirstAndTheLastLabel(){
        driver.findElement(By.xpath("//*[@id=\"verticalListContainer\"]/li[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"verticalListContainer\"]/li[4]")).click();
    }

    @And("User click on Grid")
    public void userClickOnGrid(){
        driver.findElement(By.xpath("//*[@id=\"demo-tab-grid\"]")).click();
    }

    @And("User click one five and nine")
    public void userClickOneFiveAndNine(){
        driver.findElement(By.xpath("//*[@id=\"row1\"]/li[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"row2\"]/li[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"row3\"]/li[3]")).click();
    }


}
