package Spaly;

public class Category 
{
    private String name; 
    private double currentSpendings;
    private CreditCard card;

    private Category(String name, double currentSpendings, CreditCard card)
    {
        this.name = name;
        this.currentSpendings = currentSpendings;
        this.card = card;
    }
}
