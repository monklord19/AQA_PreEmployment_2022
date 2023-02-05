package PageFactory;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import static PageFactory.ConfigReader.*;

public class DemoQPage {
    private final WebDriverWait wait;
    WebDriver driver;

    //Locators for Text Box

    private final By txt_Username = By.id("userName");
    private final By txt_Useremail = By.id("userEmail");
    private final By txt_CurrentAdress=By.id("currentAddress") ;
    private final By txt_PermAdress = By.id("permanentAddress");
    private final By btn_Submit = By.id("submit");
    private final By path_Elements=By.xpath("//*[@id='app']/div/div/div[2]/div/div[1]");
    private final By path_ElementsMenu=By.xpath("//*[@id='app']/div/div/div[2]/div[1]/div/div/div[1]/span");
    private final By path_TextBox=By.xpath("//*[@id='item-0']");

    //Locators for Buttons
    private final By btn_DoubleClick=By.id("doubleClickBtn");
    private final By btn_RightClick=By.id("rightClickBtn");
    private final By btn_DinamicClick=By.cssSelector("div:nth-of-type(3)>.btn.btn-primary");
    private final By msg_DoubleClick=By.xpath("//*[@id='doubleClickMessage']");
    private final By msg_RightClick=By.xpath("//*[@id='rightClickMessage']");
    private final By msg_DinamicClick=By.xpath("//*[@id='dynamicClickMessage']");
    private final By path_ButtonsMenu=By.xpath("//*[text() = 'Buttons']");

    //Locators for CheckBox
    private final By path_CheckBox=By.xpath("//*[@id='item-1']");
    private final By btn_PlusSeeMore=By.cssSelector("#tree-node>div>button.rct-option.rct-option-expand-all>svg");
    private final By btn_CheckBoxSelected=By.cssSelector("#tree-node>ol>li>ol>li:nth-child(2)>ol>li:nth-child(2)>ol>li:nth-child(3)>span>label>span.rct-checkbox>svg");

    //Locatators for Menu
    private final By box_OldMenu=By.id("oldSelectMenu");
    private final By box_CarMenu=By.xpath("//*[@id='cars']");
    private final By path_Widgets=By.xpath("//*[@id='app']/div/div/div[2]/div/div[4]");
    private final By path_SelectMenu=By.xpath("//*[contains(text(),'Select Menu')]");
    //private final By path_WidgetsMenu=By.xpath("//*[@id='app']/div/div/div[2]/div[1]/div/div/div[4]/span/div");

    //Locators for Download and Upload
    private final By btn_Downloadfile=By.id("downloadButton");
    private final By btn_Uploadfile=By.id("uploadFile");
    private final By txt_UpoadedFilePath=By.id("uploadedFilePath");
    private final By path_UploadMenu=By.xpath("//*[text() = 'Upload and Download']");

    //Locators for Radio Buttons
    private final By path_RadioButtonMenu=By.xpath("//*[text() = 'Radio Button']");
    private final By btn_RadioImpressive=By.xpath("//*[@for='impressiveRadio']");
    private final By msg_RadioImpressive=By.className("text-success");

    //Locators for Progress bar
    private final By path_ProgressBarMenu=By.xpath("//*[text() = 'Progress Bar']");
    private final By btn_StartProgressBar=By.id("startStopButton");
    private final By btn_progressBar=By.xpath("//*[@id='progressBar']");
    private final By btn_resetProgressBar=By.id("resetButton");

    //Locators for Slider
    private final By path_SliderMenu=By.xpath("//*[text() = 'Slider']");
    private final By txt_SliderContainer=By.xpath("//*[@id='sliderContainer']/div[1]/span/input");
    private final By txt_sliderValue=By.id("sliderValue");

    //Locators for Accordian Page
    private final By path_AccordianMenu=By.xpath("//*[text() = 'Accordian']");
    private final By txt_Section1Heading=By.id("section1Heading");
    private final By txt_Section2Heading=By.id("section2Heading");
    private final By txt_Section3Heading=By.id("section3Heading");
    private final By txt_Section1content=By.id("section1Content");
    private final By txt_Section2content=By.id("section2Content");
    private final By txt_Section3content=By.id("section3Content");
    //Locators for Alerts Page
    private final By path_AlertsFrameand=By.xpath("//*[@id='app']/div/div/div[2]/div/div[3]");
    private final By path_AlertsMenu =By.xpath("//*[text() = 'Alerts']");
    private final By btn_AlertButton=By.id("alertButton");
    private final By btn_TimerAlertbutton=By.id("timerAlertButton");
    private final By btn_ConfirmationAlertButton=By.id("confirmButton");
    private final By btn_PromtAlertButton=By.id("promtButton");
    private final By msg_Confirmationmessage=By.xpath("//*[@id='confirmResult']");
    private final By msg_PromptResult=By.id("promptResult");

    public DemoQPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void goToElementsMenu(){
        var element = driver.findElement(path_Elements);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
        driver.findElement(path_ElementsMenu).click();

    }
    public void goToAlertsFrameMenu(){
        var element = driver.findElement(path_AlertsFrameand);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();


    }
    public void goToAlertsMenu(){
        var element = driver.findElement(path_AlertsMenu);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
        driver.findElement(path_AlertsMenu).click();

    }
    public void goToWidgetsMenu(){
        var element = driver.findElement(path_Widgets);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();

    }
    public void goToSliderMenu(){
        var element = driver.findElement(path_SliderMenu);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();}
    public void goToSelectMenu(){
        var element = driver.findElement(path_SelectMenu);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();

    }
    public void goToButtonsMenu(){
        var element = driver.findElement(path_ButtonsMenu);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();

    }
    public void goToUploadMenu(){
        var element = driver.findElement(path_UploadMenu);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();

    }
    public void goToRadioButtonsMenu(){
        var element = driver.findElement(path_RadioButtonMenu);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();

    }


    public void goToTextBoxPage(){

        driver.findElement(path_TextBox).click();
    }
    public void goToCheckBoxPage(){

        driver.findElement(path_CheckBox).click();
    }
    public void goToProgressBarMenu(){
        var element = driver.findElement(path_ProgressBarMenu);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();

    }

    public void goToAccordianMenu(){
        var element = driver.findElement(path_AccordianMenu);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();

    }
    public void enterUserName(String username) {
        driver.findElement(txt_Username).sendKeys(username);
    }
    public void enterEmail(String email) {
        driver.findElement(txt_Useremail).sendKeys(email);
    }
    public void enterCurrentAdress(String current_adress) {
        driver.findElement(txt_CurrentAdress).sendKeys(current_adress);
    }
    public void enterPermanentAdress(String perm_adress) {
        driver.findElement(txt_PermAdress).sendKeys(perm_adress);
    }
    public void clickSubmit() {
        WebElement element = driver.findElement(btn_Submit);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        driver.findElement(btn_Submit).click();
    }

    public void verifyCorrectForm() throws IOException {
        String name =driver.findElement(By.xpath("//*[@id='name']")).getText();
        String email =driver.findElement(By.xpath("//*[@id='email']")).getText();
        String currentAdress =driver.findElement(By.xpath("//p[@id='currentAddress']")).getText();
        String permanentAdress =driver.findElement(By.xpath("//p[@id='permanentAddress']")).getText();
        Assert.assertEquals(name,"Name:"+getUsername());
        Assert.assertEquals(email,"Email:"+getEmail());
        Assert.assertEquals(currentAdress,"Current Address :"+getCurrentAdress());
        Assert.assertEquals(permanentAdress,"Permananet Address :"+getPermanentAdress());
    }
    public void performClickButtons(){
        //double click
        Actions actions = new Actions(driver);
        WebElement btndoubleclick = driver.findElement(btn_DoubleClick);
        actions.doubleClick(btndoubleclick).perform();

        //right click
        WebElement btnrightclick = driver.findElement(btn_RightClick);
        actions.contextClick(btnrightclick).perform();

        //dinamic click
        WebElement elem = driver.findElement(btn_DinamicClick);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", elem);
        elem.click();
    }
    public void verifyMessagesforButtons(){
        Assert.assertTrue(driver.findElement(msg_DoubleClick).isDisplayed());
        Assert.assertTrue(driver.findElement(msg_RightClick).isDisplayed());
        Assert.assertTrue(driver.findElement(msg_DinamicClick).isDisplayed());
    }
    public void clickPlusToSeeMore(){
        driver.findElement(btn_PlusSeeMore).click();
    }
    public void selectClassifiedCheckBox() throws InterruptedException {
        WebElement element = driver.findElement(btn_CheckBoxSelected);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(500);
        WebElement checkBoxSelected = driver.findElement(btn_CheckBoxSelected);
        boolean isSelected = checkBoxSelected.isSelected();

        // performing click operation if element is not selected
        if(isSelected == false) {
            checkBoxSelected.click();
        }
    }
    public void SelectMyOptionsInMenu(){
        //Old menu
        WebElement element = driver.findElement(box_OldMenu);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Select select = new Select(driver.findElement(box_OldMenu));

        List<WebElement> list = select.getOptions();

        System.out.println("Select the Option by Index 4");
        select.selectByIndex(4);

        //Car menu
        Select carSelected = new Select(driver.findElement(box_CarMenu));
        carSelected.selectByVisibleText("Volvo");
    }
    public void verifyMyOptionsInMenu(){
        Select select = new Select(driver.findElement(box_OldMenu));
        String color= select.getFirstSelectedOption().getText();
        Assert.assertEquals("Purple", color);

        Select selectcar = new Select(driver.findElement(box_CarMenu));
        String carstring= selectcar.getFirstSelectedOption().getText();
        Assert.assertEquals("Volvo", carstring);
    }
    public void clickDownloadFile(){
        driver.findElement(btn_Downloadfile).click();
    }
    public void clickUploadFile(){
        WebElement addFile = driver.findElement(btn_Uploadfile);
        addFile.sendKeys("C://Users//user//IdeaProjects//AQA_PreEmployment//src//test//resources//testFiles//AndreeaC.jpg");

    }

    public void verifyUploadedandDownloadedSuccessfull(){
        Assert.assertTrue(driver.findElement(txt_UpoadedFilePath).isDisplayed());
        String fakepath = driver.findElement(txt_UpoadedFilePath).getText();
        Assert.assertTrue(fakepath.contains("AndreeaC"));

        //verify downloaded file succesfull
        driver.get("chrome://downloads/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = (WebElement) js
                .executeScript("return document.querySelector('downloads-manager').shadowRoot.querySelector('#mainContainer > iron-list > downloads-item').shadowRoot.querySelector('#content')");
        String latestFileName=  element.getText();
        System.out.println(latestFileName);
        Assert.assertTrue(latestFileName.contains("sampleFile"));
    }
    public void clickRadioButton(){
        driver.findElement(btn_RadioImpressive).click();
    }
    public void verifyRadioButtonMessage(){
        String radioMessage = driver.findElement(msg_RadioImpressive).getText();
        Assert.assertTrue(radioMessage.equals("Impressive"));

    }
    public void clickStartProgressBar(){
        driver.findElement(btn_StartProgressBar).click();
    }
    public void waitForProgressBar(){
        WebElement progressBar=driver.findElement(btn_progressBar);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", progressBar);
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
         wait.until(ExpectedConditions.presenceOfElementLocated(btn_resetProgressBar));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", progressBar);

    }
    public void resetProgressBar(){
        driver.findElement(btn_resetProgressBar).click();
    }

    public void moveSliderToEnd() throws InterruptedException {
        WebElement slider = driver.findElement(txt_SliderContainer);
        Thread.sleep(2000);
        Actions action=new Actions(driver);
        action.dragAndDropBy(slider,300,0).perform();
    }
    public void checkSliderValue(){
        String Sliderend=driver.findElement(txt_sliderValue).getAttribute("value");
        Assert.assertEquals(Sliderend,"100");
    }
    public void clickOnSection1Heading(){
        driver.findElement(txt_Section1Heading).click();
    }
    public void checkSection1ContentisDisplayed(){
        var section1content =driver.findElement(txt_Section1content);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", section1content);
        Assert.assertTrue(section1content.isDisplayed());
    }
    public void clickOnSection2Heading(){
        driver.findElement(txt_Section2Heading).click();
    }
    public void checkSection2ContentisDisplayed() throws InterruptedException {
        var section2content =driver.findElement(txt_Section2content);

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", section2content);
        Thread.sleep(300);
        Assert.assertTrue(section2content.isDisplayed());
    }
    public void clickOnSection3Heading(){
        var section3heaading=driver.findElement(txt_Section3Heading);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", section3heaading);
        section3heaading.click();
    }
    public void checkSection3ContentisDisplayed(){
        var section3content =driver.findElement(txt_Section3content);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", section3content);
        Assert.assertTrue(section3content.isDisplayed());
    }
    public void clickonAlertButton(){
        driver.findElement(btn_AlertButton).click();
    }
    public void IacceptAllert(){
        Alert simpleAlert = driver.switchTo().alert();
        simpleAlert.accept();
    }
    public void clickonTimerAlertButtonandWait(){
        driver.findElement(btn_TimerAlertbutton).click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
    }
    public void clickConfirmButton(){
        WebElement element = driver.findElement(btn_ConfirmationAlertButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);


    }
    public void checkAlertMessage(){
        String confirmResult=driver.findElement(msg_Confirmationmessage).getText();
        Assert.assertEquals(confirmResult,"You selected Ok");

    }
    public void clickPromptAllertButtonandSendmyName(String name){
        WebElement element = driver.findElement(btn_PromtAlertButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
        Alert promptAlert  = driver.switchTo().alert();

        promptAlert.sendKeys("AndreeaC");
        promptAlert.accept();
    }
    public void checkPromptAlertMessage(){
        String confirmResult=driver.findElement(msg_PromptResult).getText();
        Assert.assertEquals(confirmResult,"You entered AndreeaC");

    }
}
