package com.guat.myosotis.bean;

public class Employ {
    private Long id;
    private String employId;
    private String name;
    private String job;
    private String hireDate;
    private String managerId;
    private String deptId;

    public Employ(Long id, String employId, String name, String job, String date, String managerId, String deptId) {
        this.id = id;
        this.employId = employId;
        this.name = name;
        this.job = job;
        this.hireDate = date;
        this.managerId = managerId;
        this.deptId = deptId;
    }

    public Employ() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmployId() {
        return employId;
    }

    public void setEmployId(String employId) {
        this.employId = employId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    @Override
    public String toString() {
        return "Employ{" +
                "id=" + id +
                ", employId='" + employId + '\'' +
                ", name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", date=" + hireDate +
                ", managerId='" + managerId + '\'' +
                ", deptId='" + deptId + '\'' +
                '}';
    }
}
