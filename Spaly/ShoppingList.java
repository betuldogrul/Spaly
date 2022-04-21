package Spaly;

import java.util.ArrayList;

public class ShoppingList {
    private ArrayList<ArrayList<Item>> items;// this arraylist will be created by using sql
    Goals goal;

    public ShoppingList() {
        items = new ArrayList<ArrayList<Item>>();// using sql it will be created
    }

    public void addToGoal(Item item) {
        if (goal.getItemsArrayList().size() != 3) {
            Item tItem = new targetedItem(item.getName(), item.getPrice(), item.getImage(), true, item.getWebsite());
            goal.getItemsArrayList().add((targetedItem) tItem);
            item.setIsTheProductInGoal(true);
            System.out.println("Product succesfully added:");
        } else
            System.out.println("User reached maximum goal number!");
    }

    public void search(String name) {
        // it will take from SQL products and when user search for an item it will bring the desired arrayList
    }
}
