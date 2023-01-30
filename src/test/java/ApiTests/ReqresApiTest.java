package ApiTests;

import io.cucumber.java.en.Given;
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
import static ApiTests.ReqresEndpoint.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ReqresApiTest {
    @BeforeClass
    public static void setup(){
        RestAssured.baseURI = "https://reqres.in/api";}
        File fileBody=new File("src/test/java/ApiPayload/Payload.json");
        File fileBody2=new File("src/test/java/ApiPayload/Payload2.json");
        File fileBody3=new File("src/test/java/ApiPayload/Payload3.json");

    @Test
    public void CreateUser(){

        Response postResponse = (Response) given().auth().none()
                .header("Content-Type","application/json")
                .contentType(ContentType.JSON)
                .when().body(fileBody)
                .post(createUser);
                postResponse.then().assertThat().body("name",equalTo("AndreeaC"))
                        .body("job",equalTo("AQA"))
                        .statusCode(201);

        System.out.println(postResponse.asString());
        long time = postResponse.getTime();
        System.out.println(time);
        Assert.assertTrue(time<2000);

    }
    @Test
    public void GetUser(){
        var response =  given().when().get(getUser).then().log().body();
                response.assertThat().body("data.id",equalTo(2));
                response.assertThat().statusCode(200);
            response.time(Matchers.lessThan(1500L));

    }
    @Test
    public void UpdateUser(){

    var response = given().auth().none()
                .header("Content-Type","application/json")
                .contentType(ContentType.JSON).
            body(fileBody2).when().put(getUser).then().log().body();
    response.assertThat().statusCode(200);
    response.assertThat().body("name",equalTo("morpheus"));
        response.time(Matchers.lessThan(2000L));
    }
    @Test
    public void UpdateUserPatch(){

        var response = given().auth().none()
                .header("Content-Type","application/json")
                .contentType(ContentType.JSON).
                body(fileBody2).when().patch(getUser).then().log().body();
        response.assertThat().statusCode(200);
        response.assertThat().body("name",equalTo("morpheus"));
        response.time(Matchers.lessThan(2000L));
    }
    @Test

    public void RegisterSuccessful(){

        var response = given().auth().none()
                .header("Content-Type","application/json")
                .contentType(ContentType.JSON).body(fileBody3)
                .when().post("/register").then()
                .extract().response();
        response.then().log().body();

        Assertions.assertEquals(200, response.statusCode());
        long time = response.getTime();
        System.out.println(time);
        Assert.assertTrue(time<1600);
    }
    @Test
    public void DeleteUser(){
        var response =given().when().delete(getUser).then().log().body();
        response.assertThat().statusCode(204);
        response.time(Matchers.lessThan(2000L));

    }
    @Test
    public void getUser404(){
        var response =given().when().get(notFoundUser).then().log().body();
        response.assertThat().statusCode(404);
        response.time(Matchers.lessThan(2000L));
    }
    @Test
    public void getListResource(){
        var response =given().when().get(getListResource).then().log().body();
        response.assertThat().statusCode(200);
        response.assertThat().body("total_pages",equalTo(2));
        response.assertThat().body("data.name[1]",equalTo("fuchsia rose"));
        response.time(Matchers.lessThan(2000L));
    }
    @Test
    public void getSingleResource(){
        var response =given().when().get(getSingleResource).then().log().body();
        response.assertThat().statusCode(200);
        response.assertThat().body("data.year",equalTo(2001));
        response.time(Matchers.lessThan(2000L));
    }


    @Test
    public void GetUsers() {

        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get(getUsers);
        int statusCode = response.getStatusCode();
        response.then().log().body();
        System.out.println("Print status code:--->" + statusCode);

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
