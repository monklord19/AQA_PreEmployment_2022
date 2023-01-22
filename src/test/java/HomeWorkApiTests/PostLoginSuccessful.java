package HomeWorkApiTests;

import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PostLoginSuccessful {
    String endPoint = "https://reqres.in/api/users?page=2";
    String body = """
                  {
                  "email": "eve.holt@reqres.in",
                  "password": "cityslicka"
                  }
                  """;

    @Test
    public void loginSuccessful() {
        var response = given().body(body).when().post(endPoint).then().log().body();
        response.assertThat().statusCode(201);
    }
    @Test
    public void idIsCreated(){
        var response = given().body(body).when().post(endPoint).then().log().body();
        response.body
    }
}
