package com.example.taskmaster;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Tasks {
    @PrimaryKey(autoGenerate = true)
    private long id;
    @ColumnInfo(name = "task_image")
    private  int image;
    @ColumnInfo(name = "task_title")
    private final String title;
    @ColumnInfo(name = "task_body")
    private final String body;
    @ColumnInfo(name = "task_state")
    private final String state ;

//    public Tasks(int image, String title, String body, String state) {
//        this.image = image;
//        this.title = title;
//        this.body = body;
//        this.state = state;
//    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Tasks(String title, String body, String state) {
        this.title = title;
        this.body = body;
        this.state = state;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public String getState() {
        return state;
    }
}
