package com.example.masho.smec.model;

/**
 * Created by OK Computers on 8/26/2018.
 */


public class Profile {
    private String image;

    public Profile() {
    }

    public Profile(String Image) {

        this.image = Image;
    }
    public String getImage() {
        return image;
    }

    public void setImage(String Image) {
        this.image = Image;
    }
}