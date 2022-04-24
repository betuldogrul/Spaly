package Spaly;

public class Analyze {
    private double income;
    private double itemPrice;
    private double totalExpenditures;
    private double savings;
    public double totalExpenditures(){
        //get values from Excel
        return totalExpenditures;
    }
    //Calculates the ratio of incomes to expenditures 
    public double ratioOfMoney(){
        return income/totalExpenditures;
    }
    public double remaining(){
        return itemPrice/savings;
    }

}
