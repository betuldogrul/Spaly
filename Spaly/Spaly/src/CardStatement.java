import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * CardStatement
 */
public class CardStatement // a class to hold all credit cards which belongs to one user 
{
    private static double totalSpending;
    private static ArrayList<CreditCard> cards =  new ArrayList<>();;

    public CardStatement()
    {
        cards = getAllCreditCards();
    }

    public static ArrayList<CreditCard> getAllCreditCards() // checked 
    {
        ArrayList<CreditCard> y = new ArrayList<>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
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
            String sql = "SELECT * FROM credit_card WHERE user_id=" + Profile.getUser().getId();
            p = conn.prepareStatement(sql);
            rs = p.executeQuery();

            while (rs.next()) {
                int creditcard_id = rs.getInt("creditcard_id");
                String card_number = rs.getString("cardnumber");
                String card_bank = rs.getString("card_bank");
                int card_limit = rs.getInt("card_limit");
                int totalSpentMoney = rs.getInt("card_totalMoney");
                int user_id = rs.getInt("user_id");
                //public CreditCard(int creditcard_id, double number, double upperLimit, double totalMoney, String cardBank, int userID)
                CreditCard card = new CreditCard(creditcard_id, card_number, card_limit, totalSpentMoney, card_bank, user_id);
                y.add(card);
            }
            p.close();
            conn.close();
            } catch (Exception e) {
                System.out.println(e);
            }
            return y;
    }

    public static void updateTotalSpending() //checked 
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
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
                    String sql = "SELECT SUM(spending) FROM cardstatement WHERE creditcard_id IN (SELECT creditcard_id FROM credit_card WHERE user_id = 1)";
                    p = conn.prepareStatement(sql);
                    rs = p.executeQuery();
        
                    while(rs.next())
                    {
                        totalSpending = rs.getInt("SUM(spending)");
                    }
        
                    p.close();
                    conn.close();
                } catch (Exception e) {
                    System.out.println(e);
                }
                getMonthlySpending();
            }
        
                
            public static double getMonthlySpending() // checked 
            {
                try{
                    Class.forName("com.mysql.cj.jdbc.Driver");
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
                    String sql = "SELECT SUM(spending) FROM cardstatement WHERE creditcard_id IN (SELECT creditcard_id FROM credit_card WHERE user_id = " + Profile.getUser().getId() +  ")";
                    p = conn.prepareStatement(sql);
                    rs = p.executeQuery();
        
                    while(rs.next())
                    {
                        totalSpending = rs.getInt("SUM(spending)");
                    }
        
                    p.close();
                    conn.close();
                } catch (Exception e) {
                    System.out.println(e);
                }
                return totalSpending;
            }

    public static double getDailySpending(Date day) //checked
    {
        Calendar c = Calendar.getInstance();
        c.setTime(day);

        double dailySpending = 0;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
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
            String sql = "SELECT * FROM cardstatement WHERE creditcard_id IN (SELECT creditcard_id FROM credit_card WHERE user_id = " + Profile.getUser().getId() +  ") AND day = " + c.get(Calendar.DATE);

            p = conn.prepareStatement(sql);
            rs = p.executeQuery();

            while(rs.next())
            {
                dailySpending = dailySpending + rs.getInt("spending");
            }
            p.close();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return dailySpending;
    }

    public static ArrayList<CreditCard> getCardsOfUser() //checked
        {
        ArrayList<CreditCard> cards = new ArrayList<CreditCard>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
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
            String sql = "SELECT * FROM credit_card where user_id= " + Profile.getUser().getId();
            p = conn.prepareStatement(sql);
            rs = p.executeQuery();

            while (rs.next()) {
                int creditcard_id = rs.getInt("creditcard_id");
                String card_number = rs.getString("cardnumber");
                String card_bank = rs.getString("card_bank");
                int card_limit = rs.getInt("card_limit");
                int user_id = rs.getInt("user_id");
                //public CreditCard(int creditcard_id, double number, double upperLimit, double totalMoney, String cardBank, int userID)
                CreditCard card = new CreditCard(creditcard_id, card_number, card_limit,0, card_bank, user_id);
                cards.add(card);
            }
            
            p.close();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return cards;
    }

    public void addCreditCard(CreditCard c) //checked 
    {
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
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
            String sql = "INSERT INTO credit_card (creditcard_id, cardnumber, card_bank, card_limit, card_totalMoney, user_id) VALUES (?, ?, ?, ?, ?, ?)";//taking item to database
            p = conn.prepareStatement(sql);
            p.setInt(1, c.getCreditCardId());
            p.setString(2, c.getCardNumber());
            p.setString(3, c.getCardBank());
            p.setDouble(4, c.getUpperLimit());
            p.setDouble(5, c.getTotalSpentMoney());
            p.setInt(6, Profile.getUser().getId());
            p.executeUpdate();
            conn.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        cards.add(c);
    }

    public static CreditCard getSpecifiedCreditCard(String card_number) //checked
            {
                CreditCard c = null;
                try{
                    Class.forName("com.mysql.cj.jdbc.Driver");
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
                    String sql = "SELECT * FROM credit_card WHERE cardnumber = '" + card_number + "'";
                    p = conn.prepareStatement(sql);
                    rs = p.executeQuery();
                    while(rs.next())
                    {
                        int creditcard_id = rs.getInt("creditcard_id");
                        String number = rs.getString("cardnumber");
                        String cardBank = rs.getString("card_bank");
                        int cardLimit = rs.getInt("card_limit");
                        int cardTotalMoney = rs.getInt("card_totalMoney");
                        int user_id = rs.getInt("user_id");
                        c = new CreditCard(creditcard_id, number, cardLimit, cardTotalMoney, cardBank, user_id);
                    }
                    p.close();
                    conn.close();
                }
                catch (Exception e) {
                    System.out.println(e);
                }
                return c;
            }
}