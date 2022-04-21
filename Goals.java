import java.util.ArrayList;

public class Goals {
    private ArrayList<Item> goalsitems;//aggragation
    public Goals()
    {
        this.goalsitems = new ArrayList<>();
    }

   

    public void remove(Item item)
    {
        if(item.isInTheGoal())
        {
            for(int i = 0; i < goalsitems.size(); i++)
            {
                if(item == goalsitems.get(i))
                {
                    goalsitems.get(i).setIsTheProductInGoal(false);
                    goalsitems.remove(i);
                    System.out.println("Product successfully removed.");
                }
            }
        }
    }

    public ArrayList<Item> getItemsArrayList()
    {
        return  goalsitems;
    }
}
