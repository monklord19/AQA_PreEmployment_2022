package ApiTests;

import io.cucumber.java.BeforeAll;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.Matchers.equalTo;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.testng.Assert;
import java.util.Map;
import static io.restassured.RestAssured.given;

public class ReqresApiTest {
    @BeforeClass
    public static void setup(){
        RestAssured.baseURI = "https://reqres.in/api/";}
    @Test
    public void GetUsers(){

        given().when().get("/users?page=2").then().log().body();

        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/users?page=2");
        int statusCode = response.getStatusCode();
        System.out.println("Print status code:--->" + statusCode);
        // Assert that correct status code is returned.
        Assert.assertEquals(statusCode , 200,
                "Correct status code returned");
        long time = response.getTime();
        System.out.println(time);
        Assert.assertTrue(time<500);
        ResponseBody body = response.body();
        String bodyObj = body.asString();
        Assert.assertTrue(bodyObj.contains("page"));
        Assert.assertTrue(bodyObj.contains("per_page"));
        Assert.assertTrue(bodyObj.contains("total"));
        Assert.assertTrue(bodyObj.contains("total_pages"));
        Assert.assertTrue(bodyObj.contains("data"), "My response contains first_name !");

        Map<String, String> data = response.jsonPath().getMap("data[1]");
        System.out.println(data.get("first_name"));
        Assert.assertEquals(data.get("first_name"),"Lindsay");

    }
    @Test
    public void CreateUser(){
        String body = """
                {
                    "name": "AndreeaC",
                    "job": "AQA"
                }
                """;
        var response1 = given().body(body).when().post("/users").then().log().body();
        RequestSpecification httpRequest = RestAssured.given().body(body);
        Response response = httpRequest.post("/users");
        int statusCode = response.statusCode();
        String statusCodeName = response.getStatusLine();
        System.out.println("Print status code:--->" + statusCode);
        System.out.println("Print status line:--->" + statusCodeName);
        // Assert that correct status code is returned.
        Assert.assertEquals(statusCode, 201 ,
                "Correct status code returned");
        Assert.assertEquals(statusCodeName.contains("Created"),true);
    }
    @Test
    public void GetUser(){
        var asd =given().when().get("/users/2").then().log().body();
                asd.assertThat().body("data.id",equalTo(2));
                asd.assertThat().statusCode(200);

        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/users/2");

        long time = response.getTime();
        System.out.println(time);
        Assert.assertTrue(time<500);
    }
    @Test
    public void UpdateUser(){
        String body = """
                {
                    "name": "morpheus",
                    "job": "zion resident"
                }
                """;
        String endpoint = "https://reqres.in/api/users/2";
    var response = given().body(body).when().put(endpoint).then().log().body();
    response.assertThat().statusCode(200);
    //response.assertThat().body("name",equalTo("morpheus"));
    }
    @Test

    public void RegisterSuccessful(){
        String body1 = """
                {
                    "email": "eve.holt@reqres.in",
                    "password": "pistol"
                }
                """;
        String endpoint = "https://reqres.in/api/users";
        var response = given().body(body1).when().post("users").then()
                .extract().response();
        response.then().log().body();

        Assertions.assertEquals(201, response.statusCode());
    }
    @Test
    public void DeleteUser(){
        var responde =given().when().delete("users/2").then().log().body();
        responde.assertThat().statusCode(204);
    }
    @Test
    public void getUser404(){
        var response =given().when().get("users/23").then().log().body();
        response.assertThat().statusCode(404);
    }
    @Test
    public void getListResource(){
        var response =given().when().get("unknown").then().log().body();
        response.assertThat().statusCode(200);
        response.assertThat().body("total_pages",equalTo(2));
        response.assertThat().body("data.name[1]",equalTo("fuchsia rose"));
    }
    @Test
    public void getSingleResource(){
        var response =given().when().get("unknown/2").then().log().body();
        response.assertThat().statusCode(200);
        response.assertThat().body("data.year",equalTo(2001));
    }
}
