package com.example.rideShare;


import android.os.Bundle;
import android.view.View;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.app.ListActivity;
import android.widget.ListView;

import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;



public class AvailableRides extends ListActivity {
    DBHelper dbHelper = new DBHelper(this);
    public static String studentId;

    static final String[] FRUITS = new String[] { "Apple", "Avocado", "Banana",
            "Blueberry", "Coconut", "Durian", "Guava", "Kiwifruit",
            "Jackfruit", "Mango", "Olive", "Pear", "Sugar-apple" };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.availablerideslayout);
        setListAdapter( new ArrayAdapter<String>(this, R.layout.availablerideslayout,FRUITS));
        ListView listView = getListView();
        listView.setTextFilterEnabled(true);

        listView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // When clicked, show a toast with the TextView text
                String person = ((TextView) view).getText().toString();
                System.out.println(person);
            }
        });
    }
}
