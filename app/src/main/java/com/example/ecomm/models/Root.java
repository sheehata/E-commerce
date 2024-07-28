package com.example.ecomm.models;

public class Root{
    public int id;
    public String title;
    public String price;
    public String description;
    public String category;
    public String image;
    public Rating rating;

    public Root(String title, String price, String description, String category, String image) {
        this.title = title;
        this.price = price;
        this.description = description;
        this.category = category;
        this.image = image;

    }
}
