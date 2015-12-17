package com.yair.bookstore;

/**
 * Created by Yair on 13/12/2015.
 */
public class Book {
    private int _id;
    private String _name;
    private int image;

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

}
