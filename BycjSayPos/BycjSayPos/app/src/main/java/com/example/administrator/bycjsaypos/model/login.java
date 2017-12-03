package com.example.administrator.bycjsaypos.model;

/**
 * Created by Administrator on 2017/11/15.
 */

public class login {

    private String  businessCode;
    private String  userName;
    private String  passWord;
    private String  number;
    private String  numberon;
    private String  token;

    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public String getNumber() {
        return number;
    }

    public String getNumberon() {
        return numberon;
    }

    public String getToken() {
        return token;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setNumberon(String numberon) {
        this.numberon = numberon;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "login{" +
                "businessCode='" + businessCode + '\'' +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", number='" + number + '\'' +
                ", numberon='" + numberon + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
