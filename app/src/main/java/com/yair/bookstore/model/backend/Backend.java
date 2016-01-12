package com.yair.bookstore.model.backend;

import com.yair.bookstore.*;
import com.yair.bookstore.model.MyActivity;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by USER on 09/12/2015.
 */
public interface  Backend {

    final ArrayList<Book> BooksList = new ArrayList<Book>();
    void addBook(Book book) throws IOException;
    public void setBooksList();
    public ArrayList<Book> getBooks();
    public ArrayList<Book> getBooksList() throws Exception;
    public ArrayList<Book> getBooksList(int book_id) throws Exception;

    ArrayList<Book> getBooksList(MyActivity a, int book_id) throws Exception;
}
