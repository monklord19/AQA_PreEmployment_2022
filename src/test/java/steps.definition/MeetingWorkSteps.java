package steps.definition;

import ApiTests.ReqResApiFlow;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.JSONObject;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class MeetingWorkSteps extends ReqResApiFlow {
    //steps for getting list of users
    @Given("Getting list of users from reqres site")
    public void gettingListOfUsersFromReqresSite() {
        given().get("https://reqres.in");
    }


    @Then("A single user is extracted")
    public void aSingleUserIsExtracted() {
        given().get("https://reqres.in/api/users?page=2").then().assertThat().body("data.id[1]", equalTo(8)).log().all();
    }
    // steps for create user

    @Given("Creating users on reqres site")
    public void creatingUsersOnReqresSite() {
        given().get("https://reqres.in");

    }

    @When("Response time and status are ok")
    public void responseTimeAndStatusAreOk() {
        getStatus();
        getResponseTime();
    }

    @Then("User is created")
    public void userIsCreated() {
        JSONObject request = new JSONObject();
        request.put("name", "Iulian");
        request.put("job", "AQA");
        System.out.println(JSONObject.toJSONString(request));
        given()
                .body(request
                .toJSONString())
                .when()
                .post("https://reqres.in/api/users");
    }

}
