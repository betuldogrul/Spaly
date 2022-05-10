public class CreditCard extends CardStatement
{
    private int creditcard_id;
    private double cardNumber;
    private double upperLimit;
    private double totalSpentMoney;
    private String cardBank;
    private int user;

    public CreditCard(int creditcard_id, double number, double upperLimit, double totalMoney, String cardBank, int userID)
    {
        this.creditcard_id = creditcard_id;
        this.cardNumber = number;
        this.upperLimit = upperLimit;
        this.totalSpentMoney = totalMoney;
        this.cardBank = cardBank;
        this.user = userID;
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
