package com.uap.eclassroom.Data;

import java.io.File;
import java.util.ArrayList;

public class Presence {

    public Presence(String meeting, String date, boolean selfPresence) {
        this.meeting = meeting;
        this.date = date;
        this.selfPresence = selfPresence;
    }

    public String getMeeting() {
        return meeting;
    }

    public void setMeeting(String meeting) {
        this.meeting = meeting;
    }

    public boolean isSelfPresence() {
        return selfPresence;
    }

    public void setSelfPresence(boolean selfPresence) {
        this.selfPresence = selfPresence;
    }
    
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    private String meeting;
    private String date;
    private boolean selfPresence;
    
    
}
