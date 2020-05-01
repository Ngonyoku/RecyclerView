package com.example.recyclerview;

public class ItemsList {
    private int imageResource;
    private String name, text;

    public ItemsList(String name, String text) {
        this.name = name;
        this.text = text;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }
}
