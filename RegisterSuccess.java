package com.example.rideShare;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterSuccess extends AppCompatActivity {

    DBHelper dbHelper = new DBHelper(this);


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registersuccesslayout);

        Button next = (Button) findViewById(R.id.login);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Login.class);
                startActivityForResult(intent, 0);
            }
        });
    }
}