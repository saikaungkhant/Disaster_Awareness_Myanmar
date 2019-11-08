package com.wahaha.myapplication;

/**
 * Created by user1 on 5/27/2019.
 */
public class Item {

    String itemListName;
    int itemListImage;

    public Item(String itemName, int itemImage)
    {
        this.itemListName=itemName;
        this.itemListImage=itemImage;
    }

    public String getitemName()
    {
        return itemListName;
    }

    public int getitemImage()
    {
        return itemListImage;
    }
}
