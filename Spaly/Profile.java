package Spaly;

public class Profile 
{
    private String userName;
    private String password;
    private String email_address;

    public Profile()
    {
        
    }
    public Profile(String userName, String password, String email_address)
    {
        this.userName = userName;
        this.password = password;
        this.email_address = email_address;
        //these will be added to the database
    }

    public boolean login(String userName, String password)
    {
        if(this.userName.equals(userName))
        {
            if(this.password.equals(password))
            {
                return true;
            }
            else
            {
                System.out.println("Wrong password!");
            }
        }
        else
        {
            System.out.println("User not found. Please create an account.");
        }
        return false;
    }
}
