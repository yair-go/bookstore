package com.yair.bookstore.control;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.yair.bookstore.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class addUserActivity extends ActionBarActivity {

    SimpleDateFormat dateFormatter;
    DatePickerDialog datePickerDialog;
    TextView birthdayTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
        init();


    }
    private void init() {
//        profImage = (ImageView) findViewById(R.id.profile_image_view);
//        usernameTextView = (TextView) findViewById(R.id.profile_username_text_input);
          birthdayTextView = (TextView) findViewById(R.id.birthday);
//        emailTextView = (TextView) findViewById(R.id.profile_email_text_input);
//        changePassTextView = (TextView) findViewById(R.id.change_password);
//        registerSellerTextView = (TextView) findViewById(R.id.register_as_seller);
//        userStatusTextView = (TextView) findViewById(R.id.user_status_text);
//        userType = UserType.USER;

        dateFormatter = new SimpleDateFormat("dd/MM/yyyy");

        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                String gt = getResources().getString(R.string.birthday);
                birthdayTextView.setText(gt.concat(dateFormatter.format(newDate.getTime())));
            }

        }, 1997, 10, 8);

        birthdayTextView.setFocusable(false);
        birthdayTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog.show();
            }
        });

//        dialog = new AlertDialog.Builder(this);
//        String[] types = {"Change profile image", "Delete profile image"};
//        dialog.setItems(types, new DialogInterface.OnClickListener() {
//
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//
//                dialog.dismiss();
//                switch (which) {
//                    case 0:
//                        Intent intent = new Intent();
//                        intent.setType("image/*");
//                        intent.setAction(Intent.ACTION_GET_CONTENT);
//                        intent.addCategory(Intent.CATEGORY_OPENABLE);
//                        startActivityForResult(intent, SELECT_PHOTO);
//                        break;
//                    case 1:
//                        profImage.setImageResource(R.drawable.ic_account_circle_white_48dp);
//                        break;
//                }
//            }
//        });
        Button registerButton = (Button)findViewById(R.id.registerButton);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(addUserActivity.this,BookActivity.class);
                startActivity(intent);
            }
        });
    }

}
