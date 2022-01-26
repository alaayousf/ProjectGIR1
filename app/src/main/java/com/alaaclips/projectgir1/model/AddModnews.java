package com.alaaclips.projectgir1.model;

public class AddModnews {

    String Image;
    String descreption;

    public AddModnews(String image, String descreption) {
        Image = image;
        this.descreption = descreption;
    }

    public String getImage() {
        return Image;
    }

    public String getDescreption() {
        return descreption;
    }

    public void setImage(String image) {
        Image = image;
    }

    public void setDescreption(String descreption) {
        this.descreption = descreption;
    }
}
