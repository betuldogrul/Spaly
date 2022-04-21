package Spaly;

import java.util.ArrayList;

public class Categories 
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
