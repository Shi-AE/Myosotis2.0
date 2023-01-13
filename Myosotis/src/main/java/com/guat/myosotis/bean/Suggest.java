package com.guat.myosotis.bean;

public class Suggest {
    private Long id;
    private String target;
    private String content;
    private String sender;

    public Suggest(Long id, String target, String content, String sender) {
        this.id = id;
        this.target = target;
        this.content = content;
        this.sender = sender;
    }

    public Suggest() {
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    @Override
    public String toString() {
        return "Suggest{" +
                "id=" + id +
                ", target='" + target + '\'' +
                ", content='" + content + '\'' +
                ", sender='" + sender + '\'' +
                '}';
    }
}
