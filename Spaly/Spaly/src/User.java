public class User {
    private int userId;
    private String e_mail;
    private String userName;
    private String password;

    public User(String name, String password, String email)
    {
        this.e_mail = email;
        this.userName = name;
        this.password = password;
        userId++;
    }

    public void changePasword(String password)
    {
        this.password = password;
    }

    public void setUserName(String name)
    {
        this.userName = name;
    }

    public void setEmail(String email)
    {
        this.e_mail = email;
    }

    public String getUserName()
    {
        return this.userName;
    }

    public String getMail()
    {
        return this.e_mail;
    }
    public String getPassword()
    {
        return this.password;
    }
    public int getId()
    {
        return this.userId;
    }
}
