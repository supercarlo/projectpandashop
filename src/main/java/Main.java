import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;
import org.apache.log4j.BasicConfigurator;
import spark.Spark;

import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {
        Html html = new Html();
        SqlQueries sql = new SqlQueries();
        DBC dbc = new DBC();

        dbc.Connection();
        Spark.staticFileLocation("/");
        BasicConfigurator.configure();

//        get("/Main", (req, res) -> "Hello World");
        get("/main", ((request, response) -> html.renderContent("index.html")));
        get("/about", ((request, response) -> html.renderContent("about.html")));
        get("/register", ((request, response) -> html.renderContent("register.html")));
        post("/login", ((request, response) -> {
            String login = null;

            String username = request.queryParams("Username");
            String password = request.queryParams("Password");

            int level = sql.login(username, password);

            if (level == 0) {
//                Not a register
                System.out.println("Dont");
                login = "Fuck off";
            } else if (level == 1) {
//                Incorrect password
                System.out.println("Incorrect password");
                login = "Wrong password";
            } else if (level == 2) {
//                Correct info as normal user
                System.out.println("Login as user");
                login = "User";
            } else if (level == 3) {
//                Correct info as admin
                System.out.println("Login as admin");
                login = "Admin";
            }
            return login;
        }));

        post("/register", (request, response) -> {
            String register = null;


            String firstname = request.queryParams("Firstname");
            String lastname = request.queryParams("Lastname");
            String username = request.queryParams("Username");
            String password = request.queryParams("Password");
            String birthdate = request.queryParams("Birthdate");
            String credicardinfo = request.queryParams("Credicardinfo");
            String membersince = request.queryParams("Membersince");
            String city = request.queryParams("City");
            String postalcode = request.queryParams("Postalcode");
            String street = request.queryParams("Street");
            String housenumber = request.queryParams("Housenumber");

            User customer = new User();
            customer.createCustomer(username, password, " user" , firstname, lastname, birthdate, credicardinfo, membersince );
            customer.createAdress(username, city, postalcode, street, housenumber);



            return register;
        });
    }
}
