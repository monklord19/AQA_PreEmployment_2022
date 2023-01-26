package HomeWorkApiTests;

import io.restassured.response.ValidatableResponse;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestGETListResources extends BaseClass {

    @Test
    public void statusCode() {
        ValidatableResponse response = given()
                .queryParam("page", "1")
                .when()
                .get("/users")
                .then()
                .log()
                .body();
        response.assertThat().statusCode(200);
    }

    @Test
    public void pageNumberListResource() {
        ValidatableResponse response = given()
                .queryParam("page", "2")
                .when()
                .get("/users")
                .then()
                .log()
                .body();
        response.assertThat().body("page", equalTo(2));
    }

    @Test
    public void numberOfUsersOnPage() {
        ValidatableResponse response = given()
                .queryParam("page", "1")
                .when()
                .get("/users")
                .then()
                .log()
                .body();
        response.assertThat().body("per_page", equalTo(6));
    }

    @Test
    public void numberOfUsersThisOnPage() {
        ValidatableResponse response = given()
                .queryParam("page", "1")
                .when()
                .get("/users")
                .then()
                .log()
                .body();
        response.assertThat().body("data.size()", equalTo(6));
    }

}
