package UITests;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import io.restassured.path.json.JsonPath;
import org.apache.commons.codec.binary.Base64;
import org.hamcrest.Matchers;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.testng.Assert;


import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.*;

public class DemoQAPISteps {
    public static final String BASE_URL = "https://demoqa.com/";

    public static String username = "AndreeaCazan33";
    public static String password = "Mimi@@234";
    public static String book="9781491950296";
    public static String replacementbook="9781593275846";
    public static String UserId="aa758a3b-e857-4ce6-8f9a-2308457748a8";
     static String tokenBearer="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6IkFuZHJlZWFDYXphbjMzIiwicGFzc3dvcmQiOiJNaW1pQEAyMzQiLCJpYXQiOjE2NzU3NjIzNjF9.eDmQQtUR9qtI1rXZo27TN-Yyi9eNBLcYxyAbPIrZSBg";
     static Response response;
    @Given("user is on DemoQ Swagger address")
    public void userIsOnDemoQSwaggerAddress() {
        RestAssured.baseURI = BASE_URL;
    }


    @When("I send valid get request")
    public void iSendValidGetRequest() {
        response = given().when().get("BookStore/v1/Books");

    }

    @Then("Books are listed")
    public void booksAreListed() {
        response.then().assertThat().statusCode(200);
        System.out.println(response.body().prettyPrint());

        long time = response.getTime();
        System.out.println(time);
        org.testng.Assert.assertTrue(time<2000);
        response.then().assertThat().body("books[0].isbn",equalTo("9781449325862"));

    }

    @When("I send valid request with payload")
    public String iSendValidRequestWithPayload() {
        JSONObject request = new JSONObject();
        request.put("userName", username);
        request.put("password", password);
        RequestSpecification httpRequest = RestAssured.given();
        response =httpRequest.contentType(JSON)
                .body(request.toJSONString())
                .when()
                .post("Account/v1/User");
        return UserId;
    }

    @Then("User is created")
    public void userIsCreated() {
        UserId = response.then().contentType(JSON).extract().path("userID");
        long time = response.getTime();
        System.out.println(time);
        response.then().statusCode(201).
                time(Matchers.lessThan(2000L)).
                body("username", equalTo(username));
        System.out.println(UserId);
    }

    @When("I send userId to delete")
    public void iSendUserIdToDelete() {

        RequestSpecification httpRequest = RestAssured.given();

        response = httpRequest.
                accept("accept: application/json")
                .header("Authorization", "Bearer "+tokenBearer)
                .header("Content-Type", "application/json")
                .accept("accept: application/json")
                .when()
                .delete("Account/v1/User/"+ UserId);


    }

    @Then("User is deleted")
    public void userIsDeleted() {
        response.then().
                statusCode(204).
                time(Matchers.lessThan(1000L));
        System.out.println(response.body().prettyPrint());
    }

    @When("Send post request with user body")
    public void sendPostRequestWithUserBody() {
        JSONObject request = new JSONObject();
        request.put("userName", username);
        request.put("password", password);
        response= (Response) RestAssured.given()
                .contentType(JSON)
                .body(request.toJSONString())
                .when()
                .post("Account/v1/Authorized");
    }

    @Then("Status response is OK")
    public void statusResponseIsOK() {
        response.then().assertThat().statusCode(200);
        String bodycontains=response.then().extract().body().asString();
        Assert.assertEquals(bodycontains,"true");

    }

    @When("I send valid request with user details")
    public void iSendValidRequestWithUserDetails() {
        RequestSpecification httpRequest = RestAssured.given();
        JSONObject request = new JSONObject();
        request.put("userName", username);
        request.put("password", password);
        response =httpRequest.given()
                .contentType(JSON)
                .body(request.toJSONString())
                .when()
                .post("Account/v1/GenerateToken");
        String jsonString = response.asString();
        tokenBearer = JsonPath.from(jsonString).get("token");

    }

    @Then("Token is generated")
    public void tokenIsGenerated() {
        tokenBearer = response.then().extract().path("token");
        response.then().assertThat().statusCode(200);
        response.then().assertThat().body("status",equalTo("Success"));
        System.out.println(tokenBearer);
        System.out.println(UserId);

    }

    @When("I send get user by id request")
    public void iSendGetUserByIdRequest() {
        RequestSpecification httpRequest = RestAssured.given();
        response = httpRequest.given().
                header("Authorization", "Bearer " + tokenBearer).
                header("Content-Type", "application/json").
                accept("accept: application/json").
                when().
                get("Account/v1/User/"+ UserId);
        System.out.println(UserId);
        System.out.println(tokenBearer);
    }

    @Then("User is listed")
    public void userIsListed() {
        response.then().
                assertThat().statusCode(200).
                time(Matchers.lessThan(2000L)).
                body("username", equalTo(username)).
                log().all();
    }

    @When("I send post request with token and body")
    public void iSendPostRequestWithTokenAndBody() {
        RequestSpecification httpRequest = RestAssured.given();
        JSONObject request = new JSONObject();
        request.put("userId", UserId);

        JSONObject list = new JSONObject();
        list.put("isbn", book);

        JSONArray array = new JSONArray();
        array.add(list);
        request.put("collectionOfIsbns", array);

        response = httpRequest.
                accept("accept: application/json").
                header("Authorization", "Bearer " + tokenBearer).
                header("Content-Type", "application/json").
                body(request.toJSONString()).
                when().
                post( BASE_URL+"BookStore/v1/Books");
    }

    @Then("Book isbn is listed")
    public void bookIsbnIsListed() {
        System.out.println(tokenBearer);
        response.then().
                statusCode(201).
                time(Matchers.lessThan(2000L));
        response.prettyPrint();
    }

    @When("I send post request with encodedCredentials and body")
    public void iSendPostRequestWithEncodedCredentialsAndBody() {
        RequestSpecification httpRequest = RestAssured.given();
        String credentials ="AndreeaCazan33:Mimi@@234";

        byte[] encodedCredentials = Base64.encodeBase64(credentials.getBytes());
        String encodedCredentialsasString = new String(encodedCredentials);
        System.out.println("Basic "+encodedCredentialsasString);

        JSONObject request = new JSONObject();
        request.put("userId", UserId);

        JSONObject list = new JSONObject();
        list.put("isbn", book);

        JSONArray array = new JSONArray();
        array.add(list);
        request.put("collectionOfIsbns", array);


        response=response = httpRequest.
                accept("accept: application/json").
                header("Authorization", "Basic "+encodedCredentialsasString).
                header("Content-Type", "application/json").
                body(request.toJSONString()).
                post("BookStore/v1/Books");

    }

    @Then("Book isbn is listed with basic authorisation")
    public void bookIsbnIsListedWithBasicAuthorisation() {
        System.out.println("Status code is"+response.getStatusCode());
        Assertions.assertEquals(201,response.getStatusCode());
        response.prettyPrint();
        response.then().assertThat().body("books[0].isbn",equalTo(book));
    }

    @When("I request to delete book from user")
    public void iRequestToDeleteBookFromUser() {
        RequestSpecification httpRequest = RestAssured.given();
        JSONObject request = new JSONObject();
        request.put("userId", UserId);
        request.put("isbn", book);

        httpRequest.header("Authorization","Bearer "+tokenBearer);
        httpRequest.header("Content-Type","application/json");

         response= httpRequest.body(request.toJSONString())
                .delete("BookStore/v1/Book");
    }

    @Then("Book is deleted successfully")
    public void bookIsDeletedSuccessfully() {
        response.then().assertThat().statusCode(204);

    }

    @When("I send update request")
    public void iSendUpdateRequest() {
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.header("Authorization",
                        "Bearer "+tokenBearer)
                .header("Content-Type","application/json");
        JSONObject request = new JSONObject();
        request.put("userId", UserId);
        request.put("isbn", replacementbook);
        response= httpRequest.body(request.toJSONString())
                .put("BookStore/v1/Books/"+book);

    }

    @Then("Book is updated")
    public void bookIsUpdated() {
        System.out.println("Status code is"+response.getStatusCode());
        Assertions.assertEquals(200,response.getStatusCode());
        response.prettyPrint();
    }

    @When("I sent a delete request with userId")
    public void iSentADeleteRequestWithUserId() {
        RequestSpecification httpRequest = RestAssured.given();

        httpRequest.
                accept("accept: application/json").
                header("Authorization", "Bearer " + tokenBearer).
                when().
                delete( "BookStore/v1/Books/"+UserId);

    }

    @Then("Books are deleted from userId")
    public void booksAreDeletedFromUserId() {

                response.then().assertThat().statusCode(204).
                time(Matchers.lessThan(1000L));
    }
}
