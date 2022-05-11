

public class Delimitation 
{
    private String warning;
    private double limit;
    private String budgetPlanning;
    private User u;

    public Delimitation(User u)
    {   
        this.u = u;
        warning = "You have exceeded your limit!";
        limit = 0;
        budgetPlanning = "Daily";
    }    

    public String getBudgetPlanningWay()
    {
        return this.budgetPlanning;
    }

    public double getLimit()
    {
        return this.limit;
    }

    public String getWarning()
    {
        return this.warning;
    }

    public void setLimit(int limit)
    {
        this.limit = limit;
    }

    public void setWarning(String warning)
    {
        this.warning = warning;
    }

    public void setBudgetPlanningWay(String way)
    {
        /* budgetPlanning = way;
        if(way.equals("Daily"))
        {
            value.drawBarChartofDailySpendingAccordingtoCategories(p.getUser().getId());
        }
        else if(way.equals("Monthly"))
        {
           value.drawPieChartofMonthlySpendingAccordingtoCategories(p.getUser().getId());
           value.drawPieChartofMonthlySpendingAccordingtoCategoriesFromAllBankCards(p.getUser().getId());
        } */
        budgetPlanning = way;
    }
}
