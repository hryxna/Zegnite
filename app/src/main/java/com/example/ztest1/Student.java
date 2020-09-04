package com.example.ztest1;

public class Student {

    private String uID,Name,Enroll,College,Branch,Sem,Contact,Events1,Events2,Events3,userId;

    public Student() {
    }

    public Student(String uID, String name, String enroll, String college, String branch, String sem, String contact, String events1, String events2, String events3, String userId) {
        this.uID = uID;
        Name = name;
        Enroll = enroll;
        College = college;
        Branch = branch;
        Sem = sem;
        Contact = contact;
        Events1 = events1;
        Events2 = events2;
        Events3 = events3;
        this.userId = userId;
    }

    public String getuID() {
        return uID;
    }

    public void setuID(String uID) {
        this.uID = uID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEnroll() {
        return Enroll;
    }

    public void setEnroll(String enroll) {
        Enroll = enroll;
    }

    public String getCollege() {
        return College;
    }

    public void setCollege(String college) {
        College = college;
    }

    public String getBranch() {
        return Branch;
    }

    public void setBranch(String branch) {
        Branch = branch;
    }

    public String getSem() {
        return Sem;
    }

    public void setSem(String sem) {
        Sem = sem;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        Contact = contact;
    }

    public String getEvents1() {
        return Events1;
    }

    public void setEvents1(String events1) {
        Events1 = events1;
    }

    public String getEvents2() {
        return Events2;
    }

    public void setEvents2(String events2) {
        Events2 = events2;
    }

    public String getEvents3() {
        return Events3;
    }

    public void setEvents3(String events3) {
        Events3 = events3;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
