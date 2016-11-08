import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.Version;
import org.apache.log4j.BasicConfigurator;
import spark.Spark;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        final Configuration configuration = new Configuration(new Version(2, 3, 0));
        configuration.setClassForTemplateLoading(Main.class, "/");
        BasicConfigurator.configure();

        Spark.get("/", (request, response) -> {

            StringWriter writer = new StringWriter();

            try {
                Template formTemplate = configuration.getTemplate("/index.html");

                formTemplate.process(null, writer);
            } catch (Exception e) {
                Spark.halt(500);
            }

            return writer;
        });

        Spark.post("/sait", (request, response) -> {
            StringWriter writer = new StringWriter();

            try {
                String name = request.queryParams("name") != null ? request.queryParams("name") : "anonymous";
                String email = request.queryParams("email") != null ? request.queryParams("email") : "unknown";

                Template resultTemplate = configuration.getTemplate("/result.ftl");

                Map<String, Object> map = new HashMap<>();
                map.put("name", name);
                map.put("email", email);

                resultTemplate.process(map, writer);
            } catch (Exception e) {
                Spark.halt(500);
            }

            return writer;
        });
    }
}

//import org.apache.log4j.BasicConfigurator;
//import spark.Spark;
//
//import static spark.Spark.get;
//import static spark.Spark.post;
//
//public class Main {
//    public static void main(String[] args) {
//        Html html = new Html();
//        SqlQueries sql = new SqlQueries();
//        User customer = new User();
//        DBC dbc = new DBC();
//
//        dbc.Connection();
//        Spark.staticFileLocation("/");
//        BasicConfigurator.configure();
//
////        get("/Main", (req, res) -> "Hello World");
//        get("/main", ((request, response) -> html.renderContent("index.html")));
//        get("/about", ((request, response) -> html.renderContent("about.html")));
//        get("/register", ((request, response) -> html.renderContent("register.html")));
//        post("/login", ((request, response) -> {
//            String login = null;
//
//            String username = request.queryParams("Username");
//            String password = request.queryParams("Password");
//
//            int level = sql.login(username, password);
//
//            if (level == 0) {
////                Not a register
//                System.out.println("Dont");
//                login = "Fuck off";
//            } else if (level == 1) {
////                Incorrect password
//                System.out.println("Incorrect password");
//                login = "Wrong password";
//            } else if (level == 2) {
////                Correct info as normal user
//                System.out.println("Login as user");
//                login = "User";
//            } else if (level == 3) {
////                Correct info as admin
//                System.out.println("Login as admin");
//                login = "Admin";
//            }
//            return login;
//        }));
//
//        post("/register", (request, response) -> {
//            String register = null;
//
//
//            String firstname = request.queryParams("firstname");
//            String lastname = request.queryParams("lastname");
//            String username = request.queryParams("username");
//            String password = request.queryParams("password");
//            String birthdate = request.queryParams("birthday");
//            String credicardinfo = request.queryParams("credicardinfo");
//            String membersince = request.queryParams("membersince");
//            String city = request.queryParams("city");
//            String postalcode = request.queryParams("postalcode");
//            String street = request.queryParams("street");
//            String housenumber = request.queryParams("housenumber");
//            String userlevel = "user";
//            System.out.println(firstname);
//            System.out.println(lastname);
//            System.out.println(birthdate);
//
//            boolean testCustomerAvailibility;
//
//
//            testCustomerAvailibility = customer.createCustomer(username, password, userlevel, firstname, lastname, birthdate, credicardinfo, membersince);
//            if (testCustomerAvailibility == true) {
//                customer.createAdress(username, city, postalcode, street, housenumber);
//            }
//            System.out.println(testCustomerAvailibility);
//
//
//            return register;
//        });
//    }
//}
