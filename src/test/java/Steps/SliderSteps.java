package Steps;

import Pages.ModalDialogs;
import Pages.Slider;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SliderSteps {
    WebDriver driver = new ChromeDriver();
    Slider slider = new Slider(driver);

    @Given("User access DemoQa {string}")
    public void userAccessDemoQa(String url){
        driver.get(url);
    }

    @When("User open the Widgets category")
    public void userOpenTheWidgetsCategory(){
        slider.clickWidgets();
    }

    @And("User scrolling the page until Slider is visible")
    public void userScrollingThePageUntilSliderIsVisible(){
        slider.scroolingThePageDown();
    }


    @Then("User click on the slider subcategory")
    public void userOpenTheSliderSubcategory(){
        slider.clickSlider();
    }

    @And("User move the slider to the right")
    public void userMoveTheSliderToTheRight() throws InterruptedException {
        slider.slideToRight();
    }
}
