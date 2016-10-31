/**
 * Created by onno on 31-10-2016.
 */
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by onno on 31-10-2016.
 */
public class User {
    public void createCustomer(String UsernameCustomer, String PasswordCustomer, String Level, String firstname, String LastName, String BirthDate, String CreditCardInfo, String MemberSince) {
        try {
            DBC databasePandaShop = new DBC();
            Statement stat = databasePandaShop.Connection();
            String query = (("insert into Customer(usernameCustomer, passwordCustomer, level ,firstname, lastname, birthdate, creditcardinfo membersince) values("+ UsernameCustomer+ ", "+ PasswordCustomer + ", " + Level+ ", " + firstname + ", " + LastName + ", " + BirthDate + ", " + CreditCardInfo + ", " + MemberSince + ""));
            ResultSet rs = stat.executeQuery(query);
            rs.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

    }
    public void deleteCustomer(String UsernameCustomer){
        try {
            DBC databasePandaShop = new DBC();
            Statement stat = databasePandaShop.Connection();
            String query = (("DELETE FROM Customer WHERE usernameCustomer = " + UsernameCustomer + ""));
            ResultSet rs = stat.executeQuery(query);
            rs.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

    }
    public void alterCustomer(String columnName, String newData, String UsernameCustomer){

        try {
            DBC databasePandaShop = new DBC();
            Statement stat = databasePandaShop.Connection();
            String query = (("UPDATE Customer SET "+ columnName + " = "+ newData +" WHERE usernamecustomer = "+ UsernameCustomer +";"));
            ResultSet rs = stat.executeQuery(query);
            rs.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
}
