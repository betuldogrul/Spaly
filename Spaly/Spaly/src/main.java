import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        ShoppingList y = new ShoppingList();
        ArrayList<Item> allItem = ShoppingList.createAllItems();
        ArrayList<Item> k = ShoppingList.search("GoPro - HERO9 Black 5K and 20 MP Streaming Action Camera - Black");
        if(k == null)
        {
            System.out.println("null");
        }
       
       // Profile.registerUser("fatma", "String surname", "fatma12", "String userPassword", "String mail", 10);
        
       // Profile.registerUser("fatma", "String surname", "fatma12", "String userPassword", "String mail", 10);
       // Profile.removeUser(user);
    }
    /* public static void registerUser(String name, String surname, String userName, String userPassword, String mail, int income)
    {
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        final String DbUrl = "jdbc:mysql://localhost:3306/melisa";
        final String username = "root";
        final String password = "74252002";
        PreparedStatement p = null;
        ResultSet rs = null;
        try{
            Connection conn = DriverManager.getConnection(DbUrl, username, password);
            String sql = "INSERT INTO users (userName, userSurname, userUserName, userPassword, userMail, income) VALUES (?, ?, ?, ?, ?, ?)";//taking item to database
            p = conn.prepareStatement(sql);
            p.setString(1, name);
            p.setString(2, surname);
            p.setString(3, userName);
            p.setString(4, userPassword);
            p.setString(5, mail);
            p.setInt(6, income);
            p.executeUpdate();
            conn.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    } */
    
}
