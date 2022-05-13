public class Spend{
    private int day;
    private int month;
    private int year;
    private double spending;
    private String category;
    private int hour;
    private int min;
    public Spend(int day, int month, int year, double spending, String category){
        this.day=day;
        this.month=month;
        this.year=year;
        this.spending=spending;
        this.category=category;
    }
    public void setHour(int h)
    {
        this.hour = h;
    }
    public void setMinte(int k)
    {
        this.min = k;
    }
    public int getm()
    {
        return this.min;
    }
    public int getH()
    {
        return this.hour;
    }
    public int getDay(){
        return day;
    }
    public int getMonth(){
        return month;
    }
    public int getYear(){
        return year;
    }
    public double getSpending(){
        return spending;
    }
    public String getCategory(){
        return category;
    }
}