package UITests;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ResponseBody;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.response.ValidatableResponse;
import io.restassured.path.json.JsonPath;
import org.apache.commons.codec.binary.Base64;
import org.junit.jupiter.api.Assertions;
import org.testng.Assert;

import java.io.File;
import java.util.ArrayList;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class DemoQAPISteps {
    public static final String BASE_URL = "https://demoqa.com/";
    public static RequestSpecification request;
    public Response response;
    public Response responseGetUser;
    private String UserId;
    private String tokenBearer;
    public static ArrayList userBookList;
    File fileBody=new File("src/test/java/Util/PayloadUser.json");
    @Given("user is on DemoQ Swagger address")
    public void userIsOnDemoQSwaggerAddress() {
        RestAssured.baseURI = BASE_URL;
        request = RestAssured.given();
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
    public void iSendValidRequestWithPayload() {
        response =given()
                .contentType(ContentType.JSON)
                .body(fileBody)
                .when()
                .post("Account/v1/User");
         UserId= response.then().extract().path("userID").toString();
        System.out.println(UserId);
    }

    @Then("User is created")
    public void userIsCreated() {
        long time = response.getTime();
        System.out.println(time);
        System.out.println(response.getStatusCode());
        org.testng.Assert.assertTrue(time<2000);
        

    }

    @When("I send userId to delete")
    public void iSendUserIdToDelete() {
        String userId="05ba2493-9d31-4b35-8b79-32899aabdd4c";
        response = RestAssured.given()
                .header("Authorization", "Basic QW5kcmVlYUNhemFuMzpNaW1pMjM0IQ==")
                .contentType(ContentType.JSON)
                .when()
                .delete("/Account/v1/User"+"?UserId="+ UserId);


    }

    @Then("User is deleted")
    public void userIsDeleted() {
        response.then().assertThat().statusCode(204);
        System.out.println(response.body().prettyPrint());
    }

    @When("Send post request with user body")
    public void sendPostRequestWithUserBody() {
        response= (Response) RestAssured.given()
                .contentType(ContentType.JSON)
                .body(fileBody)
                .when()
                .post("Account/v1/Authorized");
    }

    @Then("Status response is OK")
    public void statusResponseIsOK() {
        response.then().assertThat().statusCode(200);
        String bodycontains=response.then().extract().body().asString();
        Assert.assertEquals(bodycontains,"false");

    }

    @When("I send valid request with user details")
    public void iSendValidRequestWithUserDetails() {
        response =given()
                .contentType(ContentType.JSON)
                .body(fileBody)
                .when()
                .post("Account/v1/GenerateToken");
        tokenBearer= response.then().extract().path("token").toString();
        System.out.println(tokenBearer);

    }

    @Then("Token is generated")
    public void tokenIsGenerated() {
        response.then().assertThat().statusCode(200);
        response.then().assertThat().body("status",equalTo("Success"));

    }

    @When("I send get user by id request")
    public void iSendGetUserByIdRequest() {
        String userId="05ba2493-9d31-4b35-8b79-32899aabdd4c";
        response = (Response) RestAssured.given()
                .header("Authorization", "Basic QW5kcmVlYUNhemFuMzpNaW1pMjM0IQ==")
                .contentType(ContentType.JSON)
                .when()
                .get("/Account/v1/User"+"?UserId="+ userId);



    }

    @Then("User is listed")
    public void userIsListed() {
        response.then().assertThat().statusCode(200);
        response.prettyPrint();
    }

    @When("I send post request with token and body")
    public void iSendPostRequestWithTokenAndBody() {
        String credentials ="""
                             {
                             "userName": "AndreeaCazan3",
                             "password": "Mimi234!"
                             }
                             """;
        request.header("Content-Type","application/json");

        Response responseFromToken =request.body(credentials).post("Account/v1/GenerateToken");
        responseFromToken.prettyPrint();

        String jsonString = responseFromToken.getBody().asString();
        String tokenGenerated = JsonPath.from(jsonString).get("token");

        request.header("Authorization","Bearer "+tokenGenerated)
                .header("Content-Type","application/json");

        String addBookDetails= """
                {
                  "userId": "05ba2493-9d31-4b35-8b79-32899aabdd4c",
                  "collectionOfIsbns": [
                    {
                      "isbn": "9781449337711"
                    }
                  ]
                }
                """;

        response= request.body(addBookDetails).post("BookStore/v1/Books");
    }

    @Then("Book isbn is listed")
    public void bookIsbnIsListed() {
        System.out.println("Status code is"+response.getStatusCode());
        Assertions.assertEquals(201,response.getStatusCode());
        response.prettyPrint();
    }

    @When("I send post request with encodedCredentials and body")
    public void iSendPostRequestWithEncodedCredentialsAndBody() {
        String credentials ="AndreeaCazan3:Mimi234!";

        byte[] encodedCredentials = Base64.encodeBase64(credentials.getBytes());
        String encodedCredentialsasString = new String(encodedCredentials);
        System.out.println("Basic "+encodedCredentialsasString);

        request.header("Authorization","Basic "+encodedCredentialsasString);
        String load= """
                {
                  "userId": "05ba2493-9d31-4b35-8b79-32899aabdd4c",
                  "collectionOfIsbns": [
                    {
                      "isbn": "9781593275846"
                    }
                  ]
                }
                """;
        request.header("Content-Type","application/json");
        response= request.body(load).post("BookStore/v1/Books");

    }

    @Then("Book isbn is listed with basic authorisation")
    public void bookIsbnIsListedWithBasicAuthorisation() {
        System.out.println("Status code is"+response.getStatusCode());
        Assertions.assertEquals(201,response.getStatusCode());
        response.prettyPrint();
        response.then().assertThat().body("books[0].isbn",equalTo("9781593275846"));
    }

    @When("I request to delete book from user")
    public void iRequestToDeleteBookFromUser() {

        request.header("Authorization","Basic QW5kcmVlYUNhemFuMzpNaW1pMjM0IQ==");
        String removeBook= """
                {
                  "userId": "05ba2493-9d31-4b35-8b79-32899aabdd4c",
                  "isbn": "9781593275846"
                }
                """;

        request.header("Content-Type","application/json");

         response= request.body(removeBook)
                .delete("/BookStore/v1/Book");
    }

    @Then("Book is deleted successfully")
    public void bookIsDeletedSuccessfully() {
        response.then().assertThat().statusCode(204);

    }

    @When("I send update request")
    public void iSendUpdateRequest() {
        request.header("Authorization",
                        "Basic QW5kcmVlYUNhemFuMzpNaW1pMjM0IQ==")
                .header("Content-Type","application/json");
        String replacementBody= """
                {
                  "userId": "05ba2493-9d31-4b35-8b79-32899aabdd4c",
                  "isbn": "9781593275846"
                }
                """;
        response= request.body(replacementBody)
                .put("/BookStore/v1/Books/9781491950296");

    }

    @Then("Book is updated")
    public void bookIsUpdated() {
        System.out.println("Status code is"+response.getStatusCode());
        Assertions.assertEquals(200,response.getStatusCode());
        response.prettyPrint();
    }

    @When("I sent a delete request with userId")
    public void iSentADeleteRequestWithUserId() {
        String credentials ="AndreeaCazan3:Mimi234!";
        String userId="05ba2493-9d31-4b35-8b79-32899aabdd4c";

        byte[] encodedCredentials = Base64.encodeBase64(credentials.getBytes());
        String encodedCredentialsasString = new String(encodedCredentials);
        System.out.println("Basic "+encodedCredentialsasString);

        request.header("Authorization","Basic "+encodedCredentialsasString);
        request.header("Content-Type","application/json");
        response= request.delete("BookStore/v1/Books"+"?"+userId);


    }

    @Then("Books are deleted for userId")
    public void booksAreDeletedForUserId() {
        response.then().assertThat().statusCode(204);
    }
}
