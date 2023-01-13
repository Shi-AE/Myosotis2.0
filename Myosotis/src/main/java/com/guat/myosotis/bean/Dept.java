package com.guat.myosotis.bean;

public class Dept {
    private Long id;
    private String deptName;
    private String deptId;

    public Dept(Long id, String deptName, String deptId) {
        this.id = id;
        this.deptName = deptName;
        this.deptId = deptId;
    }

    public Dept() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "id=" + id +
                ", deptName='" + deptName + '\'' +
                ", deptId='" + deptId + '\'' +
                '}';
    }
}
