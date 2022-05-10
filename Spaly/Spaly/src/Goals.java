
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
    private User profile;
    public Goals(User user)
    {
        this.goalsItems = new ArrayList<>();
        this.profile = profile;
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
        Connection conn = null;
        Statement stmt = null;
        double add = item.getCurrentMoney() + money;
        try {
           try {
              Class.forName("com.mysql.jdbc.Driver");
           } catch (Exception e) {
              System.out.println(e);
           }
           conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/melisa", "root", "74252002");
           System.out.println("Connection is created successfully:");
           stmt = (Statement) conn.createStatement();
           String query1 = "update goals set itemMoney='" + add + "' where itemID =" + item.getId() + "and userID = " + profile.getId();
           ((java.sql.Statement) stmt).executeUpdate(query1);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        item.setCurrentMoney(item.getCurrentMoney() + money);
    }

    public void moneyGoesAsPercent(targetedItem item, double money, int percent)
    {
        //this method will take money that user enter manually and add into the account and it should be connected with saving class 
        //since when we put this money into my item it should show in also saving that i have this much money on my items.
        Connection conn = null;
        Statement stmt = null;
        double add = item.getCurrentMoney() + money *(percent/ 100);
        try {
           try {
              Class.forName("com.mysql.jdbc.Driver");
           } catch (Exception e) {
              System.out.println(e);
           }
           conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/melisa", "root", "74252002");
           System.out.println("Connection is created successfully:");
           stmt = (Statement) conn.createStatement();
           String query1 = "update goals set itemMoney='" + add + "' where itemID =" + item.getId() + "and userID = " + profile.getId();
           ((java.sql.Statement) stmt).executeUpdate(query1);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        item.setCurrentMoney(item.getCurrentMoney() + money);
        item.setCurrentMoney(item.getCurrentMoney() + money * percent);
    }

    public void useMoneyFromProduct(targetedItem item, double money)
    {
        //when user needs to spend money from their desired product
        //this method should be connected with spends and savings//update them
        if(item.getCurrentMoney() >= money)
        {
            item.setCurrentMoney(item.getCurrentMoney() - money);
            Connection conn = null;
            Statement stmt = null;
            double remove = item.getCurrentMoney() - money;
        try {
           try {
              Class.forName("com.mysql.jdbc.Driver");
           } catch (Exception e) {
              System.out.println(e);
           }
           conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/melisa", "root", "74252002");
           System.out.println("Connection is created successfully:");
           stmt = (Statement) conn.createStatement();
           String query1 = "update goals set itemMoney='" + remove + "' where itemID =" + item.getId() + "and userID = " + profile.getId();
           ((java.sql.Statement) stmt).executeUpdate(query1);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        item.setCurrentMoney(item.getCurrentMoney() + money);
            
        }
        
        else
        {
            System.out.println("This product doesnt have this much money please lower the money.");
        }
    }
    public void purchaseAddTransitions(targetedItem item)
    {
        Connection conn = null;
        Statement stmt = null;
        try {
            try {
               Class.forName("com.mysql.jdbc.Driver");
            } catch (Exception e) {
               System.out.println(e);
            }
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/melisa", "root", "74252002");
            System.out.println("Connection is created successfully:");
            stmt = (Statement) conn.createStatement();
            String query1 = "delete from  goals " +
            "where id=" + profile.getId() + "and itemID =" + item.getId();
            stmt.executeUpdate(query1);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public void purchase(targetedItem item)
    {
        if(item.canBuy())//if the user has enough money 
        {
            purchaseAddTransitions(item);//add transitions and remove from goals
            remove(item);
            System.out.println("Congratulations! User accomplished a goal.");
            System.out.println("Lets set new goals!");

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
    }

    public ArrayList<targetedItem> getItemsArrayList()//look lter
    {
        ArrayList<Item> k= ShoppingList.createAllItems();
        ArrayList<targetedItem> y = new ArrayList<targetedItem>();
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        final String DbUrl = "jdbc:mysql://localhost:3306/melisa";
        final String username = "root";
        final String password = "74252002";
        PreparedStatement p = null;
        ResultSet rs = null;
        try{
            Connection conn = DriverManager.getConnection(DbUrl, username, password);
            String sql = "SELECT * FROM goals where userID=" + profile.getId();
            p = conn.prepareStatement(sql);
            rs = p.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ItemId");
                double total = rs.getDouble("itemMoney");
                for(int i = 0; i < k.size(); i++)
                {
                    if(k.get(i).getId() == id)
                    {
                        Item item = k.get(i);
                        targetedItem target = new targetedItem(item,true);
                        y.add(target);
                    }
                }
                
            }
            p.close();
            conn.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return y;
    }

}
