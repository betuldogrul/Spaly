package Spaly;
import java.util.Currency;

import javax.imageio.ImageIO;
// a method taking its information from the database of items
public class Item {
    private String name;
    private int price;
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

    public boolean isInTheGoal()
    {
        return this.isTheProductInGoal;
    }

    public boolean canBuy()
    {
        if(currentSaving >= price)
        {
            return true;
        }
        return false;
    }

    
}
