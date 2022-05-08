

public class CreditCard extends CardStatement
{
    private double cardNumber;
    private double upperLimit;
    private double totalSpentMoney;

    public CreditCard(double number, double upperLimit, double totalMoney)
    {
        this.cardNumber = number;
        this.upperLimit = upperLimit;
        this.totalSpentMoney = totalMoney;
    }

    public double getCardNumber()
    {
        return cardNumber;
    }

    public double getUpperLimit()
    {
        return this.upperLimit;
    }

    public double getTotalSpentMoney()
    {
        return this.totalSpentMoney;
    }

    public double addMoneyToCard(double amount)
    {
        totalSpentMoney = totalSpentMoney + amount;
        return totalSpentMoney;
    }

    public double removeMoneyFromCard(double amount)
    {
        totalSpentMoney = totalSpentMoney - amount;
        return totalSpentMoney;
    }

    //A method to interact with the database
}
