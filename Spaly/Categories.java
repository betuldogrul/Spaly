package Spaly;

import java.util.ArrayList;

public class Categories extends AllCategories //the class to hold the arraylist of the categories in the same credit card status 
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

}
