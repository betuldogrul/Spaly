package Spaly;

import Spaly.Item;

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
                    //if() user clicked to remove button
                    //System.out.println("Product successfully removed.");
                }
            }
        }
    }

    public void moneyGoes(double money)
    {

    }

    public void moneyGoesAsPercent(double money, int percent)
    {

    }

    public void purchase(Item item)
    {
        if(item.canBuy())
        remove(item);
        System.out.println("Congratulations! User accomplished a goal.");
        System.out.println("Lets set new goals!");
        //saving class will come here
        //decrease total money also
    }
    public ArrayList<Item> getItemsArrayList()
    {
        return  goalsItems;
    }
}
