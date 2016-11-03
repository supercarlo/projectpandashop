import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by wrket on 03-Nov-16.
 */
@WebServlet("/AdminViewUsers")

public class RequestJavaFunctionByHTML extends HttpServlet {

    @Override

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //MyClass myClass = new MyClass();
        User user = new User();

        if (request.getParameter("Refresh_UserList") != null) {

            try {
                User.selectUsers("ExampleValue");
            } catch (SQLException e) {
                e.printStackTrace();
            }

//        } else if (request.getParameter("button2") != null) {
//
//            myClass.function2();
//
//        } else if (request.getParameter("button3") != null) {
//
//            myClass.function3();

        } else {

            // some code

        }request.getRequestDispatcher("/AdminViewUsers.html").forward(request, response);

    }}