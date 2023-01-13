package com.guat.myosotis.bean;

import java.util.Arrays;

public class Document {
    private Long id;
    private String target;
    private byte[] file;
    private String name;
    private String note;
    private String sender;

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", target='" + target + '\'' +
                ", file=" + Arrays.toString(file) +
                ", name='" + name + '\'' +
                ", note='" + note + '\'' +
                ", sender='" + sender + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public Document() {
    }

    public Document(Long id, String target, byte[] file, String name, String note, String sender) {
        this.id = id;
        this.target = target;
        this.file = file;
        this.name = name;
        this.note = note;
        this.sender = sender;
    }
}
