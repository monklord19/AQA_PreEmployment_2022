package ApiTests.model.Requests;

public class UpdateUser {

        public String name;
        public String job;
        public UpdateUser() {
        }
        public UpdateUser(String name, String job) {
            super();
            this.name = name;
            this.job = job;
    }
}
