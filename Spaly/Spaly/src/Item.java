
import java.util.Currency;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
// a method taking its information from the database of items
public  class Item {
    private String name;
    protected double price;
    private String image;
    private String website;
    private boolean isTheProductInGoal;
    private int id;
    
    public Item(int id, String name, double price, String image, String website)
    {
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
        this.website = website;
    }
    public int getId()
    {
        return this.id;
    }
    public String getName()
    {
        return this.name;
    }

    public double getPrice()
    {
        return this.price;
    }

    public String getImage()
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
    public String toString()
    {
        return name;
    }
}
