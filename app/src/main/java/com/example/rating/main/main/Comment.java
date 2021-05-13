package com.example.rating.main.main;

public class Comment {
    private int avt;
    private String name;
    private String dateTime;
    private int ratingStar;
    private String comment;

    public Comment(int avt, String name, String dateTime, int ratingStar, String comment) {
        this.avt = avt;
        this.name = name;
        this.dateTime = dateTime;
        this.ratingStar = ratingStar;
        this.comment = comment;
    }

    public int getAvt() {
        return avt;
    }

    public void setAvt(int avt) {
        this.avt = avt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public int getRatingStar() {
        return ratingStar;
    }

    public void setRatingStar(int ratingStar) {
        this.ratingStar = ratingStar;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
