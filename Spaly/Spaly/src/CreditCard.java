import java.sql.*;

public class CreditCard extends CardStatement
{
    private int creditcard_id;
    private String cardNumber;
    private double upperLimit;
    private double totalSpentMoney;
    private String cardBank;
    private int userid;
    public static int numberOfCards = 0;

    public CreditCard(int creditcard_id, String number, double upperLimit, double totalMoney, String cardBank, int userID)
    {
        super();
        this.creditcard_id = creditcard_id;
        this.cardNumber = number;
        this.upperLimit = upperLimit;
        this.totalSpentMoney = totalMoney;
        this.cardBank = cardBank;
        this.userid = userID;
        numberOfCards++;
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
            String sql = "INSERT INTO creditcard VALUES (? , ? , ?, ? ,? ) ";
            p = conn.prepareStatement(sql);
            p.setInt(1, creditcard_id);
            p.setString(2, number);
            p.setDouble(3, upperLimit);
            p.setDouble(4, totalMoney);
            p.setString(5, cardBank);
            p.setInt(6, userID);
            p.executeUpdate();
            conn.close();
        } 
        catch (Exception e) 
        {
            System.out.println(e);
        }
    }

    public int getCreditCardId()
    {
        return this.creditcard_id;
    }

    public String getCardNumber()
    {
        return cardNumber;
    }

    public double getUpperLimit()
    {
        return this.upperLimit;
    }

    public double getTotalSpentMoney()
    {
        return this.totalSpentMoney;
    }

    public String getCardBank() 
    {
        return this.cardBank;
    }

    public int getUserIDOfTheCard()
    {
        return this.userid;
    }

    public double addMoneyToCard(double amount)
    {
        totalSpentMoney = totalSpentMoney + amount;
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
            String sql = "UPDATE creditcard SET totalSpentMoney=" + totalSpentMoney + " WHERE user_id=" + this.userid;
            p = conn.prepareStatement(sql);
            p.executeUpdate();
            conn.close();
        } 
        catch (Exception e) 
        {
            System.out.println(e);
        }
        return totalSpentMoney;
    }

    public double removeMoneyFromCard(double amount)
    {
        totalSpentMoney = totalSpentMoney - amount;
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
            String sql = "UPDATE creditcard SET totalSpentMoney=" + totalSpentMoney + " WHERE user_id=" + this.userid;
            p = conn.prepareStatement(sql);
            p.executeUpdate();
            conn.close();
        } 
        catch (Exception e) 
        {
            System.out.println(e);
        }
        return totalSpentMoney;
    }

    //A method to interact with the database
}
