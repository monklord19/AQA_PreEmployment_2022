//package pages;
//
//import org.junit.Assert;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//
//public class pageObjects {
//
//    WebDriver driver;
//    By elementsButton = By.className("card-up");
//    By radioButton = By.id("item-2");
//    By yesOption = By.className("custom-control-label");
//    By yesTextAppears = By.className("mt-3");
//
//    By checkBox = By.id("item-1");
//
//    By homeCheckBox = By.className("rct-checkbox");
//
//    By homeDesktopTestAppears = By.id("result");
//
//    public pageObjects(WebDriver driver) {
//        this.driver = driver;
//        if (!driver.getTitle().equals("ToolsQA")) {
//            throw new IllegalStateException("This is not demoqa page. The current page is " + driver.getCurrentUrl());
//        }
//    }
//
//    public void userClicksOnElementsButton() {
//        driver.findElement(elementsButton).click();
//    }
//
//    public void userClicksOnRadioButton() {
//        driver.findElement(radioButton).click();
//    }
//
//    public void userCLicksOnYesOption() {
//        driver.findElement(yesOption).click();
//    }
//
//    public void youHaveSelectedYesTextAppears() {
//        WebElement text = driver.findElement(yesTextAppears);
//        String expectedText = "You have selected Yes";
//        Assert.assertEquals(expectedText, text.getText());
//    }
//
//    public void userClicksOnCheckBox() {
//        driver.findElement(checkBox).click();
//    }
//
//    public void userClicksOnHomeCheckBox() {
//        driver.findElement(homeCheckBox).click();
//    }
//
//    public void youHaveSelectedHomeDesktopAppears() {
//        WebElement text = driver.findElement(homeDesktopTestAppears);
//        String expectedText = "You have selected :\n" +
//                "home\n" +
//                "desktop\n" +
//                "notes\n" +
//                "commands\n" +
//                "documents\n" +
//                "workspace\n" +
//                "react\n" +
//                "angular\n" +
//                "veu\n" +
//                "office\n" +
//                "public\n" +
//                "private\n" +
//                "classified\n" +
//                "general\n" +
//                "downloads\n" +
//                "wordFile\n" +
//                "excelFile";
//        Assert.assertEquals(expectedText, text.getText());
//    }
//
//}
