package com.uap.eclassroom.Data;

import java.util.ArrayList;

public class Classwork {

    public String getTitle() {
        return title;
    }

    public void setTitle(String judul) {
        this.title = judul;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String deskripsi) {
        this.description = deskripsi;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }
    
    private String title;
    private String description;
    private String deadline;
    
    public Classwork(String title, String description, String deadline) {
        this.title = title;
        this.description = description;
        this.deadline = deadline;
    }
    
   

}
