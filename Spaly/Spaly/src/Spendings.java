import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Spendings { // this class is to hold the every spending in a month within an arraylist 

    private ArrayList<Spending> spendings;

    public Spendings() { // consctructor , adds every data to the arraylist
        spendings = new ArrayList<Spending>();
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
            String sql = "SELECT * FROM cardstatement";
            p = conn.prepareStatement(sql);
            rs = p.executeQuery();

            while (rs.next()) {
                int day = rs.getInt("day");
                int month = rs.getInt("month");
                int year = rs.getInt("year");
                int hour = rs.getInt("hour");
                int minute = rs.getInt("minute");
                double expenditure = rs.getInt("spending");
                String company = rs.getString("company");
                String category = rs.getString("category");
                int card_id = rs.getInt("creditcard_id");
                int user_id = rs.getInt("userID");
                Spending spending =  new Spending(day, month, year, hour, minute, expenditure, company, category, card_id, user_id);
                spendings.add(spending);
            }
            p.close();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void addSpending(Spending spending)
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
            String sql = "INSERT INTO cardstatement VALUES (" + spending.getDay() + "," + spending.getMonth() + "," + spending.getYear() + "," + spending.getHour() + 
                            spending.getMinute() + "," + spending.getSpending() +  "," + spending.getCompany() +  "," + spending.getCategory();
            p = conn.prepareStatement(sql);
            p.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}
