package controllers;
import io.javalin.http.Context;
import models.JsonResponse;
import models.Users;
import services.UserService;




public class SessionController {
   private UserService userService;

    public SessionController(){

        this.userService = new UserService();
    }

    public SessionController(UserService userService){

        this.userService = userService;
    }


    public  void checkSession(Context context) {
        Users user = context.sessionAttribute("user");
        if (user == null) {
            context.json(new JsonResponse(false, "You are not logged in .... redirecting", null));

        } else {
            context.json(new JsonResponse(true, "User is logged in", user));
        }
    }

    public void logout(Context context) {
        context.sessionAttribute("user", null);
        context.json(new JsonResponse(true, "Session has been cleared", null));
    }

    public void login(Context context) {


        JsonResponse jsonResponse;

        Users credentials = context.bodyAsClass(Users.class);
        Users userFromDb = this.userService.validateCredentials(credentials.getUsername(), credentials.getPassword());


        if (userFromDb == null) {
            jsonResponse = new JsonResponse(false, "invalid username or password", null);
        } else {
            context.sessionAttribute("user", userFromDb);
            jsonResponse = new JsonResponse(true, "login successful", userFromDb);
        }
        context.json(jsonResponse);
    }
}


