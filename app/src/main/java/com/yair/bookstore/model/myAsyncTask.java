package com.yair.bookstore.model;

import com.yair.bookstore.control.threadFunction;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.widget.Toast;
import java.lang.Exception;import java.lang.Override;import java.lang.String;import java.lang.Void;

public class myAsyncTask extends AsyncTask<Void, Void, Void> {
    /*1)*/
    private ProgressDialog progressDialog;
    private Activity myAct;
    private Exception exceptionThrown;
    private threadFunction back, post;

    /*2)*/
    public myAsyncTask(Activity activity, threadFunction p, threadFunction b, threadFunction pr) {
        super();
        myAct = activity;
        back = b;
        post = p;
    }

    /*3)*/
    @Override
    protected Void doInBackground(Void... params) {
        try {
            back.run();
        } catch (Exception e) {
            exceptionThrown = e;

     /*3.1)*/
            if (e.getMessage().contains("Read timed out")) {
                exceptionThrown = new Exception("No response from server. Try again.");
            }
     /*3.2)*/
            else if (e.getMessage().contains("@@@")) {
                String s = e.getMessage();
                s = s.replaceAll("[^@]*@@@|###[^@]*", "");
                exceptionThrown = new Exception(s);
            }
     /*3.3)*/
            else {
                exceptionThrown = new Exception("Problem.");
            }

        }
        return null;
    }

    /*4)*/
    @Override
    protected void onPreExecute() {
        try {
            progressDialog = ProgressDialog.show(myAct,
                    "Please wait",
                    "Synchronizing with the server...", true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
/*5)*/

    @Override
    protected void onPostExecute(Void result) {
        try {
            if (progressDialog.isShowing()) {
                progressDialog.dismiss();
            }
            if (exceptionThrown != null) {
                Toast.makeText(myAct, exceptionThrown.getMessage(),
                        Toast.LENGTH_SHORT).show();
            } else {
                post.run();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}