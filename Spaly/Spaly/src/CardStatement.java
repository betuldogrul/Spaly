

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
    }

    public void addCreditCard(CreditCard c)
    {
        cards.add(c);
    }

    // add a method to hold the total spendings karttan bağmsiz bir şekilde 
}