package com.uap.eclassroom.Data;

import java.io.File;
import java.util.ArrayList;

public class Mahasiswa {

    public Mahasiswa(String name, String nim, ArrayList<String> presence, ArrayList<File> attached, ArrayList<File> permissionLetter, ArrayList<Double> grade) {
        this.name = name;
        this.nim = nim;
        this.presence = presence;
        this.attached = attached;
        this.permissionLetter = permissionLetter;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNIM() {
        return nim;
    }

    public void setNIM(String nim) {
        this.nim = nim;
    }

    public ArrayList<String> getPresence() {
        return presence;
    }

    public void setPresence(ArrayList<String> presence) {
        this.presence = presence;
    }

    public ArrayList<File> getAttached() {
        return attached;
    }

    public void setAttached(ArrayList<File> attached) {
        this.attached = attached;
    }
    private String name;
    private String nim;
    private ArrayList<String> presence;
    private ArrayList<File> attached;
    private ArrayList<Double> grade;

    public ArrayList<Double> getGrade() {
        return grade;
    }

    public void setGrade(ArrayList<Double> grade) {
        this.grade = grade;
    }

    public ArrayList<File> getPermissionLetter() {
        return permissionLetter;
    }

    public void setPermissionLetter(ArrayList<File> permissionLetter) {
        this.permissionLetter = permissionLetter;
    }
    private ArrayList<File> permissionLetter;
    
    
}
