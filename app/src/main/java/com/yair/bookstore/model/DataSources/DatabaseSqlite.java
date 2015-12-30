package com.yair.bookstore.model.DataSources;

import android.content.Context;

import com.yair.bookstore.Book;

import java.util.ArrayList;

import com.yair.bookstore.model.backend.Backend;

/**
 * Created by USER on 09/12/2015.
 */
public class DatabaseSqlite implements Backend {
    public DatabaseSqlite(Context context) {
    }

    @Override
    public void addBook(Book book) {

    }

    @Override
    public ArrayList<Book> getBooks() {
        return null;
    }

    @Override
    public ArrayList<Book> getBooksList() throws Exception {
        return null;
    }

    @Override
    public ArrayList<Book> getBooksList(int book_id) throws Exception {
        return null;
    }
}
