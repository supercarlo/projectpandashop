import java.sql.ResultSet;
import java.sql.Statement;

public class SqlQueries {
    DBC dbc = new DBC();
    Statement stat = dbc.Connection();

    public Integer login(String customerUsername, String customerPassword) {
        int countExistenceofUsername = 0;
        int countExistenceofPassword = 0;
        int countExistenceofadmin = 0;
        int existence = 0;

        try {
            String query = ("select usernamecustomer from Customer where usernamecustomer = '" + customerUsername + "' ;");
            ResultSet rs = stat.executeQuery(query);

            if (rs.next()) {
                countExistenceofUsername ++;
            }
            rs.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

        if (countExistenceofUsername == 1) {
            try {
                String query = ("select passwordcustomer from Customer where usernamecustomer = '" + customerUsername + "'  and passwordcustomer = '" + customerPassword + "' ;");
                ResultSet rs = stat.executeQuery(query);

                if(rs.next()) {
                    countExistenceofPassword ++;

                }
                rs.close();
            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
            }
        }

        if (countExistenceofPassword == 1) {
            try {
                String query = ("select userlevel from Customer where usernamecustomer = '" + customerUsername + "' and userlevel = 'admin';");
                ResultSet rs = stat.executeQuery(query);

                if (rs.next()) {
                    countExistenceofadmin ++;

                }
                rs.close();
            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
            }
        }
        existence = countExistenceofUsername + countExistenceofPassword + countExistenceofadmin;
        return existence;
    }
}