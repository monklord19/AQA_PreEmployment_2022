package StepDefinitions;

import Base.BaseClass;
import io.cucumber.java.cy_gb.A;
import io.cucumber.java.en.*;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import javax.swing.text.TabableView;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class DemoQaStepDefinitions{

    WebDriver driver = new ChromeDriver();

    @Given("User is on DemoQA page")
    public void user_is_on_demo_qa_page() {
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @When("User clicks on Elements button")
    public void userClicksOnElementsButton() {
        driver.findElement(By.className("card-up")).click();
    }
    @And("User clicks on Check Box")
    public void user_clicks_on_check_box() {
        WebElement checkBox = driver.findElement(By.id("item-1"));
        checkBox.click();
    }
    @And("User check the home box")
    public void user_check_the_home_box() {
        WebElement homeBox = driver.findElement(By.xpath("//span[contains(@class,'rct-title')]"));
        homeBox.click();
    }
    @Then("Text will be shown")
    public void text_will_be_shown()  throws InterruptedException{
        WebElement yesText = driver.findElement(By.id("result"));
        Assert.assertEquals(yesText.getText(), "You have selected :\n" +
                "home\n" +
                "desktop\n" +
                "notes\n" +
                "commands\n" +
                "documents\n" +
                "workspace\n" +
                "react\n" +
                "angular\n" +
                "veu\n" +
                "office\n" +
                "public\n" +
                "private\n" +
                "classified\n" +
                "general\n" +
                "downloads\n" +
                "wordFile\n" +
                "excelFile");

        //Thread.sleep(2000);
        //driver.close();
    }

    @Given("User is on DemoQA elements page")
    public void user_is_on_demo_qa_elements_page() {
        driver.get("https://demoqa.com/elements");
        driver.manage().window().maximize();
    }

    @When("User clicks on Text Box button")
    public void user_clicks_on_text_box_button() {
        WebElement textBoxButton = driver.findElement(By.id("item-0"));
        textBoxButton.click();
    }

    @And("User enters Name, Email, Current Address & Permanent Address")
    public void user_enters_name_email_current_address_permanent_address() {
        WebElement name = driver.findElement(By.id("userName"));
        WebElement email = driver.findElement(By.id("userEmail"));
        WebElement cAddress = driver.findElement(By.id("currentAddress"));
        WebElement pAddress = driver.findElement(By.id("permanentAddress"));

        name.sendKeys("Moldovan Adelin");
        email.sendKeys("moldovanadelin111@gmail.com");
        cAddress.sendKeys("Calea-Turzii, Cluj-Napoca, Cluj");
        pAddress.sendKeys("Principala, Bistrita, Bistrita-Nasaud");
    }

    @And("User clicks on Submit")
    public void user_clicks_on_submit() {
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();
    }

    @Then("The data will appear below")
    public void the_data_will_appear_below() {

        WebElement name = driver.findElement(By.id("userName"));
        WebElement email = driver.findElement(By.id("userEmail"));
        WebElement cAddress = driver.findElement(By.id("currentAddress"));
        WebElement pAddress = driver.findElement(By.id("permanentAddress"));

        System.out.println("Name:" + name);
        System.out.println("Email:" + email);
        System.out.println("Current Address:" + cAddress);
        System.out.println("Permanent Address:" + pAddress);

    }


    @When("User clicks on Radio Button")
    public void userClicksOnRadioButton() {
        WebElement radioButton = driver.findElement(By.id("item-2"));
        radioButton.click();
    }

    @And("User clicks on Yes")
    public void userClicksOnYes() {
        WebElement yesTick = driver.findElement(By.className("custom-control-label"));
        yesTick.click();
    }

    @Then("Text You have selected Yes will appear")
    public void textYouHaveSelectedYesWillAppear() {
        WebElement yesText = driver.findElement(By.className("mt-3"));
        Assert.assertEquals(yesText.getText(), "You have selected Yes");
    }

    @When("User clicks on Buttons button")
    public void userClicksOnButtonsButton() {
        WebElement buttonsButton = driver.findElement(By.id("item-4"));
        buttonsButton.click();
    }

    @And("User clicks on Right Click Me button")
    public void userClicksOnRightClickMeButton() {
        Actions actions = new Actions(driver);
        WebElement rightClickMeButton = driver.findElement(By.id("rightClickBtn"));

        actions.contextClick(rightClickMeButton).perform();
        //System.out.println("Button is right clicked");
    }

    @Then("Text You have done a right click will appear")
    public void textYouHaveDoneARightClickWillAppear() {
        WebElement yesText = driver.findElement(By.id("rightClickMessage"));
        Assert.assertEquals(yesText.getText(), "You have done a right click");

    }

    @And("User clicks on Double Click Me button")
    public void userClicksOnDoubleClickMeButton() {
        Actions actions = new Actions(driver);
        WebElement doubleClickMeButton = driver.findElement(By.id("doubleClickBtn"));

        actions.doubleClick(doubleClickMeButton).perform();
        //System.out.println("Button is double clicked");
    }

    @Then("Text You have done a double click will appear")
    public void textYouHaveDoneADoubleClickWillAppear() {
        WebElement yesText = driver.findElement(By.id("doubleClickMessage"));
        Assert.assertEquals(yesText.getText(), "You have done a double click");

    }

    @Given("User is on DemoQA browser windows page")
    public void userIsOnDemoQABrowserWindowsPage() {
        driver.get("https://demoqa.com/browser-windows");
        driver.manage().window().maximize();
    }

    @When("User click on New Tab Button")
    public void userClickOnNewTabButton() {
        WebElement newTabButton = driver.findElement(By.id("tabButton"));
        newTabButton.click();
    }

    @Then("A sample page will open on new tab")
    public void aSamplePageWillOpenOnNewTab() {
        driver.navigate().to("https://demoqa.com/sample");

        WebElement sampleText = driver.findElement(By.id("sampleHeading"));
        Assert.assertEquals(sampleText.getText(), "This is a sample page");

    }

    @Given("User is on DemoQA alerts")
    public void userIsOnDemoQAAlerts() {
        driver.get("https://demoqa.com/alerts");
        driver.manage().window().maximize();
    }

    @When("User clicks on button to open a new alert")
    public void userClicksOnButtonToOpenANewAlert() {
        WebElement alertButton = driver.findElement(By.id("alertButton"));
        alertButton.click();
    }

    @Then("Alert will appear at the top of the page")
    public void alertWillAppearAtTheTopOfThePage() {
        driver.switchTo().alert().accept();
    }

    @When("User clicks on button to open a new alert with a prompt")
    public void userClicksOnButtonToOpenANewAlertWithAPrompt() {
        WebElement alertButton = driver.findElement(By.id("promtButton"));
        alertButton.click();
    }

    @And("User enter some text on alert")
    public void userEnterSomeTextOnAlert() throws InterruptedException{
        Alert alertonpage = driver.switchTo().alert();
        Thread.sleep(2000);
        alertonpage.sendKeys("some text");
        alertonpage.accept();

    }

    @Then("Alert will close")
    public void alertWillClose() {
        //driver.switchTo().alert().dismiss();
    }

    @And("Text You entered will appear on the alerts page")
    public void textYouEnteredWillAppearOnTheAlertsPage() {
        WebElement sampleText = driver.findElement(By.id("promptResult"));
        Assert.assertEquals(sampleText.getText(), "You entered some text");

    }

    @When("User clicks on button to open a new alert with confirm box")
    public void userClicksOnButtonToOpenANewAlertWithConfirmBox() {
        WebElement confirmButton = driver.findElement(By.id("confirmButton"));
        confirmButton.click();

    }

    @And("User accept the alert")
    public void userAcceptTheAlert() throws InterruptedException{
        Alert alertonpage = driver.switchTo().alert();
        Thread.sleep(2000);
        alertonpage.accept();
    }

    @Then("Text You selected Ok will appear on page")
    public void textYouSelectedOkWillAppearOnPage() {
        WebElement sampleText = driver.findElement(By.id("confirmResult"));
        Assert.assertEquals(sampleText.getText(), "You selected Ok");
    }


    @Given("User is on DemoQA Widgets slider")
    public void userIsOnDemoQAWidgetsSlider() {
        driver.get("https://demoqa.com/slider");
        driver.manage().window().maximize();
    }

    @When("User will hold click and drag the blue circle")
    public void userWillHoldClickAndDragTheBlueCircle() throws InterruptedException{
        WebElement slider = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/form/div/div[1]/span/input"));

        Actions actions = new Actions(driver);
        Thread.sleep(3000);
        actions.clickAndHold(slider).moveByOffset(830, 250).release().perform();

        /*WebElement slider = driver.findElement(By.cssSelector(".range-slider.range-slider--primary"));
        Actions actions = new Actions(driver);

        actions.clickAndHold(slider).build().perform();
        actions.dragAndDropBy(slider, 2, 0).build().perform();*/
    }

    @Then("The value will increment or decrement")
    public void theValueWillIncrementOrDecrement() {

        //WebElement sampleText = driver.findElement(By.className("form-control"));
        WebElement sampleText = driver.findElement(By.xpath("//*[@id=\"sliderValue\"]"));
        Assert.assertEquals(sampleText.getText(), "100");

    }

    @Given("User is on Login")
    public void userIsOnLogin() {
        driver.get("https://demoqa.com/login");
        driver.manage().window().maximize();
    }

    @When("User enters credentials")
    public void userEntersCredentials() {
        WebElement name = driver.findElement(By.id("userName"));
        WebElement password = driver.findElement(By.id("password"));

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        name.sendKeys("adelin");
        password.sendKeys("moldovan");
    }

    @And("User clicks on Login button")
    public void userClicksOnLoginButton() {
        WebElement loginButton = driver.findElement(By.id("login"));
        loginButton.click();
    }

    @Then("Invalid username or password message will appear")
    public void invalidUsernameOrPasswordMessageWillAppear() {
        WebElement sampleText = driver.findElement(By.id("name"));
        Assert.assertEquals(sampleText.getText(), "Invalid username or password!");

    }

    @Given("User is on Droppable")
    public void userIsOnDroppable() {
        driver.get("https://demoqa.com/droppable");
        driver.manage().window().maximize();
    }

    @When("User drag and drop the Drag me box into Drop here box")
    public void userDragAndDropTheDragMeBoxIntoDropHereBox() {
        WebElement drag = driver.findElement(By.id("draggable"));
        WebElement drop = driver.findElement(By.id("droppable"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(drag, drop).perform();

    }

    @Then("User will be dropped")
    public void userWillBeDropped() {
        WebElement droppBoxText = driver.findElement(By.id("droppable"));
        Assert.assertEquals(droppBoxText.getText(), "Dropped!");
    }

    @Given("User is on sortable")
    public void userIsOnSortable() throws InterruptedException{
        driver.get("https://demoqa.com/sortable");
        driver.manage().window().maximize();
    }

    @When("User drag and drop the sorted list")
    public void userDragAndDropTheSortedList() throws InterruptedException {
        Thread.sleep(5000);
        WebElement draggable = driver.findElement(By.xpath("//*[@id=\"demo-tabpane-list\"]/div/div[1]"));
        WebElement droppable = driver.findElement(By.xpath("//*[@id=\"demo-tabpane-list\"]/div/div[2]"));

        WebElement draggable2 = driver.findElement(By.xpath("//*[@id=\"demo-tabpane-list\"]/div/div[4]"));
        WebElement droppable2 = driver.findElement(By.xpath("//*[@id=\"demo-tabpane-list\"]/div/div[6]"));


        Actions actions = new Actions(driver);
        actions.dragAndDrop(draggable, droppable).build().perform();

        actions.dragAndDrop(draggable2, droppable2).build().perform();

    }

    @Then("User will change the order of the list")
    public void userWillChangeTheOrderOfTheList() {
    }
}
