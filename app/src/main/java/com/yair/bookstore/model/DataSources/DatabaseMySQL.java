package com.yair.bookstore.model.DataSources;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.yair.bookstore.Book;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import com.yair.bookstore.control.BookActivity;
import com.yair.bookstore.model.Const;
import com.yair.bookstore.model.backend.Backend;

/**
 * Created by USER on 09/12/2015.
 */
public class DatabaseMySQL implements Backend {

//    final ArrayList<Book> BooksList = new ArrayList<Book>();
    public DatabaseMySQL(Context context) {
    }

    @Override
    public void addBook(Book book) {

    }

    public ArrayList<Book> getBooks()
    {
        return BooksList;
    }
    @Override
    public ArrayList<Book> getBooksList() throws Exception {
        final ArrayList<Book> BooksList = new ArrayList<Book>();
//        try {
//            new AsyncTask<Void, Void,  ArrayList<Book>>() {
//                @Override
//                protected  ArrayList<Book> doInBackground(Void... voids) {
//                    try {
//                        Book tempBook;
//                        JSONArray books = new JSONObject(GET(Const.web_url + "getBooksList.php")).getJSONArray("books");
//                        for (int i = 0; i < books.length(); i++) {
//                            tempBook = new Book();
//                            tempBook.setBookID(books.getJSONObject(i).getInt("book_id"));
//                            tempBook.setBookName(books.getJSONObject(i).getString("book_name"));
//                            BooksList.add(tempBook);
//                        }
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                    return BooksList;
//                }
//                @Override
//                protected void onPreExecute() {
//                }
//
//                @Override
//                protected void onPostExecute(ArrayList<Book> books) {
//
//                }
//            }.execute().get();
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//        return BooksList;

        /*************************************************************************************/
        Book tempBook;
        JSONArray books = new JSONObject(GET(Const.web_url + "getBooksList.php")).getJSONArray("books");
        for (int i = 0; i < books.length(); i++) {
            tempBook = new Book();
            tempBook.setBookID(books.getJSONObject(i).getInt("book_id"));
            tempBook.setBookName(books.getJSONObject(i).getString("book_name"));
            BooksList.add(tempBook);
        }
        return BooksList;
        /*************************************************************************************/
    }

    @Override
    public ArrayList<Book> getBooksList(final int book_id) throws Exception {
//        final ArrayList<Book> BooksList = new ArrayList<Book>();

        try {
            new AsyncTask<Void, Void,  ArrayList<Book>>() {
                @Override
                protected  ArrayList<Book> doInBackground(Void... voids) {
                    try {
                        Book tempBook;
                        JSONArray books = new JSONObject(GET(Const.web_url + "getBooksList.php" + "?book_id="+book_id)).getJSONArray("books");
                        for (int i = 0; i < books.length(); i++) {
                            tempBook = new Book();
                            tempBook.setBookID(books.getJSONObject(i).getInt("book_id"));
                            tempBook.setBookName(books.getJSONObject(i).getString("book_name"));
                            BooksList.add(tempBook);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return BooksList;
                }
                @Override
                protected void onPreExecute() {
                }

                @Override
                protected void onPostExecute(ArrayList<Book> myBooksList) {
                  //  return myBooksList;
                }
            }.execute();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return BooksList;

    }

    private static String GET(String url) throws Exception {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {// success
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
             in.close();
            //  print result
             return response.toString();
        } else {
            return "";
        }
    }
}

