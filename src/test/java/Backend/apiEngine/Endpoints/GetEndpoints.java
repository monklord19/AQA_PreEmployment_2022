package Backend.apiEngine.Endpoints;

import Backend.Steps.Hooks;
import Backend.apiEngine.Routes.Routes;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class GetEndpoints {
    public static Response getAllBooks(){
        Routes getAllBooksRoute=Routes.GetBooks;
        Response getAllBooksResponse= Hooks.iSetTheRequestSpecifications().get(getAllBooksRoute.getUrl());
        return getAllBooksResponse;
    }
    public static String getBooksISBN(){
        String allBooksResponseAsString=GetEndpoints.getAllBooks().asString();
        List<Map<String,String>> books= JsonPath.from(allBooksResponseAsString).get("books");
        Assert.assertTrue(books.size()>0);
        String bookISBN=books.get(0).get("isbn");
        return bookISBN;
    }
}
