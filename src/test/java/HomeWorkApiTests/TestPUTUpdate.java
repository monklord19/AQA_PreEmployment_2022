package HomeWorkApiTests;

import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.Is.isA;

public class TestPUTUpdate extends BaseClass {
    String body = """
            {
              "first_name": "Radu",
              "job": "Cluj"
            }
            """;

    @Test
    public void updateUserSuccessfulStatus() {
        var response = given()
                .body(body)
                .when()
                .put("/users/2")
                .then()
                .log()
                .body();
        response.assertThat().statusCode(200);
    }

    @Test
    public void updatedAt() {
        var response = given()
                .body(body)
                .when()
                .put("/users/2")
                .then()
                .log()
                .body();
        response.assertThat().body("updatedAt", isA(String.class));
    }
}
