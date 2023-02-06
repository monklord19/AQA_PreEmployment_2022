package ApiTests;

import org.junit.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class BookstoreAPITest {

    @Test
    public void getBooksTest() {

        var response = given()
                .when()
                .get(BookstoreAPIpage.getBookStoreBooks)
                .then()
                .log()
                .body();

        response
                .assertThat()
                .statusCode(200);
    }
}
