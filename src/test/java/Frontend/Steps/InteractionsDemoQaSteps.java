package Frontend.Steps;

import Frontend.PageObjects.InteractionsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;

public class InteractionsDemoQaSteps extends TestBase {
    InteractionsPage interactionsPage = PageFactory.initElements(driver, InteractionsPage.class);

    @And("I click on Interactions section")
    public void i_click_on_interactions_section() {
        interactionsPage.clickOnInteractionsSection();
    }

    @And("I go to Resizable section")
    public void i_go_to_resizable_section() throws InterruptedException {
        interactionsPage.clickOnResizableCategory();
    }

    @When("I resize the box without restrictions")
    public void i_resize_the_box_without_restrictions() throws InterruptedException {
        interactionsPage.resizeTheBoxWithoutRestrictions();
    }

    @Then("The box is resized")
    public void the_box_is_resized() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    //DROPPABLE SECTION
    @And("I click on droppable section")
    public void iClickOnDroppableSection() throws InterruptedException {
        interactionsPage.iClickOnDroppableSection();
    }

    @When("I perform drag and drop action")
    public void iPerformDragAndDropAction() {
        interactionsPage.performDragAndDropAction();
    }

    @Then("drag me element is successfully moved to drop element")
    public void dragMeElementIsSuccessfullyMovedToDropElement() {
        interactionsPage.assertDragIsMovedToDrop();
    }
}
