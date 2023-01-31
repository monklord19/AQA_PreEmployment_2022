package ApiTests;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;

import static io.restassured.RestAssured.given;

public class ReqresAPITestsinCucumber {

// Scenario 1

    @Given("User opens the reqres.in homepages")
    public void userOpensTheReqresInHomepages() {
        RestAssured.baseURI = "https://reqres.in";
    }

    @When("User wants to list all the users")
    public void userWantsToListAllTheUsers() {
        RequestSpecification httpRequest = given();
        Response response = RestAssured.get("https://reqres.in/api/users?page=2");
    }

    @Then("Status Code equals {int}")
    public void statusCodeEquals(int arg0) {
        Response response = RestAssured.get("https://reqres.in/api/users?page=2");
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
        ResponseBody body = response.getBody();
        System.out.println("Response Body for all the users is: " + body.asString());
    }


//Scenario 2

    @Given("User opens the reqres.in homepage")
    public void userOpensTheReqresInHomepage() {
        RestAssured.baseURI = "https://reqres.in";
    }

    @When("User wants to list one single user")
    public void userWantsToListOneSingleUser() {
        RequestSpecification httpRequest = given();
        Response response = RestAssured.get("https://reqres.in/api/users/2");
    }

    @Then("Status Code is {int}")
    public void statusCodeIs(int arg0) {
        Response response = RestAssured.get("https://reqres.in/api/users/2");
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }

    @And("Single user contains the email as {string}")
    public void singleUserContainsTheEmailAs(String arg0) {
        Response response = RestAssured.get("https://reqres.in/api/users/2");
        String responseBody = response.getBody().asString();
        System.out.println("Response Body for single user is:" + responseBody);
    }


//Scenario 3

    @Given("User is opening the reqres.in homepage")
    public void userIsOpeningTheReqresInHomepage() {
        RestAssured.baseURI = "https://reqres.in";
    }

    @When("User wants to use the PUT method and update a user")
    public void userWantsToUseThePUTMethodAndUpdateAUser() {
        RestAssured.baseURI = "https://reqres.in";
        RequestSpecification request = RestAssured.given();
        String replacementDetails = """
                {
                "name": "morpheus",
                "job": "leader"
                }
                """;
        Response updateUser = request.body(replacementDetails).put("/api/users/2");
}

    @Then("The new user is successfully updated")
    public void theNewUserIsSuccessfullyUpdated() {
        RestAssured.baseURI = "https://reqres.in";
        RequestSpecification request = RestAssured.given();
        String replacementDetails = """
                {
                "name": "morpheus",
                "job": "zion resident"
                }
                """;
        Response updateUser = request.body(replacementDetails).put("/api/users/2");
        Assertions.assertEquals(200, updateUser.getStatusCode());
        System.out.println("The response code is: "+updateUser.getStatusCode());

        String responseBody = updateUser.getBody().asString();
        System.out.println("Response Body for the updated user is:" + responseBody);

    }



//Scenario 4
    @Given("User opens the reqres.in page")
    public void userOpensTheReqresInPage() {
        RestAssured.baseURI = "https://reqres.in";
    }

    @When("User wants to create one user using the POST method")
    public void userWantsToCreateOneUserUsingThePOSTMethod() {
        RestAssured.baseURI = "https://reqres.in";
        RequestSpecification request = RestAssured.given();
        String createUserDetails = """
                {
                "name": "morpheus",
                "job": "leader"
                }
                """;
        Response updateUser = request.body(createUserDetails).post("/api/users");
    }

    @Then("The new user is successfully created")
    public void theNewUserIsSuccessfullyCreated() {
        RestAssured.baseURI = "https://reqres.in";
        RequestSpecification request = RestAssured.given();
        String createUserDetails = """
                {
                "name": "morpheus",
                "job": "leader"
                }
                """;
        Response createUser = request.body(createUserDetails).post("/api/users");
        Assertions.assertEquals(201, createUser.getStatusCode());
        System.out.println("The response code is: "+createUser.getStatusCode());
    }


//Scenario 5

    @Given("User opens the reqres.in website")
    public void userOpensTheReqresInWebsite() {
        RestAssured.baseURI = "https://reqres.in";
    }

    @When("User wants to delete one user using the DELETE method")
    public void userWantsToDeleteOneUserUsingTheDELETEMethod() {
        RequestSpecification request = RestAssured.given();
        Response deleteUser = RestAssured.delete("https://reqres.in/api/users/2");

    }

    @Then("The user is successfully deleted")
    public void theUserIsSuccessfullyDeleted() {
        Response deleteUser = RestAssured.delete("https://reqres.in/api/users/2");
        int statusCode = deleteUser.getStatusCode();
        Assert.assertEquals(statusCode, 204);
        System.out.println("The response code is: " + deleteUser.getStatusCode());
    }



// Scenario 6
    @Given("User opens the reqres.in web page")
    public void userOpensTheReqresInWebPage() {
        RestAssured.baseURI = "https://reqres.in";
    }

    @When("User wants to list one user")
    public void userWantsToListOneUser() {
        RequestSpecification httpRequest = given();
        Response response = RestAssured.get("https://reqres.in/api/users/2");
    }

    @Then("Response equals {int}")
    public void responseEquals(int arg0) {
        Response response = RestAssured.get("https://reqres.in/api/users/2");
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }

    @And("Single user contains {string} as email")
    public void singleUserContainsAsEmail(String arg0) {
        Response response = RestAssured.get("https://reqres.in/api/users/2");
        JsonPath jsonSingleUser = response.jsonPath();
        String email = jsonSingleUser.get("email");
        System.out.println("The new user that has been created has the email address: "+email);
        Assert.assertEquals(email,"janet.weaver@reqres.in", "Correct email received in the response");
    }
}


