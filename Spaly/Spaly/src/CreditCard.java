public class CreditCard extends CardStatement
{
    private int creditcard_id;
    private double cardNumber;
    private double upperLimit;
    private double totalSpentMoney;
    private String cardBank;
    private User user;

    public CreditCard(int creditcard_id, double number, double upperLimit, double totalMoney, String cardBank, User user)
    {
        this.creditcard_id = creditcard_id;
        this.cardNumber = number;
        this.upperLimit = upperLimit;
        this.totalSpentMoney = totalMoney;
        this.cardBank = cardBank;
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

    public String getCardBank() 
    {
        return this.cardBank;
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
