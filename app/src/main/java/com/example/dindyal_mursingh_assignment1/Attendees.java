package com.example.dindyal_mursingh_assignment1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.dindyal_mursingh_assignment1.Adapter.Attendees_RecyclerViewAdpater;

import java.util.ArrayList;

public class Attendees extends AppCompatActivity {
    private static final String TAG = "Attendees";

    //vars
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendees);
        Log.d(TAG, "onCreate: Stated");
        initImageBitmaps();
    }
    private void initImageBitmaps(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps");

        mImageUrls.add("https://vignette.wikia.nocookie.net" +
                "/bungostraydogs/images/1/1e/Profile-icon-9." +
                "png/revision/latest?cb=20171030104015");

        mNames.add("Memeber 1");
        mImageUrls.add("https://vignette.wikia.nocookie.net" +
                "/bungostraydogs/images/1/1e/Profile-icon-9." +
                "png/revision/latest?cb=20171030104015");

        mNames.add("Memeber 2");
        mImageUrls.add("https://vignette.wikia.nocookie.net" +
                "/bungostraydogs/images/1/1e/Profile-icon-9." +
                "png/revision/latest?cb=20171030104015");

        mNames.add("Memeber 3");
        mImageUrls.add("https://vignette.wikia.nocookie.net" +
                "/bungostraydogs/images/1/1e/Profile-icon-9." +
                "png/revision/latest?cb=20171030104015");

        mNames.add("Memeber 4");
        mImageUrls.add("https://vignette.wikia.nocookie.net" +
                "/bungostraydogs/images/1/1e/Profile-icon-9." +
                "png/revision/latest?cb=20171030104015");

        mNames.add("Memeber 5");
        mImageUrls.add("https://vignette.wikia.nocookie.net" +
                "/bungostraydogs/images/1/1e/Profile-icon-9." +
                "png/revision/latest?cb=20171030104015");

        mNames.add("Memeber 6");
        mImageUrls.add("https://vignette.wikia.nocookie.net" +
                "/bungostraydogs/images/1/1e/Profile-icon-9." +
                "png/revision/latest?cb=20171030104015");

        mNames.add("Memeber 7");

        mImageUrls.add("https://vignette.wikia.nocookie.net" +
                "/bungostraydogs/images/1/1e/Profile-icon-9." +
                "png/revision/latest?cb=20171030104015");

        mNames.add("Memeber 8");

        initRecyclerView();
    }
    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init r view");
        RecyclerView recyclerView = findViewById(R.id.recycler);
        Attendees_RecyclerViewAdpater adapter = new Attendees_RecyclerViewAdpater(mNames,mImageUrls,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


}
