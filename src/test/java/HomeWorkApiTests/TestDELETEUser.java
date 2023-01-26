package HomeWorkApiTests;

import org.junit.Test;

import static io.restassured.RestAssured.given;

public class TestDELETEUser extends BaseClass {

    @Test
    public void deleteUserStatus() {
        var response = given()
                .when()
                .delete("/users/2")
                .then()
                .log()
                .body();
        response.assertThat().statusCode(204);
    }

}
