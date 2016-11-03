import org.apache.log4j.BasicConfigurator;
import spark.Spark;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static spark.Spark.get;
import static spark.Spark.post;

public class Main {
    public static void main(String[] args) {
        Html html = new Html();
        SqlQueries sql = new SqlQueries();
        User customer = new User();
        DBC dbc = new DBC();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        String dateToday = dateFormat.format(date);

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


            String firstname = request.queryParams("firstname");
            String lastname = request.queryParams("lastname");
            String username = request.queryParams("username");
            String password = request.queryParams("password");
            String birthYear = request.queryParams("birthyear");
            String birthMonth = request.queryParams("birthmonth");
            String birthDay = request.queryParams("birthday");
            String credicardinfo = request.queryParams("credicardinfo");
            String membersince = request.queryParams("membersince");
            String city = request.queryParams("city");
            String postalcode = request.queryParams("postalcode");
            String street = request.queryParams("street");
            String housenumber = request.queryParams("housenumber");
            String userlevel = "user";


            String birthdate = (birthYear + "-" + birthMonth + "-" + birthDay);



            boolean testCustomerAvailibility;


                testCustomerAvailibility = customer.createCustomer(username, password, userlevel, firstname, lastname, birthdate, credicardinfo, dateToday);
            if (testCustomerAvailibility == true) {
                customer.createAdress(username, city, postalcode, street, housenumber);
            }
            System.out.println(testCustomerAvailibility);

            ArrayList<String> aList = customer.selectUsers("usernamecustomer");


            return register;
        });
    }
}
