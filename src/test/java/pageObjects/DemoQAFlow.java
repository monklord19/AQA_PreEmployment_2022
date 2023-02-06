package pageObjects;

import Locators.DemoQALocators;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.*;

public class DemoQAFlow {

    WebDriver driver;
    WebDriverWait wait;

    DemoQALocators demoQALocators;

    public DemoQAFlow(WebDriver driver) {
        this.driver = driver;
        demoQALocators = new DemoQALocators(driver);
    }

public void JsonFileReader() {
        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("src/main/resources/dataInput.json"));
            if (obj instanceof JSONObject) {
                JSONObject jsonObject = (JSONObject) obj;
                String fullName = (String) jsonObject.get("fullName");
                String email = (String) jsonObject.get("email");
                String currentAddress = (String) jsonObject.get("currentAddress");
                String permanentAddress = (String) jsonObject.get("permanentAddress");
                if (fullName != null) {
                    demoQALocators.getFullName().sendKeys(fullName);
                }
                if (email != null) {
                    demoQALocators.getEmail().sendKeys(email);
                }
                if (currentAddress != null) {
                    demoQALocators.getCurrentAddress().sendKeys(currentAddress);

                }
                if (permanentAddress != null) {
                    demoQALocators.getPermanentAddress().sendKeys(permanentAddress);
                }
            } else{
                System.out.println("Error: JSON data is not an object");
            }
        }catch (IOException | ParseException e){
            e.printStackTrace();
        }
}


    // flow for #1 scenario

    public void clickOnElements() {
        demoQALocators.getElementPath().click();
    }

    public void clickOnTextBox() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(demoQALocators.getTextBox()));
        demoQALocators.getTextBox().click();
    }

    public void informationInput(String fullName, String email, String currentAddress, String permanentAddress) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        demoQALocators.getFullName().clear();
        demoQALocators.getFullName().sendKeys(fullName);
        demoQALocators.getEmail().clear();
        demoQALocators.getEmail().sendKeys(email);
        demoQALocators.getCurrentAddress().clear();
        demoQALocators.getCurrentAddress().sendKeys(currentAddress);
        demoQALocators.getPermanentAddress().clear();
        demoQALocators.getPermanentAddress().sendKeys(permanentAddress);


    }

    public void submitButton() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", demoQALocators.getSubmitButton());
        Actions actions = new Actions(driver);
        actions.moveToElement(demoQALocators.getSubmitButton()).perform();
        wait.until(ExpectedConditions.visibilityOf(demoQALocators.getSubmitButton()));
        demoQALocators.getSubmitButton().click();

    }

    public void informationDisplayed() {
        Assert.assertTrue(demoQALocators.getOutput().isDisplayed());
    }

    //flow for #2 scenario

    public void clickOnFirstCase() {
        demoQALocators.getAlertButton().click();

    }

    public void popUpFirstCase() {
        Alert alert = driver.switchTo().alert();
        String alertMessage = driver.switchTo().alert().getText();
        System.out.println(alertMessage);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        alert.accept();
        Assert.assertTrue(alertMessage.contains("You clicked a button"));
    }

    public void clickOnSecondCase() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        demoQALocators.getTimerButton().click();
    }

    public void popUpSecondCase() {
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Alert alert = driver.switchTo().alert();
        String alertMessage = driver.switchTo().alert().getText();
        System.out.println(alertMessage);
        alert.accept();
        Assert.assertTrue(alertMessage.contains("This alert appeared after 5 seconds"));

    }

    public void clickOnThirdCase() {
        demoQALocators.getConfirmButton().click();
    }

    public void popUpThirdCase() {
        Alert alert = driver.switchTo().alert();
        String alertMessage = driver.switchTo().alert().getText();
        System.out.println(alertMessage);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        alert.accept();
        Assert.assertTrue(alertMessage.contains("Do you confirm action"));

    }

    public void clickOnForthCase() {
        demoQALocators.getPromtButton().click();
    }

    public void popUpForthCase() {
        Alert alert = driver.switchTo().alert();
        String alertMessage = driver.switchTo().alert().getText();
        System.out.println(alertMessage);
        driver.switchTo().alert().sendKeys("Iulian Pitiriciu");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        alert.accept();
        Assert.assertTrue(alertMessage.contains("Please enter your name"));

    }

    //flow for #3 scenario

    public void clickOnSmallModal() {
        demoQALocators.getSmallModal().click();

    }

    public void SmallModalDisplay() {
        Assert.assertTrue(demoQALocators.getSmallContent().isDisplayed());
        System.out.println("Content displayed...");
        String text = demoQALocators.getSmallText().getText();
        String[] words = text.split(" ");

        if (words.length > 10) {
            System.out.println("This is a large modal");
        } else {
            System.out.println("This is a small modal");
        }

        demoQALocators.getCloseSmallModal().click();
    }

    public void clickOnLargeModal() {
        demoQALocators.getLargeModal().click();
    }

    public void LargeModalDisplay() {
        Assert.assertTrue(demoQALocators.getLargeContent().isDisplayed());
        System.out.println("Content displayed...");
        String text = demoQALocators.getLargeText().getText();
        String[] words = text.split(" ");

        if (words.length > 10) {
            System.out.println("This is a large modal");
        } else {
            System.out.println("This is a small modal");
        }
        demoQALocators.getCloseLargeModal().click();
    }

    // flow for #4 scenario

    public void clickOnUploadAndDownload() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,600)");
        demoQALocators.getDnu().click();
    }

    public void selectBrowse(String arg0) {
        demoQALocators.getBrowse().sendKeys(arg0);
        Assert.assertTrue(demoQALocators.getBrowse().isDisplayed());

    }

    public void selectDownload() {
        demoQALocators.getDownloadButton().click();

    }

    public void fileDownloaded() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        File file = new File("/Users/pitiriciuiulian/Downloads/sampleFile.jpeg");
        Assert.assertTrue("File not found!", file.exists());
        if (file.exists()) {
            System.out.println("File " + file + " exists in your computer");

        } else {
            System.out.println("File not found");
        }
    }

    //flow for #5 scenario

    public void hoverButton() {

        Actions actions = new Actions(driver);
        actions.moveToElement(demoQALocators.getHoverButton()).build().perform();
    }

    public void displayMessage() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(demoQALocators.getMessage()));
        String hoverMessage = demoQALocators.getMessage().getText();
        Assert.assertEquals(hoverMessage, "You hovered over the Button");
    }

    public void typeText() {
        demoQALocators.getToolTipText().sendKeys("IULIAN PITIRICIU");
    }

    public void hoverTextInput() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(demoQALocators.getDisplayMessage()));
        Assert.assertTrue(demoQALocators.getDisplayMessage().isDisplayed());

    }

    public void firstTextHovered() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(demoQALocators.getFirstText()));
        Assert.assertTrue(demoQALocators.getFirstText().isDisplayed());

    }

    public void secondTextHovered() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(demoQALocators.getSecondText()));
        Assert.assertTrue(demoQALocators.getSecondText().isDisplayed());
    }

    // flow for #6 scenario

    public void resizeBox() {

        Actions actions = new Actions(driver);
        actions.dragAndDropBy(demoQALocators.getResizeBox(), 250, 250).perform();
    }

    public void checkBoxSize(int width, int height) {
        int actualWidth = demoQALocators.getSizeBox().getSize().getWidth();
        int actualHeight = demoQALocators.getSizeBox().getSize().getHeight();
        Assert.assertEquals(width, actualWidth);
        Assert.assertEquals(height, actualHeight);

    }

    public void checkMinSize(int minWidth, int minHeight) {
        int actualWidth = demoQALocators.getMinPath().getSize().getWidth();
        int actualHeight = demoQALocators.getMinPath().getSize().getHeight();
        Assert.assertTrue(actualWidth >= minWidth);
        Assert.assertTrue(actualHeight >= minHeight);
        System.out.println("Width is " + actualWidth);
        System.out.println("Heigt is " + actualHeight);


    }

    public void checkMaxSize(int maxWidth, int maxHeight) {
        int actualWidth = demoQALocators.getMaxPath().getSize().getWidth();
        int actualHeight = demoQALocators.getMaxPath().getSize().getHeight();
        Assert.assertTrue(actualWidth >= maxWidth);
        Assert.assertTrue(actualHeight >= maxHeight);
        System.out.println("Width is " + actualWidth);
        System.out.println("Height is " + actualHeight);

    }

    // flow for #7 scenario

    public void clickOnCursorStyle() {
        demoQALocators.getCursorStyle().click();
    }

    public void moveToCenter() {
        Actions builder = new Actions(driver);
        builder.dragAndDropBy(demoQALocators.getCenterBox(), 403, 332).perform();

    }

    public void locatedCenter() {
        int elementX = demoQALocators.getCenterBox().getLocation().getX();
        int elementWidth = demoQALocators.getCenterBox().getSize().getWidth();
        int pageWidth = driver.manage().window().getSize().getWidth();
        int expectedX = (pageWidth - elementWidth) / 2;
        if (elementX == expectedX) {
            Assert.assertEquals(elementX, expectedX);
        } else {
            System.out.println("Element is not centered, onto the next test...");
        }
    }

    public void moveToTopLeft() {
        Actions builder = new Actions(driver);
        builder.dragAndDropBy(demoQALocators.getTopLeftBox(), (int) -9.19531, -116).perform();

    }

    public void locatedTopLeft() {
        int elementX = demoQALocators.getTopLeftBox().getLocation().getX();
        int elementY = demoQALocators.getTopLeftBox().getLocation().getY();
        if (elementX == elementY) {
            Assert.assertEquals(elementX, elementY);
        } else {
            System.out.println("Element is not in the maximum of top left corner, onto the next test...");
        }
    }

    public void moveToBottom() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,600)");
        Actions builder = new Actions(driver);
        builder.dragAndDropBy(demoQALocators.getBottomBox(), 379, 422).perform();
    }

    public void locatedBottom() {
        int elementY = demoQALocators.getBottomBox().getLocation().getY();
        int elementHeight = demoQALocators.getBottomBox().getSize().getHeight();
        int pageHeight = driver.manage().window().getSize().getHeight();
        int expectedY = pageHeight - elementHeight;
        if (elementY == expectedY) {
            Assert.assertEquals(elementY, expectedY);
        } else {
            System.out.println("Element is not in the maximum of bottom page");
        }
    }

    //flow for #8 scenario

    public void clickOnSelectDate() {
        demoQALocators.getSelectDate().click();
    }

    public void selectDay() {
        demoQALocators.getSelectDay().click();
    }

    public void selectMonth() {
        Select selectMonth = new Select(demoQALocators.getSelectMonth());
        selectMonth.selectByVisibleText("June");

    }

    public void selectYear() {
        Select selectYear = new Select(demoQALocators.getSelectYear());
        selectYear.selectByVisibleText("1998");
    }

    public void showBirthday() {
        Assert.assertTrue(demoQALocators.getSelectDate().isDisplayed());
    }

    // flow for #9 scenario

    public void sortAsAuthor() {
        demoQALocators.getAuthor().click();
    }

    public void sortAsPublisher() {
        demoQALocators.getPublisher().click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void searchForAuthor(String author) {
        demoQALocators.getSearchFor().clear();
        demoQALocators.getSearchFor().sendKeys(author);

    }

    public void searchForPublisher(String publisher) {
        demoQALocators.getUpdateSearch().clear();
        demoQALocators.getUpdateSearch().sendKeys(publisher);
    }

    public void clickByAuthor() {
        demoQALocators.getClickAuthor().click();

    }

    public void clickByPublisher() {
        demoQALocators.getClickPublisher().click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void informationForAuthor() {
        Assert.assertTrue(demoQALocators.getInformation().isDisplayed());
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,600)");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOf(demoQALocators.getBackButton()));
        demoQALocators.getBackButton().click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public void informationForPublisher() {
        Assert.assertTrue(demoQALocators.getPub().isDisplayed());

    }

    //flow for #10 scenario

    public void startButton(){
        demoQALocators.getStartStop().click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        boolean progressStatus = wait.until(ExpectedConditions.attributeToBe(demoQALocators.getFullProgress(),"aria-valuenow","100"));
        if (progressStatus){
            wait.until(ExpectedConditions.visibilityOf(demoQALocators.getResetButton())).click();
        }
        else {
            System.out.println("Progress bar didn;t reach 100%");
        }
    }
    //WIP
    public void seeProgress(){
        Instant start = Instant.now();
        while(!demoQALocators.getFullProgress().getAttribute("aria-valuenow").equals(100))
        {
            demoQALocators.getProgressBar().click();
        }
        Instant end = Instant.now();
        Duration duration = Duration.between(start,end);
        System.out.println("Time taken for progress bar to finish loading: " + duration.toMillis() + " ms");
    }

}












