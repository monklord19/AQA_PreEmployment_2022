package Backend.apiEngine.Endpoints;

import Backend.apiEngine.Requests.RemoveBookRequest;
import Backend.apiEngine.Routes.Routes;
import io.restassured.response.Response;

public class DeleteEndpoints {

    public static Response deleteUser(){
        String userId= PostEndpoints.getUserId();
        Routes deleteUserRoute=Routes.DeleteUser;
        Response deleteAUserResponse= CommonMethods.iSetTheRequestSpecifications().when().delete(deleteUserRoute.getUrl()+userId);
        return deleteAUserResponse;
    }
    public static Response deleteABook(){
        String userId=PostEndpoints.getUserId();
        String isbn=GetEndpoints.getBookISBN();
        System.out.println("UserId is: " + userId);
        RemoveBookRequest removeBookRequest=new RemoveBookRequest(userId,isbn);
        Routes deleteABooksRoute=Routes.DeleteBook;
        Response deleteABookResponse=CommonMethods.iSetTheRequestSpecifications().body(removeBookRequest).when().delete(deleteABooksRoute.getUrl());
        return deleteABookResponse;
    }
    public static Response deleteBooks(){
        String userId=PostEndpoints.getUserId();
        Routes deleteBooks=Routes.DeleteBooks;
        Response deleteBooksResponse=CommonMethods.iSetTheRequestSpecifications().queryParam(userId).when().delete(deleteBooks.getUrl());
        return deleteBooksResponse;
    }
}
