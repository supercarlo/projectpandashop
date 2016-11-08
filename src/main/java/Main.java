import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.Version;
import org.apache.log4j.BasicConfigurator;
import spark.Spark;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

public class Main {

    public static void main(String[] args) {
        Html html = new Html();
        SqlQueries sql = new SqlQueries();
        DBC dbc = new DBC();
        Map<String, Object> map = new HashMap<>();
        StringWriter writer = new StringWriter();

        final Configuration configuration = new Configuration(new Version(2, 3, 0));
        configuration.setClassForTemplateLoading(Main.class, "/");
        Spark.staticFileLocation("/");
        BasicConfigurator.configure();
        dbc.Connection();

        Spark.get("/main", (request, response) -> {
            Template formTemplate = null;
            String session = request.session().attribute("user");
            String sessionAdmin = request.session().attribute("admin");

            try {
                if (session!= null) {
                    map.put("username", session);
                    formTemplate = configuration.getTemplate("/login.ftl");
                } else if (sessionAdmin != null) {
                    formTemplate = configuration.getTemplate("/Admin_page.ftl");
                } else {
                    formTemplate = configuration.getTemplate("/index.ftl");
                }
                formTemplate.process(map, writer);
            } catch (Exception e) {
                Spark.halt(500);
            }

            return writer;
        });

        post("/login", ((request, response) -> {
            Template login = null;

            String username = request.queryParams("Username");
            String password = request.queryParams("Password");

            int level = sql.login(username, password);

            if (level == 0) {
//                Not a register
            } else if (level == 1) {
//                Incorrect password
            } else if (level == 2) {
//                Correct info as normal user
                request.session().attribute("user", username);
                response.redirect("/main");
            } else if (level == 3) {
//                Correct info as admin
                request.session().attribute("admin", username);
                response.redirect("/main");
            }
            return login;
        }));

        get("/logout", ((request, response) -> {
            request.session().removeAttribute("user");
            response.redirect("/main");
            return null;
        }));

        get("/register", ((request, response) -> html.renderContent("register.ftl")));

    }
}
