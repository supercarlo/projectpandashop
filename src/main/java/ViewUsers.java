import java.io.BufferedWriter;
import java.io.FileWriter;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by wrket on 02-Nov-16.
 */
public class ViewUsers {

    public void method() {


        {
            FileWriter fWriter = null;
            BufferedWriter writer = null;
            try {
                DBC databasePandaShop = new DBC();
                Statement stat = databasePandaShop.Connection();
                String query = ("Select * as ALL_USERS from customer order by id;");
                ResultSet rs = stat.executeQuery(query);
                stat.getConnection().commit();
                String  name = rs.getString("");
                fWriter = new FileWriter("AdminViewUsers.html");
                writer = new BufferedWriter(fWriter);


                String First_half = "<!-- Navigation --><nav class=\"navbar navbar-inverse navbar-fixed-top\">\n" +
                        "<div class=\"container\"><!-- Brand and toggle get grouped for better mobile display -->\n" +
                        "<div class=\"navbar-header\"><button class=\"navbar-toggle\" type=\"button\" data-toggle=\"collapse\" data-target=\"#bs-example-navbar-collapse-1\"> <span class=\"sr-only\">Toggle navigation</span> </button> <button class=\"navbar-toggle\" type=\"button\" data-toggle=\"collapse\" data-target=\"#bs-example-navbar-collapse-2\"> <span class=\"sr-only\">Toggle navigation</span> </button> <a class=\"navbar-brand\" href=\"/main\">Pandashop</a></div>\n" +
                        "<!-- Collect the nav links, forms, and other content for toggling -->\n" +
                        "<div id=\"bs-example-navbar-collapse-1\" class=\"collapse navbar-collapse\">\n" +
                        "<ul class=\"nav navbar-nav\">\n" +
                        "<li><a href=\"/about\">About</a></li>\n" +
                        "<li><a href=\"/login\">Login</a></li>\n" +
                        "<li><a href=\"#\">Contact</a></li>\n" +
                        "</ul>\n" +
                        "<div class=\"collapse navbar-collapse\" align=\"right\">\n" +
                        "<ul>\n" +
                        "<li><form action=\"/login\" method=\"post\" name=\"loginForm\"><input name=\"Username\" required=\"\" type=\"text\" placeholder=\"Username\" /> <input name=\"Password\" required=\"\" type=\"text\" placeholder=\"Password\" /> <input type=\"submit\" value=\"Login\" /></form></li>\n" +
                        "<li><form action=\"/register\" method=\"get\" name=\"registerForm\"><input type=\"submit\" value=\"Register\" /></form></li>\n" +
                        "</ul>\n" +
                        "</div>\n" +
                        "</div>\n" +
                        "<!-- /.navbar-collapse --></div>\n" +
                        "<!-- /.container --></nav>\n" +
                        "<p>Shop Homepage - Start Bootstrap Template</p>\n" +
                        "<!-- Bootstrap Core CSS -->\n" +
                        "<p>&nbsp;</p>\n" +
                        "<!-- Latest compiled and minified CSS -->\n" +
                        "<p>&nbsp;</p>\n" +
                        "<!-- Optional theme -->\n" +
                        "<p>&nbsp;</p>\n" +
                        "<!-- Latest compiled and minified JavaScript -->\n" +
                        "<p>&nbsp;</p>\n" +
                        "<!--<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\" integrity=\"sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa\" crossorigin=\"anonymous\"></script>-->\n" +
                        "<p>&nbsp;</p>\n" +
                        "<div class=\"container\">\n" +
                        "<div class=\"row\">\n" +
                        "<div class=\"col-sm-4 col-lg-4 col-md-4\">\n" +
                        "<h4>Hello admin,</h4>\n" +
                        "<p>&nbsp;</p>\n" +
                        "<h4>&nbsp;</h4>\n" +
                        "<br />";


                String Second_half = "<h4>&nbsp;</h4>\n" +
                        "<h4>&nbsp;</h4>\n" +
                        "<h4>&nbsp;</h4>\n" +
                        "<h4>&nbsp;</h4>\n" +
                        "<h4>&nbsp;</h4>\n" +
                        "<h4>&nbsp;</h4>\n" +
                        "<h4>&nbsp;</h4>\n" +
                        "<h4>&nbsp;</h4>\n" +
                        "<h4>&nbsp;</h4>\n" +
                        "<h4>&nbsp;</h4>\n" +
                        "<h4>&nbsp;</h4>\n" +
                        "<h4>&nbsp;</h4>\n" +
                        "<h4>&nbsp;</h4>\n" +
                        "<h4>&nbsp;</h4>\n" +
                        "<h4><a href=\"#\">Like this template?</a></h4>\n" +
                        "<p>If you like this template, then check out <a href=\"http://maxoffsky.com/code-blog/laravel-shop-tutorial-1-building-a-review-system/\" target=\"_blank\">this tutorial</a> on how to build a working review system for your online store!</p>\n" +
                        "<a class=\"btn btn-primary\" href=\"http://maxoffsky.com/code-blog/laravel-shop-tutorial-1-building-a-review-system/\" target=\"_blank\">View Tutorial</a></div>\n" +
                        "</div>\n" +
                        "</div>\n" +
                        "<!-- /.container -->\n" +
                        "<div class=\"container\"><hr /><!-- Footer --><footer>\n" +
                        "<div class=\"row\">\n" +
                        "<div class=\"col-lg-12\">\n" +
                        "<p>Copyright &copy; Your Website 2014</p>\n" +
                        "</div>\n" +
                        "</div>\n" +
                        "</footer></div>\n" +
                        "<!-- /.container -->\n" +
                        "<p>&nbsp;</p>\n" +
                        "<!-- jQuery -->\n" +
                        "<script src=\"js/jquery.js\"></script>\n" +
                        "<!-- Bootstrap Core JavaScript -->\n" +
                        "<script src=\"js/bootstrap.min.js\"></script>";


                writer.write("<span>This iss your html content here</span>");
                writer.newLine(); //this is not actually needed for html files - can make your code more readable though
                writer.close(); //make sure you close the writer object
            } catch (Exception e) {
                //catch any exceptions here
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
            }
        }
    }
}
