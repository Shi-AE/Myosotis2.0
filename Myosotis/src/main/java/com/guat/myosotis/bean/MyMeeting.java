package com.guat.myosotis.bean;

import java.sql.Time;
import java.sql.Timestamp;

public class MyMeeting {
    private Long id;
    private String title;
    private Timestamp startTime;
    private Time endTime;
    private String note;
    private String employId;

    public MyMeeting(Long id, String title, Timestamp startTime, Time endTime, String note, String employId) {
        this.id = id;
        this.title = title;
        this.startTime = startTime;
        this.endTime = endTime;
        this.note = note;
        this.employId = employId;
    }

    public MyMeeting() {
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

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getEmployId() {
        return employId;
    }

    public void setEmployId(String employId) {
        this.employId = employId;
    }

    @Override
    public String toString() {
        return "MyMeeting{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", note='" + note + '\'' +
                ", employId='" + employId + '\'' +
                '}';
    }
}
