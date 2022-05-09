

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class targetedItem extends Item implements Percentage {

    private double currentSaving;
    private boolean isTheProductInGoal;
    private Item item;
   
    public targetedItem(Item item , boolean isTheProductInGoal) {
        super(item.getId(), item.getName(), item.getPrice(), item.getImage(), item.getWebsite());
        this.item = item;
        this.isTheProductInGoal = isTheProductInGoal;
        this.currentSaving = 0;
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

    public void setIsTheProductInGoal(boolean trueOrFalse)
    {
        this.isTheProductInGoal = trueOrFalse;
    }

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
