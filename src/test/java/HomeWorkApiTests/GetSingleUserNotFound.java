package HomeWorkApiTests;


import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetSingleUserNotFound {
    String endPointUserNotFound = "https://reqres.in/api/users/23";
    @Test
    public void getStatusCode(){
        var response = given().when().get(endPointUserNotFound).then().log().body();
        response.assertThat().statusCode(404);
    }
}
