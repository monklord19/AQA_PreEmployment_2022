package pages;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementsPage {
    WebDriver driver;

    public ElementsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div/div[1]/div/div[2]")
    private WebElement Elements;


    @FindBy(xpath = "//*[@id=\"item-2\"]")
    private WebElement radioBtn;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[2]/label")
    private WebElement yesRadioBtn;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/p/span")
    private WebElement yesTextRadioBtn;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/label")
    private WebElement impressiveRadioBtn;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/p/span")
    private WebElement impressiveTextRadioBtn;


    @FindBy(id = "item-4")
    private WebElement Buttons;
    @FindBy(id = "doubleClickBtn")
    private WebElement doubleClickBtn;
    @FindBy(id = "doubleClickMessage")
    private WebElement doubleClickMessage;
    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[3]/button")
    private WebElement dynamicClickBtn;
    @FindBy(id = "dynamicClickMessage")
    private WebElement dynamicClickMessage;
    @FindBy(id = "rightClickBtn")
    private WebElement rightClickBtn;
    @FindBy(id = "rightClickMessage")
    private WebElement rightClickMessage;


    @FindBy(xpath = "//*[@id=\"item-0\"]")
    private WebElement textBox;
    @FindBy(id = "userName")
    private WebElement textBoxUsername;
    @FindBy(id = "userEmail")
    private WebElement textBoxUserEmail;
    @FindBy(id = "currentAddress")
    private WebElement textBoxCurrentAddress;
    @FindBy(id = "permanentAddress")
    private WebElement textBoxPermanentAddress;
    @FindBy(id = "submit")
    private WebElement textBoxSubmitButton;
    @FindBy(xpath = "//*[@id=\"output\"]/div")
    private WebElement displayedInfo;


    @FindBy(xpath = "//*[@id=\"item-7\"]/span")
    private WebElement updateAndDownloadBtn;
    @FindBy(id = "downloadButton")
    private WebElement downloadBtn;
    @FindBy(xpath = "//*[@id=\"uploadFile\"]")
    private WebElement uploadFileBtn;
    @FindBy(id = "uploadedFilePath")
    private WebElement uploadedFile;

    @FindBy(xpath = "//*[@id=\"item-8\"]/span")
    private WebElement dynamicProperties;

    @FindBy(id = "colorChange")
    private WebElement colorChangeBtn;


    public void wait(WebElement element){
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
        w.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void clickElements(){

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("javascript:window.scrollBy(250,350)");

        wait(Elements);
        Elements.click();
    }

    public void clickButtons(){

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("javascript:window.scrollBy(250,350)");

        wait(Buttons);
        Buttons.click();

    }

    public void doubleClickButtons() throws InterruptedException{
        Thread.sleep(2000);
        Actions act = new Actions(driver);
        act.doubleClick(doubleClickBtn).perform();
    }

    public void rightClickButton(){
        Actions actions = new Actions(driver);
        actions.moveToElement(rightClickBtn).contextClick().perform();

    }

    public void singleClickButton() throws InterruptedException{
        Thread.sleep(2000);
        dynamicClickBtn.click();
    }

    public void clickRadioButtons(){
        wait(radioBtn);
        radioBtn.click();
    }

    public void clickImpressiveRadioButton(){
        impressiveRadioBtn.click();
    }

    public void clickYesRadioButton(){
        yesRadioBtn.click();
    }

    public void doubleClickMessage(String message){

        Assert.assertEquals(doubleClickMessage.getText(), message);
    }

    public void rightClickMessage(String message){

        Assert.assertEquals(rightClickMessage.getText(), message);
    }

    public void dynamicClickMessage(String message){

        Assert.assertEquals(dynamicClickMessage.getText(), message);
    }

    public void impressiveMessage(String message){
        Assert.assertEquals(impressiveTextRadioBtn.getText(), message);
    }

    public void updateAndDownloadPage(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("javascript:window.scrollBy(250,350)");

        wait(updateAndDownloadBtn);
        updateAndDownloadBtn.click();
    }

    public void uploadFile(){

        String filePath = "C:\\Users\\silvi\\Desktop\\AQA_PreEmployment_2022\\AQA_PreEmployment_2022\\src\\test\\resources\\images\\sampleFile.jpeg";
        uploadFileBtn.sendKeys(filePath);
    }

    public void verifyUpload(){
        Assert.assertTrue(uploadedFile.isDisplayed());
    }

    public void goToTextBox(){
        textBox.click();
    }

    public void insertInfo(){
        textBoxUsername.sendKeys(("Silvia"));
        textBoxUserEmail.sendKeys(("silvia.pp@yahoo.com"));
        textBoxCurrentAddress.sendKeys("Strada Maratei 182");
        textBoxPermanentAddress.sendKeys("Strada Maratei 182");
        textBoxSubmitButton.click();
    }

    public void displayedInformations(){
        Assert.assertTrue(displayedInfo.isDisplayed());
    }


    public void YesMessage(String message){
        Assert.assertEquals(yesTextRadioBtn.getText(), message);
    }

    public void goToDynamicPropertiesPage(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("javascript:window.scrollBy(250,350)");

        wait(dynamicProperties);
        dynamicProperties.click();
    }

    public void clickChangeColorBtn() throws InterruptedException{
        String initialColor = colorChangeBtn.getCssValue("color");
        colorChangeBtn.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.not(ExpectedConditions.attributeToBe(colorChangeBtn, "color", initialColor)));

        String updatedColor = colorChangeBtn.getCssValue("color");
        Assert.assertNotEquals(initialColor, updatedColor);
    }


}
