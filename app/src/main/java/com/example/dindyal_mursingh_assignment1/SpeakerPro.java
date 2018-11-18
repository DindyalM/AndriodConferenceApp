package com.example.dindyal_mursingh_assignment1;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class SpeakerPro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speaker_pro);
        TextView name = (TextView) findViewById(R.id.textView15);
        TextView affiliation = (TextView) findViewById(R.id.textView16);
        TextView email = (TextView) findViewById(R.id.textView17);
        TextView bio = (TextView) findViewById(R.id.textView18);
        ImageView img = (ImageView)findViewById(R.id.imageView4);


        String name2 = getIntent().getStringExtra("name");
        String affiliation2 = getIntent().getStringExtra("affiliation");
        String email2 = getIntent().getStringExtra("email");
        String bio2 = getIntent().getStringExtra("bio");

        Picasso.with(this).load("https://www.freeiconspng.com/uploads/account-profile-user-icon--icon-search-engine-10.png").into(img);


        name.setText(name2);
        affiliation.setText(affiliation2);
        email.setText(email2);
        bio.setText(bio2);
    }
}

