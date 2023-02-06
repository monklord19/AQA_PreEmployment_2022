package ApiTests;

public class BookstoreAPIpage {
    public static String baseURL = "https://demoqa.com/swagger/#/";

    public static String getBookStoreBooks = baseURL + "BookStore/BookStoreV1BooksGet";
    public static String postBookStoreBooks = baseURL + "BookStore/BookStoreV1BooksPost";
    public static String deleteBookStoreBooks = baseURL + "BookStore/BookStoreV1BooksDelete";
    public static String getBookStoreBook = baseURL + "BookStore/BookStoreV1BookGet";
    public static String deleteBookStoreBook = baseURL + "BookStore/BookStoreV1BookDelete";
    public static String putBookStoreBooks = baseURL + "BookStore/BookStoreV1BooksByISBNPut";
}
