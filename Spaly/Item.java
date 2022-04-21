package Spaly;
import java.util.Currency;

import javax.imageio.ImageIO;
// a method taking its information from the database of items
public class Item {
    private String name;
    private double price;
    private ImageIO image;
    private boolean isTheProductInGoal;
    private String website;
    private double currentSaving;
    public Item(String name, int price, ImageIO image, boolean isTheProductInGoal, String website)
    {
        this.name = name;
        this.price = price;
        this.image = image;
        this.isTheProductInGoal = isTheProductInGoal;
        this.website = website;
        this.currentSaving = 0;
    }
    public void setIsTheProductInGoal(boolean trueOrFalse)
    {
        this.isTheProductInGoal = trueOrFalse;
    }

    public boolean canBuy()
    {
        if(currentSaving >= price)
        {
            return true;
        }
        return false;
    }
    
    public String getName()
    {
        return this.name;
    }

    public double getPrice()
    {
        return this.price;
    }

    public ImageIO getImage()
    {
        return this.image;
    }

    public boolean isInTheGoal()
    {
        return this.isTheProductInGoal;
    }
    
    public String getWebsite()
    {
        return this.website;
    }

    public double getSaver()
    {
        return this.currentSaving;
    }

    public void setPrice(double newPrice)
    {
        if(price > newPrice)
        {
            System.out.println("Your product on sale.");
        }
        this.price = newPrice;
        
    }
}
