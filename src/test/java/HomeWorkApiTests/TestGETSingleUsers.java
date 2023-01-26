package HomeWorkApiTests;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class TestGETSingleUsers extends BaseClass {
    @Test
    public void responseTime() {
        var response = given()
                .when()
                .get("/users/2")
                .then()
                .log()
                .body();
        response.assertThat().time(lessThan(600L), TimeUnit.MILLISECONDS);
    }

    @Test
    public void statusCode() {
        var response = given()
                .when()
                .get("/users/2")
                .then()
                .log()
                .body();
        response.assertThat().statusCode(200);
    }

    @Test
    public void getSingleUserIdNumber() {
        var response = given()
                .when()
                .get("/users/2")
                .then()
                .log()
                .body();
        response.assertThat().body("data.id", equalTo(2));
    }

    @Test
    public void getUserFirstName() {
        var response = given()
                .when()
                .get("/users/2")
                .then()
                .log()
                .body();
        response.assertThat().body("data.first_name", equalTo("Janet"));
    }

    @Test
    public void getUserLastName() {
        var response = given()
                .when()
                .get("/users/2")
                .then()
                .log()
                .body();
        response.assertThat().body("data.last_name", equalTo("Weaver"));
    }

    @Test
    public void getUserEmail() {
        var response = given()
                .when()
                .get("/users/2")
                .then()
                .log()
                .body();
        response.assertThat().body("data.email", equalTo("janet.weaver@reqres.in"));
    }

}
