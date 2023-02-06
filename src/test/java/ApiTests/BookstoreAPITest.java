package ApiTests;

import org.junit.Test;
import static io.restassured.RestAssured.given;


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
    @Test
    public void postBookStoreBooks() {
        var body = """
                    {
                               "userId": "152343",
                               "collectionOfIsbns": [
                                 {
                                   "isbn": "72568778"
                                 }
                               ]
                             }
                """;
        var response = given()
                .body(body)
                .when()
                .post(BookstoreAPIpage.postBookStoreBooks)
                .then()
                .log()
                .body();

        response
                .assertThat()
                .statusCode(200);
    }
    @Test
    public void deleteBookStoreBooks() {
        var body = """
                {
                  "isbn": "72568778",
                  "userId": "152343"
                }
                """;

        var response = given()
                .body(body)
                .when()
                .delete(BookstoreAPIpage.deleteBookStoreBooks)
                .then()
                .log()
                .body();

        response
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void getBookStoreBook() {

        var response = given()
                .when()
                .get(BookstoreAPIpage.getBookStoreBook)
                .then()
                .log()
                .body();

        response
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void deleteBookStoreBook() {
        var body = """
                {
                  "isbn": "72568778",
                  "userId": "152343"
                }
                """;

        var response = given()
                .body(body)
                .when()
                .delete(BookstoreAPIpage.deleteBookStoreBook)
                .then()
                .log()
                .body();

        response
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void putBookStoreBooks() {
        var body = """
                    {
                        "isbn": "72568778",
                         "userId": "152343"
                    }
                """;
        var response = given()
                .body(body)
                .when()
                .put(BookstoreAPIpage.putBookStoreBooks)
                .then()
                .log()
                .body();

        response
                .assertThat()
                .statusCode(200);
    }

}
