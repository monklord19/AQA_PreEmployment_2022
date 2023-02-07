package steps;
import io.cucumber.java.After;
import pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class frontend {

    public WebDriver driver = new ChromeDriver();
    ElementsPage ElementsPage = new ElementsPage(driver);
    InteractionsPage InteractionsPage = new InteractionsPage(driver);
    AlertsFramesWindowsPage AlertsFramesWindowsPage = new AlertsFramesWindowsPage(driver);

    WidgetsPage WidgetsPage = new WidgetsPage(driver);

    @After
    public void quit() {
        driver.quit();
    }


    @Given("I open the demoqa website")
    public void iOpenTheDemoqaWebsite(){
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
    }

    @When("I go on the buttons page")
    public void i_go_on_the_buttons_page() throws InterruptedException{

        ElementsPage.clickButtons();
    }

    @When("I double click the button")
    public void i_double_click_the_button() throws InterruptedException{
        ElementsPage.doubleClickButtons();
    }

    @Then("I should see the message {string}")
    public void i_should_see_the_message(String rightClickMessage){
        ElementsPage.doubleClickMessage(rightClickMessage);
    }


    @And("I right click the button")
    public void iRightClickTheButton(){
        ElementsPage.rightClickButton();
    }

    @And("I single click the button")
    public void iSingleClickTheButton() throws InterruptedException{
        ElementsPage.singleClickButton();
    }

    @When("I go on the radioButton page")
    public void iGoOnTheRadioButtonPage(){
        ElementsPage.clickRadioButtons();
    }

    @And("I click on the impressive button")
    public void iClickOnTheImpressiveButton(){
        ElementsPage.clickImpressiveRadioButton();
    }

    @And("I click on the Yes button")
    public void iClickOnTheYesButton(){
        ElementsPage.clickYesRadioButton();
    }

    @When("I go on the alerts page")
    public void iGoOnTheAlertsPage() throws InterruptedException{
        AlertsFramesWindowsPage.clickAlertsButton();
    }

    @And("I click on button")
    public void iClickOnButton(){
        AlertsFramesWindowsPage.clickAlertButton();
    }

    @And("After i press ok button the pop up should close")
    public void afterIPressOkButtonIShouldBeOnTheSamePage(){
        AlertsFramesWindowsPage.closeAlert();
    }

    @When("I go on the Elements page")
    public void iGoOnTheElementsPage(){
        ElementsPage.clickElements();
    }

    @When("I go to Alerts,Frame,Windows page")
    public void iGoToAlertsFrameWindowsPage(){
        AlertsFramesWindowsPage.clickOnAlertsFrameWindowsPage();
    }

    @Then("An alert should be displayed with the text {string}")
    public void anAlertShouldBeDisplayedWithTheText(String msg){
        AlertsFramesWindowsPage.displayedAlert(msg);
    }

    @When("I go on Browser Windows")
    public void iGoOnBrowserWindows(){
        AlertsFramesWindowsPage.BrowserWindows();
    }

    @Then("I click new tab button and a new tag should be opened")
    public void iClickNewTabButtonAndANewTagShouldPeOpened(){
        AlertsFramesWindowsPage.clickNewTabButton();
    }

    @Then("I click new window button and a new window should be opened")
    public void iClickNewWindowButtonAndANewWindowShouldBeOpened(){
        AlertsFramesWindowsPage.clickNewWindowButton();
    }

    @When("I go to Widgets button")
    public void iGoToWidgetsButton(){
        WidgetsPage.clickWidgetButton();
    }

    @Then("I should see the message for double click {string}")
    public void iShouldSeeTheMessageForDoubleClick(String message){
        ElementsPage.doubleClickMessage(message);
    }

    @Then("I should see the message for right click {string}")
    public void iShouldSeeTheMessageForRightClick(String message){
        ElementsPage.rightClickMessage(message);
    }

    @Then("I should see the message for dynamic click {string}")
    public void iShouldSeeTheMessageForDynamicClick(String message){
        ElementsPage.dynamicClickMessage(message);
    }

    @Then("I shoud see the message {string}")
    public void iShoudSeeTheMessage(String message){
        ElementsPage.YesMessage(message);
    }

    @When("I go on Progress Bar Page")
    public void iGoOnProgressBarPage(){
        WidgetsPage.clickProgressBar();
    }

    @Then("I press start button and the progress bar should change its value")
    public void afterIPressStartButtonTheProgressBarShouldChargeUntilReach(){
        WidgetsPage.startProgressBar();
    }

    @Given("I go on Update and Download page")
    public void iGoOnUpdateAndDownloadPage(){
        ElementsPage.updateAndDownloadPage();
    }

    @When("I upload the file")
    public void iUploadTheFile(){
        ElementsPage.uploadFile();
    }

    @Then("The file should be uploaded")
    public void theFileShouldBeUploaded(){
        ElementsPage.verifyUpload();
    }

    @Given("I go on the Text Box page")
    public void iGoOnTheTextBoxPage(){
        ElementsPage.goToTextBox();
    }

    @When("I insert my informations in the text box and i press submit button")
    public void iInsertMyInformationsInTheTextBoxAndIPressSubmitButton(){
        ElementsPage.insertInfo();

    }

    @Then("The informations should be displayed")
    public void theInformationsShouldBeDisplayed(){
        ElementsPage.displayedInformations();
    }

    @When("I go on Slider Page")
    public void iGoOnSliderPage(){
        WidgetsPage.sliderPage();
    }

    @When("I use slide bar")
    public void iUseSlideBar(){
        WidgetsPage.useSlider();
    }

    @Then("The slide value should change")
    public void theSlideValueShouldChange(){
        WidgetsPage.verifySliderValue();
    }

    @Given("I go on the Interactions page")
    public void iGoOnTheInteractionsPage(){
        InteractionsPage.goToInteractions();

    }

    @Given("I go on the Droppable page")
    public void iGoOnTheDroppablePage(){
        InteractionsPage.goToDroppable();
    }

    @When("I perform drag and drop")
    public void iPerformDragAndDrop(){
        InteractionsPage.performDrop();
    }

    @Then("The item should be dropped and the text {string}should appear")
    public void theItemShouldBeDroppedAndTheTextShouldAppear(String text){
        InteractionsPage.verifyDroppedText(text);
    }

    @Given("I go on the Dragabble page")
    public void iGoOnTheDragabblePage(){
        InteractionsPage.goToDragabble();
    }


    @When("I drag an element it should change its position")
    public void iDragAnElementItShouldChangeItsPosition(){
        InteractionsPage.dragElement();
    }


    @When("I go on the Dynamic Properties page")
    public void iGoOnTheDynamicPropertiesPage(){
        ElementsPage.goToDynamicPropertiesPage();

    }

    @Then("I click the color change button and the colour should be changed")
    public void iClickTheColorChangeButtonAndTheColourShouldBeChanged() throws InterruptedException{
        ElementsPage.clickChangeColorBtn();
    }

}
