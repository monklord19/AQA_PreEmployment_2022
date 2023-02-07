package Backend.apiEngine.Endpoints;

import Backend.apiEngine.Routes.Routes;
import Configurations.BackendConfigs.BackendPropertiesReader;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class GetEndpoints {

    public static Response getAllBooks() {
        Routes getAllBooksRoute = Routes.GetBooks;
        Response getAllBooksResponse = CommonMethods.iSetTheRequestSpecifications().get(getAllBooksRoute.getUrl());
        return getAllBooksResponse;
    }

    public static String getBookISBN() {
        String allBooksResponseAsString = GetEndpoints.getAllBooks().asString();
        List<Map<String, String>> books = JsonPath.from(allBooksResponseAsString).get("books");
        Assert.assertTrue(books.size() > 0);
        String bookISBN = books.get(0).get("isbn");
        return bookISBN;
    }

    public static Response getABook() {
        String bookISBN = GetEndpoints.getBookISBN();
        Routes getABookRoute = Routes.GetBook;
        Response getABookResponse = CommonMethods.iSetTheRequestSpecifications().queryParam("ISBN", bookISBN).get(getABookRoute.getUrl());
        return getABookResponse;
    }

    public static Response getAUser() {
        String userId = PostEndpoints.getUserId();
        Routes getAUserRoute = Routes.GetUser;
        Response getAUserResponse = CommonMethods.iSetTheRequestSpecifications().get(getAUserRoute.getUrl()+userId);
        return getAUserResponse;
    }
}
