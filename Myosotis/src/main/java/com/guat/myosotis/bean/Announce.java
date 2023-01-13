package com.guat.myosotis.bean;

public class Announce {
    private Long id;
    private String title;
    private String content;
    private String url;

    public Announce(Long id, String title, String content, String url) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.url = url;
    }

    public Announce() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Announce{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", context='" + content + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
