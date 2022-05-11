import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Analyze {
    private double income;
    private double itemPrice;
    private double totalExpenditures;
    private double savings;
    private Category category;
    private Categories categories;
    private Profile p;
    private int userID;
    public Analyze(Profile p){
        userID=p.getUser().getId();
    }
    public double getTotalExpenditures(){return totalExpenditures;}
    public double getIncome(){return income;}
    public double getItemPrice(){return itemPrice;}
    public double getSavings(){return savings;}
    public double totalExpenditures(){
        //get values from Database
        return totalExpenditures;
    }
    public double ratioOfSpendingToTotalLimit(){
        return totalExpenditures/categories.totalLimitCalculator()*100;
    }
    //Calculates the ratio of incomes to expenditures 
    public double ratioOfMoney(){
        return income/totalExpenditures;
    }
    public double remaining(){
        return itemPrice-savings;
    }
    //Draws the chart of Daily Spending of the User According to categories of his/her spending
    public void drawBarChartofDailySpendingAccordingtoCategories(int userID){
     
    }
    public ArrayList<> drawPieMonth(int monthh){
        ArrayList<> k ;
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
        final String DbUrl = "jdbc:mysql://localhost:3306/melisa";
        final String username = "root";
        final String password = "74252002";
        ResultSet rs = null;
        PreparedStatement p = null;
        try{
            Connection conn = DriverManager.getConnection(DbUrl, username, password);
            String sql = "SELECT * FROM cardstatement WHERE monthh=" + monthh
            p = conn.prepareStatement(sql);
            rs = p.executeQuery();

            while (rs.next()) {
            }
            p.close();
            conn.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        k;
    }
    //Draws the chart of Monthly Spending of the User from All Bank Card Info
    public void drawPieChartofMonthlySpendingAccordingtoCategoriesFromAllBankCards(int userID){
        try{
            String query= "select sum(spending),category from x where ";
            JDBCCategoryDataset dataset=new JDBCCategoryDataset();
            JFreeChart chart=ChartFactory.createPieChart("Monthly All Bank Cards Category Analyses",dataset,false, true, false);
            BarRenderer renderer=null;
            CategoryPlot plot=null;
            renderer=new BarRenderer();
            ChartFrame frame= new ChartFrame("Monthly All Spending-Categories Chart",chart);
            frame.setVisible(true);
            frame.setSize(400,650);
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
}
