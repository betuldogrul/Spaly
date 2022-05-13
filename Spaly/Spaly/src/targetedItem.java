


import java.util.Currency;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;


public class TargetedItem extends Item implements Percentage {
    private double currentSaving;
    private boolean isTheProductInGoal;
    private Item item;

   
   
    public TargetedItem(Item item, double currentSaving) {
        super(item.getId(), item.getName(), item.getPrice(), item.getImage(), item.getWebsite());
        this.item = item;
        this.currentSaving = currentSaving;
        //TODO Auto-generated constructor stub
    }

    public boolean canBuy()
    {
        if(currentSaving >= price)
        {
            return true;
        }
        return false;
    }
    public int getID()
    {
        return item.getId();
    }
    public String getImage()
    {
        return item.getImage();
    }

    public double getPrice()
    {
        return item.getPrice();
    }

    public String getName()
    {
        return item.getName();
    }

    public String getWebsite()
    {
        return item.getWebsite();
    }
    /* public void setIsTheProductInGoal(boolean trueOrFalse)
    {
        this.isTheProductInGoal = trueOrFalse;
    }
 */
    public double getSaver()
    {
        return this.currentSaving;
    }

    public void setCurrentMoney(double currentSaving)
    {
        this.currentSaving = currentSaving;
    }

    public double getCurrentMoney()
    {
        return currentSaving;
    }

    @Override
    public double pieceCalculator() {
        return currentSaving / this.price;
    }
}
