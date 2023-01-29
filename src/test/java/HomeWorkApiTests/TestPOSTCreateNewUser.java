package HomeWorkApiTests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.Is.isA;

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
    @Test
    public void createNewUserNameAndJob() {
        Response response = given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post("/users")
                .then()
                .extract()
                .response();

        String responseBody = response.asString();
        JsonPath jsonBody = new JsonPath(responseBody);

        Assert.assertEquals(jsonBody.getString("name"), "Radu");
        Assert.assertEquals(jsonBody.getString("job"), "Tech");
        System.out.println(jsonBody.getString("id"));
        System.out.println(jsonBody.getString("createdAt"));
    }

}
