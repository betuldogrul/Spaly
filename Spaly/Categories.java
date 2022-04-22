package Spaly;

import java.util.ArrayList;

public class Categories //the class to hold the arraylist of the categories in the same credit card status 
{
    private ArrayList<Category> categories;

    private Categories()
    {
        categories  = new ArrayList<Category>();
    }

    public void addToCategories(Category cat)
    {
        categories.add(cat);
    }
}
