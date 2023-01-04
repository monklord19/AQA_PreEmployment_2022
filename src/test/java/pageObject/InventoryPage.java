package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class InventoryPage {

    public static WebDriver driver;

    public InventoryPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//div[@class='inventory_container']")
    private WebElement inventoryContainer;

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
    private WebElement addToCart1;

    @FindBy(xpath = "//button[@id='back-to-products']")
    private WebElement backButton;

    @FindBy(xpath = "//select[@class='product_sort_container']")
    private WebElement selectSort;

    @FindBy(xpath = "//div[@id='shopping_cart_container']/a[1]")
    private WebElement shoppingCart;

    @FindBy(xpath = "//button[@id='remove-test.allthethings()-t-shirt-(red)']")
    private WebElement removeButton;

    @FindBy(xpath = "//button[@id='checkout']")
    private WebElement checkOutButton;

    @FindBy(xpath = "//input[@id='first-name']")
    private WebElement firstNameField;

    @FindBy(xpath = "//input[@id='last-name']")
    private WebElement lastNameField;

    @FindBy(xpath = "//input[@id='postal-code']")
    private WebElement postalCodeField;

    @FindBy(xpath = "//input[@id='continue']")
    private WebElement continueButton;

    @FindBy(xpath = "//div[@class='summary_subtotal_label']")
    private WebElement subTotalSection;

    @FindBy(xpath = "//div[@class='summary_tax_label']")
    private WebElement taxSection;

    @FindBy(xpath = "//div[@class='summary_total_label']")
    private WebElement totalSection;

    @FindBy(xpath = "//button[@id='finish']")
    private WebElement finishButton;

    @FindBy(xpath = "//h2[@class='complete-header']")
    private WebElement completeHeader;

    @FindBy(xpath = "//h3")
    private WebElement errorMessage;

    public void chooseItem(String itemName){
        driver.findElement(By.xpath("//div[.="+itemName+"]")).click();
    }

    public boolean displayed(){
        inventoryContainer.isDisplayed();
        return true;
    }

    public void clickAddToChart(String item){
        driver.findElement(By.xpath("//button[@id='"+item+"']")).click();
    }

    public void clickAdd1(){
        addToCart1.click();
    }

    public void clickBackButton(){
        backButton.click();
    }

    public void sortProduct(String sort){
        selectSort.click();
        Select a = new Select(selectSort);
        a.selectByVisibleText(sort);
    }
    public void checkCart(){
        shoppingCart.click();
    }

    public void clickRemoveButton(){
        removeButton.click();
    }

    public void clickCheckOutButton(){checkOutButton.click();}
    public void inputFirstName(String firstName){
        firstNameField.sendKeys(firstName);
    }

    public void inputLastName(String lastName){
        lastNameField.sendKeys(lastName);
    }

    public void inputPostalCode(String postalCode){
        postalCodeField.sendKeys(postalCode);
    }

    public void clickContinue(){continueButton.click();}

    public String getSubTotal(){
        return subTotalSection.getText();
    }

    public String getTax(){
        return taxSection.getText();
    }

    public String getTotal(){
        return totalSection.getText();
    }

    public void clickFinish(){finishButton.click();}

    public String getCompleteHeader(){
        return completeHeader.getText();
    }

    public String getErrorMessage(){
        return errorMessage.getText();
    }
}