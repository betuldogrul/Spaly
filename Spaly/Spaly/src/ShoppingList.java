

import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.xml.crypto.Data;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class ShoppingList {
    private static ArrayList<ArrayList<Item>> AllItems;// this arraylist will be created by using sql
    static ArrayList<Item> searched;
    private Goals goal = new Goals();


    public ShoppingList() {
        AllItems = differKind(createAllItems());// using sql it will be created arraylist of items of arraylist 
        //inside arraylist will keep for same product in different website
        //outside will keep different products
    }
    public static ArrayList<ArrayList<Item>> differKind(ArrayList<Item> k)
    {
        ArrayList<ArrayList<Item>> all = new ArrayList<ArrayList<Item>>();
        k = createAllItems();
        ArrayList<Item> same = new ArrayList<Item>();
        same.add(k.get(0));
        for(int i = 1; i <k.size(); i++)
        {
            if(k.get(i - 1).getName().equals(k.get(i).getName()))
            {
                same.add(k.get(i));
            }
            else
            {
                all.add(same);
                ArrayList<Item> samee = new ArrayList<Item>();
                same = samee;
                same.add(k.get(i));
            }
        }
        all.add(same);
        return all;
    }
    public  static ArrayList<Item> createAllItems()//this means inside arraylist same item for different prices outside different items
    {
        Item item = null;
        Connection conn = null;
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
        ArrayList<Item> allItem = new ArrayList<Item>();
        try{
            conn = DriverManager.getConnection(DbUrl, username, password);
            String sql = "SELECT * FROM shoping";
            p = conn.prepareStatement(sql);
            rs = p.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ItemId");
                String name = rs.getString("ItemName");
                Double price = rs.getDouble("price");
                String website = rs.getString("website");
                String image = rs.getString("image");
                item = new Item(id, name, price, image, website);
                allItem.add(item);
            }
            p.close();
            conn.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        finally {
            if (conn != null) try { conn.close(); } catch (SQLException ignore) {}
        }
        return allItem;
    }
    public static void giveWebsiteInfo(Item item)
    {
        JOptionPane.showMessageDialog(null,item.getWebsite(), "Website: " , JOptionPane.INFORMATION_MESSAGE);   
    }
    public static void addToGoal(Item item) {
      
        //this item will come in goal
        Connection conn = null;
        if (Goals.getItemsArrayList().size() <= 4) {
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
                conn = DriverManager.getConnection(DbUrl, username, password);
                String sql = "INSERT INTO goals VALUES (?, ?, ?)";//taking item to database
                p = conn.prepareStatement(sql);
                p.setInt(1, Profile.getUser().getId());
                p.setInt(2, item.getId());
                p.setFloat(3,0);
                p.executeUpdate();
                conn.close();
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
            finally {
                if (conn != null) try { conn.close(); } catch (SQLException ignore) {}
            }
            TargetedItem tItem = new TargetedItem(item, 0);
            createAllItems().add(tItem);
            System.out.println("Product succesfully added:");
        }       
    }

        
    public static ArrayList<Item> getSearched()
    {
        return searched;
    }
    public static ArrayList<Item> search(String name) {
        ArrayList<ArrayList<Item>> AllItems = differKind(createAllItems());
        for(int i = 0; i < AllItems.size(); i++)
        {
            // it will take from SQL products and when user search for an item it will bring the desired arrayList
            if(name.equals(AllItems.get(i).get(i).getName()))//searched after searching from our arraylist with an for loop we will 
            //return this arraylist and show the user different website for the same products.
            {
                searched = AllItems.get(i);
                return AllItems.get(i);
            }
        }
            searched = null;
            JOptionPane.showMessageDialog(null,"Spaly doesn't have that product yet. Please wait later versions.", "InfoBox: " , JOptionPane.INFORMATION_MESSAGE);
            return null;//if there is no product
    }
}
