import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;

//This class stores and updates the savings according to the incomes and spendings that are going to be taken from the bank’s database.
public class MoneyBox{

    //VARIABLES
    public Calendar endDate;
    private static int numberOfDays; //Update when there is a change in budget planing way
    public static int dailySpendingLimit; //Update according to budget planning way
    public static double dailySaving; //Update daily bases
    public static double monthlySaving; //Update monthly bases
    public static double totalSaving; //Update daily bases
    private User u;


    //CONSTRUCTORS
    public MoneyBox(){
    }

    //METHODS

    //Getters
    public Calendar getEndDate(){
        return endDate;
    }

    public static int getNumberOfDays(){
        return numberOfDays;
    }

    public static int getDailySpendingLimit(){
        return dailySpendingLimit;
    }

    public static double getDailySaving(){
        return dailySaving;
    }

    public static double getMonthlySaving(){
        return monthlySaving;
    }

    public static double getTotalSaving(){
        return totalSaving;
    }


    //Setters
    private void setEndDate(){

        int year = startDate.get(Calendar.YEAR);
        int month = startDate.get(Calendar.MONTH);
        int date = startDate.get(Calendar.DATE);//Date is set so that there wouldn't be errors sourced by this.

        if(Delimitation.getBudgetPlanningWay().equals("Daily")){
            date = startDate.get(Calendar.DATE) + 1;
        }

        else if(Delimitation.getBudgetPlanningWay().equals("Weekly")){
            date = startDate.get(Calendar.DATE) + 7;
        }

        else if(Delimitation.getBudgetPlanningWay().equals("Monthly")){
            date = startDate.get(Calendar.DATE) + 30;
        }

        else{
            System.out.println("There is something wrong with the budgetPlanningWay");
        }

        endDate.set(year, month, date, 0, 0);
    }

    public void setNumberOfDays(){
        if(Delimitation.getBudgetPlanningWay().equals("Daily")){
            numberOfDays = 1;
        }

        else if(Delimitation.getBudgetPlanningWay().equals("Weekly")){
            numberOfDays = 7;
        }

        else if(Delimitation.getBudgetPlanningWay().equals("Monthly")){
            numberOfDays = 30;
        }

        else{
            System.out.println("There is something wrong with the budgetPlanningWay");
        }
    }

    private void setDailySpendingLimit(){
        dailySpendingLimit = User.getUserIncome()/numberOfDays;
    }

    private void setDailySaving(){
        dailySaving = dailySpendingLimit - CardStatement.getDailySpending(Calendar.getInstance().getTime());//There is no variable as spendigs however we need that
    }

    private void setMonthlySaving(){
        monthlySaving = (dailySpendingLimit * 30) - CardStatement.getMonthlySpending();
    }

    private void setTotalSaving(){
        totalSaving += dailySaving; 
    }

    //Other Methods

    public void updateMoneyBox(){

        Calendar currentDate = Calendar.getInstance();
        Calendar today;

        if(Delimitation.budgetPlanningWayChanged){
            setNumberOfDays();
            Delimitation.budgetPlanningWayChanged = false;
        }

        if(currentDate.after(endDate)){
            setDailySpendingLimit();
            changeStartDate((Date) endDate.getTime());
            setEndDate();
        }
    }

    private void changeStartDate(Date startDate){//Changes startDate in sql
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
           String query1 = "update moneyBox set startDate='" + startDate + "' where userID =" + u.getId();
           ((java.sql.Statement) stmt).executeUpdate(query1);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    
    }
    
}
