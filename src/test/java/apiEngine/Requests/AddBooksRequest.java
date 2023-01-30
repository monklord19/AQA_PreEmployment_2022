package apiEngine.Requests;

import java.util.List;

public class AddBooksRequest {
    public String userId;
    public List<ISBN> collectionOfIsbns;
    public AddBooksRequest(String userId, List<ISBN> collectionOfIsbns) {
        super();
        this.userId = userId;
        this.collectionOfIsbns = collectionOfIsbns;
    }

}
