package com.yair.bookstore.model.DataSources;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.yair.bookstore.Book;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import com.yair.bookstore.R;
import com.yair.bookstore.control.BookActivity;
import com.yair.bookstore.model.Const;
import com.yair.bookstore.model.MyActivity;
import com.yair.bookstore.model.backend.Backend;

/**
 * Created by USER on 09/12/2015.
 */
public class DatabaseMySQL implements Backend {

//    final ArrayList<Book> BooksList = new ArrayList<Book>();
    public DatabaseMySQL(Context context) {
    }

    @Override
    public void addBook(final Book book) throws IOException {
//      DatabaseList DBList = new DatabaseList();
//        DBList.addBook(book);
        BooksList.add(book);
        try{
            new AsyncTask< Void,Void,Void>() {
                @SafeVarargs
                @Override
                protected final Void doInBackground(Void... params) {
                    Map<String,Object> _params = new LinkedHashMap<>();
                    _params.put("book_id",book.get_id());
                    _params.put("book_name", book.get_name());
                    _params.put("book_price", book.get_price());
                    try {
                        POST(R.string.web_url + "addBook.php", _params);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return null;
                }
            }.execute();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    //TODO:
    //VERSION 1
    public void setBooksList()
    {
        BooksList.clear();
        try {
            new AsyncTask<Void, Void,  ArrayList<Book>>() {
                @Override
                protected  ArrayList<Book> doInBackground(Void... voids) {
                    try {
                        Book tempBook;
                        JSONArray books = new JSONObject(GET(R.string.web_url + "getBooksList.php")).getJSONArray("books");
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
                protected void onPostExecute(ArrayList<Book> books) {

                }
            }.execute().get();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public ArrayList<Book> getBooks()
    {
        return BooksList;
    }
    @Override
    public ArrayList<Book> getBooksList() throws Exception {
//TODO:
// VERSION 1
        return BooksList;

        /*************************************************************************************/
//        final ArrayList<Book> BooksList = new ArrayList<Book>();
        // TODO :
        //VERSION 2
        //

//        Book tempBook;
//        JSONArray books = new JSONObject(GET(Const.web_url + "getBooksList.php")).getJSONArray("books");
//        for (int i = 0; i < books.length(); i++) {
//            tempBook = new Book();
//            tempBook.setBookID(books.getJSONObject(i).getInt("book_id"));
//            tempBook.setBookName(books.getJSONObject(i).getString("book_name"));
//            BooksList.add(tempBook);
//        }
//        return BooksList;
        /*************************************************************************************/
        //TODO:
//        VERSION 3
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

    }

    @Override
    public ArrayList<Book> getBooksList(int book_id) throws Exception {
        return null;
    }
    //TODO: VERSION4
    @Override
    public ArrayList<Book> getBooksList( final MyActivity a, final int book_id) throws Exception {
//        final ArrayList<Book> BooksList = new ArrayList<Book>();

        try {
            new AsyncTask<MyActivity, Void,  ArrayList<Book>>() {

                public MyActivity activity;
                @Override
                protected  ArrayList<Book> doInBackground(MyActivity... a) {
                    this.activity = a[0];
                    try {
                        Book tempBook;
                        JSONArray books = new JSONObject(GET(R.string.web_url + "getBooksList.php" + "?book_id="+book_id)).getJSONArray("books");
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
                    a.Refresh();
                }
            }.execute(a);
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

    private static String POST(String url, Map<String,Object> params) throws IOException {

        //Convert Map<String,Object> into key=value&key=value pairs.
        StringBuilder postData = new StringBuilder();
        for (Map.Entry<String,Object> param : params.entrySet()) {
            if (postData.length() != 0) postData.append('&');
            postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
            postData.append('=');
            postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
        }

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");

        // For POST only - START
        con.setDoOutput(true);
        OutputStream os = con.getOutputStream();
        os.write(postData.toString().getBytes("UTF-8"));
        os.flush();
        os.close();
        // For POST only - END

        int responseCode = con.getResponseCode();
        System.out.println("POST Response Code :: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) { //success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            return response.toString();
        }
        else return "";
    }
    }

