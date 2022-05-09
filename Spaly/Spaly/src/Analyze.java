import javax.swing.JOptionPane;

public class Analyze {
    private double income;
    private double itemPrice;
    private double totalExpenditures;
    private double savings;
    private Category category;
    private Categories categories;
    public double getTotalExpenditures(){return totalExpenditures;}
    public double getIncome(){return income;}
    public double getItemPrice(){return itemPrice;}
    public double getSavings(){return savings;}
    public double totalExpenditures(){
        //get values from Excel
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
    public void drawBarChartofDailySpendingAccordingtoCategories(){
        try{
            String query= "select spending,category from x where ";
            JDBCCategoryDataset dataset=new JDBCCategoryDataset();
            JFreeChart chart=ChartFactory.createBarChart("Daily Analyze Chart","Categories","Spending",dataset,PlotOrientation.VERTICAL,false,true,true);
            BarRenderer renderer=null;
            CategoryPlot plot=null;
            renderer=new BarRenderer();
            ChartFrame frame= new ChartFrame("Daily Spending-Categories Chart",chart);
            frame.setVisible(true);
            frame.setSize(400,650);
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
    public void drawPieChartofMonthlySpendingAccordingtoCategories(){
        try{
            String query= "select spending,category from x where ";
            JDBCCategoryDataset dataset=new JDBCCategoryDataset();
            JFreeChart chart=ChartFactory.createPieChart("Monthly Category Analyses",dataset,false, true, false);
            BarRenderer renderer=null;
            CategoryPlot plot=null;
            renderer=new BarRenderer();
            ChartFrame frame= new ChartFrame("Monthly Spending-Categories Chart",chart);
            frame.setVisible(true);
            frame.setSize(400,650);
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
    public void drawPieChartofMonthlySpendingAccordingtoCategoriesFromAllBankCards(){
        try{
            String query= "select spending,category from x where ";
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
