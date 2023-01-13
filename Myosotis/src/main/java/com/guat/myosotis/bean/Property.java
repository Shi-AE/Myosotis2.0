package com.guat.myosotis.bean;

public class Property {
    private Long id;
    private String item;
    private int number;

    @Override
    public String toString() {
        return "Property{" +
                "id=" + id +
                ", item='" + item + '\'' +
                ", number=" + number +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Property() {
    }

    public Property(Long id, String item, int number) {
        this.id = id;
        this.item = item;
        this.number = number;
    }
}
