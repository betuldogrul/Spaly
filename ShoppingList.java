import java.util.ArrayList;

public class ShoppingList {
    private ArrayList<Item> items;
    Goals goal;
    public void addToGoal(Item item)
    {
        if(goal.getItemsArrayList().size() != 3)
        {
            goal.getItemsArrayList().add(item);
            item.setIsTheProductInGoal(true);
            System.out.println("Product succesfully added:");
        }
        else
        System.out.println("User reached maximum goal number!");
    }
}
