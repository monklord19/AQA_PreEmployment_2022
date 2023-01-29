package HomeWorkApiTests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.junit.Assert;
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
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post("/login")
                .then()
                .log()
                .body();
        response.assertThat().statusCode(200);
    }

    @Test
    public void tokenIsCreated() {
        var response = given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post("/login")
                .then()
                .extract()
                .response();

        String responseBody = response.asString();
        JsonPath jsonBody = new JsonPath(responseBody);
        Assert.assertEquals(jsonBody.getString("token"),"QpwL5tke4Pnpja7X4");
    }

}
