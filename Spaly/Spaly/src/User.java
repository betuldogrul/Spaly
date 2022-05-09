public class User {
    private int userId;
    private String e_mail;
    private String userName;
    private String password;
    private String pic;
    private String userSurname;
    private String userUserName;


    public User(int id, String userName, String userSurname, String userUserName, String password, String userMail)
    {
        this.userId = id;
        this.e_mail = userMail;
        this.userUserName = userUserName;
        this.userSurname = userSurname;
        this.userName = userName;
        this.password = password;
        this.pic = "";
    }
    
    public String getSurname()
    {
        return this.userSurname;
    }

    public void setSurname(String surname)
    {
        this.userSurname = surname;
    }

    public void setUserUserName(String userName)
    {
        this.userUserName = userName;
    }
    public String getUserUserName()
    {
        return userUserName;
    }
    public void setPic(String pic)
    {
        this.pic = pic;
    }

    public String getPic()
    {
        return this.pic;
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
