

public class Delimitation 
{
    private static String warning;
    private static double limit;
    private static String budgetPlanning;
    public static boolean budgetPlanningWayChanged = false;

    public Delimitation()
    {   
        warning = "You have exceeded your limit!";
        limit = 0;
        budgetPlanning = "Daily";
    }    

    public static String getBudgetPlanningWay()
    {
        return budgetPlanning;
    }

    public double getLimit()
    {
        return this.limit;
    }

    public String getWarning()
    {
        return this.warning;
    }

    public static void setLimit(Object object)
    {
        this.limit = object;
    }

    public void setWarning(String warning)
    {
        this.warning = warning;
    }

    public static void setBudgetPlanningWay(String way)
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
