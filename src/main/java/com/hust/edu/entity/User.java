package com.hust.edu.entity;

/*
    *用户实体类
*/
public class User {
    private int id;
    private String uname;
    private String loginName;
    private String pwd;
    private String dbSource;

    public User() {
    }

    public User(int id, String uname, String loginName, String pwd, String dbSource) {
        this.id = id;
        this.uname = uname;
        this.loginName = loginName;
        this.pwd = pwd;
        this.dbSource = dbSource;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getDbSource() {
        return dbSource;
    }

    public void setDbSource(String dbSource) {
        this.dbSource = dbSource;
    }
}
