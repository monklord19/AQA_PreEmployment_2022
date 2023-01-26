package HomeWorkApiTests;

import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class TestPOSTCreateNewUser extends BaseClass {
    String body = """
            {
            "name": "Radu",
            "job": "Tech"
                }
            """;

    @Test
    public void createNewUserStatus() {
        var response = given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post("/users")
                .then()
                .statusCode(201);
    }
}
