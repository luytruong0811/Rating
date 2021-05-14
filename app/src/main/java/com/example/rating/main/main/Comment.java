package com.example.rating.main.main;

public class Comment {
    private int avt;
    private String name;
    private String dateTime;
    private int ratingStar;
    private Boolean lnImage;
    private int image1;
    private int image2;
    private int image3;
    private int image4;
    private int image5;
    private String comment;
    private Boolean seeMore;
    private Boolean clReplay;
    private String shopName;
    private String reply;

    public Comment(int avt, String name, String dateTime, int ratingStar, Boolean lnImage,
                   int image1, int image2, int image3, int image4, int image5, String comment, Boolean seeMore, Boolean clReplay, String shopName, String reply) {
        this.avt = avt;
        this.name = name;
        this.dateTime = dateTime;
        this.ratingStar = ratingStar;
        this.lnImage = lnImage;
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
        this.image4 = image4;
        this.image5 = image5;
        this.comment = comment;
        this.seeMore = seeMore;
        this.clReplay = clReplay;
        this.shopName = shopName;
        this.reply = reply;
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

    public Boolean isLnImage() {
        return lnImage;
    }

    public void setLnImage(Boolean lnImage) {
        this.lnImage = lnImage;
    }

    public int getImage1() {
        return image1;
    }

    public void setImage1(int image1) {
        this.image1 = image1;
    }

    public int getImage2() {
        return image2;
    }

    public void setImage2(int image2) {
        this.image2 = image2;
    }

    public int getImage3() {
        return image3;
    }

    public void setImage3(int image3) {
        this.image3 = image3;
    }

    public int getImage4() {
        return image4;
    }

    public void setImage4(int image4) {
        this.image4 = image4;
    }

    public int getImage5() {
        return image5;
    }

    public void setImage5(int image5) {
        this.image5 = image5;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Boolean isSeeMore() {
        return seeMore;
    }

    public void setSeeMore(Boolean seeMore) {
        this.seeMore = seeMore;
    }

    public Boolean isClReplay() {
        return clReplay;
    }

    public void setClReplay(Boolean clReplay) {
        this.clReplay = clReplay;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }
}
