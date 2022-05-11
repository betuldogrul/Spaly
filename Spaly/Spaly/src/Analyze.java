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
    private Spend spend;
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
    public void drawBarChartofDailySpendingAccordingtoCategories(int userID, CreditCard c){
        
    }
    public static ArrayList<ArrayList<Double>> differ(ArrayList<Spend> spend){
        ArrayList<Double> k=new ArrayList<>();
        ArrayList<ArrayList<Double>> y=new ArrayList<>();
        k.add(spend.get(0).getSpending());
        Spend s =spend.get(0);
        for(int i=1;i<spend.size();i++){
            if(s.getCategory().equals("Transportation")&&s.getDay()==spend.get(i).getDay()){
                k.set(spend.get(i).getDay()-1, k.get(i)+spend.get(i).getSpending());
            }
            else if(s.getCategory().equals(spend.get(i).getCategory())){
                s=spend.get(i);
                k.add(s.getSpending());
            }
        }
        y.add(k);
        k=new ArrayList<>();
        for(int i=1;i<spend.size();i++){
            if(s.getCategory().equals("Food")&&s.getDay()==spend.get(i).getDay()){
                k.set(spend.get(i).getDay()-1, k.get(i)+spend.get(i).getSpending());
            }
            else if(s.getCategory().equals(spend.get(i).getCategory())){
                s=spend.get(i);
                k.add(s.getSpending());
            }
        }
        y.add(k);
        k=new ArrayList<>();
        for(int i=1;i<spend.size();i++){
            if(s.getCategory().equals("Clothing")&&s.getDay()==spend.get(i).getDay()){
                k.set(spend.get(i).getDay()-1, k.get(i)+spend.get(i).getSpending());
            }
            else if(s.getCategory().equals(spend.get(i).getCategory())){
                s=spend.get(i);
                k.add(s.getSpending());
            }
        }
        y.add(k);
        k=new ArrayList<>();
        for(int i=1;i<spend.size();i++){
            if(s.getCategory().equals("Other")&&s.getDay()==spend.get(i).getDay()){
                k.set(spend.get(i).getDay()-1, k.get(i)+spend.get(i).getSpending());
            }
            else if(s.getCategory().equals(spend.get(i).getCategory())){
                s=spend.get(i);
                k.add(s.getSpending());
            }
        }
        y.add(k);
        return y;
    }
    public static ArrayList<Spend> getValuesFromDatabase(int monthh, CreditCard c){
        ArrayList<Spend> k= new ArrayList<>();
        Spend spend;
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
            String sql = "SELECT * FROM cardstatement Where userID=" + Profile.getUser().getId() + " and creditcard_id=" + c.getCreditCardId() + "and month="+ monthh;
            p = conn.prepareStatement(sql);
            rs = p.executeQuery();

            while (rs.next()) {
                int day = rs.getInt("day");
                int month = rs.getInt("month");
                int year = rs.getInt("year");
                double spending = rs.getDouble("spending");
                String category = rs.getString("category");
                spend = new Spend( day,  month,  year,  spending,  category);
                k.add(spend);
            }
            p.close();
            conn.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return k;
    }
    //Draws the chart of Monthly Spending of the User from All Bank Card Info
    public static void drawPieChartofMonthlySpendingAccordingtoCategories(Stage primaryStage){
       		 
    public static void drawPieChartofMonthlySpendingAccordingtoCategoriesFromAllBankCards(){
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
