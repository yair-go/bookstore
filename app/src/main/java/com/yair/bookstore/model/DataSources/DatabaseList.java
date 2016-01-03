package com.yair.bookstore.model.DataSources;

import android.content.Context;

import com.yair.bookstore.*;

import java.util.ArrayList;

import com.yair.bookstore.model.backend.Backend;

/**
 * Created by USER on 09/12/2015.
 */
public class DatabaseList implements Backend {


    ArrayList<Book> books = new ArrayList<Book>();


    public DatabaseList(Context context) {
    }

    @Override
    public void addBook(Book book) {
        books.add(book);

    }

    @Override
    public void setBooksList() {
        BooksList.add(new Book(3,"aaa"));
        BooksList.add(new Book(4,"bbb"));
    }

    @Override
    public ArrayList<Book> getBooks() {
        return books;
    }

    @Override
    public ArrayList<Book> getBooksList() throws Exception {
        return books;
    }

    @Override
    public ArrayList<Book> getBooksList(int book_id) throws Exception {
        return null;
    }


}
