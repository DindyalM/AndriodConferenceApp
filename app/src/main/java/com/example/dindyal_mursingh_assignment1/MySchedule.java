package com.example.dindyal_mursingh_assignment1;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class MySchedule extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_schedule);
        String[] plan = {"8am: Breakfast","9am: Welcome Speech","12:am: Press","4pm:dinner","5pm: guest speakers","6pm:questions", "7pm: Snack", "10pm: exit"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getListView().getContext(),android.R.layout.simple_list_item_1,plan);
        getListView().setAdapter(adapter);
    }
}
