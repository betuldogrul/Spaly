package Spaly;

import java.util.ArrayList;

/**
 * CardStatement
 */
public class CardStatement 
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
}