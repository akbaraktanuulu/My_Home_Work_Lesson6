package com.example.my_home_work_lesson6;

public class Item2 {
    private String title;
    private String price;
    private int imageResId;

    public Item2(String title, String price, int imageResId) {
        this.title = title;
        this.price = price;
        this.imageResId = imageResId;
    }

    public String getTitle() { return title; }
    public String getPrice() { return price; }
    public int getImageResId() { return imageResId; }
}
