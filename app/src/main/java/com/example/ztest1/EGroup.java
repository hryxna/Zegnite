package com.example.ztest1;

public class EGroup {
        private String GrpuID,GName,GEnroll,GCollege,GBranch,GSem,GContact,GEvents,GrpID,userId;
    public EGroup() {
    }

    public EGroup(String grpuID, String GName, String GEnroll, String GCollege, String GBranch, String GSem, String GContact, String GEvents, String grpID, String userId) {
        this.GrpuID = grpuID;
        this.GName = GName;
        this.GEnroll = GEnroll;
        this.GCollege = GCollege;
        this.GBranch = GBranch;
        this.GSem = GSem;
        this.GContact = GContact;
        this.GEvents = GEvents;
        this.GrpID = grpID;
        this.userId = userId;
    }

    public String getGrpuID() {
        return GrpuID;
    }

    public void setGrpuID(String grpuID) {
        GrpuID = grpuID;
    }

    public String getGName() {
        return GName;
    }

    public void setGName(String GName) {
        this.GName = GName;
    }

    public String getGEnroll() {
        return GEnroll;
    }

    public void setGEnroll(String GEnroll) {
        this.GEnroll = GEnroll;
    }

    public String getGCollege() {
        return GCollege;
    }

    public void setGCollege(String GCollege) {
        this.GCollege = GCollege;
    }

    public String getGBranch() {
        return GBranch;
    }

    public void setGBranch(String GBranch) {
        this.GBranch = GBranch;
    }

    public String getGSem() {
        return GSem;
    }

    public void setGSem(String GSem) {
        this.GSem = GSem;
    }

    public String getGContact() {
        return GContact;
    }

    public void setGContact(String GContact) {
        this.GContact = GContact;
    }

    public String getGEvents() {
        return GEvents;
    }

    public void setGEvents(String GEvents) {
        this.GEvents = GEvents;
    }

    public String getGrpID() {
        return GrpID;
    }

    public void setGrpID(String grpID) {
        GrpID = grpID;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
