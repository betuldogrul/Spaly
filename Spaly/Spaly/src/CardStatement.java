import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * CardStatement
 */
public class CardStatement // a class to hold all credit cards which belongs to one user 
{
    private double totalSpending;
    private ArrayList<CreditCard> cards;

    public CardStatement(int userId)
    {
        cards = new ArrayList<>();
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
            String sql = "SELECT * FROM cardstatement WHERE user_id = " + userId;
            p = conn.prepareStatement(sql);
            rs = p.executeQuery();

            while (rs.next()) {
                int creditcard_id = rs.getInt("creditcard_id");
                Double card_number = rs.getDouble("card_number");
                String card_bank = rs.getString("card_bank");
                int card_limit = rs.getInt("card_limit");
                int totalSpentMoney = rs.getInt("totalSpentMoney");
                int user_id = rs.getInt("user_id");
                //public CreditCard(int creditcard_id, double number, double upperLimit, double totalMoney, String cardBank, int userID)
                CreditCard card = new CreditCard(creditcard_id, card_number, card_limit, totalSpentMoney, card_bank, user_id);
                cards.add(card);
            }
            p.close();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        try{
            Connection conn = DriverManager.getConnection(DbUrl, username, password);
            String sql = "SELECT SUM(spending) FROM cardstatement WHERE creditcard_id IN (SELECT creditcard_id FROM credit_card WHERE user_id = " + userId + ")";
            p = conn.prepareStatement(sql);
            rs = p.executeQuery();

            while(rs.next())
            {
                totalSpending = rs.getInt("SUM(spending");
            }

            p.close();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public double getTotalSpending()
    {
        return this.totalSpending;
    }

    public ArrayList<CreditCard> getCards()
    {
        return this.cards;
    }

    public void addCreditCard(CreditCard c)
    {
        cards.add(c);
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
            String sql = "INSERT INTO credit_card VALUES (" + c.getCreditCardId() + "," + c.getCardNumber() + "," +
                             c.getCardBank() + "," + c.getUpperLimit() + "," + c.getTotalSpentMoney() + "," + c.getUserIDOfTheCard();
            p = conn.prepareStatement(sql);
            rs = p.executeQuery();
            p.close();
            conn.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}