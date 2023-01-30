package ApiTests;

public enum Routes {
    //ACCOUNT
    Authorize("Account/AccountV1AuthorizedPost"),
    GenerateToken("Account/AccountV1GenerateTokenPost"),


    //BOOKSTORE
    GetBooks("BookStore/BookStoreV1BooksGet"),
    PostBooks("BookStore/BookStoreV1BooksPost"),
    DeleteBooks("BookStore/BookStoreV1BooksDelete"),
    GetBook("BookStore/BookStoreV1BookGet");
    private final String url;

    Routes(String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }
}

