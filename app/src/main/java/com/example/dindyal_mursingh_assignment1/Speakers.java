package com.example.dindyal_mursingh_assignment1;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.dindyal_mursingh_assignment1.Adapter.Speakers_Adapter_class;
import com.example.dindyal_mursingh_assignment1.Model.Item;

import java.util.ArrayList;
import java.util.List;

public class Speakers extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    private SpeakerViewModel mSpeakerViewModel; //grab view model
    public static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;
    List<Item> items;
    //Speakers_Adapter_class adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speakers);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        RecyclerView recyclerView = findViewById(R.id.recyclerView); //grabbing recycler view


        final WordListAdapter adapter = new WordListAdapter(this);
        recyclerView.setAdapter(adapter);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mSpeakerViewModel = ViewModelProviders.of(this).get(SpeakerViewModel.class);// grab view model

        mSpeakerViewModel.getAllSpeakers().observe(this, new Observer<List<Speaker>>() {
            @Override
            public void onChanged(@Nullable final List<Speaker> speakers) {
                // Update the cached copy of the words in the adapter.
                adapter.setSpeakers(speakers);

            }
        });
    }
}
