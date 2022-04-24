package Spaly;

public class Category 
{
    private String name; 
    private double currentSpending;
    private CreditCard card;
    private double totalExpenditures;
    private Category(String name, double currentSpendings, CreditCard card)
    {
        this.name = name;
        this.currentSpending = currentSpendings;
        this.card = card;
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

    public void addSpending(int amount)
    {
        currentSpending = currentSpending + amount;
    }
    public double categoryToTotal(){
        return currentSpending/totalExpenditures;
    }
}
