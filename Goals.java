import java.util.ArrayList;

public class Goals {
    private ArrayList<Item> items;//aggragation
    public Goals()
    {
        this.items = new ArrayList<>();
    }

    public void add(Item item)
    {
        if(items.size() != 3)
        {
            items.add(item);
            item.setIsTheProductInGoal(true);
            System.out.println("Product succesfully added:");
        }
        else
        System.out.println("User reached maximum goal number!");
    }

    public void remove(Item item)
    {
        if(item.isInTheGoal())
        {
            for(int i = 0; i < items.size(); i++)
            {
                if(item == items.get(i))
                {
                    items.get(i).setIsTheProductInGoal(false);
                    items.remove(i);
                    System.out.println("Product successfully removed.");
                }
            }
        }
    }
}
