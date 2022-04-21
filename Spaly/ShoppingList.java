package Spaly;

import java.util.ArrayList;

public class ShoppingList {
    private ArrayList<ArrayList<Item>> items;// this arraylist will be created by using sql
    Goals goal;

    public ShoppingList() {
        items = new ArrayList<ArrayList<Item>>();// using sql it will be created arraylist of items of arraylist 
        //inside arraylist will keep for same product in different website
        //outside will keep different products
    }

    public void addToGoal(Item item) {
        if (goal.getItemsArrayList().size() != 3) {
            targetedItem tItem = new targetedItem(item.getName(), item.getPrice(), item.getImage(), true, item.getWebsite());
            goal.getItemsArrayList().add(tItem);
            System.out.println("Product succesfully added:");
        } else
            System.out.println("User reached maximum goal number!");
    }

    public ArrayList<Item> search(String name) {
        for(int i = 0; i < items.size(); i++)
        {
            // it will take from SQL products and when user search for an item it will bring the desired arrayList
            if(name == items.get(i).get(i).getName())//searched after searching from our arraylist with an for loop we will 
            //return this arraylist and show the user different website for the same products.
            {
               return items.get(i);
            }
        }
            System.out.println("Spaly doesn't have that product yet. Please wait later versions.");
            return null;//if there is no product
    }
}
