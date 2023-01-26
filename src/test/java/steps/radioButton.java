package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class radioButton {
    public WebDriver driver = new ChromeDriver();
   /* @When("User selects Impresive radio button")
    public void userSelectsImpresiveRadioButton(){
        driver.findElement(By.xpath("//div[@id='app']/div[@class='body-height']/div[@class='container playgound-body']/div[@class='row']/div[2]/div[2]/div[3]/label[@class='custom-control-label']")).click();
    }


    @Then("check if label {string} is displayed correctly")
    public void checkIfLabelIsDisplayedCorrectly(String ExpectedLabel){
        WebElement Label = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/p/span"));
        Assert.assertEquals(Label.getText(), ExpectedLabel);
    }

    @And("I should see the add to cart button from every picture")
    public void iShouldSeeTheAddToCartButtonFromEveryPicture(){
    }

    @Then("i should click on every button and each one shoould change their text from add to cart to remove")
    public void iShouldClickOnEveryButtonAndEachOneShoouldChangeTheirTextFromAddToCartToRemove(){
    }

    @And("I add an item to card pressing the button add to cart")
    public void iAddAnItemToCardPressingTheButtonAddToCart(){
    }

    @Then("The item should be added successfully")
    public void theItemShouldBeAddedSuccessfully(){
    }

    @And("I should see the item in my cart and successfully remove it")
    public void iShouldSeeTheItemInMyCartAndSuccessfullyRemoveIt(){
    }*/


}
