package StepDef;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObject.InventoryPage;

import static org.junit.Assert.assertEquals;

public class purchaseSteps {

    private WebDriver webDriver;

    public purchaseSteps(){
        super();
        this.webDriver = Hooks.webDriver;
    }

    @And("user already choose \"(.*)\" as one item")
    public void addItem(String itemName) throws InterruptedException {
        InventoryPage inventoryPage = new InventoryPage(webDriver);
        inventoryPage.chooseItem(itemName);
        Thread.sleep(2000);
        inventoryPage.clickAdd1();
        Thread.sleep(3000);
        inventoryPage.clickBackButton();
        Thread.sleep(2000);
    }

    @When("user sort product list by \"(.*)\"")
    public void sortingProduct(String index) throws InterruptedException {
        InventoryPage inventoryPage = new InventoryPage(webDriver);
        Thread.sleep(3000);
        inventoryPage.sortProduct(index);
        Thread.sleep(3000);

    }

    @And("user pick first \"(.*)\" with Test.allTheThings T-Shirt")
    public void addMoreItem(String item) throws InterruptedException {
        InventoryPage inventoryPage = new InventoryPage(webDriver);
        item = "add-to-cart-test.allthethings()-t-shirt-(red)";
        inventoryPage.clickAddToChart(item);
        Thread.sleep(1000);
    }

    @And("user pick second \"(.*)\" with Sauce Labs Onesie")
    public void addMoreItem2(String item) throws InterruptedException {
        InventoryPage inventoryPage = new InventoryPage(webDriver);
        item = "add-to-cart-sauce-labs-onesie";
        inventoryPage.clickAddToChart(item);
        Thread.sleep(1000);
        inventoryPage.checkCart();
        Thread.sleep(3000);
    }

    @Then("user go to detail cart page and remove last item")
    public void removeItem() throws InterruptedException {
        InventoryPage inventoryPage = new InventoryPage(webDriver);
        inventoryPage.clickRemoveButton();
        Thread.sleep(1000);
        inventoryPage.clickCheckOutButton();
        Thread.sleep(3000);
    }

    @When("user input \"(.*)\" as firstName and \"(.*)\" as lastName and \"(.*)\" as postalCode")
    public void inputDeliveryInfo(String firstName,String lastName,String postalCode) throws InterruptedException {
        InventoryPage inventoryPage = new InventoryPage(webDriver);
        inventoryPage.inputFirstName(firstName);
        Thread.sleep(1000);
        inventoryPage.inputLastName(lastName);
        Thread.sleep(1000);
        inventoryPage.inputPostalCode(postalCode);
        Thread.sleep(1000);
        inventoryPage.clickContinue();
        Thread.sleep(3000);
    }

    @Then("user will see \"(.*)\" as expected itemTotal and \"(.*)\" as expected tax")
    public void verifySubTotalAndTax(String itemTotal,String tax){
        InventoryPage inventoryPage = new InventoryPage(webDriver);
        Assert.assertEquals(itemTotal,inventoryPage.getSubTotal());
        Assert.assertEquals(tax,inventoryPage.getTax());
    }

    @And("user will see \"(.*)\" as expected total")
    public void verifyTotal(String total) throws InterruptedException {
        InventoryPage inventoryPage = new InventoryPage(webDriver);
        Assert.assertEquals(total,inventoryPage.getTotal());
        Thread.sleep(3000);
        inventoryPage.clickFinish();
    }

    @Then("user go to finish page and will see \"(.*)\" as completeHeader")
    public void verifyCompleteHeader(String completeHeader) throws InterruptedException {
        InventoryPage inventoryPage = new InventoryPage(webDriver);
        Assert.assertEquals(completeHeader,inventoryPage.getCompleteHeader());
        Thread.sleep(5000);
    }

    @Then("user will get \"(.*)\" on checkout page")
    public void verifyErrorMessage(String errorText){
        InventoryPage inventoryPage = new InventoryPage(webDriver);
        assertEquals(errorText,inventoryPage.getErrorMessage());
    }

}