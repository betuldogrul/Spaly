package Spaly;

import java.sql.ResultSet;

public class Profile 
{
    private ArrayList<User> users;

    public Profile()
    {
       users =  new ArrayList<User>();
       try{
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
            String sql = "SELECT * FROM users";
            p = conn.prepareStatement(sql);
            rs = p.executeQuery();

            while (rs.next()) {
                int user_id = rs.getInt("user_id");
                int income = rs.getInt("income");
                String user_name = rs.getString("username");
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                String userpassword = rs.getString("password");
                String email = rs.getString("email");
                User user = new User(user_id, income, user_name, first_name, last_name, userpassword, email);
                users.add(user);

            }
            p.close();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        } 
    }

    public boolean login(String userName, String userpassword)
    {
        try{
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
            String sql = "SELECT * FROM users WHERE username = " + userName + " AND password = " + userpassword;
            p = conn.prepareStatement(sql);
            rs = p.executeQuery();
            if(rs = "NULL")
            {
                System.out.println("Invalid password or user_id. Please try again.");
            }
            else
            {
                //ana ekrana yönlendir 
            }
            p.close();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        } 
    }

    public void addNewProfile(int id, int income, String userName, String userSurname, String userUserName, String password, String userMail)
    {
        User user = new User(id, income, userName, userSurname, userUserName, password, userMail);
    }
}
