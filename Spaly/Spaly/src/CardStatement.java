

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * CardStatement
 */
public class CardStatement // a class to hold all credit cards 
{
    private ArrayList<CreditCard> cards;

    public CardStatement()
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
            String sql = "SELECT * FROM cardstatement";
            p = conn.prepareStatement(sql);
            rs = p.executeQuery();

            while (rs.next()) {
                int creditcard_id = rs.getInt("creditcard_id");
                String card_number = rs.getString("card_number");
                String card_bank = rs.getString("card_bank");
                int card_limit = rs.getInt("card_limit");
                int user_id = rs.getInt("user_id");
                CreditCard card = new CreditCard(creditcard_id, card_number, card_limit, )
                cards.add();
            }
            p.close();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void addCreditCard(CreditCard c)
    {
        cards.add(c);
    }

    // add a method to hold the total spendings karttan bağmsiz bir şekilde 
}