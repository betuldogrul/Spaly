
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

import javax.swing.JOptionPane;
public class Goals{
    private static ArrayList<targetedItem> goalsItems = null;//aggragation
    private User profile;
    public Goals()
    {
    }
    public static double moneyInGoals()
    {
        ArrayList<targetedItem> y = getItemsArrayList();
        double sum = 0;
        for(int i = 0; i < y.size(); i++)
        {
            sum = sum + y.get(i).getCurrentMoney();
        }
        return sum;
    }
    public static void remove(int ID)
    {
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
                String sql = "DELETE FROM goals WHERE userID=" + Profile.getUser().getId() + " and itemID="+ ID;
                p = conn.prepareStatement(sql);
                p.executeUpdate();
                p.close();
                conn.close();
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
            for(int i = 0; i < goalsItems.size(); i++)
            {
                if(ID == goalsItems.get(i).getID())
                {
                    goalsItems.remove(i);
                }
            }
            
        JOptionPane.showMessageDialog(null,"Item successfully deleted from goals!" ,"Info Box" , JOptionPane.INFORMATION_MESSAGE); 
    }

    
    public static void moneyGoes(targetedItem item, double money)
    {
        //this method will take money that user enter manually and add into the account and it should be connected with saving class 
        //since when we put this money into my item it should show in also saving that i have this much money on my items.
        double add = item.getCurrentMoney() + money;
        if(add > item.price)
        {
            double substract = add - item.price;
            add = item.price;
            JOptionPane.showMessageDialog(null,"Limit exceeded! This money cannot be added: "+ substract, "InfoBox: " , JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null,"Money added.", "InfoBox: " , JOptionPane.INFORMATION_MESSAGE);
        }
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
           String query1 = "update goals set itemMoney='" + add + "' where userID =" + Profile.getUser().getId()+ " and itemID="+ item.getID();
           ((java.sql.Statement) stmt).executeUpdate(query1);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        item.setCurrentMoney(item.getCurrentMoney() + money);
        
    }

    public static void moneyGoesAsPercent(targetedItem item, double money, int percent)
    {
        //this method will take money that user enter manually and add into the account and it should be connected with saving class 
        //since when we put this money into my item it should show in also saving that i have this much money on my items.
        Connection conn = null;
        Statement stmt = null;
        String DATABASE_URL = "jdbc:mysql://localhost/hr";
        double add = item.getCurrentMoney() + money *(percent/ 100);
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
               Class.forName("com.mysql.jdbc.Driver");
               connection = DriverManager.getConnection(DATABASE_URL, "root", "74252002");
               PreparedStatement ps = conn.prepareStatement(
                "UPDATE goals SET itemMoney = ? WHERE userID = ? AND itemID = ?");
          
              // set the preparedstatement parameters
              ps.setDouble(1,add);
              ps.setInt(2,Profile.getUser().getId());
              ps.setInt(3,item.getID());
          
              // call executeUpdate to execute our sql update statement
              ps.executeUpdate();
              ps.close();
                               
        } catch (SQLException sqlEx) {
               sqlEx.printStackTrace();
               System.exit(1);
        } catch (ClassNotFoundException clsNotFoundEx) {
               clsNotFoundEx.printStackTrace();
               System.exit(1);
        } finally {
               try {
                      preparedStatement.close();
                      connection.close();
               } catch (Exception e) {
                      System.exit(1);
               }
        }
        item.setCurrentMoney(item.getCurrentMoney() + money * percent);
    }

    public static void useMoneyFromProduct(targetedItem item, double money)
    {
        //when user needs to spend money from their desired product
        //this method should be connected with spends and savings//update them
        if(item.getCurrentMoney() >= money)
        {
            item.setCurrentMoney(item.getCurrentMoney() - money);
            Connection conn = null;
            Statement stmt = null;
            double remove = item.getCurrentMoney() - money;
            item.setCurrentMoney(item.getCurrentMoney() + money);   
        }
        
        else
        {  
        JOptionPane.showMessageDialog(null,"Item doen't have enough money." ,"Info Box" , JOptionPane.INFORMATION_MESSAGE); 
        }
    }
    public static void purchaseAddTransitions(targetedItem item)
    {
        
    }
    public static ArrayList<targetedItem> getTargets()
    {
        return goalsItems;
    }
    public static void purchase(targetedItem item)
    {
        if(item.canBuy())//if the user has enough money 
        {
            purchaseAddTransitions(item);//add transitions and remove from goals
            remove(item.getID());
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
            JOptionPane.showMessageDialog(null,item.getWebsite(), "Website: " , JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Wrong password");
        } 
        //when user want to purchase a product it will lead to the website of the product it will cut the money
        // from the account and it will remove the item from the goals and it will say user to set new goals since user will buy the product from her bank account it will not spend money in
        // here when s/he purchase it will come from the card info
    }

    public static ArrayList<targetedItem> getItemsArrayList()//look lter
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
            String sql = "SELECT * FROM goals where userID=" + Profile.getUser().getId();
            p = conn.prepareStatement(sql);
            rs = p.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ItemID");
                double total = rs.getDouble("itemMoney");
                for(int i = 0; i < k.size(); i++)
                {
                    if(k.get(i).getId() == id)
                    {
                        Item item = k.get(i);
                        targetedItem target = new targetedItem(item, total);
                        y.add(target);
                    }
                }   
            }
            goalsItems = y;
            p.close();
            conn.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        if(y.size() == 0)//just to not make gpals array null
        {
            targetedItem i = new targetedItem(k.get(11), 0);
            y.add(10, i);
        }
        goalsItems = y;
        return y;
    }

}
