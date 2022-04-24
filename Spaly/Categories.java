package Spaly;

import java.util.ArrayList;

public class Categories implements Percentage//the class to hold the arraylist of the categories in the same credit card status 
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
    
    private double sum=0;
    private ArrayList pieces=new ArrayList<>();
    public double  pieceCalculator() {
        for(int i=0;i<categories.size();i++){
            sum+=categories.get(i).getCurrentSpending();
        }
        for(int k=0;k<categories.size();k++){
            pieces.add(categories.get(k).getCurrentSpending()/sum);
        }
    }
}
