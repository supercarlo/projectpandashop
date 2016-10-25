import org.apache.log4j.BasicConfigurator;

import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {
        Html html = new Html();
        DBC dbc = new DBC();

        dbc.Conneciton();
        staticFileLocation("/resources");

        BasicConfigurator.configure();
//        get("/Main", (req, res) -> "Hello World");
        get("/Main", (req, res) -> html.renderContent("index.html"));

    }
}