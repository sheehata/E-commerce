package com.example.ecomm.models;
//represent the data model.
public class Product {
    private int id;
    private String title;
    private String price;
    private String description;
    private String image;

    public Product(int id, String title, String price, String description, String image) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.description = description;
        this.image = image;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getPrice() { return price; }
    public void setPrice(String price) { this.price = price; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }
}

