import javax.imageio.ImageIO;

public class Item {
    private String name;
    private int price;
    private ImageIO image;
    private boolean isTheProductInGoal;
    private String website;
    public Item(String name, int price, ImageIO image, boolean isTheProductInGoal, String website)
    {
        this.name = name;
        this.price = price;
        this.image = image;
        this.isTheProductInGoal = isTheProductInGoal;
        this.website = website;
    }
    public void setIsTheProductInGoal(boolean trueOrFalse)
    {
        this.isTheProductInGoal = trueOrFalse;
    }

    public boolean isInTheGoal()
    {
        return this.isTheProductInGoal;
    }

    
}
