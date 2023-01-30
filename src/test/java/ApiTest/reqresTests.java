package ApiTest;

import io.opentelemetry.sdk.logs.data.Body;
import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class reqresTests {


    public static void setup(){
        RestAssured.baseURI = "https://reqres.in/";
    }

    @Test
    public void getSingleUser(){
        setup();

        //baseURI = "https://reqres.in/";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET, "/api/users/2");

        ResponseBody body = response.getBody();
        System.out.println("The 2nd user is"+body.toString());

        int statusCode = response.getStatusCode();
        System.out.println("Response status code is" + " " + statusCode);
        Assertions.assertEquals(200, statusCode);

        Headers header = response.getHeaders();
        System.out.println("Headers for response are" + " " + header);

        int timeToResponse = Math.toIntExact(response.getTime());
        System.out.println("Time to response is" + " " + timeToResponse);
        get("https://reqres.in/api/users/2").then().assertThat().time(lessThan(500l));
    }

    @Test
    public void getSingleUserNotFound(){
        setup();
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET, "/api/users/23");

        int statusCode = response.getStatusCode();
        System.out.println("Response status code is" + " " + statusCode);
        Assertions.assertEquals(404, statusCode);

        Headers header = response.getHeaders();
        System.out.println("Headers for response are" + " " + header);

        int timeToResponse = Math.toIntExact(response.getTime());
        System.out.println("Time to response is" + " " + timeToResponse);
        get("https://reqres.in/api/users/2").then().assertThat().time(lessThan(500l));

        String body = response.getBody().asString();
        System.out.println(body);
        Assertions.assertEquals("{}", body);
    }

    @Test
    public void getListResource(){
        setup();
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET, "/api/unknow");

        int statusCode = response.getStatusCode();
        System.out.println("Response status code is" + " " + statusCode);
        Assertions.assertEquals(200, statusCode);

        int timeToResponse = Math.toIntExact(response.getTime());
        System.out.println("Time to response is" + " " + timeToResponse);
        get("https://reqres.in/api/users/2").then().assertThat().time(lessThan(500l));


    }

    @Test
    public void getSingleResource(){
        setup();
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET, "/api/unknow/2");

        int statusCode = response.getStatusCode();
        System.out.println("Response status code is" + " " + statusCode);
        Assertions.assertEquals(200, statusCode);

        int timeToResponse = Math.toIntExact(response.getTime());
        System.out.println("Time to response is" + " " + timeToResponse);
        get("https://reqres.in/api/users/2").then().assertThat().time(lessThan(500l));

        String body = response.getBody().asString();
        System.out.println(body);

    }

    @Test
    public void createUser(){
        String endpoint = "https://reqres.in/api/users";
        String body = """
                {
                "name":"morpheus",
                "job":"leader"
                }
                 """;
        given().body(body).when().post(endpoint).then().log().body().statusCode(201);
    }

    @Test
    public void updateUser(){
        String endpoint = "https://reqres.in/api/users/2";
        String body = """       
                {
                 "name": "updatedUser",
                 "job": "updatedJob"
                }
                """;
        var response = given().body(body).when().put(endpoint).then().log().body();
        response.assertThat().body("status", equalTo("success"));
    }

    @Test
    public void deleteUser(){
        String endpoint = "https://reqres.in/api/users/2";
        given().when().delete(endpoint).then().log().body().statusCode(204);
    }

    @Test
    public void getRegisterUnsuccessful(){

        String endpoint = "https://reqres.in/api/register";
        String body = """       
                {
                 "email": "sydney@fife"
                }
                """;
        var response = given().body(body).when().post(endpoint).then().log().body();
        response.assertThat().statusCode(400);
    }

    @Test
    public void getLoginSuccessful(){

        String endpoint = "https://reqres.in/api/login";
        String body = """       
                {
                  "email": "eve.holt@reqres.in",
                  "password": "cityslicka"
                }
                """;
        var response = given().body(body).when().post(endpoint).then().log().body();
        response.assertThat().statusCode(201);
    }
}
