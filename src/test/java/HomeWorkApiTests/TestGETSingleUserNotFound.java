package HomeWorkApiTests;


import org.junit.Test;

import static io.restassured.RestAssured.given;

public class TestGETSingleUserNotFound extends BaseClass {
    @Test
    public void getStatusCode() {
        var response = given()
                .when()
                .get("/users/23")
                .then()
                .log()
                .body();
        response.assertThat().statusCode(404);
    }
}
