package ApiTests;

import ApiTests.pageObjects.RestApiPage;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class FirstApiTests {

    @Test
    public void getUser() {
        var response = given()
            .when()
            .get(RestApiPage.getUserUrl)
            .then()
            .log()
            .body();

        response
            .assertThat()
            .statusCode(200)
            .body("data.id", equalTo(2))
            .body("data.email", equalTo("janet.weaver@reqres.in"))
            .body("data.first_name", equalTo("Janet"))
            .body("data.last_name", equalTo("Weaver"));
    }

    @Test
    public void getUserNotFound() {
        var response = given()
                .when()
                .get(RestApiPage.getUserNotFoundUrl)
                .then()
                .log()
                .body();

        response
                .assertThat()
                .statusCode(404);
    }

    @Test
    public void postCreateUserTest() {

        var body = """
            {
                "name": "morpheus",
                "job": "leader"
            }
        """;
        var response = given()
                .body(body)
                .when()
                .post(RestApiPage.postUserUrl)
                .then()
                .log()
                .body();

        response
                .assertThat()
                .statusCode(201)
                .body("id", notNullValue());
    }

    @Test
    public void putUpdateUserTest() {
        var body = """
            {
                "name": "morpheus",
                "job": "zion resident"
            }
        """;
        var response = given()
                .body(body)
                .when()
                .put(RestApiPage.putUserUrl)
                .then()
                .log()
                .body();

        response
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void deleteUserTest() {
        var response = given()
                .when()
                .delete(RestApiPage.deleteUserUrl)
                .then()
                .log()
                .body();

        response
                .assertThat()
                .statusCode(204);
    }
}
