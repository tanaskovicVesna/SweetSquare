package com.example.android.sweetsquare.model;

/**
 * Created by Tanaskovic on 4/13/2018.
 */

public class Item {

    private String name;
    private String description;
    private int image;

    public Item() {
    }

    public Item( String name, String description, int image) {

        this.name = name;
        this.description = description;
        this.image = image;
    }

    public Item(String name, int image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
