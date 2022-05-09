

public class Analyze {
    private double income;
    private double itemPrice;
    private double totalExpenditures;
    private double savings;
    public double getTotalExpenditures(){return totalExpenditures;}
    public double getIncome(){return income;}
    public double getItemPrice(){return itemPrice;}
    public double getSavings(){return savings;}
    public double totalExpenditures(){
        //get values from Excel
        return totalExpenditures;
    }
    //Calculates the ratio of incomes to expenditures 
    public double ratioOfMoney(){
        return income/totalExpenditures;
    }
    public double remaining(){
        return itemPrice-savings;
    }
}
