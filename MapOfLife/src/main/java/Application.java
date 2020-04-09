import io.javalin.Javalin;
import io.javalin.plugin.rendering.vue.VueComponent;
import model.*;
import controller.*;
import repository.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class Application {
    public static void main(String args[]) {
        Javalin app = Javalin.create().start(7001);
        app.config.enableWebjars();
        Repository repository = new Repository("src\\main\\resources\\fileoutput\\repository.json");
        ObservationController observationController = new ObservationController(repository);

        app.get("/observations", new VueComponent("observations-overview"));
        app.get("api/observations", observationController::getAllObservations);
        app.before("/", ctx -> ctx.redirect("/observations"));
        app.get("/observations/create-observation", new VueComponent("observation-create"));

    }




}
