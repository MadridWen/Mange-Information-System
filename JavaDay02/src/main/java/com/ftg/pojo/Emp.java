package com.ftg.pojo;

public class Emp {
    private int eid;
    private String ename;
    private String sex;
    private int edu;
    private String employed;
    private String birthday;
    private double salary;

    public Emp() {
    }
    public Emp(int eid, String ename, String sex, int edu, String employed, String birthday, double salary) {
        this.eid = eid;
        this.ename = ename;
        this.sex = sex;
        this.edu = edu;
        this.employed = employed;
        this.birthday = birthday;
        this.salary = salary;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getEdu() {
        return edu;
    }

    public void setEdu(int edu) {
        this.edu = edu;
    }

    public String getEmployed() {
        return employed;
    }

    public void setEmployed(String employed) {
        this.employed = employed;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
