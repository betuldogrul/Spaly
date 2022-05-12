import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Profile{
    static User user;

    public static User isUserVaid(String userName, String passw)//checing user whether login right or wrong and return the user
    {
        ArrayList<User> y = getAllUsers();
        for(int i = 0; i < y.size(); i++)
        {
            if(y.get(i).getPassword().equals(passw) && y.get(i).getUserUserName().equals(userName))
            {
                user = y.get(i);
                return y.get(i);
            }
        }
        for(int i = 0; i < y.size(); i++)
        {
            if(!y.get(i).getPassword().equals(passw) && y.get(i).getUserUserName().equals(userName))
            {
                JOptionPane.showMessageDialog(null,"Wrong password", "InfoBox: " , JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Wrong password");
                return null;
            }
        }
        return null;
    }
    public static User getUser()
    {
        return user;
    }

    public static void registerUser(String name, String surname, String userName, String userPassword, String mail, int income)
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
        Item item = ShoppingList.createAllItems().get(0);
        isUserVaid(userName, userPassword);
        ShoppingList.addToGoal(item);
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
                int income = rs.getInt("income");
                String userUserName = rs.getString("userUserName");
                String userPassword = rs.getString("userPassword");
                int userID = rs.getInt("userID");
                String userName = rs.getString("userName");
                String userSurname = rs.getString("userSurname");
                String email = rs.getString("userMail");
                String userPage = rs.getString("userPage");
                User user = new User(userID,income ,userName, userSurname, userUserName, userPassword, email);
                user.setPic(userPage);
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
            String sql = "DELETE FROM users WHERE userID=" + Profile.getUser().getId();
            p = conn.prepareStatement(sql);
            rs = p.executeQuery();
            p.close();
            conn.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public static String getUserNameFromId(int id)
    {
        String userName = "";
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
        final String DbUrl = "jdbc:mysql://localhost:3306/melisa";
        final String username = "root";
        final String password = "74252002";
        PreparedStatement p = null;
        ResultSet rs = null;
        try{
            Connection conn = DriverManager.getConnection(DbUrl, username, password);
            String sql = "SELECT first_name * FROM users WHERE userID= " + id;
            p = conn.prepareStatement(sql);
            rs = p.executeQuery();

            while (rs.next()) {
                userName = rs.getString("first_name");
            }
            p.close();
            conn.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return username;
    }
}