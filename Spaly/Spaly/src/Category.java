

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
}
