package com.hqz.demo.model;
public class UserComment {
    private int cmid;
    private String comment;
    private String cmusername;
    private String busername;
    private String timenow;

    public UserComment() {
    }

    public int getCmid() {
        return this.cmid;
    }

    public void setCmid(int cmid) {
        this.cmid = cmid;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCmusername() {
        return this.cmusername;
    }

    public void setCmusername(String cmusername) {
        this.cmusername = cmusername;
    }

    public String getBusername() {
        return this.busername;
    }

    public void setBusername(String busername) {
        this.busername = busername;
    }

    public String getTimenow() {
        return this.timenow;
    }

    public void setTimenow(String timenow) {
        this.timenow = timenow;
    }
}
