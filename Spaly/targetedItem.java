package Spaly;

import javax.imageio.ImageIO;

public class targetedItem extends Item implements Percentage {

    private double currentSaving;
    private boolean isTheProductInGoal;
   
    public targetedItem(String name, double d, ImageIO image, boolean isTheProductInGoal, String website) {
        super(name, d, image, website);
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
        // TODO Auto-generated method stub
        return 0;
    }
}
