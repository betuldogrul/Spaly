public class Spend{
    private int day;
    private int month;
    private int year;
    private double spending;
    private String category;
    public Spend(int day, int month, int year, double spending, String category){
        this.day=day;
        this.month=month;
        this.year=year;
        this.spending=spending;
        this.category=category;
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