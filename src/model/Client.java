package model;

import java.util.Date;

public class Client
{

    private int clientID;
    private String firstName;
    private String surname;
    private Date dob;
    private String username;
    private String password;

    public Client(int clientID, String firstName, String surname, java.sql.Date dob,
                  String username, String password)
    {
        this.clientID = clientID;
        this.firstName = firstName;
        this.surname = surname;
        this.dob = dob;
        this.username = username;
        this.password = password;
    }

    public Client(int anInt, String string) {
    }

    public int getClientID()
    {
        return clientID;
    }

    public void setClientID(int clientID)
    {
        this.clientID = clientID;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getSurname()
    {
        return surname;
    }

    public void setSurname(String surname)
    {
        this.surname = surname;
    }

    public Date getDob()
    {
        return dob;
    }

    public void setDob(Date dob)
    {
        this.dob = dob;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    @Override
    public String toString()
    {
        return "Client{" + "clientID=" + clientID + ", firstName=" + firstName
                + ", surname=" + surname + ", dob=" + dob + ", username="
                + username + '}';
    }

}
