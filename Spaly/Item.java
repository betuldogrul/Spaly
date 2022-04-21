package Spaly;
import java.util.Currency;

import javax.imageio.ImageIO;
// a method taking its information from the database of items
public  class Item {
    private String name;
    protected double price;
    private ImageIO image;
    private String website;
    private boolean isTheProductInGoal;
    
    public Item(String name, double price, ImageIO image, String website)
    {
        this.name = name;
        this.price = price;
        this.image = image;
        this.website = website;
    }
    public Item()
    {

    }
    public void setIsTheProductInGoal(boolean trueOrFalse)
    {
        this.isTheProductInGoal = trueOrFalse;
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

    public void setPrice(double newPrice)
    {
        if(price > newPrice)
        {
            System.out.println("Your product on sale.");
        }
        this.price = newPrice;  
    }
}
