package com.example.cart.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Cart {

    public static String COLUMN_ID = "id";
    public static String COLUMN_NAME = "name";
    public static String COLUMN_STATE = "state";
    public static String COLUMN_DESCRIPTION = "description";
    public static String COLUMN_IMAGE_COST = "cost";
    public static String COLUMN_IMAGE_URL = "imageUrl";

    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo
    private String name;
    @ColumnInfo
    private String state;
    @ColumnInfo
    private String description;
    @ColumnInfo
    private double cost;
    @ColumnInfo
    private String imageUrl;

    public Cart(int id, String name, String state, String description, double cost, String imageUrl) {
        this.id = id;
        this.name = name;
        this.state = state;
        this.description = description;
        this.cost = cost;
        this.imageUrl = imageUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double coust) {
        this.cost = coust;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
