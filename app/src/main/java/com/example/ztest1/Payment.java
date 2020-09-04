package com.example.ztest1;

public class Payment {
    private String Enroll,Totalpay,Amount,userId;

    public Payment() {
    }

    public Payment(String enroll, String totalpay, String amount, String userId) {
        Enroll = enroll;
        Totalpay = totalpay;
        Amount = amount;
        this.userId = userId;
    }

    public String getEnroll() {
        return Enroll;
    }

    public void setEnroll(String enroll) {
        Enroll = enroll;
    }

    public String getTotalpay() {
        return Totalpay;
    }

    public void setTotalpay(String totalpay) {
        Totalpay = totalpay;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String amount) {
        Amount = amount;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
