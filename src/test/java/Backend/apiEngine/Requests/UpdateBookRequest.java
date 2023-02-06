package Backend.apiEngine.Requests;

public class UpdateBookRequest {
    public String isbn;
    public String userId;

    public UpdateBookRequest(String userId, String isbn) {
        this.userId = userId;
        this.isbn = isbn;
    }
}
