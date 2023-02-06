package Backend.apiEngine.Endpoints;

import Backend.apiEngine.Requests.UpdateBookRequest;
import Backend.apiEngine.Routes.Routes;
import io.restassured.response.Response;


public class PutEndpoints extends CommonMethods{
    public static Response updateBookResponse () {
        Routes updateBookRoute = Routes.UpdateBook;
        String isbnIHaveInReadingList = GetEndpoints.getBookISBN();
        String userId = PostEndpoints.getUserId();
        String isbnIWishToUpdateTo = "9781593275846";
        UpdateBookRequest updateBookRequest=new UpdateBookRequest(userId,isbnIWishToUpdateTo);
        Response updateBookResponse = CommonMethods.iSetTheRequestSpecifications().pathParam("ISBN", isbnIHaveInReadingList).body(updateBookRequest).when().put(updateBookRoute.getUrl());
        return updateBookResponse;
    }
}
