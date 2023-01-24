package ApiTests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.testng.Assert;
import java.io.File;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class DemoqApi {
//    @BeforeClass
//    public static void setup(){
//        RestAssured.baseURI = "https://demoqa.com/Account/v1/User";}
    File fileBody=new File("src/test/java/ApiTests/Payload.json");
    File fileBody2=new File("src/test/java/ApiPayload/Payload2.json");
    File fileBody3=new File("src/test/java/ApiTests/Payload3.json");

    @Test
    public void AddUser(){

        Response postResponse = (Response) given().auth().none()
                .header("Content-Type","application/json")
                .contentType(ContentType.JSON)
                .when().body(fileBody)
                .post("https://demoqa.com/Account/v1/User");
       // postResponse.then().assertThat().body("username",equalTo("AndreeaCazan1"))
                postResponse.then().statusCode(201);

        System.out.println(postResponse.asString());
        long time = postResponse.getTime();
        System.out.println(time);
        Assert.assertTrue(time<2000);

    }
    @Test
    public void GetUser(){
        var asd =  given().when().get("/users/2").then().log().body();
        asd.assertThat().body("data.id",equalTo(2));
        asd.assertThat().statusCode(200);
        asd.time(Matchers.lessThan(1500L));

    }
    @Test
    public void UpdateUser(){

        var response = given().auth().none()
                .header("Content-Type","application/json")
                .contentType(ContentType.JSON).
                body(fileBody2).when().put("/users/2").then().log().body();
        response.assertThat().statusCode(200);
        response.assertThat().body("name",equalTo("morpheus"));
        response.time(Matchers.lessThan(2000L));
    }
    @Test

    public void RegisterSuccessful(){

        var response = given().auth().none()
                .header("Content-Type","application/json")
                .contentType(ContentType.JSON).body(fileBody3)
                .when().post("/users").then()
                .extract().response();
        response.then().log().body();
        response.then().assertThat().body("email",equalTo("eve.holt@reqres.in"));

        Assertions.assertEquals(201, response.statusCode());
        long time = response.getTime();
        System.out.println(time);
        Assert.assertTrue(time<1600);
    }
    @Test
    public void DeleteUser(){
        var responde =given().when().delete("users/2").then().log().body();
        responde.assertThat().statusCode(204);
        responde.time(Matchers.lessThan(2000L));

    }
    @Test
    public void getUser404(){
        var response =given().when().get("users/23").then().log().body();
        response.assertThat().statusCode(404);
        response.time(Matchers.lessThan(2000L));
    }
    @Test
    public void getListResource(){
        var response =given().when().get("unknown").then().log().body();
        response.assertThat().statusCode(200);
        response.assertThat().body("total_pages",equalTo(2));
        response.assertThat().body("data.name[1]",equalTo("fuchsia rose"));
        response.time(Matchers.lessThan(2000L));
    }
    @Test
    public void getSingleResource(){
        var response =given().when().get("unknown/2").then().log().body();
        response.assertThat().statusCode(200);
        response.assertThat().body("data.year",equalTo(2001));
        response.time(Matchers.lessThan(2000L));
    }
    @Test
    public void GetUsers() {

        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/users?page=2");
        int statusCode = response.getStatusCode();
        response.then().log().body();
        System.out.println("Print status code:--->" + statusCode);
        // Assert that correct status code is returned.
        Assert.assertEquals(statusCode, 200,
                "Correct status code returned");
        long time = response.getTime();
        System.out.println(time);
        Assert.assertTrue(time < 2000);
        ResponseBody body = response.body();
        String bodyObj = body.asString();
        Assert.assertTrue(bodyObj.contains("page"));
        Assert.assertTrue(bodyObj.contains("per_page"));
        Assert.assertTrue(bodyObj.contains("total"));
        Assert.assertTrue(bodyObj.contains("total_pages"));
        Assert.assertTrue(bodyObj.contains("data"));

        Map<String, String> data = response.jsonPath().getMap("data[1]");
        System.out.println(data.get("first_name"));
        Assert.assertEquals(data.get("first_name"), "Lindsay");
    }
}
