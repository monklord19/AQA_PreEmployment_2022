package ApiTests;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;

public class SecondApiTests {
    @Test
    public void getAllUsers() {
        String endpoint = "https://reqres.in/api/users?page=2";
        given().when().get(endpoint).then().assertThat().time(lessThan(2500L)).log().body();
    }

    @Test
    public void getUserEight() {
        RestAssured.baseURI = "https://reqres.in/api/users/8";
        RequestSpecification httpRequest = given();
        Response response = httpRequest.get("");
        Headers allHeaders = response.headers();
        for (Header header : allHeaders) {
            System.out.println("Key:" + header.getName() + "Value" + header.getValue());
        }
    }

    @Test
    public void createUniqueIdUser() {
        String endpoint = "https://reqres.in/api/users/";
        String body = """
                {
                "name": "adi",
                "job": "tester"
                }
                """;
        given().body(body).when().post(endpoint).then().log().body();
    }

    @Test
    public void register() {
        String endpoint = "https://reqres.in/api/register";
        String body = """
                {
                 "email": "eve.holt@reqres.in",
                 "password": "pistol"
                }
                """;
        given().body(body).when().post(endpoint).then().time(lessThan(2500L)).log().body();
    }

    @Test
    public void updateUser() {
        String endpoint = "https://reqres.in/api/users/8";
        String body = """
                {
                "name": "morpheus",
                "job": "zion resident"
                }
                """;
        given().body(body).when().put(endpoint).then().log().body();
    }
}

