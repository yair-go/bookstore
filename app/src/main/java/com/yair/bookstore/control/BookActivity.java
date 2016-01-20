package com.yair.bookstore.control;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.yair.bookstore.Book;
import com.yair.bookstore.R;
import com.yair.bookstore.model.Const;
import com.yair.bookstore.model.DataSources.BackendFactory;
import com.yair.bookstore.model.MyActivity;
import com.yair.bookstore.model.backend.Backend;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class BookActivity extends AppCompatActivity implements MyActivity{

    ArrayList<Book> booksArrayList = new ArrayList<Book>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        final Backend backend = BackendFactory.getInstance(this);
        // TODO:
        // VERSION 1& 3
        try {
            booksArrayList = backend.getBooksList();
        } catch (Exception e) {
            Toast.makeText(BookActivity.this, "catch error", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
        /********************************************************************************************/
        //TODO:
//        //VERSION 2
//        new AsyncTask<Void, Void,  ArrayList<Book>>() {
//            @Override
//            protected ArrayList<Book> doInBackground(Void... voids) {
//                try {
//                    return backend.getBooksList();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                return null;
//            }
//
//            @Override
//            protected void onPreExecute() {
//            }
//
//            @Override
//            protected void onPostExecute(ArrayList<Book> abooks) {
//                booksArrayList = abooks;
//                initBookByListView();
//            }
//        }.execute();
        /***************************************************************************************/
        /////////////////////////////////////////////////////////////////////////////////////////////
//        booksArrayList.add(new Book(3,"aaa"));
//        booksArrayList.add(new Book(4,"bbb"));
          initBookByListView();
        //TODO: VERSION4
//        try {
//            booksArrayList = backend.getBooksList(this,2);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    void initBookByListView()
    {
        ListView listView = new ListView(this);
        listView.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
//       ListView listView = (ListView) findViewById(R.id.booksListView);
        ArrayAdapter<Book> adapter = new ArrayAdapter<Book>(this,
                R.layout.row_book, booksArrayList)
        {
            @Override
            public View getView(int position, View convertView, ViewGroup parent)
            {
                if (convertView == null)
                {
                    convertView = View.inflate(BookActivity.this,
                            R.layout.row_book,null);
                }
                TextView bookNameTextView = (TextView) convertView
                        .findViewById(R.id.bookName);
                bookNameTextView.setText( booksArrayList.get(position).get_name());
//                productNameTextView.setText(myBookList.get(position).getName());
//
//                // format date to dd/MM/yyyy
//                CharSequence date = DateFormat.format("[dd/MM/yyyy]",
//                        myBookList.get(position).getDate());
//
//                productionDateTextView.setText(date);
                return convertView;
            }
        };
        listView.setAdapter(adapter);
        this.setContentView(listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value = (String)parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext() , value, Toast.LENGTH_SHORT).show();
            }
        });
//        listView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(parent.getContext() , "hhhhhh", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
    }
    //TODO: VERSION4
    @Override
    public void Refresh() {
        initBookByListView();
    }
//    public static void initBookByListView(ArrayList<Book> booksArrayList)
//    {
//        // initBookList(size);
//        ListView listView = new ListView(BookActivity.this);
//
//        ArrayAdapter<Book> adapter = new ArrayAdapter<Book>(this,
//                R.layout.row_book, booksArrayList)
//        {
//            @Override
//            public View getView(int position, View convertView, ViewGroup parent)
//            {
//                if (convertView == null)
//                {
//                    convertView = View.inflate(BookActivity.this,
//                            R.layout.row_book,null);
//                }
//                TextView bookNameTextView = (TextView) convertView
//                        .findViewById(R.id.bookName);
//                bookNameTextView.setText( booksArrayList.get(position).get_name());
//                return convertView;
//            }
//        };
//        listView.setAdapter(adapter);
//        this.setContentView(listView);
//    }

}
