

import java.util.ArrayList;

public class Categories //the class to hold the arraylist of the categories in the same credit card status 
{
    private ArrayList<Category> categories;
    private double totalMoneySpent;
    private CreditCard card;

    public Categories(CreditCard card)
    {
        categories  = new ArrayList<Category>();
        totalMoneySpent = 0;
        this.card = card;
    }

    public double getTotalMoneySpent()
    {
        return totalMoneySpent;
    }

    public void addToCategories(Category cat)
    {
        categories.add(cat);
    }
    public double totalLimitCalculator(){
        double totalLimit=0;
        for(int i=0;i<categories.size();i++){
            totalLimit+=categories.get(i).getLimitofCategory();
        }
        return totalLimit;
    }
}