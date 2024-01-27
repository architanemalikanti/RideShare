package com.example.rideShare;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import android.view.View;

import android.content.ContentValues;

import androidx.appcompat.app.AppCompatActivity;

public class EnrollDays extends AppCompatActivity {

    DBHelper dbHelper = new DBHelper(this);


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choosedayslayout);

        Button next = (Button) findViewById(R.id.chooseButton);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioWeekday);

                int selectedId = radioGroup.getCheckedRadioButtonId();
                RadioButton selectedRadioButton = (RadioButton) findViewById(selectedId);
                String selectedDay = selectedRadioButton.getText().toString();

                ContentValues values = new ContentValues();
                values.put("ridecommitedday", selectedDay);
                // String sql = "Update student set ridecommitedday = " + "`'selectedDay'`" + " where id = "+ RegistrationActivity.studentId;
                dbHelper.update("student", values, "id="+RegistrationActivity.studentId);

                dbHelper.select(RegistrationActivity.studentId);

                Intent intent = new Intent(view.getContext(), RegisterSuccess.class);
                startActivityForResult(intent, 0);

            }
    });
}
}
