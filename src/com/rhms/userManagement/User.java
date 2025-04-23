package com.rhms.userManagement;

public class User{
    protected String name;
    protected String email;
    protected String password;      //I added password for login (Future project )
    protected String phone;
    protected String address;
    protected int userID;

    public User(String name, String email, String password, String phone, String address, int userID){
        this.name = name;
        this.email = email;
        this.password = password;   //Constructors as setters.
        this.phone= phone;
        this.address = address;
        this.userID = userID;
    }

    public String getName(){    //Getters
        return name;
    }
    
    public String getEmail(){
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }
}