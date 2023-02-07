package Steps;

import Config.PropertyFile;
import PageObjects.*;
import com.google.gson.Gson;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Random;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;


public class DemoDefs {
    DemoElementsPage demoElementsPage;
    DemoAlertsPage demoAlertsPage;
    DemoButtonsPage demoButtonsPage;
    DemoBookStorePage demoBookStorePage;
    DemoWidgetsPage demoWidgetsPage;
    SingletonClass singleton = SingletonClass.getInstance();
    WebDriver driver = singleton.getDriver();
    Actions actions = singleton.getActions();
    PropertyFile pfe = new PropertyFile();
    String demoUserName = pfe.getDemoUserName();
    String demoPassword = pfe.getDemoPassword();

    @Before
    public void demoDefsSetUp() {
        driver.manage().window().maximize();
        demoElementsPage = new DemoElementsPage(driver);
        demoAlertsPage = new DemoAlertsPage(driver);
        demoButtonsPage = new DemoButtonsPage(driver);
        demoBookStorePage = new DemoBookStorePage(driver);
        demoWidgetsPage = new DemoWidgetsPage(driver);
    }

    @After
    public void tearDownBookDemoDefs() {
        driver.quit();
    }


    //Demo Elements Page
    @Given("On demoQA website")
    public void onDemoWebsite() {
        driver.get("https://demoqa.com/");
    }

    @When("User goes to elements menu")
    public void clickOnElementsMenu() {
        driver.findElement(By.xpath("//h5[contains(text(), 'Elements')]")).click();
    }

    @And("Click on text box submenu")
    public void clickOnTextBoxSubmenu() {
        demoElementsPage.getDemoQATextBoxSubmenu().click();
    }

    @And("Complete form with {string}, {string}, {string} and {string}")
    public void completeForm(String name, String email, String currentAddress, String permanentAddress) {
        demoElementsPage.enterDemoQAFullName().sendKeys(name);
        demoElementsPage.enterDemoQAEmail().sendKeys(email);
        demoElementsPage.enterDemoQACurrentAddress().sendKeys(currentAddress);
        demoElementsPage.enterDemoQaPermanentAddress().sendKeys(permanentAddress);
        demoElementsPage.getDemoQASubmitButton().click();
    }

    @Then("User should submit the form with success {string}")
    public void verifySubmit(String success) {
        boolean isPresent = !driver.findElements(By.id("output")).isEmpty();
        if (Boolean.parseBoolean(success)) {
            assertTrue(isPresent);
        } else {
            assertFalse(isPresent);
        }
    }

    @And("Click on web tables submenu")
    public void clickOnWebTablesSubmenu() {
        demoElementsPage.getDemoQAWebTablesSubmenu().click();
    }

    @And("Click on add button")
    public void clickOnAddButton() {
        demoElementsPage.getDemoQANewRecordButton().click();
    }

    @And("User fill all fields")
    public void fillFields() {
        demoElementsPage.enterRegistrationTablesFirstName().sendKeys("Filip");
        demoElementsPage.enterRegistrationTablesLastName().sendKeys("Paul");
        demoElementsPage.enterRegistrationTablesEmail().sendKeys("paulfilip.dev@gmail.com");
        demoElementsPage.enterRegistrationTablesAge().sendKeys("27");
        demoElementsPage.enterRegistrationSalary().sendKeys("500");
        demoElementsPage.enterRegistrationDepartment().sendKeys("AQA");
        demoElementsPage.getRegistrationSubmitButton().click();
    }

    @Then("User should be able to search his name on the list {string}")
    public void seeNewDataOnWebTables(String success) {
        demoElementsPage.searchNewItemCreated().sendKeys("Filip");
        boolean isPresent = !driver.findElements(By.xpath("//*[contains(text(), 'Filip')]")).isEmpty();
        if (Boolean.parseBoolean(success)) {
            assertTrue(isPresent);
        } else {
            assertFalse(isPresent);
        }
    }

    @And("User wants to delete new data that he just created {string}")
    public void deleteNewDataOnWebTables(String success) {
        demoElementsPage.getWebTablesDeleteIcon().click();
        demoElementsPage.pleaseWait(1);
        boolean isPresent = !driver.findElements(By.xpath("//*[contains(text(), 'No rows found')]")).isEmpty();
        if (Boolean.parseBoolean(success)) {
            assertTrue(isPresent);
        } else {
            assertFalse(isPresent);
        }
    }

    @And("Click on upload and download box submenu")
    public void clickOnUploadAndDownloadSubmenu() {
        WebElement myButton = driver.findElement(By.id("item-7"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", myButton);
        myButton.click();
    }

    @And("Click on download button")
    public void clickOnDownloadButton() {
        demoElementsPage.getDownloadButton().click();
    }

    @Then("Check if the file has been downloaded")
    public void checkDownloadedFile() {
        demoElementsPage.pleaseWait(5);
        //path for macOS (by default)
        File expectedFile = new File(System.getProperty("user.home") + "/Downloads/sampleFile.jpeg");

        //path for Windows (uncomment this to test on Windows machine)
        //File expectedFile = new File(System.getenv("HOMEDRIVE") + System.getenv("HOMEPATH") + "\\Downloads\\sampleFile.jpeg");
        assertTrue(expectedFile.exists());
    }

    @And("User click on choose file button")
    public void userSelectsAFile() {
        String projectPath = System.getProperty("user.dir");
        driver.findElement(By.id("uploadFile")).sendKeys(projectPath + "/Picture/sampleFile.jpeg");
    }

    @Then("Check if the file has been uploaded {string}")
    public void checkFileUpload(String success) {
        boolean isPresent = !driver.findElements(By.id("uploadedFilePath")).isEmpty();
        if (Boolean.parseBoolean(success)) {
            assertTrue(isPresent);
        } else {
            assertFalse(isPresent);
        }
    }

    //Demo Buttons Page
    @And("Click on buttons submenu")
    public void clickOnButtonSubmenu() {
        demoButtonsPage.getDemoQAButtonsSubmenu().click();
    }

    @And("Double click on 'Double Click Me' button")
    public void doubleClickDemoQAButton() {
        actions.doubleClick(demoButtonsPage.getDemoQADoubleClickButton()).perform();
    }

    @Then("User should see a confirmation message 'You have done a double click' {string}")
    public void confirmationMessageDoubleClick(String success) {
        boolean isPresent = !driver.findElements(By.id("doubleClickMessage")).isEmpty();
        if (Boolean.parseBoolean(success)) {
            assertTrue(isPresent);
        } else {
            assertFalse(isPresent);
        }
    }

    @And("Right click on 'Right Click Me' button")
    public void rightClickDemoQAButton() {
        actions.contextClick(demoButtonsPage.getDemoQARightClickButton()).perform();
    }

    @Then("User should see a confirmation message 'You have done a right click' {string}")
    public void confirmationMessageRightClick(String success) {
        boolean isPresent = !driver.findElements(By.id("rightClickMessage")).isEmpty();
        if (Boolean.parseBoolean(success)) {
            assertTrue(isPresent);
        } else {
            assertFalse(isPresent);
        }
    }

    @And("Left click on 'Click Me' button")
    public void leftClickMeDemoQAButton() {
        demoButtonsPage.getDemoClickMeButton().click();
    }

    @Then("User should see a confirmation message 'You have done a dynamic click' {string}")
    public void dynamicClick(String success) {
        boolean isPresent = !driver.findElements(By.id("dynamicClickMessage")).isEmpty();
        if (Boolean.parseBoolean(success)) {
            assertTrue(isPresent);
        } else {
            assertFalse(isPresent);
        }
    }


    //Demo Alert, Frame & Windows Page
    @When("User goes to Alerts, Frame & Windows menu")
    public void clickOnAlertsMenu() {
        demoAlertsPage.getDemoAlertsFrameWindowsButton().click();
    }

    @And("Click on alerts submenu")
    public void clickOnAlertsSubmenu() {
        demoAlertsPage.getDemoAlertsSubmenuButton().click();
    }

    @And("Click on first 'Click me' button")
    public void clickOnFirstButton() {
        demoAlertsPage.getDemoAlertButton().click();
    }

    @Then("User should see an alert with the text {string} and click 'OK' button")
    public void verifyAlert(String expectedText) {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            assertEquals(alertText, expectedText);
            alert.accept();
        } catch (NoAlertPresentException e) {
            Assert.fail("Alert is not present");
        }
    }

    @And("Click on second 'Click me' button")
    public void clickOnSecondButton() {
        demoAlertsPage.getDemoTimerAlertButton().click();
    }

    @Then("User should see an alert with the text {string} after 5 seconds and click 'OK' button")
    public void verifyDelayAlert(String expectedText) {
        try {
            demoAlertsPage.pleaseWait(5);
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            Assert.assertEquals(alertText, expectedText);
            alert.accept();
        } catch (NoAlertPresentException e) {
            Assert.fail("Alert is not present");
        }
    }

    @And("Click on third 'Click me' button")
    public void clickOnThirdButton() {
        demoAlertsPage.getDemoConfirmButton().click();
    }

    @And("User should see an alert with text {string} and click ok")
    public void chooseOkButton(String expectedText) {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            Assert.assertEquals(alertText, expectedText);
            alert.accept();
        } catch (NoAlertPresentException e) {
            Assert.fail("Alert is not present");
        }
    }

    @Then("User should see a green text {string}")
    public void Okconfirmation(String expectedConfirmationText) {
        String actualConfirmationText = driver.findElement(By.id("confirmResult")).getText();
        Assert.assertTrue(actualConfirmationText.contains(expectedConfirmationText));
    }

    @And("User should see an alert with text {string} and click cancel")
    public void clickCancel(String alertText) {
        Alert alert = driver.switchTo().alert();
        assertEquals(alertText, alert.getText());
        alert.dismiss();
    }

    @Then("User should see a green text with {string}")
    public void CancelConfirmation(String text) {
        assertEquals(text, driver.findElement(By.id("confirmResult")).getText());
        assertEquals("text-success", driver.findElement(By.id("confirmResult")).getAttribute("class"));
    }

    @And("Click on the fourth 'Click me' button")
    public void clickOnFourthButton() {
        demoAlertsPage.getDemoPromptButton().click();
    }

    @And("User should see an alert with text {string} and should complete field")
    public void promptAlert(String alertText) {
        Alert alert = driver.switchTo().alert();
        assertEquals(alertText, alert.getText());
        alert.sendKeys("Filip Paul");
        alert.accept();
    }

    @Then("User should see a green text after click ok, with user name {string}")
    public void promptConfirmation(String success) {
        boolean isPresent = !driver.findElements(By.id("promptResult")).isEmpty();
        if (Boolean.parseBoolean(success)) {
            assertTrue(isPresent);
        } else {
            assertFalse(isPresent);
        }
    }


    //Book Store Page
    @Given("DemoQA login website")
    public void loginWebsite(){
        driver.get("https://demoqa.com/login");
    }

    @When("Created and logged in user")
    public void createdAndLoggedInUser() {
        Gson gson = new Gson();
        String body = "{\"userName\":\"" + demoUserName + "\",\"password\":\"" + demoPassword + "\"}";
        String responseCreateUser = given().body(body).contentType(demoBookStorePage.contentType()).when().post(demoBookStorePage.endpointCreateUser()).thenReturn().asString();
        Map<String, Object> mapCreateUser = gson.fromJson(responseCreateUser, Map.class);
        assertFalse(mapCreateUser.containsKey("code"));
        for (Map.Entry<String, Object> entry : mapCreateUser.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    @Then("User has token and is authorized")
    public void userHasTokenAndIsAuthorized() {
        Gson gson = new Gson();
        String body = "{\"userName\":\"" + demoUserName + "\",\"password\":\"" + demoPassword + "\"}";
        String responseGenerateToken = given().body(body).contentType(demoBookStorePage.contentType()).when().post(demoBookStorePage.endpointGenerateToken()).thenReturn().asString();
        String responseAuthorized = given().body(body).contentType(demoBookStorePage.contentType()).when().post(demoBookStorePage.endpointAuthorize()).thenReturn().asString();
        Boolean userIsAuthorized = gson.fromJson(responseAuthorized, Boolean.class);
        Assert.assertTrue(userIsAuthorized);
    }

    @When("User goes to bookstore menu")
    public void clickOnBookStoreMenu() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", demoBookStorePage.getBookStoreApplicationMenu());
        demoBookStorePage.getBookStoreApplicationMenu().click();
    }

    @And("Click on login button")
    public void clickOnLoginButton() {
        demoBookStorePage.getLoginButton().click();
    }

    @And("User enter valid credentials")
    public void enterValidCredentials() {
        demoBookStorePage.getUserNameLabel().sendKeys(demoUserName);
        demoBookStorePage.getPasswordLabel().sendKeys(demoPassword);
        demoBookStorePage.getLoginButton().click();
    }

    @Then("User should be logged in with success {string}")
    public void shouldLoggedIn(String success) {
        demoBookStorePage.pleaseWait(3);
        boolean isPresent = !driver.findElements(By.id("submit")).isEmpty();
        if (Boolean.parseBoolean(success)) {
            assertTrue(isPresent);
        } else {
            assertFalse(isPresent);
        }
    }

    @Given("User is logging in")
    public void userIsLoggingIn() {
        driver.get("https://demoqa.com/login");
        demoBookStorePage.getUserNameLabel().sendKeys(demoUserName);
        demoBookStorePage.getPasswordLabel().sendKeys(demoPassword);
        demoBookStorePage.getLoginButton().click();
    }

    @When("User click on 'Go To Bookstore' button")
    public void clickOnGoToBookstoreButton() {
        demoBookStorePage.pleaseWait(5);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", demoBookStorePage.getGoToBookstoreButton());
        demoBookStorePage.getGoToBookstoreButton().click();
    }

    @And("User search a book by author")
    public void searchingBook() {
        demoBookStorePage.pleaseWait(2);
        demoBookStorePage.typeInSearchLabel().sendKeys("Kyle Simpson");
    }

    @Then("User should see the result on the list")
    public void shouldSeeResult() {
        WebElement parentDiv = driver.findElement(By.className("rt-tbody"));
        if (parentDiv.getText().contains("Kyle Simpson")) {
            System.out.println("rt-body contains Kyle Simpson");
        } else {
            System.out.println("rt-body does not contain Kyle Simpson");
        }
        assertTrue(parentDiv.getText().contains("Kyle Simpson"));
    }

    @Given("User is on the book store page")
    public void userOnTheBookStorePage() {
        driver.get("https://demoqa.com/login");
        demoBookStorePage.getUserNameLabel().sendKeys(demoUserName);
        demoBookStorePage.getPasswordLabel().sendKeys(demoPassword);
        demoBookStorePage.getLoginButton().click();
        demoBookStorePage.pleaseWait(5);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", demoBookStorePage.getGoToBookstoreButton());
        demoBookStorePage.getGoToBookstoreButton().click();
    }

    @When("Click on a random book title")
    public void clickOnRandomBookTitle() {
        demoBookStorePage.pleaseWait(2);
        WebElement parentDiv = driver.findElement(By.className("rt-table"));
        List<WebElement> clickableTexts = parentDiv.findElements(By.tagName("a"));
        int size = clickableTexts.size();
        Random random = new Random();
        int randomIndex = random.nextInt(size);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", clickableTexts.get(randomIndex));
        clickableTexts.get(randomIndex).click();
    }

    @And("Click on 'Add to Your Collection' button")
    public void clickOnAddToYourCollectionButton() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", demoBookStorePage.getAddToYourCollectionButton());
        demoBookStorePage.getAddToYourCollectionButton().click();
    }

    @And("Click on 'ok' pop-up button")
    public void okOnPopupButton() {
        demoBookStorePage.pleaseWait(1);
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    @And("Click on profile submenu")
    public void clickOnProfileButtonSubmenu() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", demoBookStorePage.getProfileButtonSubmenu());
        demoBookStorePage.getProfileButtonSubmenu().click();
    }

    @Then("User should be able to delete his new single record {string}")
    public void deleteSingleRecord(String success) {
        demoBookStorePage.pleaseWait(2);
        demoBookStorePage.getDeleteSingleRecordButton().click();
        demoBookStorePage.pleaseWait(2);
        demoBookStorePage.getOkForSmallModalDeleteRecord().click();
        demoBookStorePage.pleaseWait(2);
        Alert alert = driver.switchTo().alert();
        alert.accept();
        boolean isPresent = !driver.findElements(By.xpath("//*[contains(text(), 'No rows found')]")).isEmpty();
        if (Boolean.parseBoolean(success)) {
            assertTrue(isPresent);
        } else {
            assertFalse(isPresent);
        }
    }

    @When("User adding multiple random books in the collection")
    public void addMultipleRandomBooks(){
        demoBookStorePage.pleaseWait(2);
        demoBookStorePage.getFirstBook().click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", demoBookStorePage.getAddToYourCollectionButton());
        demoBookStorePage.getAddToYourCollectionButton().click();
        demoBookStorePage.pleaseWait(2);
        Alert alert = driver.switchTo().alert();
        alert.accept();
        demoBookStorePage.pleaseWait(2);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", demoBookStorePage.getBackToBookStore());
        demoBookStorePage.getBackToBookStore().click();
        demoBookStorePage.getSecondBook().click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", demoBookStorePage.getAddToYourCollectionButton());
        demoBookStorePage.getAddToYourCollectionButton().click();
        demoBookStorePage.pleaseWait(2);
        Alert secondalert = driver.switchTo().alert();
        secondalert.accept();
        demoBookStorePage.pleaseWait(2);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", demoBookStorePage.getProfileButtonSubmenu());
        demoBookStorePage.getProfileButtonSubmenu().click();
    }

    @Then("User should be able to delete all books records {string}")
    public void deleteAllBooksRecords(String success){
        demoBookStorePage.pleaseWait(2);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", demoBookStorePage.getDeleteAllBooksRecordButton());
        demoBookStorePage.getDeleteAllBooksRecordButton().click();
        demoBookStorePage.getOkForSmallModalDeleteRecord().click();
        demoBookStorePage.pleaseWait(2);
        Alert alert = driver.switchTo().alert();
        alert.accept();
        demoBookStorePage.pleaseWait(2);
        boolean isPresent = !driver.findElements(By.xpath("//*[contains(text(), 'No rows found')]")).isEmpty();
        if (Boolean.parseBoolean(success)) {
            assertTrue(isPresent);
        } else {
            assertFalse(isPresent);
        }
    }

    @When("User click log out")
    public void clickLogOut(){
        demoBookStorePage.pleaseWait(2);
        demoBookStorePage.getLogOutAccountButton().click();
    }

    @Then("User should be logged out")
    public void userShouldBeLoggedOut(){
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("https://demoqa.com/login", currentUrl);
    }

    @When("User click on delete account button")
    public void deleteAccountButton(){
        demoBookStorePage.pleaseWait(2);
        demoBookStorePage.getDeleteAccountButton().click();
        demoBookStorePage.getOkForSmallModalDeleteRecord().click();
        demoBookStorePage.pleaseWait(1);
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    @Then("User trying to reconnect with same credentials {string}")
    public void accountShouldBeDeleted(String success){
        demoBookStorePage.getUserNameLabel().sendKeys(demoUserName);
        demoBookStorePage.getPasswordLabel().sendKeys(demoPassword);
        demoBookStorePage.getLoginButton().click();
        demoBookStorePage.pleaseWait(1);
        List<WebElement> elements = driver.findElements(By.xpath("//*[contains(text(), 'Invalid username or password!')]"));
        boolean isPresent = !elements.isEmpty();
        boolean shouldAllowToContinue = Boolean.parseBoolean(success);
        if (shouldAllowToContinue) {
            assertFalse(isPresent);
        } else {
            Assert.assertTrue(isPresent);
        }
    }


    //Widgets Page
    @Given("On demoQA slider page")
    public void onDemoWebsiteSliderPage() {
        driver.get("https://demoqa.com/slider");
    }

    @When("I move the horizontal slider handle to {int}")
    public void moveSlider(int expectedValue){
        actions.clickAndHold(demoWidgetsPage.horizontalSlider()).perform();
        int width = demoWidgetsPage.horizontalSlider().getSize().width;
        int x_offset = (int)(width*((expectedValue*1.0)/100));
        actions.moveByOffset(x_offset,0).build().perform();
        actions.release().build().perform();
    }

    @Then("I should see the current value of the slider is {int}")
    public void seeCurrentValuesOfSlider(int expectedValue){
        demoWidgetsPage.horizontalSlider();
        int actualValue = Integer.parseInt(demoWidgetsPage.horizontalSlider().getAttribute("value"));
        Assert.assertEquals(expectedValue, actualValue);
    }
}
