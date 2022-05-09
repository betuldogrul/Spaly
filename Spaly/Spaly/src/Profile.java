import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Profile{

    public static User isUserVaid(String userName, String passw)//checing user whether login right or wrong and return the user
    {
        ArrayList<User> y = getAllUsers();
        for(int i = 0; i < y.size(); i++)
        {
            if(y.get(i).getPassword().equals(passw) && y.get(i).getUserUserName().equals(userName))
            {
                return y.get(i);
            }
        }
        for(int i = 0; i < y.size(); i++)
        {
            if(!y.get(i).getPassword().equals(passw) && y.get(i).getUserUserName().equals(userName))
            {
                System.out.println("Wrong password");
                return null;
            }
        }
        return null;
    }
    public static void registerUser(String name, String surname, String userName, String userPassword, String mail)
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
            String sql = "INSERT INTO users (userName, userSurname, userUserName, userPassword, userMail) VALUES (?, ?, ?, ?, ?)";//taking item to database
            p = conn.prepareStatement(sql);
            p.setString(1, name);
            p.setString(2, surname);
            p.setString(3, userName);
            p.setString(4, userPassword);
            p.setString(5, mail);
            p.executeUpdate();
            conn.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public static ArrayList<User> getAllUsers()
    {
        ArrayList<User> k = new ArrayList<User>();
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
            String sql = "SELECT * FROM users";
            p = conn.prepareStatement(sql);
            rs = p.executeQuery();

            while (rs.next()) {
                String userUserName = rs.getString("userUserName");
                String userPassword = rs.getString("userPassword");
                int userID = rs.getInt("userID");
                String userName = rs.getString("userName");
                String userSurname = rs.getString("userSurname");
                String email = rs.getString("userMail");
                String userPage = rs.getString("userPage");
                User user = new User(userID, userName, userSurname, userUserName, userPassword, email);
                k.add(user);
            }
            p.close();
            conn.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return k;
    }

    public static void removeUser(User user)
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
            String sql = "DELETE FROM users WHERE userID = " + user.getId();
            p = conn.prepareStatement(sql);
            p.executeUpdate();
            p.close();
            conn.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}