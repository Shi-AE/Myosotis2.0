package com.guat.myosotis.bean;

public class Cipher {
    private String cipherText;
    private String salt;

    public Cipher(String cipherText, String salt) {
        this.cipherText = cipherText;
        this.salt = salt;
    }

    public Cipher() {
    }

    public String getCipherText() {
        return cipherText;
    }

    public void setCipherText(String cipherText) {
        this.cipherText = cipherText;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Override
    public String toString() {
        return "Cipher{" +
                "cipherText='" + cipherText + '\'' +
                ", salt='" + salt + '\'' +
                '}';
    }
}
