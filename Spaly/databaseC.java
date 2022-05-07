package Spaly;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties; 
    /**
     *
     * @author 1BestCsharp
     */
    public class databaseC {
        
      // init database constants
    private static final String DATABASE_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/melisa";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "74252002";
    private static final String MAX_POOL = "250";

    // init connection object
    private Connection connection;
    // init properties object
    private Properties properties;

    // create properties
    private Properties getProperties() {
        if (properties == null) {
            properties = new Properties();
            properties.setProperty("user", USERNAME);
            properties.setProperty("password", PASSWORD);
            properties.setProperty("MaxPooledStatements", MAX_POOL);
        }
        return properties;
    }
    Connection con = connect();
    ResultSet rs = null;
    String sql = "SELECT * FROM shoping";
   
            p = con.prepareStatement(sql);
            rs = p.executeQuery();

            while (rs.next()) {
 
                String name = rs.getString("name");
                Double price = rs.getDouble("price");
                String website = rs.getString("website");
                String image = rs.getString("image");
                Item item = new Item(name, price, image, website);
                System.out.println(item);
            }

    // connect database
    public Connection connect() {
        if (connection == null) {
            try {
                Class.forName(DATABASE_DRIVER);
                connection = DriverManager.getConnection(DATABASE_URL, getProperties());
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    // disconnect database
    public void disconnect() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
        
    }    
    

