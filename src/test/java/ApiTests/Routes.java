package ApiTests;

public enum Routes {
   //for GET requests
   ListUsersRoute("api/users?page=2"),
   SingleUserRoute("api/users/"),
   ResourceRoute("api/unknown/"),
   DelayedRoute("api/users?delay=3"),

   //for POST requests
   CreateUserRoute("api/users"),
   RegisterRoute("api/register"),
   LoginRoute("api/login"),

   //for PUT, PATCH and DELETE
   UpdateAndDeleteRoute("api/users/");

   private final String url;
   Routes(String url) {
      this.url = url;
   }
   public String getUrl() {
      return this.url;
   }


}
