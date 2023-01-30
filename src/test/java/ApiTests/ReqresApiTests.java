package ApiTests;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.given;



public class ReqresApiTests {

    public static String baseUrl = "https://reqres.in/api";

    @Test
    public void getUsers(){
        String endpoint = baseUrl + "/users?page=2";
        var page = given().when().get(endpoint).then().assertThat().body("page", equalTo(2));
        page.log().body();
    }

    @Test
    public void getSingleUser(){
        String endpoint = baseURI + "/users/2";
        given().when().get(endpoint).then().log().body();

    }

    @Test
    public void getUserNotFound(){
        String endpoint = baseUrl + "/users/23";
        given().when().get(endpoint).then().log().body();

    }

    @Test
    public void postCreateUser(){
        String endpoint = baseUrl + "/users";
        String body = """
                {
                "name":"morpheus",
                "job":"leader"
                }
                 """;
        given().body(body).when().post(endpoint).then().log().body().statusCode(201);
    }

    @Test
    public void putUpdateUser(){
        String endpoint = baseUrl + "/users/2";
        String body = """
                {
                "name":"morpheus",
                "job":"zion resident"
                }
                 """;
        given().body(body).put(endpoint).then().log().body().statusCode(200);
    }

    @Test
    public void deleteUser(){
        String endpoint = baseUrl + "/users/2";
        given().when().delete(endpoint).then().log().body().statusCode(204);
    }


}
