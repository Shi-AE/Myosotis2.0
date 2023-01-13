package com.guat.myosotis.bean;

public class Admin extends Cipher{
    private Long id;
    private String handle;
    private String contact;

    public Admin(String cipherText, String salt, Long id, String handle, String contact) {
        super(cipherText, salt);
        this.id = id;
        this.handle = handle;
        this.contact = contact;
    }

    public Admin() {
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", handle='" + handle + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
