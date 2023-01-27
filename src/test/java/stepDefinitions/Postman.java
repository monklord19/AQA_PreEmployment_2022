package stepDefinitions;

import io.cucumber.cienvironment.internal.com.eclipsesource.json.JsonObject;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.json.JSONArray;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class Postman {

    JSONObject json = new JSONObject();

    @Given("User is on")
    public void onReqresHomepage() {
        RestAssured.baseURI = "https://reqres.in";
    }

    @When("Clicks list users")
    public void listAllUsers() {
        given().get("/api/users?page=2");
    }

    @Then("The users should appear")
    public void showAllUsers() {
        given().get("/api/users?page=2").then().statusCode(200).body("data.id[1]", equalTo(8)).time(Matchers.lessThan(3000L));
    }

    //2nd scenario
    @Given("User is on reqres")
    public void reqresHomepage() {
        RestAssured.baseURI = "https://reqres.in";
    }

    @When("User clicks on create button")
    public void clickCreateButton() {
        given().post("/api/users");
    }

    @Then("A new user should be created")
    public void userCreated() {
        given().get("/api/users").then().statusCode(200).assertThat().body("data.id[1]", equalTo(2)).time(Matchers.lessThan(3000L));
    }

    //3rd scenario
    @Given("User is on the reqres homepage")
    public void onTheReqresHomepage() {
        RestAssured.baseURI = "https://reqres.in";
    }

    @When("User clicks on get single user")
    public void getUserEight() {
        given().get("/api/users/8");
    }

    @Then("User 8 info should appear")
    public void getUserEightInfo() {
        given().when().get().then().time(lessThan(2500L)).log().body();
    }

    //4th scenario
    @Given("User is on reqres homepage")
    public void ReqresLandingPage(){
        RestAssured.baseURI = "https://reqres.in";
    }
    @When("User clicks update")
    public void updateUserInfo() {

    }
    @Then("User is updated")
    public void userIsUpdated() {
        JSONObject request = new JSONObject();
        request.put("name", "Test");
        request.put("job", "Tester");
        System.out.println(request);
        System.out.println(json.toString());
        given().body(json.toString()).when().patch("/api/users/2").then().statusCode(200).time(Matchers.lessThan(2000L));
    }
    //5th scenario
    @Given("User is on reqres landing page")
    public void onHomepage() {
        RestAssured.baseURI = "https://reqres.in";
    }

    @When("User clicks register")
    public void clickRegister() {

    }

    @Then("User should be registered")
    public void registerUser() {
        JSONObject request = new JSONObject();
        request.put("email", "eve.holt@reqres.in");
        request.put("password", "pistol");
        System.out.println(request);
        System.out.println(json.toString());
        given().body(json.toString()).when().post("/api/register").then().statusCode(200).time(Matchers.lessThan(1500L));
    }
}
