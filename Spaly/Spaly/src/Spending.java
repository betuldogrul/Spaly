public class Spending { // this class is to hold the data about the cardstatement table, 
    //which stores data about the exact date, time, spending of an item in a certain category with the specified creditcard.

    private int day;
    private int month;
    private int year;
    private int hour;
    private int minute;
    private double spending;
    private String company;
    private String category;
    private int card_id;
    
    public Spending(int day, int month, int year, int hour, int minute, double spending, String company, String category, int card_id)
    {
        this.day = day;
        this.month = month;
        this.year = year;
        this.hour = hour;
        this.minute = minute;
        this.spending = spending;
        this.company = company;
        this.category = category;
        this.card_id = card_id;
    }

    public int getDay() {
        return this.day;
    }

    public int getMonth() {
        return this.month;
    }

    public int getYear() {
        return this.year;
    }
    
    public int getHour() {
        return this.hour;
    }

    public int getMinute() {
        return this.minute;
    }

    public double getSpending() {
        return this.spending;
    }

    public String getCompany() {
        return this.company;
    }

    public String getCategory() {
        return this.category;
    }

    public int getCard_id() {
        return this.card_id;
    }
}
