package com.yair.bookstore;

/**
 * Created by Yair on 13/12/2015.
 */
public class Book {

       private int _id;
    private String _name;
    private int _price;
    private int image;

    public Book() {
    }


    public Book(int _id, String _name) {
        this._id = _id;
        this._name = _name;
    }

    public int get_id() {
        return _id;
    }

//    public void set_id(int _id) {
//        this._id = _id;
//    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String get_name() {
        return _name;
    }

//    public void set_name(String _name) {
//        this._name = _name;
//    }

    public void setBookID(int bookID) {
        this._id = bookID;
    }

    public void setBookName(String bookName) {
        this._name = bookName;
    }

    public int get_price() {
        return _price;
    }

    public void set_price(int _price) {
        this._price = _price;
    }

}
