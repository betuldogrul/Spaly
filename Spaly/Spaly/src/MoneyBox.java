import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;

//This class stores and updates the savings according to the incomes and spendings that are going to be taken from the bank’s database.
public class MoneyBox{

    //VARIABLES
    public Calendar endDate;
    private int numberOfDays; //Update when there is a change in budget planing way (in setBudgetPlanningWay method update this also)
    public int dailySpendingLimit; //Update according to budget planning way
    public int dailySaving; //Update daily bases
    public int monthlySaving; //Update monthly bases
    public int totalSaving; //Update daily bases
    private User u;


    //CONSTRUCTORS
    public MoneyBox(User u){
        this.u = u;
    }

    //METHODS

    //Getters
    public Calendar getEndDate(){
        return endDate;
    }

    public int getNumberOfDays(){
        return numberOfDays;
    }

    public int getDailySpendingLimit(){
        return dailySpendingLimit;
    }

    public int getDailySaving(){
        return dailySaving;
    }

    public int getMonthlySaving(){
        return monthlySaving;
    }

    public int getTotalSaving(){
        return totalSaving;
    }


    //Setters
    private void setEndDate(){

        int year = startDate.get(Calendar.YEAR);
        int month = startDate.get(Calendar.MONTH);
        int date = startDate.get(Calendar.DATE);//Date is set so that there wouldn't be errors sourced by this.

        if(budgetPlanningWay.equals("Daily")){
            date = startDate.get(Calendar.DATE) + 1;
        }

        else if(budgetPlanningWay.equals("Weekly")){
            date = startDate.get(Calendar.DATE) + 7;
        }

        else if(budgetPlanningWay.equals("Monthly")){
            date = startDate.get(Calendar.DATE) + 30;
        }

        else{
            System.out.println("There is something wrong with the budgetPlanningWay");
        }

        endDate.set(year, month, date, 0, 0);
    }

    public void setNumberOfDays(){
        if(budgetPlanningWay.equals("Daily")){
            numberOfDays = 1;
        }

        else if(budgetPlanningWay.equals("Weekly")){
            numberOfDays = 7;
        }

        else if(budgetPlanningWay.equals("Monthly")){
            numberOfDays = 30;
        }

        else{
            System.out.println("There is something wrong with the budgetPlanningWay");
        }
    }

    private void setDailySpendingLimit(){
        dailySpendingLimit = u.getIncome()/numberOfDays;
    }

    private void setDailySaving(){
        dailySaving = dailySpendingLimit - getDailySpendings();//There is no variable as spendigs however we need that
    }

    private void setMonthlySaving(){
        monthlySaving = (dailySpendingLimit * 30) - getMonthlySpendings();
    }

    private void setTotalSaving(){
        totalSaving += dailySaving; 
    }

    //Other Methods

    public void updateMoneyBox(User u){

        Calendar currentDate = Calendar.getInstance();
        Calendar today;

        if(budgetPlanningWayChanged){
            setNumberOfDays();
            budgetPlanningWayChanged = false;
        }

        if(currentDate.after(endDate)){
            setDailySpendingLimit();
            changeStartDate((Date) endDate.getTime());
            setEndDate();
        }

        if(u.getToday().before(currentDate)){//If the day is passed
            setTotalSaving();
            setMonthlySaving();
            dailySaving = 0;
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
