package Spaly;

public class Category extends Categories
{
    private String name; // the name of the category 
    private double currentSpending; // the total spending so far 
    private CreditCard card;
    private double percentageOfTheCategory;

    public Category(String name, double currentSpendings, CreditCard card)
    {
        super();
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

    public void pieceCalculator() // calculates and stores the percentages of each category
    {
        int sum = 0;
        for(int i = 0; i < super.categories.size(); i++)
        {
            sum =  sum + super.categories.get[i];
        }

        for(int j = 0; j < super.categories.size(); j++)
        {
            super.percentageOfCategories.add[j] = (super.categories.get[j] * 100) / sum;
        }
    }
}
