package com.yair.bookstore.control;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import com.yair.bookstore.Book;
import com.yair.bookstore.R;
import com.yair.bookstore.model.DataSources.BackendFactory;
import com.yair.bookstore.model.backend.Backend;

import java.io.IOException;

public class addBookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);
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
    }

    public void addBookClicked(View view) throws IOException {
//        EditText et =(EditText)findViewById(R.id.bookName);
        Book newBook = new Book();
        newBook.setBookName(((EditText) findViewById(R.id.editBookName)).getText().toString());
        newBook.set_price(Integer.parseInt(((EditText) findViewById(R.id.editBookPrice)).getText().toString()));
        final Backend backend = BackendFactory.getInstance(this);
        backend.addBook(newBook);
        super.onBackPressed();
    }
}
