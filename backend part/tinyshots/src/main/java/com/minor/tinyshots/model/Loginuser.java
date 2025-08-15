package com.minor.tinyshots.model;

public class Loginuser {

    private static String email;
    private static String password;


    public Loginuser() {

    }

    public Loginuser(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public static String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Loginuser{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
