package Spaly;

import Spaly.Item;

import java.util.ArrayList;
public class Goals {
    private ArrayList<targetedItem> goalsItems;//aggragation
    public Goals()
    {
        this.goalsItems = new ArrayList<>();
    }

    public void remove(targetedItem item)
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

    public void moneyGoes(targetedItem item, double money)
    {
        //this method will take money that user enter manually and add into the account and it should be connected with saving class 
        //since when we put this money into my item it should show in also saving that i have this much money on my items.
        item.setCurrentMoney(item.getCurrentSaving() + money);
    }

    public void moneyGoesAsPercent(targetedItem item, double money, int percent)
    {
        item.setCurrentMoney(item.getCurrentSaving() + money * percent);
    }

    public void purchase(targetedItem item)
    {
        if(item.canBuy())
        remove(item);
        System.out.println("Congratulations! User accomplished a goal.");
        System.out.println("Lets set new goals!");
        //saving class will come here
        //decrease total money also
    }

    public ArrayList<targetedItem> getItemsArrayList()
    {
        return  goalsItems;
    }
    
}
