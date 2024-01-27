package com.example.rideShare;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.EditText;

import android.database.sqlite.SQLiteDatabase;
import android.content.ContentValues;

import com.example.rideShare.DBHelper;

import androidx.appcompat.app.AppCompatActivity;

public class RegistrationActivity extends AppCompatActivity {
    DBHelper dbHelper = new DBHelper(this);
    public static String studentId;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrationlayout);

        Button next = (Button) findViewById(R.id.submitRegButton);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                EditText firstName = (EditText)findViewById(R.id.firstName);
                EditText lastName = (EditText)findViewById(R.id.lastName);
                EditText id = (EditText)findViewById(R.id.studentId);
                EditText email = (EditText)findViewById(R.id.studentEmail);
                EditText password = (EditText)findViewById(R.id.password);

                ContentValues values = new ContentValues();
                values.put("id", id.getText().toString());
                values.put("firstname", firstName.getText().toString());
                values.put("lastname", lastName.getText().toString());
                values.put("email", email.getText().toString());
                values.put("password", password.getText().toString());
                dbHelper.insert(values);
                dbHelper.select(id.getText().toString());
                studentId = id.getText().toString();

                Intent intent = new Intent(view.getContext(), EnrollDays.class);
                startActivityForResult(intent, 0);
            }

        });
    }
}
