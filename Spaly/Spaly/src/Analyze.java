import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.time.Month;

public class Analyze {
    private static double income;
    private static double itemPrice;
    private static double totalExpenditures;
    private static CreditCard c;
    private static double savings;
    private Category category;
    private static Categories categories;
    private Profile p;
    private int userID;
    private ArrayList<Spend> spend;
    ArrayList<ArrayList<Double>> allExpenditures;
    public Analyze(Profile p,CreditCard c){
        userID=p.getUser().getId();
        this.c=c;
        spend=getValuesFromDatabase(5, c);
        allExpenditures=differ(spend);
    }
    public ArrayList<ArrayList<Double>> getAllSpending(){return allExpenditures;}
    public double getTotalExpenditures(){return totalExpenditures;}
    public double getIncome(){return income;}
    public double getItemPrice(){return itemPrice;}
    public double getSavings(){return savings;}

    public static double totalExpenditures(){
        totalExpenditures=0;
        ArrayList<Spend> spend= getValuesFromDatabase(5, c);
        ArrayList<ArrayList<Double>> allExpenditures=differ(spend);
        for(int i=0;i<allExpenditures.size();i++){
            for(int j=0;j<allExpenditures.get(i).size();j++){
                totalExpenditures+=allExpenditures.get(i).get(j);
            }
        }
        return totalExpenditures;
    }

    public static double ratioOfSpendingToTotalLimit(){
        return totalExpenditures/categories.totalLimitCalculator()*100;
    }
    //Calculates the ratio of incomes to expenditures 
    public static double ratioOfMoney(){
        return income/totalExpenditures;
    }
    public static double remaining(){
        return itemPrice-savings;
    }
    //Draws the chart of Daily Spending of the User According to categories of his/her spending
    public static void drawBarChartofDailySpendingAccordingtoCategories(CreditCard c){
        
    }
    public static ArrayList<ArrayList<Double>> differ(ArrayList<Spend> spend){//this method turns monthly spending of user's one card inside arraylist for same catogory outside is general
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
    public static ArrayList<Spend> getValuesFromDatabase(int monthh, CreditCard c){// thid methods calculate 
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
            for(int i = 1; i < 31; i++)
            {
                spend = new Spend(i, monthh, 2022, 0, "Transportation");
                k.add(spend);
                spend = new Spend(i, monthh, 2022, 0, "Food");
                k.add(spend);
                spend = new Spend(i, monthh, 2022, 0, "Clothing");
                k.add(spend);
                spend = new Spend(i, monthh, 2022, 0, "Other");
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
    public static double  getMonthSpend(int k) // this method is calculating sum of a credit card spend in a month
    {
        ArrayList<CreditCard> cards = CardStatement.getAllCreditCards();
        double sum = 0;
        for(int i = 0 ; i < cards.size(); i++)
        {
            ArrayList<Double> s = differ(getValuesFromDatabase(5, cards.get(i))).get(k);
            for(int y = 0; y < s.size(); y++ )
            {
                sum = sum + s.get(y);
            }
            
        }
        return sum;
    }	
     //Draws the chart of Monthly Spending of the User from All Bank Card Info
    public static void drawPieChartofMonthlySpendingAccordingtoCategoriesFromAllBankCards(){
       
    }
}
