package com.hqz.demo.model;

public class UserRegister {
    private Integer ID;
    private String nickName;
    private String sex;
    private String phoneNumber;
    private String email;
    private String passwd;
    private String age;
    private String dream;

    public UserRegister() {
    }

    public Integer getID() {
        return this.ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getnickName() {
        return this.nickName;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return this.sex;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getPasswd() {
        return this.passwd;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAge() {
        return this.age;
    }

    public void setDream(String dream) {
        this.dream = dream;
    }

    public String getDream() {
        return this.dream;
    }
}
