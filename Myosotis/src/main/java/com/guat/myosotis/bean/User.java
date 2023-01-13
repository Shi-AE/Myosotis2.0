package com.guat.myosotis.bean;

public class User extends Cipher {
    private Long id;
    private String phoneNumber;
    private String emil;
    private String token;
    private String employId;



    public User(Long id, String cipherText, String salt, String phoneNumber, String emil, String token, String employId) {
        super(cipherText, salt);
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.emil = emil;
        this.token = token;
        this.employId = employId;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmil() {
        return emil;
    }

    public void setEmil(String emil) {
        this.emil = emil;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getEmployId() {
        return employId;
    }

    public void setEmployId(String employId) {
        this.employId = employId;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", emil='" + emil + '\'' +
                ", token='" + token + '\'' +
                ", employId='" + employId + '\'' +
                '}';
    }
}
