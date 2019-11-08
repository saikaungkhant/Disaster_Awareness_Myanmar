package com.wahaha.myapplication;

/**
 * Created by HP on 23/6/2019.
 */
public class Donation {
    String title;
    int image;

    public void setPhone(String phone) {
        this.phone = phone;
    }

    String phone;

    public String getAddress() {
        return address;
    }

    String address;

    public Donation(String title, int image, String address, String phone) {
        this.title = title;
        this.image = image;
        this.address=address;
        this.phone = phone;
    }




    public String getTitle() {
        return title;
    }

    public int getImage() {
        return image;
    }

    public String getPhone() {
        return phone;
    }
}
