/**
 * Created by onno on 31-10-2016.
 */
import java.sql.Connection;
import java.sql.DriverManager;
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
            String query = ("insert into customer(usernamecustomer, passwordcustomer, userlevel ,firstname, lastname, birthdate, creditcardinfo, membersince) values('"+ UsernameCustomer+ "', '"+ PasswordCustomer + "', '" + Level+ "', '" + firstname + "', '" + LastName + "', '" + BirthDate + "', '" + CreditCardInfo + "', '" + MemberSince + "');");
            stat.executeUpdate(query);
            System.out.println("test1");
            stat.getConnection().commit();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
            System.out.println("lukt niet");
        }
        System.out.println("test2");

    }
    public void deleteCustomer(String UsernameCustomer){
        try {
            DBC databasePandaShop = new DBC();
            Statement stat = databasePandaShop.Connection();
            String query = ("DELETE FROM Customer WHERE usernameCustomer = " + UsernameCustomer + ";");
            stat.executeUpdate(query);
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

    }
    public void alterCustomer(String columnName, String newData, String UsernameCustomer){

        try {
            DBC databasePandaShop = new DBC();
            Statement stat = databasePandaShop.Connection();
            String query = ("UPDATE Customer SET "+ columnName + " = "+ newData +" WHERE usernamecustomer = "+ UsernameCustomer +";");
            stat.executeUpdate(query);

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
    public void createAdress(String UsernameCustomer, String city, String postalcode, String street, String househumber) {
        try {
            DBC databasePandaShop = new DBC();
            Statement stat = databasePandaShop.Connection();
            String query = ("insert into adress(usernamecustomer, city, postalcode ,street, housenumber) values('"+ UsernameCustomer+ "', '"+ city + "', '" + postalcode+ "', '" + street + "', '" + househumber + "');");
            stat.executeUpdate(query);
            stat.getConnection().commit();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }


    }
    public void deleteAdress(String UsernameCustomer){
        try {
            DBC databasePandaShop = new DBC();
            Statement stat = databasePandaShop.Connection();
            String query = ("DELETE FROM Adress WHERE usernameCustomer = " + UsernameCustomer + ";");
            stat.executeUpdate(query);
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

    }
    public void alterAdress(String columnName, String newData, String UsernameCustomer){

        try {
            DBC databasePandaShop = new DBC();
            Statement stat = databasePandaShop.Connection();
            String query = ("UPDATE Adress SET "+ columnName + " = "+ newData +" WHERE usernamecustomer = "+ UsernameCustomer +";");
            stat.executeUpdate(query);
            stat.getConnection().commit();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
}
