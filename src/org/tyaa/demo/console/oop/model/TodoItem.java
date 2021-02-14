package org.tyaa.demo.console.oop.model;

import java.util.Date;

public class TodoItem {

    private static Integer lastId;

    private Integer id;
    private String title;

    private String description;
    private Date date;
    private Boolean done;

    static {
        lastId = 0;
    }

    public TodoItem() {
        this.id = ++lastId;
        date = new Date();
        done = false;
    }

    public TodoItem(Integer id, String title) {
        this.id = id;
        this.setTitle(title);
        date = new Date();
        done = false;
    }

    public TodoItem(String title) {
        this.id = ++lastId;
        this.setTitle(title);
        date = new Date();
        done = false;
    }

    public TodoItem(String title, String description) {
        this.id = ++lastId;
        this.setTitle(title);
        this.setDescription(description);
        this.date = new Date();
        done = false;
    }
    public TodoItem(String title, String description, Date date) {
        this.id = ++lastId;
        this.setTitle(title);
        this.setDescription(description);
        this.setDate(date);
        done = false;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Boolean getDone() { return done; }

    public String getDescription() { return description; }

    public Date getDate() { return date; }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    public void setTitle(String title) {
        if (title.isBlank()) {
            throw new IllegalArgumentException("id must be not blank");
        }
        this.title = title;
    }

    @Override
    public String toString() {
        return "TodoItem{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", done=" + done +
                '}';
    }
}