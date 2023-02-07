package MyStepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class DemoqaSteps {

    WebDriver driver = new ChromeDriver();
    WebDriverWait wait;
    private Actions actions;



    @And("User clicks on Text Box")
    public void userClicksOnTextBox() {
        driver.findElement(By.xpath("//span[normalize-space()='Text Box']")).click();

    }

    @And("User fills Full Name , Email, Current Address, Permanent Address box")
    public void userFillsFullNameEmailCurrentAddressPermanentAddressBox() {
        WebElement fullName = driver.findElement(By.id("userName"));
        fullName.sendKeys("Anto Moldovan");

        WebElement userEmail = driver.findElement(By.id("userEmail"));
        userEmail.sendKeys("test@gmail.com");

        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        currentAddress.sendKeys("Targu Mures");

        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
        permanentAddress.sendKeys("Marosvasarhely");

    }

    @And("User click Submit button")
    public void userClickSubmitButton() {

        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();

    }
    @Then("Confirmation of introduced datas")
    public void confirmationOfIntroducedDatas() {
        WebElement fullName = driver.findElement(By.id("userName"));
        fullName.sendKeys("Anto Moldovan");
        System.out.println("Full name : "+fullName.getAttribute("value"));

        WebElement userEmail = driver.findElement(By.id("userEmail"));
        userEmail.sendKeys("test@gmail.com");
        System.out.println("Email address :"+ userEmail.getAttribute("value"));

        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        currentAddress.sendKeys("Targu Mures");
        System.out.println("Current address : "+ currentAddress.getAttribute("value"));


        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
        permanentAddress.sendKeys("Marosvasarhely");
        System.out.println("Permanent address : "+ permanentAddress.getAttribute("value"));


    }

    @Given("User is on demoqa page")
    public void userIsOnDemoqaPage() {
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
    }

    @When("User clicks on Elements button")
    public void userClicksOnElementsButton() {
//        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[1]/span/div")).click();
        driver.findElement(By.className("card-up")).click();


    }

    @And("User clicks on Check Box")
    public void userClicksOnCheckBox() {
        WebElement checkbox = driver.findElement(By.xpath("//span[normalize-space()='Check Box']"));
        checkbox.click();
    }

    @And("User clicks on Home")
    public void userClicksOnHome() {
        WebElement home = driver.findElement(By.xpath("//span[contains(@class,'rct-title')]"));
        home.click();
    }

    @Then("You have selected home desktop notes commands appears")
    public void youHaveSelectedHomeDesktopNotesCommandsAppears() throws InterruptedException {
//        WebElement home = driver.findElement(By.xpath("//span[contains(@class,'rct-title')]"));
//        home.click();
//        Thread.sleep(5000);
//        System.out.println(home.getText());


//        WebElement homedesktopnotescommandsappears = null;
//        WebElement text = homedesktopnotescommandsappears;
//        String message = "You have selected "
//        Assert.assertEquals(message, text.getText());

    }

    @And("User clicks on Radio Button")
    public void userClicksOnRadioButton() {
        WebElement radiobutton = driver.findElement(By.id("item-2"));
        radiobutton.click();
    }

    @And("User clicks on Yes")
    public void userClicksOnYes() {
        driver.findElement(By.className("custom-control-label")).click();
    }

    @Then("You have selected Yes")
    public void youHaveSelectedYes() {
        WebElement text = driver.findElement(By.className("mt-3"));
        String expectedText = "You have selected Yes";
        Assert.assertEquals(expectedText, text.getText());
    }



    @When("User selects impressive radio button")
    public void userSelectsImpressiveRadioButton() throws InterruptedException {
        driver.findElement(By.xpath("//label[normalize-space()='Impressive']")).click();
        Thread.sleep(2000);
    }

    @Then("check label is displayed correctly")
    public void checkLabelIsDisplayedCorrectly() {

        WebElement element = driver.findElement(By.className("text-success"));
        element.click();

        String strng = element.getText();
        System.out.println("strng");

        Assert.assertEquals("Impressive", strng);


    }



    @And("User clicks on Buttons")
    public void userClicksOnButtonsButton() {
        WebElement buttons = driver.findElement(By.id("item-4"));

    }


    @Then("User clicks on Click me button")
    public void userClicksOnClickMeButton() throws InterruptedException {

//      driver.findElement(By.xpath("(//button[normalize-space()='Click Me'])[1]")).click();
        WebElement buttons = driver.findElement(By.id("item-4"));

        Actions actions = new Actions(driver);
        new Actions(driver).click(buttons).perform();
        actions.moveToElement(buttons);
        actions.perform();

        buttons.click();


//        WebElement dynamicClickTextAppears = null;
//        WebElement text = dynamicClickTextAppears;
//            String expectedText = "You have done a dynamic click";
//            Assert.assertEquals(expectedText, text.getText());

        }

    @Given("User is on demoqa page browser windows")
    public void userIsOnDemoqaPageBrowserWindows() {
        driver.get("https://demoqa.com/browser-windows");
    }

    @When("User clicks on New Window Message")
    public void userClicksOnNewWindowMessage() {
        driver.findElement(By.id("messageWindowButton")).click();
        driver.findElement(By.id("messageWindowButton")).click();

        String MainWindow = driver.getWindowHandle();
        System.out.println("Main window handle is " + MainWindow);

    }

    @Then("User is on New Window")
    public void userIsOnNewWindow() {
        Set<String> s1 = driver.getWindowHandles();
        System.out.println("Child window handle is" + s1);
        Iterator<String> i1 = s1.iterator();


    }


    @Given("User is on demoqa page Alerts, Frame & Window")
    public void userIsOnDemoqaPageAlertsFrameWindow() {
        driver.get("https://demoqa.com/alerts");
        driver.manage().window().maximize();

    }

    @When("User clicks Alerts")
    public void userClicksAlerts() {

    }

    @Then("User clicks Button to see alert")
    public void userClicksButtonToSeeAlert() throws InterruptedException {
         WebElement element = driver.findElement(By.id("alertButton"));

        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);


    }

    @Then("Confirmation alert box opens")
    public Alert confirmationAlertBoxOpens() throws InterruptedException {

        wait.until(ExpectedConditions.alertIsPresent());
        Alert simpleAlert = driver.switchTo().alert();
        simpleAlert.accept();
        Assert.assertTrue(simpleAlert.getText().contains("You clicked a button"));
        return simpleAlert;

////
// Alert promptAlert  = driver.switchTo().alert();
////        String alertText = promptAlert.getText();
//        System.out.println("Alert text is " + alertText);
//
//        promptAlert.sendKeys("Test User");
//        promptAlert.accept();
//        return alertText;

//        Assert.assertTrue(element.alertconfirmationAlertBoxOpens().contains("You clicked a button"));

    }


    @Given("User is on demoqa page Interactions and Droppable element")
    public void userIsOnDemoqaPageInteractionsAndDroppableElement() {

        driver.get("https://demoqa.com/droppable/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

    }





    @And("User clicks on Simple drag box into drop box")
    public String userClicksOnSimpleDragBoxIntoDropBox() {


        WebElement simpleDroppable =  driver.findElement(By.id("droppableExample-tab-simple"));
        simpleDroppable.click();


        WebElement dragBox = driver.findElement(By.id("draggable"));


        WebElement droppBox = driver.findElement(By.id("droppable"));



        Actions action = new Actions(driver);
        action.dragAndDrop(dragBox, droppBox).build().perform();


        return droppBox.getText();

    }

    @Then("User Dropped")
    public String userDropped() {


            WebElement droppBox = driver.findElement(By.id("droppable"));
            return droppBox.getText();

//        if(droppBox.equals("Dropped!")) {
//            System.out.println("PASS: Source is dropped to target as expected");
//        }else {
//            System.out.println("FAIL: Source couldn't be dropped to target as expected");
//        }

//        driver.close();
        //        Assert.assertEquals(droppBox.userDroppedIsDisplayed(),message);

        }

    @Given("User is on demoqa Bookstore")
    public void userIsOnDemoqaBookstore() {
        driver.get("https://demoqa.com/login");
        driver.manage().window().maximize();
        String title = driver.getTitle();
        System.out.println("The page title is : " +title);
    }

    @When("User enters credentials")
    public void userEntersCredentials() {
        WebElement uName = driver.findElement(By.xpath("//*[@id='userName']"));
        uName.sendKeys("testuser");

        WebElement pswd = driver.findElement(By.xpath("//*[@id='password']"));
        pswd.sendKeys("Password@123");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    @And("User clicks submit button")
    public void userClicksSubmitButton() {
        WebElement loginBtn = driver.findElement(By.xpath("//*[@id='login']"));
        loginBtn.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Then("Error message is displayed")
    public void errorMessageIsDisplayed() {
        try {

            WebElement logoutBtn = driver.findElement(By.xpath("//div[@class='text-right col-md-5 col-sm-12']//button[@id='submit']"));

            if(logoutBtn.isDisplayed()){

                logoutBtn.click();
                System.out.println("LogOut Successful!");
            }
        }
        catch (Exception e) {
            System.out.println("Invalid username or password");
        }

      driver.quit();

//        WebElement errorMessage = driver.findElement(By.className("mb-1"));
//        Assert.assertEquals(errorMessage.getText(), "Invalid username or password.");
    }

    @And("User clicks on Upload and Download")
    public void userClicksOnUploadAndDownload() {

        driver.findElement(By.xpath("//span[normalize-space()='Upload and Download']")).click();

    }

    @And("User selects Download")
    public void userSelectsDownload() {
        WebElement download = driver.findElement(By.id("downloadButton"));
        download.click();


    }

    @Then("User downloaded sample File")
    public void userDownloadedSampleFile() {

        System.out.println("sampleFile" );
    }


    @Then("User selects Choose File")
    public void userSelectsChooseFile() {
        WebElement choosefile = driver.findElement(By.xpath("//input[@id='uploadFile']"));
//        upload.sendKeys(C:\Users\Anto\Desktop\Me.txt");
//        choosefile.click();
       choosefile.sendKeys();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

//        System.out.println("Message is :" );

    }


}





