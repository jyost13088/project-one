import controllers.ReimbController;
import controllers.ReimbListController;
import controllers.SessionController;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

public class MainDriver {
    public static void main(String[] args) {

  /************************************************************/
        //Landing.view();
        Javalin app = Javalin.create(javalinConfig -> {
        //   javalinConfig.enableCorsForOrigin("");
            javalinConfig.addStaticFiles("/HTML", Location.CLASSPATH);
        }).start(9000);
        SessionController sessionController = new SessionController();
       // UserController userController = new UserController();
        ReimbListController reimbListController = new ReimbListController();
        ReimbController reimbController = new ReimbController();


        /// :: method reference symbol
        //user endpoints

       app.post("/session", sessionController::login);
       app.get("/session", sessionController::checkSession);
        //list endpoints

        app.get("/reimbList/{userId}", reimbListController::displayAllListForUser);
        app.get("/reimbList", reimbListController::displayAllLists);

        //reimb endpoints

       app.patch("/reimb", reimbController::updateReimb);
       app.put("/reimb", reimbController::createReimb);


    /*

        app.routes(() -> {
                    post("/session", SessionController::checkSession);

           path("{userId}", () -> {
                get(reimbListController::displayAllListForUser);
                path("ReimbList", () -> {
                    // post(reimbController::createReimb);
                    get(reimbListController::displayAllLists);
                    path("Reimb", () -> {
                        post(reimbController::updateReimb);
                        put(reimbController::createReimb);
                    });
                });

                post("/login", userController::login);

            });

        });
*/
    }

}
