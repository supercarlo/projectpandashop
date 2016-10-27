import org.apache.log4j.BasicConfigurator;
import spark.Spark;

import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {
        Html html = new Html();
//        DBC dbc = new DBC();

//        dbc.Connection();
        Spark.staticFileLocation("/");

        BasicConfigurator.configure();
//        get("/Main", (req, res) -> "Hello World");
        get("/main", ((request, response) -> html.renderContent("index.html")));
        get("/about", ((request, response) -> html.renderContent("about.html")));
        post("/login", ((request, response) -> {
            html.renderContent("login.html");

            String username = request.queryParams("Username");
            String password = request.queryParams("Password");

            return username + password;
        }));

        get("/register", ((request, response) -> html.renderContent("register.html")));
    }
}