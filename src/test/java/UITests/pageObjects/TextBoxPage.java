package UITests.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextBoxPage {

    WebDriver driver;
    public static final String title = "Text Box";
    public static final By fullNameInput = By.id("userName");
    public static final By email = By.id("userEmail");
    public static final By currentAddress = By.id("currentAddress");
    public static final By permanentAddress = By.id("permanentAddress");
    public static final By submitButton = By.id("submit");
    public static final By header = By.className("main-header");
    public static final By output = By.id("output");

    public TextBoxPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getElement(By locator) {
        return driver.findElement(locator);
    }

    public boolean isHeaderDisplayed() {
        return getElement(header).getText().equals(title);
    }

    public void clickSubmitButton() {
        getElement(submitButton).click();
    }

    private WebElement createInputElement(String input) {
        switch (input.toLowerCase()) {
            case "full name":
                return getElement(fullNameInput);
            case "email":
                return getElement(email);
            case "current address":
                return getElement(currentAddress);
            default:
                throw new IllegalArgumentException("Input not found "+ input);
        }
    }

    public void enterTextFor(String input, String text) {
        createInputElement(input).sendKeys(text);
    }

    private boolean isOutputFullNameDisplayed(WebElement container, String name) {
        return container.findElement(By.id("name")).getText().contains(name);
    }

    private boolean isOutputEmailDisplayed(WebElement container, String email) {
        return container.findElement(By.id("email")).getText().contains(email);
    }

    private boolean isOutputCurrentAddressDisplayed(WebElement container, String currentAddress) {
        return container.findElement(By.id("currentAddress")).getText().contains(currentAddress);
    }

    public boolean isOutputDisplayed(String name, String email, String currentAddress) {
        WebElement outputContainer = getElement(output);

        return isOutputFullNameDisplayed(outputContainer, name) &&
                isOutputEmailDisplayed(outputContainer, email) &&
                isOutputCurrentAddressDisplayed(outputContainer, currentAddress);
    }


    public boolean emailInputHasErrors () {
        return getElement(email).getAttribute("class").contains("field-error");
    }
}
