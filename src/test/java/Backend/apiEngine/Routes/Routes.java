package Backend.apiEngine.Routes;

public enum Routes {
    //ACCOUNT
    Authorize("/Account/v1/Authorized"),
    GenerateToken("/Account/v1/GenerateToken"),
    CreateUser("/Account/v1/User"),
    DeleteUser("/Account/v1/User/"),
    GetUser("/Account/v1/User/"),

    //BOOKSTORE
    GetBooks("/BookStore/v1/Books"),
    AddBooks("/BookStore/v1/Books"),
    DeleteBooks("/BookStore/v1/Books"),
    GetBook("/BookStore/v1/Book"),
    DeleteBook("/BookStore/v1/Book"),
    UpdateBook("/BookStore/v1/Books/");
    private final String url;

    Routes(String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }
}

