

import java.sql.*;
import java.util.ArrayList;

public class Categories //the class to hold the arraylist of the categories in the same credit card status 
{
    private ArrayList<Category> categories;
    private double totalMoneySpent;
    private CreditCard card;

    public Categories(CreditCard card)
    {
        categories  = new ArrayList<Category>();
        totalMoneySpent = 0;
        this.card = card;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
        final String DbUrl = "jdbc:mysql://localhost:3306/melisa";
        final String username = "root";
        final String password = "74252002";
        PreparedStatement p = null;
        ResultSet rs = null;
        try{
            Connection conn = DriverManager.getConnection(DbUrl, username, password);
            String sql = "SELECT * FROM category";
            p = conn.prepareStatement(sql);
            rs = p.executeQuery();

            while (rs.next()) {
                String category_name = rs.getString("category_name");
                double currentSpendings = rs.getDouble("current_spendings");
                double category_limit = rs.getDouble("category_limit");
                Category category = new Category(category_name, currentSpendings, category_limit, card);
                categories.add(category);
            }
            p.close();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public double getTotalMoneySpent()
    {
        return totalMoneySpent;
    }

    public void addToCategories(Category cat)
    {
        categories.add(cat);
    }
    
    public double totalLimitCalculator(){
        double totalLimit=0;
        for(int i=0;i<categories.size();i++){
            totalLimit+=categories.get(i).getLimitofCategory();
        }
        return totalLimit;
    }
}
