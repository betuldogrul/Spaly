import java.util.ArrayList;

public class Goals {
    private ArrayList<Item> goalsItems;//aggragation
    public Goals()
    {
        this.goalsItems = new ArrayList<>();
    }

   

    public void remove(Item item)
    {
        if(item.isInTheGoal())
        {
            for(int i = 0; i < goalsItems.size(); i++)
            {
                if(item == goalsItems.get(i))
                {
                    goalsItems.get(i).setIsTheProductInGoal(false);
                    goalsItems.remove(i);
                    System.out.println("Product successfully removed.");
                }
            }
        }
    }

    public ArrayList<Item> getItemsArrayList()
    {
        return  goalsItems;
    }
}
