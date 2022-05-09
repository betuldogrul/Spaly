import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.cj.xdevapi.Statement;

public class User {
    private int userId;
    private String e_mail;
    private String userName;
    private String password;
    private String pic;
    private String userSurname;
    private String userUserName;
    private int income;


    public User(int id, int income, String userName, String userSurname, String userUserName, String password, String userMail)
    {
        this.income = income;
        this.userId = id;
        this.e_mail = userMail;
        this.userUserName = userUserName;
        this.userSurname = userSurname;
        this.userName = userName;
        this.password = password;
        this.pic = "";
    }
    
    public String getSurname()
    {
        return this.userSurname;
    }

    public void setSurname( String surname)
    {
        Connection conn = null;
        Statement stmt = null;
        try {
           try {
              Class.forName("com.mysql.jdbc.Driver");
           } catch (Exception e) {
              System.out.println(e);
           }
           conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/melisa", "root", "74252002");
           System.out.println("Connection is created successfully:");
           stmt = (Statement) conn.createStatement();
           String query1 = "update users set userSurname='" + surname + "' where userID =" + this.getId();
           ((java.sql.Statement) stmt).executeUpdate(query1);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public void setUserUserName(String userName)
    {
        this.userUserName = userName;
        Connection conn = null;
        Statement stmt = null;
        try {
           try {
              Class.forName("com.mysql.jdbc.Driver");
           } catch (Exception e) {
              System.out.println(e);
           }
           conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/melisa", "root", "74252002");
           System.out.println("Connection is created successfully:");
           stmt = (Statement) conn.createStatement();
           String query1 = "update users set userUserName='" + userName + "' where userID =" + this.getId();
           ((java.sql.Statement) stmt).executeUpdate(query1);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public String getUserUserName()
    {
        return userUserName;
    }

    public void setPic(String pic)
    {
        Connection conn = null;
        Statement stmt = null;
        try {
           try {
              Class.forName("com.mysql.jdbc.Driver");
           } catch (Exception e) {
              System.out.println(e);
           }
           conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/melisa", "root", "74252002");
           System.out.println("Connection is created successfully:");
           stmt = (Statement) conn.createStatement();
           String query1 = "update users set userPage='" + pic + "' where userID =" + this.getId();
           ((java.sql.Statement) stmt).executeUpdate(query1);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        this.pic = pic;
    }

    public int getUserIncome()
    {
        return this.income;
    }
    public String getPic()
    {
        return this.pic;
    }

    public void changePasword(String password)
    {
        this.password = password;
        Connection conn = null;
        Statement stmt = null;
        try {
           try {
              Class.forName("com.mysql.jdbc.Driver");
           } catch (Exception e) {
              System.out.println(e);
           }
           conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/melisa", "root", "74252002");
           System.out.println("Connection is created successfully:");
           stmt = (Statement) conn.createStatement();
           String query1 = "update users set userPassword='" + password + "' where userID =" + this.getId();//"update TABLENAME set TABLELABEL='" +parameter + "'where userID = 1"
           ((java.sql.Statement) stmt).executeUpdate(query1);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public void setUserName(String name)
    {
        this.userName = name;
        Connection conn = null;
        Statement stmt = null;
        try {
           try {
              Class.forName("com.mysql.jdbc.Driver");
           } catch (Exception e) {
              System.out.println(e);
           }
           conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/melisa", "root", "74252002");
           System.out.println("Connection is created successfully:");
           stmt = (Statement) conn.createStatement();
           String query1 = "update users set userPassword='" + password + "' where userID =" + this.getId();
           ((java.sql.Statement) stmt).executeUpdate(query1);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public void setEmail(String email)
    {
        this.e_mail = email;
        Connection conn = null;
        Statement stmt = null;
        try {
           try {
              Class.forName("com.mysql.jdbc.Driver");
           } catch (Exception e) {
              System.out.println(e);
           }
           conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/melisa", "root", "74252002");
           System.out.println("Connection is created successfully:");
           stmt = (Statement) conn.createStatement();
           String query1 = "update users set userMail='" + email + "' where userID =" + this.getId();
           ((java.sql.Statement) stmt).executeUpdate(query1);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public String getUserName()
    {
        return this.userName;
    }

    public String getMail()
    {
        return this.e_mail;
    }
    public String getPassword()
    {
        return this.password;
    }
    public int getId()
    {
        return this.userId;
    }
}
