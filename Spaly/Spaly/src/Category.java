import java.sql.*;

public class Category extends Categories // only one card, only one category
{
    private String name; // the name of the category 
    private double currentSpending; // the total spending so far 
    private CreditCard card;
    private double percentageOfTheCategory;
    private double limit;

    public Category(String name, double currentSpendings, double limit, CreditCard card)
    {
        super(card);
        this.name = name;
        this.currentSpending = currentSpendings;
        this.card = card;
        this.limit=limit;
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
            String sql = "INSERT INTO category VALUES(" + card.getCreditCardId() + ", " + name + "," + currentSpendings + "," + limit;
            p = conn.prepareStatement(sql);
            p.executeUpdate();
            conn.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    public String getName()
    {
        return this.name;
    }

    public double getCurrentSpending()
    {
        return currentSpending;
    }

    public CreditCard getCreditCard()
    {
        return this.card;
    }

    public double getPercentageOfTheCategory()
    {
        return percentageOfTheCategory;
    }
    public double getLimitofCategory()
    {
        return limit;
    }
    public void setLimit(double newLimit)
    {
        this.limit=newLimit;
    }
    public void addSpending(int amount)
    {
        currentSpending = currentSpending + amount;
    }

    public double pieceCalculator() // calculates and stores the percentages of each category
    {
        percentageOfTheCategory = currentSpending * 100 / super.getTotalMoneySpent();
        return percentageOfTheCategory;
    }
    public double percentageOfCategorySpendingToLimit()
    {
        return getCurrentSpending()/getLimitofCategory();
    }
}
