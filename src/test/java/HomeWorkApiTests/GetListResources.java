package HomeWorkApiTests;
import io.restassured.path.json.JsonPath;

import static org.hamcrest.Matchers.equalTo;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetListResources {
    String endPointListResourcePage2 = "https://reqres.in/api/users?page=2";

    @Test
    public void statusCode() {
        var response = given().when().get(endPointListResourcePage2).then().log().body();
        response.assertThat().statusCode(200);
    }

    @Test
    public void pageNumberListResource() {
        var response = given().when().get(endPointListResourcePage2).then().log().body();
        response.assertThat().body("page", equalTo(2));
    }

    @Test
    public void numberOfUsersOnPage() {
        var response = given().when().get(endPointListResourcePage2).then().log().body();
        response.assertThat().body("per_page", equalTo(6));
    }

    @Test
    public void numberOfUsersThisOnPage() {
        var response = given().when().get(endPointListResourcePage2);
        JsonPath js = new JsonPath(response.asString());
        int size = js.getInt("data.size()");
        System.out.println(size);
    }


}
