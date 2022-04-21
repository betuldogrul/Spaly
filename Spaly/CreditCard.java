package Spaly;

public class CreditCard 
{
    private double number;
    private double upperLimit;
    private double totalMoney;

    public CreditCard(double number, double upperLimit, double totalMoney)
    {
        this.number = number;
        this.upperLimit = upperLimit;
        this.totalMoney = totalMoney;
    }

    public double addMoneyToCard(int amount)
    {
        totalMoney = totalMoney + amount;
        return totalMoney;
    }

    public double removeMoneyFromCard(int amount)
    {
        totalMoney = totalMoney - amount;
        return totalMoney;
    }

    //A method to interact with the database
}
