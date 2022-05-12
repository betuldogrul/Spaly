import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;

//This class stores and updates the savings according to the incomes and spendings that are going to be taken from the bank’s database.
public class MoneyBox{

    //VARIABLES
    private static int numberOfDays; //Update when there is a change in budget planing way
    public static int dailySpendingLimit; //Update according to budget planning way
    public static double dailySaving; //Update daily bases
    public static double monthlySaving; //Update monthly bases
    public static double totalSaving; //Update daily bases


    //CONSTRUCTORS
    public MoneyBox(){
        Delimitation d = new Delimitation();
        setNumberOfDays();
        updateMoneyBox();
    }

    //METHODS

    //Getters

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

    public void setNumberOfDays(){
        if(Delimitation.getBudgetPlanningWay().equalsIgnoreCase("Daily")){
            numberOfDays = 1;
        }

        else if(Delimitation.getBudgetPlanningWay().equalsIgnoreCase("Weekly")){
            numberOfDays = 7;
        }

        else if(Delimitation.getBudgetPlanningWay().equalsIgnoreCase("Monthly")){
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
        dailySaving = dailySpendingLimit - CardStatement.getDailySpending(Calendar.getInstance().getTime());
    }

    private void setMonthlySaving(){
        monthlySaving = (dailySpendingLimit * 30) - CardStatement.getMonthlySpending();
    }

    private void setTotalSaving(){
        totalSaving += dailySaving; 
    }

    //Other Methods

    public void updateMoneyBox(){

        if(Delimitation.budgetPlanningWayChanged){
            setNumberOfDays();
            Delimitation.budgetPlanningWayChanged = false;
        }

        setDailySpendingLimit();
        setDailySaving();
        setMonthlySaving();
        setTotalSaving();
    }
    
}
