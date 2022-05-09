import java.util.ArrayList;
import java.util.Calendar;

//This class stores and updates the savings according to the incomes and spendings that are going to be taken from the bank’s database.
public class MoneyBox{

    //VARIABLES
    public Calendar endDate;
    private int numberOfDays; //Update when there is a change in budget planing way (in setBudgetPlanningWay method update this also)
    public int maxIncomeOfStartDate; //Update according to budget planning way
    public int dailySpendingLimit; //Update according to budget planning way
    public int dailySaving; //Update daily bases
    public int monthlySaving; //Update monthly bases
    public int totalSaving; //Update daily bases
    public ArrayList<Integer> dailyIncomes; //Update daily bases


    //CONSTRUCTORS
    public MoneyBox(){

    }

    //METHODS

    //Getters
    public Calendar getEndDate(){
        return endDate;
    }

    public int getNumberOfDays(){
        return numberOfDays;
    }

    public int getMaxIncome(){
        return maxIncomeOfStartDate;
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

    public ArrayList<Integer> getDailyIncomes(){
        return dailyIncomes;
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

    public void setDailyIncomes(){
        dailyIncomes = new ArrayList<Integer>(); //In order to start daily income array list in daily bases
    }

    private void setMaxIncome(){
        for(int i = 0; i < dailyIncomes.length; i++){
            if(maxIncomeOfStartDate < dailyIncomes.get(i)){
                maxIncomeOfStartDate = dailyIncomes.get(i);
            }
        }
    }

    private void setDailySpendingLimit(){
        dailySpendingLimit = maxIncomeOfStartDate/numberOfDays;
    }

    private void setDailySaving(){
        dailySaving = dailySpendingLimit - getDailySpendings();//There is no variable as spendigs however we need that
    }

    private void setMonthlySaving(){
        monthlySaving = (dailySpendingLimit * 30) - getMonthlySaving();
    }

    private void setTotalSaving(){
        totalSaving += dailySaving; 
    }

    //Other Methods
    public void addDailyIncome(int income){
        dailyIncomes.add(income);
    }

    public void startNewDay(){
        
    }
    
}
