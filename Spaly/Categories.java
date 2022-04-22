package Spaly;

import java.util.ArrayList;

public class Categories implements Percentage
{
    private ArrayList<Category> categories;
    private double totalMoneySpent;

    public Categories()
    {
        categories  = new ArrayList<Category>();
        totalMoneySpent = 0;
    }

    public double getTotalMoneySpent()
    {
        return totalMoneySpent;
    }

    public void addToCategories(Category cat)
    {
        categories.add(cat);
    }

    public void sumOfMoneyOfCategories()
    {
        totalMoneySpent = 0;
        for(int i = 0; i < categories.size(); i++)
        {
            totalMoneySpent =  totalMoneySpent + categories.get(i).getCurrentSpending();
        }
    }

    @Override
    public double pieceCalculator() 
    {
        return totalMoneySpent;
    }
}
