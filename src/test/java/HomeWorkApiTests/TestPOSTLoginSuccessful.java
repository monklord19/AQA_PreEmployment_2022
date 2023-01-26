package HomeWorkApiTests;

import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.Is.isA;

public class TestPOSTLoginSuccessful extends BaseClass {

    String body = """
            {
                "email": "eve.holt@reqres.in",
                "password": "cityslicka"
            }
            """;

    @Test
    public void loginSuccessful() {
        var response = given()
                .queryParam("page", "2")
                .body(body)
                .when()
                .post("/users")
                .then()
                .log()
                .body();
        response.assertThat().statusCode(201);
    }

    @Test
    public void idIsCreated() {
        var response = given()
                .queryParam("page", "2")
                .body(body)
                .when()
                .post("/users")
                .then()
                .log()
                .body();
        response.assertThat().body("id", isA(String.class));
    }

}
