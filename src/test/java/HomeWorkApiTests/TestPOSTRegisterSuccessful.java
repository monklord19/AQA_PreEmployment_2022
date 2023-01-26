package HomeWorkApiTests;


import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class TestPOSTRegisterSuccessful extends BaseClass {

    @Test
    public void registerUserSuccessfulStatus() {

        String requestParams = """
                {
                    "email": "eve.holt@reqres.in",
                    "password": "pistol"
                }
                """;

        Response response = given()
                .contentType(ContentType.JSON)
                .body(requestParams)
                .when()
                .post("/register")
                .then()
                .statusCode(200)
                .extract().response();

        String responseBody = response.asString();
        JsonPath jsonBody = new JsonPath(responseBody);

        Assert.assertEquals(jsonBody.getString("id"), "4");
        Assert.assertEquals(jsonBody.getString("token"), "QpwL5tke4Pnpja7X4");

    }

}
