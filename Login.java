package com.example.rideShare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    DBHelper dbHelper = new DBHelper(this);


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginlayout);

        Button next = (Button) findViewById(R.id.loginSubmit);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                EditText studentId = (EditText)findViewById(R.id.loginstudentId);
                EditText password = (EditText)findViewById(R.id.studentPassword);


                String[] tableColumns = new String[] {
                        "password"

                };
                String whereClause = "id = ?";
                String[] whereArgs = new String[] {
                        studentId.getText().toString()
                };
                String orderBy = "password";
                boolean isSuccess = dbHelper.loginQuery("student", tableColumns, whereClause, whereArgs, orderBy, password.getText().toString());
                if (isSuccess) {
                    Intent intent = new Intent(view.getContext(), AvailableRides.class);
                    startActivityForResult(intent, 0);
                }
            }
        });
    }
}