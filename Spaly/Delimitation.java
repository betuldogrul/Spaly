package Spaly;

public class Delimitation 
{
    private String warning;
    private double limit;
    private String budgetPlanning;

    public Delimitation()
    {
        warning = "You have exceeded your limit!";
        limit = 0;
        budgetPlanning = "Daily";
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
        budgetPlanning = way;
        if(way.equals("Daily"))
        {
            //Will be implemented
        }
        else if(way.equals("Monthly"))
        {
            //will be implemented
        }
    }
}
