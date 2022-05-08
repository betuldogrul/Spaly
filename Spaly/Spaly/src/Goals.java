

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
public class Goals{
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
        item.setCurrentMoney(item.getCurrentMoney() + money);
    }

    public void moneyGoesAsPercent(targetedItem item, double money, int percent)
    {
        //this method will take money that user enter manually and add into the account and it should be connected with saving class 
        //since when we put this money into my item it should show in also saving that i have this much money on my items.
        item.setCurrentMoney(item.getCurrentMoney() + money * percent);
    }

    public void useMoneyFromProduct(targetedItem item, double money)
    {
        //when user needs to spend money from their desired product
        //this method should be connected with spends and savings//update them
        if(item.getCurrentMoney() >= money)
        item.setCurrentMoney(item.getCurrentMoney() - money);
        else
        {
            System.out.println("This product doesnt have this much money please lower the money.");
        }
    }

    public void purchase(targetedItem item)
    {
        if(item.canBuy())//if the user has enough money 
        {
            try {
   
                URI uri= new URI(item.getWebsite());
                
                java.awt.Desktop.getDesktop().browse(uri);//directing to the website of the targetedItem
                System.out.println("Web page opened in browser");
              
               } catch (Exception e) {
                
                e.printStackTrace();
               }
              }
        else//user doesnt have enough money this part may lead user to put money to that item. not sure yet.
        {
            System.out.println("User doesn't have enough money!");
        } 
        //when user want to purchase a product it will lead to the website of the product it will cut the money
        // from the account and it will remove the item from the goals and it will say user to set new goals since user will buy the product from her bank account it will not spend money in
        // here when s/he purchase it will come from the card info
        if(true || false)// this needs to take informtion from spending if the person bought the product it 
        //will come transitions and if the transations happened for that product it should remove the product from the goals.
        {
            remove(item);
            System.out.println("Congratulations! User accomplished a goal.");
            System.out.println("Lets set new goals!");
       
        }
        //saving class will come here
        //transitions class also releted
        //decrease total money also
    }

    public ArrayList<targetedItem> getItemsArrayList()
    {
        return  goalsItems;
    }

}
