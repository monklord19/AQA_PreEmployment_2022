package ApiTests;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import netscape.javascript.JSObject;
import org.apache.groovy.parser.antlr4.GroovyParser;
import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class HomeworkApiTests {
    @Test
    public void testGetUserList() {
        int n = 300;
        String endpoint = "https://reqres.in/api/users?page=2";
        var fff = RestAssured.get(endpoint);
        System.out.println(fff.getStatusCode());
        int statCode = fff.getStatusCode();
        Assert.assertEquals(statCode, 200);
        if (fff.getTime() <= n) {
            System.out.println("It Is good");
        }
        System.out.println("It is not good.Actual response time is " + fff.getTime());
        System.out.println(fff.getBody().asString());
    }

    @Test
    public void getUserList() {
        String endpoint = "https://reqres.in/api/users?page=2";
        var fff = given().get(endpoint).then().statusCode(200).body("data.id[1]",equalTo(8)).log().all();

    }

    @Test
    public void postTestCreateUser() {


        String endpoint = "https://reqres.in/api/users";
        String body = """
                { "name": "morpheus",
                  "job": "leader"
                }
                """;
     var fff =   given().body(body).when().post(endpoint).then().log().body().statusCode(201);
    }

    @Test
    public void putUpdateUser() {
        String endpoint = "https://reqres.in/api/users/2";
        String body = """              
                { "name": "Naruto",
                  "job": "Ninja"
                }
                """;
        given().body(body).put(endpoint).then().log().body().statusCode(200);
    }

    @Test
    public void patchUpdatePartiallyUser() {
        String endpoint = "https://reqres.in/api/users/2";
        String body = """              
                { "name": "Jiraya",
                }
                 """;
        given().body(body).when().patch(endpoint).then().log().body().statusCode(200);
    }

    @Test
    public void deleteUser() {
        String endpoint = "https://reqres.in/api/users/2";
        when().delete(endpoint).then().statusCode(204).log().all();

    }


}
