package ApiTests;

import io.restassured.RestAssured;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class HomeworkApiTests {
    @Test
    public void testGetUserList() {
        int n = 300;
        String endpoint = "https://reqres.in/api/users?page=2";
        var response = RestAssured.get(endpoint);
        System.out.println(response.getStatusCode());
        int statCode = response.getStatusCode();
        Assert.assertEquals(statCode, 200);
        if (response.getTime() <= n) {
            System.out.println("It Is good");
        }
        System.out.println("It is not good.Actual response time is " + response.getTime());
        System.out.println(response.getBody().asString());
    }

    @Test
    public void getUserList() {
        String endpoint = "https://reqres.in/api/users?page=2";
        var response = given().get(endpoint).then().statusCode(200).body("data.id[1]",equalTo(8)).log().all();

    }

    @Test
    public void postTestCreateUser() {


        String endpoint = "https://reqres.in/api/users";
        String body = """
                { "name": "morpheus",
                  "job": "leader"
                }
                """;
     var response =   given().body(body).when().post(endpoint).then().log().body().statusCode(201);
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
